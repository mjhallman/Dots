package com.dots;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dot {

    private DotColor color;
    private int x; // X-coord. [0-5]
    private int y; // Y-coord. [0-5]

    public Dot(int x, int y, DotColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public DotColor getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
