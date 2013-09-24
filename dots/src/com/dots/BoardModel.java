package com.dots;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardModel {

    public static final int BOARD_SIZE = 5;

    Dot[][] dots;

    public BoardModel() {
        this.dots = new Dot[BOARD_SIZE][BOARD_SIZE];
    }

    public Dot getDot(int x, int y) {
        return dots[x][y];
    }

    public void setDot(Dot dot) {
        dots[dot.getX()][dot.getY()] = dot;
    }

    public void populateRandomBoard() {
        for (int i = 0; i <= BOARD_SIZE; i++) {
            for (int j = 0; i <=BOARD_SIZE; i++) {
                dots[i][j] = DotFactory.createRandomDot(i, j);
            }
        }
    }
}
