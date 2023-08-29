/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
    private File settingsFile = new File("./src/main/resources/META-INF/hibernate.cfg.xml");

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
        Configuration configuration = new Configuration().configure(settingsFile);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        boolean connected = false;

        try {
            // Tentar executar uma consulta simples para validar a conexão
            session.createSQLQuery("SELECT 1").uniqueResult();
            connected = true;
        } catch (Exception e) {
            connected = false;
        } finally {
            session.close();
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

            // Obtendo os elementos da tag properties, de dentro do arquivo xml
            Element elemHibernateConfiguration = (Element) doc.getElementsByTagName("hibernate-configuration").item(0);
            Element sessionFactory = (Element) elemHibernateConfiguration.getElementsByTagName("session-factory").item(0);

            // Atribuindo cada um deles a sua determinada variável
            NodeList properties = sessionFactory.getElementsByTagName("property");
            String urlConfig = properties.item(2).getTextContent();
            String usernameConfig = properties.item(3).getTextContent();
            String passwordConfig = properties.item(4).getTextContent();

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
                properties.item(2).setTextContent(urlConfig.substring(0, indexInicial) + endereco + "/" + dbNome);
                properties.item(3).setTextContent(usuario);
                properties.item(4).setTextContent(senha);

                // Definição do objeto transformador, responsável por editar e salvar o XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//Hibernate/Hibernate Configuration DTD 3.0//EN");
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd");

                // Definindo o source de ambos os documentos, antigo(atual) e novo
                DOMSource source = new DOMSource(doc);
                DOMSource oldSource = new DOMSource(oldDoc);

                // Criando um novo arquivo que receberá o documento XML sem as alterações aplicadas pelo usuário
                File oldFile = new File("./src/main/resources/META-INF/oldHibernate.cfg.xml");

                // Atribuindo os antigos valores do XML para o "antigo" arquivo
                StreamResult oldResult = new StreamResult(oldFile);
                transformer.transform(oldSource, oldResult);

                // Atribuindo os novos valores para o arquivo de configuração padrão do hibernate e atualizando a variável que armazena ele na classe
                StreamResult result = new StreamResult(new File("./src/main/resources/META-INF/hibernate.cfg.xml"));
                transformer.transform(source, result);
                settingsFile = new File("./src/main/resources/META-INF/hibernate.cfg.xml");

                // Validanddo conexão
                if (isValidConnection()) {
                    // Fecho a janela
                    dialogStage.close();
                } else {
                    // Retorno os atribuitos antigos para não serem perdidos
                    transformer.transform(oldSource, result);
                    settingsFile = new File("./src/main/resources/META-INF/hibernate.cfg.xml");
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

    public void loadSettings(int operacao) {
        try {
            // Definindo o objeto responsável por "ler" o XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = dBuilder.parse(settingsFile);
            doc.getDocumentElement().normalize();

            // Obtendo os elementos das tags properties
            Element sessionFactory = (Element) doc.getElementsByTagName("session-factory").item(0);
            NodeList properties = sessionFactory.getElementsByTagName("property");

            // Definindo cada uma para as variaveis
            String urlConfig = properties.item(2).getTextContent();
            String usernameConfig = properties.item(3).getTextContent();
            String passwordConfig = properties.item(4).getTextContent();

            // Manipulação de strings para obtenção do conteudo desejado
            int indexInicial = urlConfig.indexOf("//") + 2;
            int indexFinal = urlConfig.indexOf("/", indexInicial);
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
        loadSettings(0);
    }
}
