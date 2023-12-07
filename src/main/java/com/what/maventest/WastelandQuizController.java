package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WastelandQuizController implements Initializable {

    public Button continueButton;
    public Button goBackToWasteland;

    @FXML
    private TextArea textArea;

    private WastelandQuiz wastelandQuiz;

    private GameController gameController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.wastelandQuiz = new WastelandQuiz(textArea);
        updateWastelandQuizUI();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @FXML
    public void continueQuizWasteland(ActionEvent event) throws IOException {
        gameController.goToWastelandQuiz();
    }

    @FXML
    public void goBackToWasteland(ActionEvent event) throws IOException {
        gameController.goBackToWasteland();
    }

    public static class WastelandQuiz {
        public WastelandQuiz(TextArea textArea) {
        }
    }

    private void updateWastelandQuizUI() {
        textArea.appendText("Hello and welcome to the Poaching Quiz!\n");
        textArea.appendText("In this Quiz you're going to be asked some questions about poaching.\n");
        textArea.appendText("   \n");
    }
}
