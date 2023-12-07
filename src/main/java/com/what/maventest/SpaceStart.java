package com.what.maventest;

import javafx.scene.image.Image;

public class SpaceStart extends Space{

    SpaceStart() {
        // BackgroundImg
        images.put("background",new Image(getClass().getResource("Map/start.png").toString(), Main.width, Main.height, true, true));

        // NPC
        npcs.add(new NPC("James Brown", 100, 120, 380, 300, "NPC/CoffeeMan.png", "#3C4AEA", true, "office"));

        // Animal

        // Exit
        exits.add(new CollisionExit(66,36,239,169, "office", 100, 550));
        exits.add(new CollisionExit(26,93,-11,437, "savannah", 800, 320));
        exits.add(new CollisionExit(28,103,887,476, "forest", -50, 340));
        exits.add(new CollisionExit(106,31,400,878, "wasteland", 350, -100));
        exits.add(new CollisionExit(67,43,493,-29, "desert", 350, 750));


        // Bounds
        bounds.add(new CollisionObject(160, 200, 0, 700));
        bounds.add(new CollisionObject(391, 21, 508, 896));
        bounds.add(new CollisionObject(239,30,159,890));
        bounds.add(new CollisionObject(91,161,0,529));
        bounds.add(new CollisionObject(15,431,-15,1));
        bounds.add(new CollisionObject(477,15,1,-15));
        bounds.add(new CollisionObject(86,53,94,350));
        bounds.add(new CollisionObject(55,148,85,23));
        bounds.add(new CollisionObject(186,176,185,1));
        bounds.add(new CollisionObject(57,153,555,96));
        bounds.add(new CollisionObject(124,166,631,21));
        bounds.add(new CollisionObject(127,159,772,94));
        bounds.add(new CollisionObject(332,18,567,-17));
        bounds.add(new CollisionObject(14,475,901,1));
        bounds.add(new CollisionObject(16,344,902,556));
        bounds.add(new CollisionObject(232,87,539,612));
        bounds.add(new CollisionObject(64,155,764,721));
    }
}
