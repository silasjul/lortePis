package com.what.maventest;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class ResultController {
    @FXML
    public TextArea WoodsResults;

    @FXML
    private void initialize() {

        WoodsResults.appendText(String.valueOf(QuestionController.correct + "/15"));

        int correct = QuestionController.correct;

        if (correct < 2) {
            WoodsResults.appendText("\nOh no, you didn't do so well this time!");
            WoodsResults.appendText("\nYou got time to improve! Just ask your colleagues.");
        } else if (correct >= 3 && correct <= 5) {
            WoodsResults.appendText("\n Damn! you didn't do so well.. Maybe next time !!");
            WoodsResults.appendText("\n");
        } else if (correct >= 6 && correct <= 8) {
            WoodsResults.appendText("\nYou did fine.. I know you can do better, ");
            WoodsResults.appendText("\nI know you will get everything correct next time!");
        } else if (correct >= 9 && correct <= 11) {
            WoodsResults.appendText("\nYou did pretty well this time!");
            WoodsResults.appendText("\nNext time you're going to do even better!");
        } else if (correct == 12 ||   correct == 13) {
            WoodsResults.appendText("\nYou almost got every question correct!");
            WoodsResults.appendText("\nNext time you've got this in the bag!");
        } else if (correct == 14) {
            WoodsResults.appendText("\nOh yes, Perfect ! You nailed this quiz!!! you deserve an ice cream!");
            WoodsResults.appendText("\n");
        }
    }
}
