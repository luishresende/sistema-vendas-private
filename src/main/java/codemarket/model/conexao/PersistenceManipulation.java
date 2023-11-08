package codemarket.model.conexao;

import codemarket.model.utils.CryptoXML;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.hibernate.HibernateException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersistenceManipulation {

    private Element addressElement;
    private Element userElement;
    private Element passwordElement;
    private File persistenceFile;
    private CryptoXML crypto;
    private DocumentBuilder dBuilder;
    private Document persistenceDoc;
    private boolean encrypted = true;
    private static PersistenceManipulation persistenceManipulation;
    private Map<String, String> properties;

    /**
     * Inicializa o objeto PersistenceManipulation. <br>
     *
     * Lê o arquivo e instancia atributos privados ao objeto, com base nas
     * informações retidas do arquivo. <br>
     *
     */
    public PersistenceManipulation() throws Exception {
        try {
            this.persistenceFile = new File("./src/main/resources/META-INF/persistence.xml");
            this.crypto = CryptoXML.getInstance();

            // Definição de objetos responsáveis pir contruir os documentos XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            this.dBuilder = dbFactory.newDocumentBuilder();

            // Crio o documento passando o já existente como parametro
            this.persistenceDoc = dBuilder.parse(persistenceFile);
            getPersistenceDoc().getDocumentElement().normalize();

            // Obtendo todos os elementos com a tag property
            NodeList properties = getPersistenceDoc().getElementsByTagName("property");

            this.addressElement = (Element) properties.item(0);
            this.userElement = (Element) properties.item(1);
            this.passwordElement = (Element) properties.item(3);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static PersistenceManipulation getInstance() {
        if (persistenceManipulation == null) {
            synchronized (HibernateConnection.class) {
                if (persistenceManipulation == null) {
                    try {
                        persistenceManipulation = new PersistenceManipulation();
                    } catch (HibernateException he) {
                        System.err.println(he.getMessage());
                    } catch (Exception e) {

                    }
                }
            }
        }

        return persistenceManipulation;
    }

    public void encryptSensitiveData() {
        if (!encrypted) {
            try {
                getUserElement().setAttribute("value", crypto.encryptText(getUserElement().getAttribute("value")));
                getAddressElement().setAttribute("value", crypto.encryptText(getAddressElement().getAttribute("value")));
                getPasswordElement().setAttribute("value", crypto.encryptText(getPasswordElement().getAttribute("value")));

                savePersistence();
                encrypted = true;
            } catch (Exception e) {

            }
        }
    }

    /**
     * Descriptografa o arquivo de persistência. <br>
     *
     */
    public void decryptSensitiveData() {
        if (!encrypted) {
            return;
        }
        try {
            getUserElement().setAttribute("value", crypto.decryptText(getUserElement().getAttribute("value")));
            getPasswordElement().setAttribute("value", crypto.decryptText(getPasswordElement().getAttribute("value")));
            getAddressElement().setAttribute("value", crypto.decryptText(getAddressElement().getAttribute("value")));
            
            savePersistence();
            encrypted = false;
        } catch (Exception e) {

        }

    }

    /**
     * Salva o arquivo persistência. Aplicando as alterações no arquivo caso
     * houver. <br>
     *
     */
    public void savePersistence() {
        try {
            // Obter uma instância de TransformerFactory
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Criar uma origem DOM a partir do documento
            DOMSource source = new DOMSource(getPersistenceDoc());

            // Defino o destido do arquivo de 
            StreamResult result = new StreamResult(persistenceFile);

            // Transformar e escrever as alterações no arquivo
            transformer.transform(source, result);
            Thread.sleep(2000);
        } catch (TransformerConfigurationException e) {

        } catch (TransformerException e) {

        } catch (InterruptedException e) {

        }

    }

    public boolean updatePersistence(String newAddress, String newUser, String newPassword, String newDatabaseName) {
        decryptSensitiveData();
        String oldAddress = getAddressElement().getAttribute("value");
        String oldUser = getUserElement().getAttribute("value");
        String oldPassword = getPasswordElement().getAttribute("value");
        
        getAddressElement().setAttribute("value", "jdbc:mysql://" + newAddress + "/" + newDatabaseName);
        getUserElement().setAttribute("value", newUser);
        getPasswordElement().setAttribute("value", newPassword);
        savePersistence();
        
        updateProperties();

        ConnectionValidator conValidator = new ConnectionValidator(this);
        if (!conValidator.testConnection(newAddress, newUser, newPassword, newDatabaseName)) {
            getAddressElement().setAttribute("value", oldAddress);
            getUserElement().setAttribute("value", oldUser);
            getPasswordElement().setAttribute("value", oldPassword);
            encryptSensitiveData();
            savePersistence();
            return false;
        }
        encryptSensitiveData();
        return true;
    }

    private Document getPersistenceDoc() {
        return persistenceDoc;
    }

    private Element getAddressElement() {
        return addressElement;
    }

    private Element getUserElement() {
        return userElement;
    }

    private Element getPasswordElement() {
        return passwordElement;
    }

    public void updateProperties() {
        this.properties = new HashMap<>();
        this.properties.put("javax.persistence.jdbc.url", addressElement.getAttribute("value"));
        this.properties.put("javax.persistence.jdbc.user", userElement.getAttribute("value"));
        this.properties.put("javax.persistence.jdbc.password", passwordElement.getAttribute("value"));
        this.properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
    }

    public Map<String, String> getProperties() {
        return properties;
    }    
}
