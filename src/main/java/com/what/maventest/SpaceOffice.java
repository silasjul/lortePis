package com.what.maventest;

import javafx.scene.image.Image;

public class SpaceOffice extends Space {

    SpaceOffice() {
        // BackgroundImg
        images.put("background", new Image(getClass().getResource("Map/office.png").toString(), Main.width, Main.height, true, true));

        // NPC
        npcs.add(new NPC("Smart office man", 100, 120, 700, 300, "NPC/CoffeeMan.png", "#3C4AEA", false, "office"));


        // Exit
        exits.add(new CollisionExit(84,13,154,722, "start", 180, 100));

        // Bounds
        bounds.add(new CollisionObject(95, 42, 425, 275));
        bounds.add(new CollisionObject(300,80,23,338));
        bounds.add(new CollisionObject(13,358,7,249));
        bounds.add(new CollisionObject(855,83,23,166));
        bounds.add(new CollisionObject(166,81,452,336));
        bounds.add(new CollisionObject(299,78,578,466));
        bounds.add(new CollisionObject(16,440,879,165));
        bounds.add(new CollisionObject(39,49,580,417));
        bounds.add(new CollisionObject(597,11,280,593));
        bounds.add(new CollisionObject(88,13,20,592));
        bounds.add(new CollisionObject(17,128,90,608));
        bounds.add(new CollisionObject(16,128,282,605));
        bounds.add(new CollisionObject(46,14,108,722));
        bounds.add(new CollisionObject(42,12,237,722));
        bounds.add(new CollisionObject(40,71,536,426));
        bounds.add(new CollisionObject(51,82,819,374));
        bounds.add(new CollisionObject(31,50,837,297));
        bounds.add(new CollisionObject(31,25,50,560));
        bounds.add(new CollisionObject(79,61,239,250));
    }
}
