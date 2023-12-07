package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CollisionObject {
    public int width, height;
    public double x, y;

    CollisionObject(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.web("#15F0FF", .5));
        gc.fillRect(x,y,width,height);
    }

    public boolean isColliding() {
        return (x < Main.player.collisionX && Main.player.collisionX < x + width) && (y < Main.player.collisionY && Main.player.collisionY < y + height);
    }
}
