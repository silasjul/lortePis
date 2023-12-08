package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

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

    @FXML
    public void continueQuizWoods(ActionEvent event) throws IOException {
        Main.setScene("quiz");
    }

    public static class WoodsQuiz {
        public WoodsQuiz(TextArea textArea) {
        }
    }

    private void updateWoodsQuizUI() {
        textArea.appendText("Hello and welcome to the Park Ranger Quiz!\n");
        textArea.appendText("In this Quiz you're going to be asked some questions about deforestation," +
                "\nenvironmental degradation, poaching and biodiversity loss.");
        textArea.appendText("\nIf you think you don't know enough about the subject yet, sucks to suck." +
                "\nYou had the time to learn before. " +
                "\nDid you maybe waste too much time hunting Poachers?");
    }
}
