package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CollisionExit extends CollisionObject {
    int spawnX, spawnY;
    String spaceName;
    CollisionExit(int width, int height, int x, int y, String space, int spawnX, int spawnY) {
        super(width, height, x, y);
        this.spaceName = space;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.web("#3be529"));
        gc.fillRect(x,y,width,height);
    }
}
