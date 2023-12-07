package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

public class StatusBar {
    int animalKillCount = 0;
    final int secondsInADay = 30;
    int daysToQuizStart = 5;
    int daysPassed = 0;
    Long timeGameStart;
    public Float timeSeconds;

    StatusBar() {
        timeGameStart = System.currentTimeMillis();
    }

    public void display(GraphicsContext gc) {
        update();
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Gill Sans", FontWeight.BOLD, 30));
        gc.fillText(String.format("Days to Quiz: %s  |  Animals killed: %d", daysToQuizStart, animalKillCount), 30,40);
    }

    public void update() {

        // Lose after 3 animals die
        if (animalKillCount >= 3) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("YOU LOST!");
            alert.setHeaderText("TOO MANY ANIMALS DIED");
            alert.setContentText("Game over - you are a loser!");
            alert.show();
            Main.stage.close();
            Main.tl.stop();
            return;
        }

        timeSeconds = (System.currentTimeMillis() - timeGameStart) / 1000F;
        if (isNewDay()) Main.world.spaces.get("savannah").spawnPoacher();
        daysPassed = (int)(timeSeconds / secondsInADay);
        daysToQuizStart = 5 - daysPassed;
        if (daysToQuizStart == 0) Main.setScene("quizIntro");
    }

    public boolean isNewDay() {
        return daysPassed != (int)(timeSeconds / secondsInADay);
    }
}
