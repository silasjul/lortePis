package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animal {
    boolean isDead = false, walkVertical = true;
    double x, y, speed = 0.16f, distanceWalked = 0f, maxWalkingDistance = 20;
    int width, height;
    int minX = 100, maxX = 400, minY = 150, maxY = 550;
    double sleepCount = 0;
    Image image;
    Image deadElephant = new Image(getClass().getResource("Animal/deadElephant.png").toString(), 250, 250, true, true);
    Animal(int width, int height, String image) {
        this.image = new Image(getClass().getResource(image).toString(), width, height, true, false);
        setup();
    }

    public void move() {
        if (isDead) return;
        // stands still when spawning
        if (sleepCount > 0) {
            sleepCount--;
            return;
        }

        // Walk in the selected direction and swap direction when maxWalkingDistance reached
        if (distanceWalked > maxWalkingDistance || distanceWalked < -maxWalkingDistance) {
            speed *= -1;
            distanceWalked = 0;
        }
        if (walkVertical) x += speed;
        else y += speed;
        distanceWalked += Math.sqrt(Math.pow(speed, 2) * Math.pow(speed, 2));
    }

    public void draw(GraphicsContext gc) {
        if (isDead) {
            gc.drawImage(deadElephant, x, y);
            return;
        }
        if (speed > 0) gc.drawImage(image, x+image.getWidth(), y, -image.getWidth(), image.getHeight());
        else gc.drawImage(image, x, y);
    }

    void setup() {
        // walks in a random direction on a random axis
        if (Math.random() < 0.5) walkVertical = false;
        if (Math.random() < 0.5) speed *= -1;
        sleepCount = Math.random()*2000;

        // Random spawn location
        x = minX + Math.random() * (maxX-minX);
        y = minY + Math.random() * (maxY-minY);
    }
}
