package codemarket.model.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DisplayDialogScreen {

    private static DisplayDialogScreen dif;

    public static DisplayDialogScreen getInstance() {
        if (dif == null) {
            synchronized (DisplayDialogScreen.class) {
                if (dif == null) {
                    dif = new DisplayDialogScreen();
                }
            }
        }
        return dif;
    }

    public void displayNoneScreen(String title, String headerText, String contentText) {
        displayScreen(Alert.AlertType.NONE, title, headerText, contentText);
    }

    public void displayWarningScreen(String title, String headerText, String contentText) {
        displayScreen(Alert.AlertType.WARNING, title, headerText, contentText);
    }

    public void displayConfirmationScreen(String title, String headerText, String contentText) {
        displayScreen(Alert.AlertType.CONFIRMATION, title, headerText, contentText);
    }

    public void displayErrorScreen(String title, String headerText, String contentText) {
        displayScreen(Alert.AlertType.ERROR, title, headerText, contentText);
    }

    public void displayInfoScreen(String title, String headerText, String contentText) {
        displayScreen(Alert.AlertType.INFORMATION, title, headerText, contentText);
    }

    private void displayScreen(AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }
}
