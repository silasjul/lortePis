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


public class WastelandQuizResultController {
    @FXML
    public TextArea WastelandResults;

    public Button goBackToWasteland;
    private Stage stage;
    private Parent root;
    private GameController gameController;
    @FXML
    private void initialize() {

        WastelandResults.appendText(String.valueOf(WastelandQuizQuestionController.correct + "/8"));

        int correct = WastelandQuizQuestionController.correct;

        if (correct < 2) {
            WastelandResults.appendText("\nOh no, you didn't do so well this time!");
            WastelandResults.appendText("\nYou got time to improve! Just ask your collegues.");
        } else if (correct >= 2 && correct <= 3) {
            WastelandResults.appendText("\n Damn! you didn't do so well.. Maybe next time !!");
            WastelandResults.appendText("\n");
        } else if (correct >= 4 && correct <= 5) {
            WastelandResults.appendText("\nYou did fine.. I know you can do better, ");
            WastelandResults.appendText("\nI know you will get everything correct next time!");
        } else if (correct == 6 ||   correct == 7) {
            WastelandResults.appendText("\n You almost got every question correct");
            WastelandResults.appendText("\nNext time you've got this!.");
        } else if (correct == 8) {
            WastelandResults.appendText("\nOh yes, Perfect ! You nailed this quiz!!! you deserve an ice cream!");
            WastelandResults.appendText("\n");
        }
    }

    public void goBackToWasteland () throws IOException {
        root = FXMLLoader.load(getClass().getResource("Wasteland.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void goBackToWastelandButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        goBackToWasteland();
    }


    public void setGameController(GameController wastelandQuizQuestionController) {
        gameController = wastelandQuizQuestionController;
    }
}
