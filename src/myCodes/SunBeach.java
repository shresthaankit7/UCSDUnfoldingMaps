package myCodes;

import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;
import java.io.InputStream;

/**
 * Created by ankit07 on 10/30/16.
 */
public class SunBeach extends PApplet {

    PImage beachImage;
    int sunVelocity = 1;

    int sunPosX;
    int sunPosY;

    public void setup(){

        beachImage = loadImage(SunBeach.class.getClassLoader().getResource("resources/beach.jpeg").toString());
        beachImage.resize(0,height);

        sunPosX = (int) beachImage.width/4;
        sunPosY = (int) beachImage.height/3;

        size(beachImage.width,beachImage.height);

        image(beachImage,0,0);
    }

    public void draw(){
        int[] color = sunColor(second());
        fill(color[0],color[1],color[2]);

//        sunPosition();

        ellipse( sunPosX,sunPosY,40,40);

    }

    public int[] sunColor(float seconds){
        int[] rgb = new int[3];

        // Consider for color of sun with a minute. 30 is black.
        float diff = Math.abs(30-seconds);

        float ratio = diff/30;

        rgb[0] = (int) (255*ratio);
        rgb[1] = (int) (255*ratio);
        rgb[2] = 0;

        return rgb;
    }

    public void sunPosition(){

        if( sunPosX >= beachImage.width) {
            sunPosX = 0;
        }else {
            sunPosX = sunPosX + 1;
        }


        sunPosY = sunPosY +  (int) (0.5 * 9.8 * 1);

    }
}
