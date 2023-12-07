package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Poacher extends Animal {
    float killTimerStart;
    float timeAlive;
    final int killTime = 15;
    CollisionObject collider;
    Poacher(int width, int height, String image) {
        super(width, height, image);
        killTimerStart = Main.statusBar.timeSeconds;
        setup();
        collider = new CollisionObject(width, height, (int)x, (int)y);
    }

    @Override
    public void move() {
        super.move();
        timeAlive = Main.statusBar.timeSeconds - killTimerStart;
        if (walkVertical) collider.x += speed;
        else collider.y += speed;

        if (collider.isColliding() && Main.world.current == Main.world.spaces.get("savannah")) {
            // Start battle
            Main.setScene("battle");
            isDead = true;
            Main.player.resetKeys();
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        if (Main.isTesting) collider.draw(gc);
    }

    @Override
    public void setup() {
        super.setup();
        sleepCount = 0;
    }

    public void killAnimal(ArrayList<Animal> animals) {
        if (animals.isEmpty()) return;
        animals.get((int)(Math.random()*animals.size())).isDead = true;
        Main.statusBar.animalKillCount++;
        killTimerStart = Main.statusBar.timeSeconds;
    }
}
