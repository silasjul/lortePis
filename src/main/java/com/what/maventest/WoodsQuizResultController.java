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

    public Button goBackToWoods;
    @FXML
    private void initialize() {

        WoodsResults.appendText(String.valueOf(WoodsQuizQuestionController.correct + "/8"));

        int correct = WoodsQuizQuestionController.correct;

        if (correct < 2) {
            WoodsResults.appendText("\nOh no, you didn't do so well this time!");
            WoodsResults.appendText("\nYou got time to improve! Just ask your collegues.");
        } else if (correct >= 2 && correct <= 3) {
            WoodsResults.appendText("\n Damn! you didn't do so well.. Maybe next time !!");
            WoodsResults.appendText("\n");
        } else if (correct >= 4 && correct <= 5) {
            WoodsResults.appendText("\nYou did fine.. I know you can do better, ");
            WoodsResults.appendText("\nI know you will get everything correct next time!");
        } else if (correct == 6 ||   correct == 7) {
            WoodsResults.appendText("\nYou almost got every question correct");
            WoodsResults.appendText("\nNext time you've got this!.");
        } else if (correct == 8) {
            WoodsResults.appendText("\nOh yes, Perfect ! You nailed this quiz!!! you deserve an icecream!");
            WoodsResults.appendText("\n");
        }
    }
}
