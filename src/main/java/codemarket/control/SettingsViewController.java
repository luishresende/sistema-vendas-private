package codemarket.control;

import codemarket.model.utils.SettingsFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

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
    private ColorPicker colorPickerPrimaryIcon;

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
    
    private SettingsFile settingsColor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingsColor = new SettingsFile();
    }
    
    public void handleSaveButton(){
        System.out.println(colorPickerPrimaryTheme.getValue());
        System.out.println(colorPickerSecondTheme.getValue());
        System.out.println(colorPickerPrimaryFont.getValue());
        System.out.println(colorPickerSecondFont.getValue());
        //settingsColor.updatePropertiesFile(colorPickerPrimaryTheme.getValue(), null, null, null);
    }
    
}
