package codemarket.control;

import codemarket.model.utils.DisplayDialogScreen;
import codemarket.model.utils.SettingsFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SettingsViewController implements Initializable{
    
    @FXML
    private ColorPicker colorPickerPrimaryTheme;

    @FXML
    private Label tituloJanela;

    @FXML
    private Button buttonSave;

    @FXML
    private ColorPicker colorPickerSecondTheme;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonRemove;

    @FXML
    private ColorPicker colorPickerSecondFont;

    @FXML
    private ColorPicker colorPickerPrimaryFont;

    @FXML
    private Button buttonAdd;
    
    private final SettingsFile settingsColor = SettingsFile.getInstance();
    
    private Stage dialogStage;
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Carrego os colors pickers com base no arquivo de configurações
        Platform.runLater(() -> {
            colorPickerPrimaryTheme.setValue(Color.valueOf("#" + settingsColor.getProperties().getProperty("primaryThemeColor")));
            colorPickerSecondTheme.setValue(Color.valueOf("#" + settingsColor.getProperties().getProperty("secondThemeColor")));
            colorPickerPrimaryFont.setValue(Color.valueOf("#" + settingsColor.getProperties().getProperty("primaryTextColor")));
            colorPickerSecondFont.setValue(Color.valueOf("#" + settingsColor.getProperties().getProperty("secondTextColor")));
        });
    }
    
    @FXML
    public void handleSaveButton(){
        // Tento salvar as novas cores no arquivo de configurações
        try {
            settingsColor.updatePropertiesFile(colorPickerPrimaryTheme.getValue().toString().substring(2, 8), colorPickerSecondTheme.getValue().toString().substring(2, 8), 
                                               colorPickerPrimaryFont.getValue().toString().substring(2, 8), colorPickerSecondFont.getValue().toString().substring(2, 8));
            DisplayDialogScreen.getInstance().displayInfoScreen("Sucesso", "Configurações atualizadas", "Algumas alterações requerem que o sistema seja reiniciado para serem aplicadas.");
        } catch (Exception e) {
            DisplayDialogScreen.getInstance().displayErrorScreen("Erro", "Parece que algo deu errado", "Não foi possível salvar as informações");
        } 
        
    }
    @FXML
    public void handleCancelButton(){
//        dialogStage.close();
    }
    
}
