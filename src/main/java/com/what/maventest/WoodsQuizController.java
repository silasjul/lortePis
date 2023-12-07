package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WoodsQuizController implements Initializable {

    public Button continueButton;
    public Button goBackToWoods;

    @FXML
    private TextArea textArea;

    private WoodsQuiz woodsQuiz;

    private GameController gameController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.woodsQuiz = new WoodsQuiz(textArea);
        updateWoodsQuizUI();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @FXML
    public void continueQuizWoods(ActionEvent event) throws IOException {
        gameController.goToWoodsQuiz();
    }

    @FXML
    public void goBackToWoodsButton(ActionEvent event) throws IOException {
        gameController.goBackToWoods();
    }

    public static class WoodsQuiz {
        public WoodsQuiz(TextArea textArea) {
        }
    }

    private void updateWoodsQuizUI() {
        textArea.appendText("Hello and welcome to the Woods Quiz!\n");
        textArea.appendText("In this Quiz you're going to be asked some questions about deforestation" +
                "\n and environmental degradation.");
        textArea.appendText("\nIf you think you don't know enough about the subject yet, " +
                "\nyou can go back and talk to me. I'll gladly tell you more or remind you.");
    }
}
