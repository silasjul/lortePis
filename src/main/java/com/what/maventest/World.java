package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class World {
    Space current;
    HashMap<String, Space> spaces = new HashMap<>();

    World() {
        spaces.put("office", new SpaceOffice());
        spaces.put("start", new SpaceStart());
        spaces.put("forest", new SpaceForest());
        spaces.put("wasteland", new SpaceWasteland());
        spaces.put("savannah", new SpaceSavannah());
        spaces.put("desert", new SpaceDesert());

        current = spaces.get("start");
    }

    public void transition(CollisionExit exit) {
        Main.player.x = exit.spawnX;
        Main.player.y = exit.spawnY;
        current = spaces.get(exit.spaceName);
    }
}
