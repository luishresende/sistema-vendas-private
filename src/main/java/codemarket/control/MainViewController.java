/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane applicationAnchorPane;

    @FXML
    private Button menuButton; // Menu Principal

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
    private AnchorPane mainAnchorPane;
    
    @FXML
    private Separator menuSeparator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        menuButton.setOnAction(event -> {
            closeSideBarTransition();
        });
    }

    public void closeSideBarTransition() {
        Timeline timeline = new Timeline();
        sideBarContentGridPane.setEffect(null);
        /*menuSeparatorColumn.setPercentWidth(3);
        menuSeparatorGridPane.setVisible(true);*/

        double parentWidth = mainAnchorPane.getScene().getWidth(); // Obtém a largura da GridPane pai
        double sideBarWidth = parentWidth * (sideBarColumn.getPercentWidth() / 100.0); // Calcula a largura da sideBarColumn em pixels

        KeyFrame transitionFrame1 = new KeyFrame(Duration.seconds(0.5),
                new KeyValue(sideBarContentGridPane.translateXProperty(), -sideBarWidth)
        );

        KeyFrame transitionFrame2 = new KeyFrame(Duration.seconds(0.4),
                new KeyValue(sideBarColumn.percentWidthProperty(), 0),
                new KeyValue(applicationColumn.percentWidthProperty(), 100)
        );

        timeline.getKeyFrames().add(transitionFrame1);
        timeline.getKeyFrames().add(transitionFrame2);
        timeline.play();
    }
    
    public void appearMenuSeparator(){
        menuSeparator.setVisible(true);
    }

    public void handleFornecedoresButton() {
        applicationAnchorPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FornecedoresView.fxml"));
        try {
            // Carregue o conteúdo do novo FXML
            AnchorPane novoConteudo = loader.load();
            AnchorPane.setBottomAnchor(novoConteudo, 0.0);
            AnchorPane.setTopAnchor(novoConteudo, 0.0);
            AnchorPane.setRightAnchor(novoConteudo, 0.0);
            AnchorPane.setLeftAnchor(novoConteudo, 0.0);
            // Defina o conteúdo do AnchorPane existente como o novo conteúdo carregado
            applicationAnchorPane.getChildren().setAll(novoConteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
