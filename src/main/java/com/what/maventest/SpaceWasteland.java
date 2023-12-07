package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceWasteland extends Space{

    Image deadElephant = new Image(getClass().getResource("Animal/deadElephant.png").toString(), 250, 250, true, true);

    SpaceWasteland() {
        // BackgroundImg
        images.put("background",new Image(getClass().getResource("Map/Wasteland.png").toString(), Main.width, Main.height, true, true));
        images.put("water",new Image(getClass().getResource("Map/Water.png").toString(), 1800, Main.height, true, true));

        // Exit
        exits.add(new CollisionExit(169,25,366,-15, "start", 350, 750));

        // NPC
        npcs.add(new NPC("Sabrina", 100, 120, 550, 500, "NPC/SafariWoman.png", "#00D656", false, "wasteland"));

        // Bounds
        bounds.add(new CollisionObject(62,170,-10,665));
        bounds.add(new CollisionObject(74,15,-7,591));
        bounds.add(new CollisionObject(17,123,53,484));
        bounds.add(new CollisionObject(73,12,53,474));
        bounds.add(new CollisionObject(12,104,115,383));
        bounds.add(new CollisionObject(59,13,66,377));
        bounds.add(new CollisionObject(13,135,65,242));
        bounds.add(new CollisionObject(63,10,64,235));
        bounds.add(new CollisionObject(14,121,113,122));
        bounds.add(new CollisionObject(65,12,111,115));
        bounds.add(new CollisionObject(13,67,170,115));
        bounds.add(new CollisionObject(55,12,180,175));
        bounds.add(new CollisionObject(12, 128,230,177));
        bounds.add(new CollisionObject(139,11,231,298));
        bounds.add(new CollisionObject(12,118,357,182));
        bounds.add(new CollisionObject(66,14,357,171));
        bounds.add(new CollisionObject(17,110,410,84));
        bounds.add(new CollisionObject(12,106,355,-3));
        bounds.add(new CollisionObject(55,16,370,76));
        bounds.add(new CollisionObject(59,13,477,80));
        bounds.add(new CollisionObject(14,91,537,2));
        bounds.add(new CollisionObject(17,98,477,87));
        bounds.add(new CollisionObject(54,17,477,177));
        bounds.add(new CollisionObject(19,120,531,186));
        bounds.add(new CollisionObject(114,16,552,226));
        bounds.add(new CollisionObject(17,40,649,185));
        bounds.add(new CollisionObject(47,22,665,163));
        bounds.add(new CollisionObject(76,76,710,167));
        bounds.add(new CollisionObject(51, 19,785,163));
        bounds.add(new CollisionObject(64,80,834,162));
        bounds.add(new CollisionObject(64,72,835,290));
        bounds.add(new CollisionObject(13,49,890,241));
        bounds.add(new CollisionObject(9,361,897,358));
        bounds.add(new CollisionObject(910, 43,-3,860));
        bounds.add(new CollisionObject(72,63,173,795));
        bounds.add(new CollisionObject(442,58,283,803));
        bounds.add(new CollisionObject(24,72,407,733));
        bounds.add(new CollisionObject(70,70,769,792));
        bounds.add(new CollisionObject(68,120,831,680));
        bounds.add(new CollisionObject(16,271,-14,599));
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
        gc.drawImage(deadElephant, 200, 250);
        gc.drawImage(deadElephant, 400, 250);
        gc.drawImage(deadElephant, 300, 600);
    }
}
