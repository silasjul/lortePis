package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceForest extends Space {
    double waterX = 0;
    SpaceForest() {
        // BackgroundImg
        images.put("background" ,new Image(getClass().getResource("Map/Forest.png").toString(), Main.width, Main.height, true, true));
        images.put("water" ,new Image(getClass().getResource("Map/Water.png").toString(), 1800, Main.height, true, true));

        // Exit
        exits.add(new CollisionExit(18,66,-8,416, "start", 800, 400));

        // NPC
        npcs.add(new NPC("Lumberjack", 100, 120, 650, 280, "NPC/Lumberjack.png", "#EB1423", false, "woods"));

        // Bounds
        bounds.add(new CollisionObject(50,278,2,624));
        bounds.add(new CollisionObject(60,76,52,564));
        bounds.add(new CollisionObject(132,282,112,478));
        bounds.add(new CollisionObject(66,226,178,200));
        bounds.add(new CollisionObject(96,372,242,44));
        bounds.add(new CollisionObject(52,132,338,176));
        bounds.add(new CollisionObject(38,90,368,308));
        bounds.add(new CollisionObject(126,154,406,200));
        bounds.add(new CollisionObject(125,120,532,116));
        bounds.add(new CollisionObject(140,76,657, 84));
        bounds.add(new CollisionObject(104, 154, 797, 83));
        bounds.add(new CollisionObject(56, 437,845,236));
        bounds.add(new CollisionObject(61,839,229,637));
        bounds.add(new CollisionObject(122, 103, 717, 799));
        bounds.add(new CollisionObject(55, 221,662,676));
        bounds.add(new CollisionObject(68,124,626,552));
        bounds.add(new CollisionObject(88, 120, 560, 432));
        bounds.add(new CollisionObject(95,104,244,547));
        bounds.add(new CollisionObject(139,58,319,489));
        bounds.add(new CollisionObject(42,69,458,544));
        bounds.add(new CollisionObject(63, 156,115,202));
        bounds.add(new CollisionObject(115,79,0,229));
        bounds.add(new CollisionObject(65,37,113,390));
        bounds.add(new CollisionObject(61,229,839,673));
        bounds.add(new CollisionObject(59, 55, 500, 500));

    }
}
