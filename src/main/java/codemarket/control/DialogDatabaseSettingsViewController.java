/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import codemarket.model.conexao.ConexaoHibernate;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DialogDatabaseSettingsViewController implements Initializable {

    @FXML
    private TextField textFieldEnderecoDB;
    @FXML
    private TextField textFieldNomeDB;
    @FXML
    private TextField textFieldUsuarioDB;
    @FXML
    private PasswordField passwordFieldSenhaDB;
    @FXML
    private AnchorPane anchorPaneDBSettings;
    @FXML
    private Button buttonSalvar;

    private Stage dialogStage;
    private boolean buttonSalvarClicked = false;
    private File settingsFile = new File("./src/main/resources/META-INF/persistence.xml");

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonSalvarClicked() {
        return buttonSalvarClicked;
    }

    public void setButtonSalvarClicked(boolean buttonSalvarClicked) {
        this.buttonSalvarClicked = buttonSalvarClicked;
    }

    public boolean validateNewSettings(String endereco, String dbNome, String usuario, String senha) {
        if (!endereco.contains(":") || endereco.contains("/") || endereco.substring(endereco.indexOf(":")).isEmpty()) {
            return false;
        }

        return !dbNome.isEmpty() && !usuario.isEmpty() && !senha.isEmpty();
    }

    public boolean isValidConnection() throws SQLException {
        ConexaoHibernate conexao = new ConexaoHibernate();
        EntityManager manager = conexao.getInstance();

        boolean connected = false;

        try {
            // Tentar executar uma consulta simples para validar a conexão
            manager.createQuery("SELECT 1");
            connected = true;
        } catch (Exception e) {
            connected = false;
        } finally {
            manager.close();
        }

        return connected;
    }

    private void displayErrorScreen() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Ocorreu um erro");
        alert.setContentText("Verifique as credenciais informadas e tente novamente!");

        alert.showAndWait();
    }

    @FXML
    public void handlerButtonSalvar() {
        try {
            // Definição de objetos responsáveis pir contruir os documentos XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Crio os documentos passando o já existente como parametro
            org.w3c.dom.Document doc = dBuilder.parse(settingsFile);
            org.w3c.dom.Document oldDoc = dBuilder.parse(settingsFile);
            doc.getDocumentElement().normalize();

            // Obtendo todos os elementos com a tag property
            NodeList properties = doc.getElementsByTagName("property");
            Element urlElement = (Element) properties.item(0);
            Element userElement = (Element) properties.item(1);
            Element passwordElement = (Element) properties.item(3);
            
            // Definindo cada uma para as variaveis
            String urlConfig = urlElement.getAttribute("value");
            String usernameConfig = userElement.getAttribute("value");
            String passwordConfig = passwordElement.getAttribute("value");

            // Manipulação de strings para obter apenas o conteudo desejado de determinados atributos
            int indexInicial = urlConfig.indexOf("//") + 2;
            int indexFinal = urlConfig.indexOf("/", indexInicial);
            String schema;
            try {
                int indexInterrogacao = urlConfig.indexOf("?", indexInicial);
                schema = urlConfig.substring(indexFinal + 1, indexInterrogacao);
            } catch (Exception e) {
                schema = urlConfig.substring(indexFinal + 1);
            }

            // Definindo variáveis para receberem os valores dos campos de texto com as entradas do usuario
            String endereco = textFieldEnderecoDB.getText();
            String dbNome = textFieldNomeDB.getText();
            String usuario = textFieldUsuarioDB.getText();
            String senha = passwordFieldSenhaDB.getText();

            // Validando os dados
            if (validateNewSettings(endereco, dbNome, usuario, senha)) {
                // Atribuindo as novas propriedades ao documento XML
                properties.item(0).setTextContent(urlConfig.substring(0, indexInicial) + endereco + "/" + dbNome);
                properties.item(1).setTextContent(usuario);
                properties.item(3).setTextContent(senha);

                // Definição do objeto transformador, responsável por editar e salvar o XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                //transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//Hibernate/Hibernate Configuration DTD 3.0//EN");

                // Definindo o source de ambos os documentos, antigo(atual) e novo
                DOMSource source = new DOMSource(doc);
                DOMSource oldSource = new DOMSource(oldDoc);

                // Criando um novo arquivo que receberá o documento XML sem as alterações aplicadas pelo usuário
                File oldFile = new File("./src/main/resources/META-INF/oldPersistence.xml");

                // Atribuindo os antigos valores do XML para o "antigo" arquivo
                StreamResult oldResult = new StreamResult(oldFile);
                transformer.transform(oldSource, oldResult);

                // Atribuindo os novos valores para o arquivo de configuração padrão do hibernate e atualizando a variável que armazena ele na classe
                StreamResult result = new StreamResult(new File("./src/main/resources/META-INF/persistence.xml"));
                transformer.transform(source, result);
                settingsFile = new File("./src/main/resources/META-INF/persistence.xml");

                // Validanddo conexão
                if (isValidConnection()) {
                    // Fecho a janela
                    dialogStage.close();
                } else {
                    // Retorno os atribuitos antigos para não serem perdidos
                    transformer.transform(oldSource, result);
                    settingsFile = new File("./src/main/resources/META-INF/persistence.xml");
                    displayErrorScreen();
                }
                // Apago o arquivo XML que possuia os antigos valores
                oldFile.delete();
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSettings() {
        System.out.println(settingsFile.getAbsolutePath());
        try {
            // Definindo o objeto responsável por "ler" o XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Normalizando o documento
            org.w3c.dom.Document doc = dBuilder.parse(settingsFile);
            doc.getDocumentElement().normalize();

            // Obtendo todos os elementos com a tag property
            NodeList nodeList = doc.getElementsByTagName("property");
            Element urlElement = (Element) nodeList.item(0);
            Element userElement = (Element) nodeList.item(1);
            Element passwordElement = (Element) nodeList.item(3);
            
            // Definindo cada uma para as variaveis
            String urlConfig = urlElement.getAttribute("value");
            String usernameConfig = userElement.getAttribute("value");
            String passwordConfig = passwordElement.getAttribute("value");

            // Manipulação de strings para obtenção do conteudo desejado
            int indexInicial = urlConfig.indexOf("//") + 2;
            int indexFinal = urlConfig.indexOf("/", indexInicial);
            System.out.println(indexInicial);
            System.out.println(indexFinal);
            String schema;
            try {
                int indexInterrogacao = urlConfig.indexOf("?", indexInicial);
                schema = urlConfig.substring(indexFinal + 1, indexInterrogacao);
            } catch (Exception e) {
                schema = urlConfig.substring(indexFinal + 1);
            }
            String endereco = urlConfig.substring(indexInicial, indexFinal);

            // Aplicação dos valores armazenado no XML nos fields, possibilitando a visualização dos mesmos.
            textFieldEnderecoDB.setText(endereco);
            textFieldNomeDB.setText(schema);
            textFieldUsuarioDB.setText(usernameConfig);
            passwordFieldSenhaDB.setText(passwordConfig);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadSettings();
    }
}
