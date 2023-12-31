package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class BattleController implements Initializable {

    @FXML
    private TextFlow textFlow;
    @FXML
    private TextArea textArea;

    private int playerHP = 100;

    private int enemyHP = 100;
    private int playerDamage;
    private int enemyDamage;
    Random random = new Random();
    boolean escapeSuccessful = false;

    private Battle battle;

    public BattleController() {
        this.battle = new Battle(textArea);
    }
    @FXML
    public ProgressBar myHealthbar;
    @FXML
    public ProgressBar enemyHealthbar;
    double health = 100;
    double enemyhealth = 100;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myHealthbar.setStyle("fx-accent: green;");
    }

    public static class Battle {
        private TextArea textArea;
        public Battle(TextArea textArea) {
            this.textArea = textArea;
        }
    }
    private GameController gameController;

    @FXML
    public void handleAttackButton(ActionEvent event) {
        playerDamage = random.nextInt(20) + 2;
        enemyDamage = random.nextInt(10) + 2;

        enemyHP -= playerDamage;
        playerHP -= enemyDamage;

        health -= enemyDamage;
        myHealthbar.setProgress(health/100);

        enemyhealth -= playerDamage;
        enemyHealthbar.setProgress(enemyhealth/100);

        updateUI();
        checkBattleResult();
    }

    @FXML
    private void handleDefendButton(ActionEvent event) {
        enemyDamage = new Random().nextInt(5) + 1;
        playerHP -= enemyDamage;

        health -= enemyDamage;
        myHealthbar.setProgress(health/100);

        updateUI();
        checkBattleResult();
    }

    @FXML
    public void handleRunButton(ActionEvent event) {
        double escape = Math.random();

        if (escape < 0.2) {
            textArea.clear();
            textArea.appendText("\nPlayer decided to flee from the battle like a little pussy");
            escapeSuccessful = true;
            battleOver();
        } else {
            int enemyDamage = new Random().nextInt(5) + 1;
            playerHP -= enemyDamage;
            health -= enemyDamage;
            myHealthbar.setProgress(health/100);
            textArea.clear();
            textArea.appendText("\nPlayer attempted to flee but couldn't escape!\nEnemy dealt " + enemyDamage + " damage to the player.");
        }
    }


    private void updateUI() {
        textArea.clear();
        textArea.appendText("\nPlayer HP: " + playerHP + "\nPoacher HP: " + enemyHP);
        textArea.appendText("\nPlayer dealt " + playerDamage + " damage to the poacher.");
        textArea.appendText("\nPoacher dealt " + enemyDamage + " damage to the player.");
    }

    private void checkBattleResult() {
        if (playerHP <= 0) {
            textArea.appendText("\nPlayer has been defeated. Game over!");
            handleGameOver(false);
        } else if (enemyHP <= 0) {
            textArea.appendText("\nEnemy has been defeated. You win!");
            battleOver();
            resetBattle();
        }
    }

    private void handleGameOver(boolean playerWins) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);

        if (playerWins) {
            alert.setContentText("Enemy has been defeated. You win!");
        } else {
            alert.setContentText("You have been defeated. Game over!");
        }

        alert.showAndWait();

        Stage stage = (Stage) textFlow.getScene().getWindow();
        stage.close();

        if (playerWins && gameController != null) {
            battleOver();
        }
    }

    private void battleOver() {
        Main.stage.getScene().setRoot(new Region());
        Main.stage.setScene(Main.gameScene);
        Main.stage.show();
        Main.tl.play();
    }

    private void resetBattle() {
        health = 100;
        enemyhealth = 100;
        playerHP = 100;
        enemyHP = 100;
        myHealthbar.setProgress(health/100);
        enemyHealthbar.setProgress(health/100);
    }
}
