package com.what.maventest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {

    // screen size
    static int width = 900, height = 900;

    // init game
    static public boolean isTesting = false; // show collision objects
    static public Player player = new Player(360, 370);
    static public StatusBar statusBar = new StatusBar();
    static public World world = new World();
    static public GameController gameController = new GameController();
    static public Canvas canvas = new Canvas(width, height);
    static public Stage mainStage;
    static public Scene gameScene = new Scene(new StackPane(canvas), width, height);
    static public Parent root;


    @Override
    public void start(Stage stage) throws IOException {
        
        // Setup stage
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(5), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        mainStage = stage;
        //root = FXMLLoader.load(getClass().getResource("Office.fxml"));
        mainStage.setScene(gameScene);
        mainStage.show();
        tl.play();

        
        // Keypress
        gameScene.setOnKeyPressed(e -> player.keyPress(e));
        gameScene.setOnKeyReleased(e -> player.keyRelease(e));
    }

    private void run(GraphicsContext gc) {
        // Game Loop
        world.current.draw(gc);
        statusBar.display(gc);
        player.move();
        player.draw(gc);
    }

    public static void main(String[] args) {
        launch();
    }
}