package com.dots.models;

import java.awt.*;

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

    private Color yellow = Color.yellow;
    private Color red = Color.red;
    private Color green = Color.green;
    private Color magenta = Color.magenta;
    private Color blue = Color.blue;

    private Color selectYellow = new Color(255,255,224);
    private Color selectRed = new Color(255,90,90);
    private Color selectGreen = new Color(150,255,150);
    private Color selectMagenta = new Color(255,130,250);
    private Color selectBlue = new Color(90,90,255);

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

    public Color nextColor(Color currentColor) {
        if(currentColor==yellow)
            return red;
        else if(currentColor==red)
            return green;
        else if(currentColor==green)
            return magenta;
        else if(currentColor==magenta)
            return blue;
        else if(currentColor==blue)
            return yellow;
        else
            return Color.white;
    }

    public Color selectColor(Color currentColor){
        if(currentColor==Color.YELLOW)
            return selectYellow;
        else if(currentColor==Color.RED)
            return selectRed;
        else if(currentColor==Color.GREEN)
            return selectGreen;
        else if(currentColor==Color.MAGENTA)
            return selectMagenta;
        else if(currentColor==Color.BLUE)
            return selectBlue;
        else if(currentColor==selectYellow)
            return Color.YELLOW;
        else if(currentColor==selectRed)
            return Color.RED;
        else if(currentColor==selectGreen)
            return Color.GREEN;
        else if(currentColor==selectMagenta)
            return Color.MAGENTA;
        else if(currentColor==selectBlue)
            return Color.BLUE;
        else
            return Color.white;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DotModel that = (DotModel) o;

        if ( (color == that.getColor()) &&  (x == that.getX()) && (y == that.getY())) {
            return true;
        }
        return false;
    }



}