package com.dots.models;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class DotModel {

//    private DotColor color;
    private Color color;
    private int x; // X-coord. [0-5]
    private int y; // Y-coord. [0-5]

    public DotModel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color= color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}