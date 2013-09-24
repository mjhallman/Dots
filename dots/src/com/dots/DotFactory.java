package com.dots;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DotFactory {

    public static Dot createRandomDot(int x, int y) {
        return new Dot(x, y, DotColor.getRandom());
    }
}
