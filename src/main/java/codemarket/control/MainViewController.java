/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.model.rn.*;
import codemarket.model.utils.ImageManipulation;
import codemarket.model.vo.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.*;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane applicationAnchorPane;
    @FXML
    private Button menuButton;
    @FXML
    private GridPane mainGridPane;
    @FXML
    private GridPane sideBarContentGridPane;
    @FXML
    private GridPane menuSeparatorGridPane;
    @FXML
    private ColumnConstraints sideBarColumn;
    @FXML
    private ColumnConstraints sideBarContentColumn;
    @FXML
    private ColumnConstraints applicationColumn;
    @FXML
    private ColumnConstraints menuSeparatorColumn;
    @FXML
    private Button fornecedoresButton;
    @FXML
    private Button estoqueButton;
    @FXML
    private Button funcionariosButton;
    @FXML
    private Button clientesButton;
    @FXML
    private Button pdvButton;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Separator menuSeparator;
    @FXML
    private Label labelUserName;
    @FXML
    private Label labelUserRole;
    @FXML
    private GridPane gridPaneImage;
    @FXML
    private ImageView imageViewUser;

    private AnchorPane fornecedoresView;
    private AnchorPane estoqueView;
    private AnchorPane clientesView;
    private AnchorPane funcionariosView;
    private AnchorPane PDVLoaderView;
    private TbUsuario user;
    private boolean changingImageSize;
    private Image userImage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Carregando as views de cada subTela
        try {
            fornecedoresView = new FXMLLoader(getClass().getResource("/view/FornecedoresView.fxml")).load();
            estoqueView = new FXMLLoader(getClass().getResource("/view/EstoqueView.fxml")).load();
            clientesView = new FXMLLoader(getClass().getResource("/view/ClienteView.fxml")).load();
            funcionariosView = new FXMLLoader(getClass().getResource("/view/FuncionariosView.fxml")).load();
            PDVLoaderView = new FXMLLoader(getClass().getResource("/view/PDVView.fxml")).load();
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Adicionando a ação dos botões com os parâmetros personalizados
        fornecedoresButton.setOnAction(event -> handleViewsButtons(fornecedoresView));
        estoqueButton.setOnAction(event -> handleViewsButtons(estoqueView));
        clientesButton.setOnAction(event -> handleViewsButtons(clientesView));
        funcionariosButton.setOnAction(event -> handleViewsButtons(funcionariosView));
        pdvButton.setOnAction(event -> handleViewsButtons(PDVLoaderView));

        Platform.runLater(() -> {
            Scene mainScene = mainAnchorPane.getScene();
            mainScene.heightProperty().addListener((obs, oldHeight, newHeight) -> {
                if (!changingImageSize) {
                    resizeUserImage((Double) newHeight);
                }
            });
            updateImageUser();
        });

    }

