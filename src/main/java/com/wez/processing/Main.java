package com.wez.processing;

import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String args[]) {
        PApplet.main(Main.class.getName(), args);
    }

    @Override
    public void settings() {
        size(1024, 768);
    }

    @Override
    public void setup() {
        background(255);
    }

    @Override
    public void draw() {
        stroke(0);
        fill(255, 0, 255);
        ellipse(width / 2f, height / 2f, 100, 100);
    }
}
