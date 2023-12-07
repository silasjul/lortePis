package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;


public class WoodsQuizResultController {
    @FXML
    public TextArea WoodsResults;

    @FXML
    private void initialize() {

        WoodsResults.appendText(String.valueOf(WoodsQuizQuestionController.correct + "/16"));

        int correct = WoodsQuizQuestionController.correct;

        if (correct < 2) {
            WoodsResults.appendText("\nOh no, you didn't do so well this time!");
            WoodsResults.appendText("\nYou got time to improve! Just ask your colleagues.");
        } else if (correct >= 3 && correct <= 5) {
            WoodsResults.appendText("\n Damn! you didn't do so well.. Maybe next time !!");
            WoodsResults.appendText("\n");
        } else if (correct >= 6 && correct <= 8) {
            WoodsResults.appendText("\nYou did fine.. I know you can do better, ");
            WoodsResults.appendText("\nI know you will get everything correct next time!");
        } else if (correct >= 9 && correct <= 12) {
            WoodsResults.appendText("\nYou did pretty well this time!");
            WoodsResults.appendText("\nNext time you're going to do even better!");
        } else if (correct == 13 ||   correct == 14) {
            WoodsResults.appendText("\nYou almost got every question correct!");
            WoodsResults.appendText("\nNext time you've got this in the bag!");
        } else if (correct == 15) {
            WoodsResults.appendText("\nOh yes, Perfect ! You nailed this quiz!!! you deserve an ice cream!");
            WoodsResults.appendText("\n");
        }
    }
}
