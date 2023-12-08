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

    static public Canvas canvas = new Canvas(width, height);
    static public Stage stage;
    static public Parent daRoot = new StackPane(canvas);
    static public Scene gameScene = new Scene(daRoot, width, height);
    static public HashMap<String, Parent> rooms = new HashMap<>();
    static public Timeline tl = new Timeline();


    @Override
    public void start(Stage stage) throws IOException {

        // Add Rooms
        rooms.put("office", FXMLLoader.load(getClass().getResource("fxml/Office.fxml")));
        rooms.put("outside", FXMLLoader.load(getClass().getResource("fxml/Outside.fxml")));
        rooms.put("woods", FXMLLoader.load(getClass().getResource("fxml/Woods.fxml")));
        rooms.put("safari", FXMLLoader.load(getClass().getResource("fxml/Safari.fxml")));
        rooms.put("wasteland", FXMLLoader.load(getClass().getResource("fxml/Wasteland.fxml")));
        rooms.put("battle", FXMLLoader.load(getClass().getResource("fxml/Battle.fxml")));
        rooms.put("quizIntro", FXMLLoader.load(getClass().getResource("fxml/WoodsIntro.fxml")));
        rooms.put("quiz", FXMLLoader.load(getClass().getResource("fxml/QuizWoodsQuestions.fxml")));


        // Setup stage
        GraphicsContext gc = canvas.getGraphicsContext2D();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(5), e -> run(gc)));
        tl.setCycleCount(Timeline.INDEFINITE);
        this.stage = stage;
        stage.setScene(gameScene);
        stage.show();
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

    static public void setScene(String roomName) {
        tl.stop();
        Scene scene = new Scene(rooms.get(roomName));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}