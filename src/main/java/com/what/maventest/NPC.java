package com.what.maventest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.EventObject;

public class NPC {
    int width, height, x, y;
    boolean flipImage;
    Image image;
    String name, room;
    CollisionObject collider;
    String color;
    NPC(String name, int width, int height, int x, int y, String image, String textNameColor, boolean flipImage, String roomName) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.image = new Image(getClass().getResource(image).toString(), width, height, true, true);
        collider = new CollisionObject(width, height, x, y);
        this.color = textNameColor;
        this.flipImage = flipImage;
        this.room = roomName;
    }

    public void draw(GraphicsContext gc) {
        if (flipImage) gc.drawImage(image, x+image.getWidth(), y, -image.getWidth(), image.getHeight());
        else gc.drawImage(image, x, y);

        if (collider.isColliding()) {
            gc.setFill(Color.BLACK);
            gc.setFont(Font.font("Gill Sans", FontWeight.NORMAL, 20));
            gc.fillText("Talk to ", x-30, y-10);
            gc.setFill(Color.web(color));
            gc.fillText(name, x+35, y-10);

            if (Main.player.interactPressed) {
                // Talking to npc
                Main.setScene(room);
                Main.player.resetKeys();
            }
        }
        if (Main.isTesting) collider.draw(gc);
    }
}
