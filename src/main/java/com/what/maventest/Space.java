package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class Space {
    double waterX = 0;
    HashMap<String, Image> images = new HashMap<>();
    ArrayList<CollisionObject> bounds = new ArrayList<>();
    ArrayList<CollisionExit> exits = new ArrayList<>();
    ArrayList<NPC> npcs = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Poacher> poachers = new ArrayList<>();

    public void draw(GraphicsContext gc) {
        if (Main.world.current != Main.world.spaces.get("savannah")) Main.world.spaces.get("savannah").update();

        // Draw background
        if (images.containsKey("water")) drawWater(gc);
        else {
            gc.setFill(Color.BLACK);
            gc.fillRect(0,0, Main.width, Main.height);
        }

        // Draw map
        gc.drawImage(images.get("background"), 0, 0);

        // Draw characters
        for (NPC npc : npcs) npc.draw(gc);

        for (Animal animal : animals) {
            animal.move();
            animal.draw(gc);
        }

        for (Poacher poacher : poachers) {
            poacher.move();
            poacher.draw(gc);
            if (poacher.isDead) {
                poachers.remove(poacher);
                break;
            }

            if (poacher.timeAlive > poacher.killTime) poacher.killAnimal(animals);
        }

        // Draw bounds during testing
        if (Main.isTesting) {
            for (CollisionObject collider : Main.world.current.bounds) collider.draw(gc);
            for (CollisionExit exit : Main.world.current.exits) exit.draw(gc);
        }
    }

    public void drawWater(GraphicsContext gc) {
        gc.drawImage(images.get("water"), -waterX, 0);
        waterX += 0.2;
        if (waterX > 900) waterX = 0;
    }

    public void spawnPoacher() {
        poachers.add(new Poacher(100, 100, "NPC/Poacher.png"));
    }

    public void update() {
        for (Animal animal : animals) {
            animal.move();
        }

        for (Poacher poacher : poachers) {
            poacher.move();
            if (poacher.timeAlive > poacher.killTime) poacher.killAnimal(animals);
        }
    }
}
