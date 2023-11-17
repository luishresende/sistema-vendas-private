package codemarket.control;

import codemarket.model.conexao.HibernateConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManager;

public class LoginViewController implements Initializable {

    @FXML
    private AnchorPane anchorPaneLogin;
    @FXML
    private Button buttonBDSettings;
    @FXML
    private Button buttonEntrar;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private PasswordField passwordFieldSenha;
    @FXML
    private Text textStatus;

    private boolean connectedToTheServer; // Váriavel que define a função do botão entrar (entrar/conectar)
    private Stage dialogStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Adicionando o evento ao botão após a cena ser inicializada
        buttonEntrar.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                textFieldUsuario.requestFocus(); // Requisito o foco para o textField de usuario
                // Adiciono evento para o botão "entrar" ser pressionado quando a tecla enter for ativada, e o botão estiver habilitado
                newScene.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.ENTER && !buttonEntrar.isDisabled()) {
                        handleButtonEntrar();
                    }
                });

                // Adiciono evento para passar para o proximo textField, quando o usuário apertar TAB e estiver no primeiro textField da cena
                textFieldUsuario.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.TAB) {
                        passwordFieldSenha.requestFocus();
                        event.consume(); // Consome o evento para evitar que o foco seja transferido pelo sistema
                    }
                });
            }
        });
        tryServerConnection(); // Tento realizar a conexão com o servidor, inicialmente
    }

    @FXML
    public void handleButtonDBSettings() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DialogDatabaseSettingsView.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Scene scene = new Scene(page);
        dialogStage = new Stage();
        dialogStage.setTitle("Configurações de banco de dados");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setResizable(false);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        DialogDatabaseSettingsViewController controller = loader.getController();
        controller.setDialogStage(dialogStage);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();
    }

    @FXML
    public void handleButtonEntrar() {
        buttonEntrar.setDisable(true); // Desabilito o botão para entrar/conectar
        if (!connectedToTheServer) {
            // Se não estiver conectado, atualizo a label e tento realizar a conexão
            setStatus("Realizando conexão com o servidor...", Color.BLACK);
            tryServerConnection(); // Tentando conectar novamente
            buttonEntrar.setDisable(false);
        } else {
            // Se estiver conectado. atualizo a label e o programa tenta realizar a autenticação
            setStatus("Realizando autenticação...", Color.BLACK);
            // Executo em uma nova thread para não travar a tela 
            Thread thread = new Thread(() -> {
                AuthController auth = AuthController.getInstance();
                // Obtenho o resultado da autenticação
                boolean authenticationResult = auth.authenticate(textFieldUsuario.getText(), passwordFieldSenha.getText());
                Platform.runLater(() -> { // Realizando as alterações da GUI dentro da thread principal da interface, garantindo a sua integridade.
                    if (authenticationResult) {
                        // Se autenticado. carrego a mainView
                        setStatus("Carregando...", Color.GREEN);
                        setMainView();
                    } else {
                        // Se não autenticado, neste caso, informo que as credenciais são inválidas
                        if(!connectedToTheServer)
                            buttonEntrar.setDisable(true);
                        setStatus("Credenciais inválidas!", Color.RED);
                        buttonEntrar.setDisable(false);
                    }
                });
            });
            thread.start();
        }
    }

    private void setStatus(String status, Color color) {
        textStatus.setText(status);
        textStatus.setFill(color);
    }

    private void tryServerConnection() {
        // Executo a tentativa de conexão em uma nova thread, para não travar a tela
        Thread thread = new Thread(() -> {
            EntityManager em = HibernateConnection.getInstance(); // Inicializando a conexão do programa
            Platform.runLater(() -> { // Realizando as alterações da GUI dentro da thread principal da interface, garantindo a sua integridade.
                if (em == null || !em.isOpen()) {
                    setStatus("Falha ao conectar com servidor.", Color.RED);
                    buttonEntrar.setText("CONECTAR");
                    buttonEntrar.setDisable(false);
                } else {
                    buttonEntrar.setText("ENTRAR");
                    this.connectedToTheServer = true;
                    setStatus("Conexão realizada com sucesso!", Color.GREEN);
                    buttonEntrar.setDisable(false);
                }
            });
        });
        thread.start();
    }

    private void setMainView() {
        // Carrego a mainView
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainView.fxml"));
        AnchorPane page = null;
        try {
            page = (AnchorPane) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene scene = new Scene(page);
        Stage mainStage = new Stage();
        mainStage.setTitle("Code Market");
        mainStage.setScene(scene);

        // Carrego o controlador e chamo o método que atualiza as informações do usuário na mainView
        MainViewController mainController = loader.getController();
        mainController.updateUserInfo(); // Atualizo as informações do usuário na mainView

        Stage loginStage = (Stage) buttonEntrar.getScene().getWindow(); // 
        loginStage.close(); // Fecho o stage de login

        mainStage.show(); // Ativo o stage da mainView
    }
}