// Função para fechar a side bar
    public void closeSideBar() {
        Timeline timeline = new Timeline(); // Definindo uma timeline (animação)
        sideBarContentGridPane.setEffect(null); // Removendo o efeito de shaddow da side bar

        double parentWidth = mainAnchorPane.getScene().getWidth(); // Obtém a largura da GridPane pai
        double sideBarWidth = parentWidth * (sideBarColumn.getPercentWidth() / 100.0); // Calcula a largura da sideBarColumn em pixels

        KeyFrame transitionFrame1 = new KeyFrame(Duration.seconds(0.5), // Definição de KeyFrame para a animação do conteudo da sideBar
                new KeyValue(sideBarContentGridPane.translateXProperty(), -sideBarWidth)
        );

        KeyFrame transitionFrame2 = new KeyFrame(Duration.seconds(0.4), // Definição de KeyFrame para a animação da grid pai da side bar e da tela da aplicação
                new KeyValue(sideBarColumn.percentWidthProperty(), 0),
                new KeyValue(applicationColumn.percentWidthProperty(), 100)
        );

        // Adicionando os keyframes na timeline e executando
        timeline.getKeyFrames().add(transitionFrame1);
        timeline.getKeyFrames().add(transitionFrame2);
        timeline.play();

        timeline.setOnFinished((ActionEvent e) -> {
            menuSeparatorGridPane.setVisible(true); // Deixando a grid do menu separator visivel
            menuSeparator.setVisible(true); // Deixando o menu separator visivel
            menuSeparatorGridPane.setDisable(false); // Habilitando a grid do menu separator
            desappearMenuSeparator();
        });
    }

    public void openSideBar() {
        menuSeparatorGridPane.setVisible(false); // Deixando a grid do menu separator invisivel
        menuSeparator.setVisible(false); // Deixando o menu separator invisivel
        menuSeparatorGridPane.setDisable(true); // Desabilitando a grid do menu separator

        Timeline timeline = new Timeline(); // Definindo uma timeline (animação)

        double parentWidth = mainAnchorPane.getScene().getWidth(); // Obtém a largura da GridPane pai
        double sideBarWidth = parentWidth * (sideBarColumn.getPercentWidth() / 100.0); // Calcula a largura da sideBarColumn em pixels

        KeyFrame transitionFrame1 = new KeyFrame(Duration.seconds(0.4), // Definição de KeyFrame para a animação do conteudo da sideBar
                new KeyValue(sideBarContentGridPane.translateXProperty(), 0)
        );

        KeyFrame transitionFrame2 = new KeyFrame(Duration.seconds(0.4), // Definição de KeyFrame para a animação da grid pai da side bar e da tela da aplicação
                new KeyValue(sideBarColumn.percentWidthProperty(), 25),
                new KeyValue(applicationColumn.percentWidthProperty(), 75)
        );

        // Aplicando o efeito de sombra no gridpane novamente
        timeline.setOnFinished((ActionEvent e) -> {
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(10);
            dropShadow.setColor(javafx.scene.paint.Color.rgb(0, 0, 0, 0.8));
            sideBarContentGridPane.setEffect(dropShadow);
        });

        // Adicionando os keyframes na timeline e executando
        timeline.getKeyFrames().add(transitionFrame1);
        timeline.getKeyFrames().add(transitionFrame2);
        timeline.play();
    }

    public void appearMenuSeparator() {
        TranslateTransition sideBarTransition = new TranslateTransition(); // Instanciando uma transição
        sideBarTransition.setDuration(Duration.seconds(0.2)); // Delay de abertura
        sideBarTransition.setNode(menuSeparatorGridPane); // Setando o nó que receberá a transição

        sideBarTransition.setToX(0); // Definindo a posição final da animação
        sideBarTransition.play(); // Executando a transição
        menuSeparatorGridPane.setVisible(true); // Deixando a grid do menu separator visivel
    }

    public void desappearMenuSeparator() {
        TranslateTransition sideBarTransition = new TranslateTransition(); // Instanciando uma transição
        sideBarTransition.setDuration(Duration.seconds(0.2)); // Delay de recuo
        sideBarTransition.setNode(menuSeparatorGridPane); // Setando o nó que receberá a transição

        sideBarTransition.setToX(-21); // Definindo a posição final da animação
        sideBarTransition.play(); // Executando a transição
    }

    public void handleViewsButtons(AnchorPane view) {
        applicationAnchorPane.getChildren().clear(); // Limpando o conteudo do AnchorPane pai
        // Definindo as costraints do novo conteudo para ocupar 100% da tela
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);

        // Definindo o conteúdo do AnchorPane existente como o novo conteúdo carregado
        applicationAnchorPane.getChildren().setAll(view);
    }

    public void updateUserInfo() {
        // Busco no banco, o nome do usuario e atualizo na tela
        this.user = AuthController.getInstance().getUser();
        EntidadeRN urn = new EntidadeRN();
        List users = urn.pesquisar("SELECT e FROM TbEntidade e INNER JOIN TbFuncionario f ON e.entcpfCnpj = f.funcentcpfCnpj WHERE f.funcUsuario = '" + user.getUsuUsuario() + "'");
        TbEntidade ent = (TbEntidade) users.get(0);
        labelUserName.setText(ent.getEntnomeFantasia());

        // Busco no banco, o cargo do usuario e atualizo na tela
        CargoRN crf = new CargoRN();
        List cargos = crf.pesquisar("SELECT c FROM TbFuncionario f INNER JOIN TbCargo c ON f.funcCargo = c.carId WHERE f.funcUsuario = '" + user.getUsuUsuario() + "'");
        TbCargo car = (TbCargo) cargos.get(0);
        labelUserRole.setText(car.getCarDescricao());
        
        if(user.getUsuimgPerfil() != null) {
            ImageManipulation imageManipulation = new ImageManipulation();
            userImage = imageManipulation.convertToImage(user.getUsuimgPerfil());
        } else {
            userImage = new Image("images/userAddImage.png");
        }
    }
    
    public void updateImageUser() {
        imageViewUser.setImage(userImage);
    }

    private void resizeUserImage(double newValue) {
        changingImageSize = true; 
        double newSize = (57.0 / 289 * newValue) - 1; // Redimensionando a imagem com base na relação entre quando x = 1009, y = 198, quando x = 720, 7 = 141
        System.out.println(newSize);
        imageViewUser.resize(newSize, newSize); // Redimensionando a imageView
        imageViewUser.setFitHeight(newSize); // Setando a imagem com a altura completa da imageView
        imageViewUser.setFitWidth(newSize); // Setando a imagem com a largura comp,eta da imageView
        changingImageSize = false; 
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }
}
