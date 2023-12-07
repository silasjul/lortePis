package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceDesert extends Space {

    SpaceDesert() {
        // BackgroundImg
        images.put("background",new Image(getClass().getResource("Map/Desert.png").toString(), Main.width, Main.height, true, true));
        images.put("water",new Image(getClass().getResource("Map/Water.png").toString(), 1800, Main.height, true, true));

        // Exit
        exits.add(new CollisionExit(290,17,358,892, "start", 430, -80));

        // NPC
        npcs.add(new NPC("Sabrina", 100, 120, 520, 200, "NPC/SafariWoman.png", "#EA6B41", false, "safari"));

        // Bounds
        bounds.add(new CollisionObject(53,83,621,198));
        bounds.add(new CollisionObject(54,48,682,141));
        bounds.add(new CollisionObject(138,148,677,190));
        bounds.add(new CollisionObject(49,48,768,141));
        bounds.add(new CollisionObject(204,100,220,681));
        bounds.add(new CollisionObject(67,100,476,681));
        bounds.add(new CollisionObject(134,49,534,677));
        bounds.add(new CollisionObject(97,58,594,725));
        bounds.add(new CollisionObject(40,116,650,784));
        bounds.add(new CollisionObject(96,62,272,781));
        bounds.add(new CollisionObject(99,30,259,875));
        bounds.add(new CollisionObject(21,34,283,842));
        bounds.add(new CollisionObject(241,62,677,617));
        bounds.add(new CollisionObject(49,51,858,-9));
        bounds.add(new CollisionObject(53,43,-10,-4));
        bounds.add(new CollisionObject(42,99,0,500));
        bounds.add(new CollisionObject(125,60,40,555));
        bounds.add(new CollisionObject(83,63,144,616));
        bounds.add(new CollisionObject(52,58,740,558));
        bounds.add(new CollisionObject(86,55,825,561));
        bounds.add(new CollisionObject(42,58,858,500));
        bounds.add(new CollisionObject(10,456,897,42));
        bounds.add(new CollisionObject(15,455,-8,42));
        bounds.add(new CollisionObject(812,20,44,-4));
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        //gc.drawImage(deadElephant, 200, 200);
    }
}
