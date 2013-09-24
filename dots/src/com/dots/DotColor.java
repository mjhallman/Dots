package com.dots;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public enum DotColor {
    YELLOW, GREEN, RED, PURPLE, BLUE,

    UNKNOWN;


    public static DotColor getRandom() {
        return values()[(int) (Math.random() * values().length-1)];
    }
}
