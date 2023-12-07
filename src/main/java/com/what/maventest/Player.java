package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    public int size = 200; // player starting pos
    public float walkSpeed = 1.2f, runSpeed = 1.8f, x, y;
    public float drawRadius = 10, collisionX, collisionY;

    // Player controls
    public HashMap<String, Boolean> controls = new HashMap<>();
    public String direction = "s";
    public boolean isRunning;
    public boolean interactPressed;
    public ArrayList<CollisionObject> colliding = new ArrayList<>();

    // inventory
    public ArrayList<Item> inventory = new ArrayList<>();

    HashMap<String, Image> playerImg = new HashMap<>();

    Player(int startPosX, int startPosY) {
        // add controls
        controls.put("w", false);
        controls.put("a", false);
        controls.put("s", false);
        controls.put("d", false);

        // startPos
        x = startPosX;
        y = startPosY;

        // Player images
        playerImg.put("w", new Image(getClass().getResource("Player/PlayerUp.png").toString(), size, size, true, true));
        playerImg.put("s", new Image(getClass().getResource("Player/PlayerDown.png").toString(), size, size, false, false));
        playerImg.put("d", new Image(getClass().getResource("Player/PlayerRight.png").toString(), size, size, false, false));
        playerImg.put("a", new Image(getClass().getResource("Player/PlayerLeft.png").toString(), size, size, false, false));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(playerImg.get(direction), x, y);

        if (Main.isTesting) {
            gc.setFill(Color.web("#5BFF93"));
            gc.fillOval(collisionX-((double) drawRadius /2),collisionY-((double) drawRadius /2),drawRadius,drawRadius);
        }
    }

    public void move() {
        // Check collision
        colliding.clear();
        collisionX = x + 85;
        collisionY = y + 125;

        // If at exit leave
        for (CollisionExit exit : Main.world.current.exits) if (exit.isColliding()) Main.world.transition(exit);


        // check for colliding bounds
        for (CollisionObject collider : Main.world.current.bounds) {
            if (collider.isColliding()) colliding.add(collider);
        }


        // Move player

        int dirCount = 0;
        float speed = walkSpeed;
        if (isRunning) speed = runSpeed;
        float moveX = 0, moveY = 0;

        for (String dir : controls.keySet()) {
            if (controls.get(dir)) {
                switch (dir) {
                    case "w" -> moveY = -speed;
                    case "s" -> moveY =  speed;
                    case "a" -> moveX = -speed;
                    case "d" -> moveX =  speed;
                }
                direction = dir;
                dirCount++;
            }
        }

        // Move slower in multiple directions

        moveX = dirCount > 1 ? moveX * 0.8f : moveX;
        moveY = dirCount > 1 ? moveY * 0.8f : moveY;

        // No collision

        if (colliding.isEmpty()) {
            x += moveX;
            y += moveY;
            return;
        }

        // Collision

        boolean xIsBlocked = false, yIsBlocked = false;

        for (CollisionObject collider : colliding) {
            double distanceX = Math.abs(collider.x + (collider.width/2.) - collisionX);
            double distanceY = Math.abs(collider.y + (collider.height/2.) - collisionY);
            double distanceXAfterMove = Math.abs(collider.x + (collider.width/2.) - (collisionX + moveX));
            double distanceYAfterMove = Math.abs(collider.y + (collider.height/2.) - (collisionY + moveY));


            // DistanceX = distance to horizontal center of square
            // If player is at the edge of the square
            if (distanceX > (collider.width/2.)-5) {
                // You cannot move towards the center of the collider
                if (distanceXAfterMove < distanceX) xIsBlocked = true;
            }
            if (distanceY > (collider.height/2.)-5) {
                if (distanceYAfterMove < distanceY) yIsBlocked = true;
            }


//            System.out.print("DistanceX: " + distanceX +" Height: " + collider.width/2. + "\t");
//            System.out.print(" DistanceY: " + distanceY +" Height: " + collider.height/2. + "\n");
//            x += moveX;
//            y += moveY;

        }
        // System.out.println(colliding.size());
        if (!xIsBlocked) x += moveX;
        if (!yIsBlocked) y += moveY;

    }

    public void keyPress(KeyEvent e) {
        if (e.getCode() == KeyCode.SHIFT) {isRunning = true; return;}
        else if (e.getCode() == KeyCode.SPACE) {interactPressed = true; return;}
        controls.replace(e.getText(), true);
    }

    public void keyRelease(KeyEvent e) {
        if (e.getCode() == KeyCode.SHIFT) {isRunning = false; return;}
        else if (e.getCode() == KeyCode.SPACE) {interactPressed = false; return;}
        controls.replace(e.getText(), false);
    }

    public void resetKeys() {

    }
}
