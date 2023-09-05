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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
    private AnchorPane mainAnchorPane;

    @FXML
    private Separator menuSeparator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

    public void handleFornecedoresButton() {
        applicationAnchorPane.getChildren().clear(); // Limpando o conteudo do AnchorPane pai
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FornecedoresView.fxml"));
        try {
            // Carregando o conteudo da nova tela
            AnchorPane novoConteudo = loader.load();

            // Definindo as costraints do novo conteudo para ocupar 100% da tela
            AnchorPane.setBottomAnchor(novoConteudo, 0.0);
            AnchorPane.setTopAnchor(novoConteudo, 0.0);
            AnchorPane.setRightAnchor(novoConteudo, 0.0);
            AnchorPane.setLeftAnchor(novoConteudo, 0.0);

            // Definindo o conteúdo do AnchorPane existente como o novo conteúdo carregado
            applicationAnchorPane.getChildren().setAll(novoConteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleEstoqueButton() {
        applicationAnchorPane.getChildren().clear(); // Limpando o conteudo do AnchorPane pai
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EstoqueView.fxml"));
        try {
            // Carregando o conteudo da nova tela
            AnchorPane novoConteudo = loader.load();

            // Definindo as costraints do novo conteudo para ocupar 100% da tela
            AnchorPane.setBottomAnchor(novoConteudo, 0.0);
            AnchorPane.setTopAnchor(novoConteudo, 0.0);
            AnchorPane.setRightAnchor(novoConteudo, 0.0);
            AnchorPane.setLeftAnchor(novoConteudo, 0.0);

            // Definindo o conteúdo do AnchorPane existente como o novo conteúdo carregado
            applicationAnchorPane.getChildren().setAll(novoConteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleClientesButton() {
        applicationAnchorPane.getChildren().clear(); // Limpando o conteudo do AnchorPane pai
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ClienteView.fxml"));
        try {
            // Carregando o conteudo da nova tela
            AnchorPane novoConteudo = loader.load();

            // Definindo as costraints do novo conteudo para ocupar 100% da tela
            AnchorPane.setBottomAnchor(novoConteudo, 0.0);
            AnchorPane.setTopAnchor(novoConteudo, 0.0);
            AnchorPane.setRightAnchor(novoConteudo, 0.0);
            AnchorPane.setLeftAnchor(novoConteudo, 0.0);

            // Definindo o conteúdo do AnchorPane existente como o novo conteúdo carregado
            applicationAnchorPane.getChildren().setAll(novoConteudo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
