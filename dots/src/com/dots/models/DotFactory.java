package com.dots.models;

import java.awt.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DotFactory {
    private DotModel dot;

    public static DotModel createRandomDot(int x, int y) {

        return new DotModel(x, y, getRandomColor());
    }

    private static Color getRandomColor() {
        Random r = new Random();

        int c = r.nextInt(5);

//        YELLOW, GREEN, RED, PURPLE, BLUE,

        if (c == 0) {
            return Color.YELLOW;
        } else if (c == 1) {
            return Color.GREEN;
        } else if (c == 2) {
            return Color.RED;
        } else if (c == 3) {
            return Color.MAGENTA;
        } else if (c == 4) {
            return Color.BLUE;
        }
        return null;
    }

}