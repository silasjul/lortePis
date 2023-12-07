package com.what.maventest;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceSavannah extends Space{
    SpaceSavannah() {
        // BackgroundImg
        images.put("background",new Image(getClass().getResource("Map/Savannah.png").toString(), Main.width, Main.height, true, true));
        images.put("water",new Image(getClass().getResource("Map/Water.png").toString(), 1800, Main.height, true, true));

        // Exit
        exits.add(new CollisionExit(26,118,893,365, "start", -20, 350));

        // Animals
        String[] animalPictures = {"Animal/Duck.png", "Animal/Elephant.png", "Animal/Giraf.png"};
        for (int i = 0; i < 10; i++) {
            animals.add(new Animal(150,150, animalPictures[(int)(Math.random()*animalPictures.length)]));
        }

        // Bounds
        bounds.add(new CollisionObject(79,78,201,798));
        bounds.add(new CollisionObject(605,19,-4,896));
        bounds.add(new CollisionObject(18,899,-13,-3));
        bounds.add(new CollisionObject(519,13,8,-9));
        bounds.add(new CollisionObject(103,109,9,8));
        bounds.add(new CollisionObject(44,171,9,243));
        bounds.add(new CollisionObject(99,176,9,599));
        bounds.add(new CollisionObject(245,63,652,480));
        bounds.add(new CollisionObject(73,119,652,306));
        bounds.add(new CollisionObject(172,20,726,346));
        bounds.add(new CollisionObject(62,130,589,176));
        bounds.add(new CollisionObject(52,103, 536,86));
        bounds.add(new CollisionObject(72,62,532,1));
        bounds.add(new CollisionObject(33,51,594,60));
        bounds.add(new CollisionObject(34,108,652,542));
        bounds.add(new CollisionObject(57,287,594,620));
        bounds.add(new CollisionObject(54,99,536,742));
        bounds.add(new CollisionObject(49,22,542,872));

    }
}
