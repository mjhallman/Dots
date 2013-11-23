package com.dots.models;

import com.dots.models.DotFactory;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardModel {

    public static final int BOARD_SIZE = 6;

    DotModel[][] dotModels;

    public BoardModel() {
        this.dotModels = new DotModel[BOARD_SIZE][BOARD_SIZE];
    }

    public DotModel getDot(int x, int y) {
        return dotModels[x][y];
    }

    public void setDot(DotModel dotModel) {
        dotModels[dotModel.getX()][dotModel.getY()] = dotModel;
    }

    public void populateRandomBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j <BOARD_SIZE; j++) {
                dotModels[i][j] = DotFactory.createRandomDot(i, j);
            }
        }
    }

    public void nextColor(int x, int y, DotModel clickedDot){
        Color dotColor = clickedDot.getColor();
        Color nextColor = clickedDot.nextColor(dotColor);
        clickedDot.setColor(nextColor);
    }

    public void selectColor(int x, int y,  DotModel clickedDot){
        Color dotColor = clickedDot.getColor();
        Color selectColor = clickedDot.selectColor(dotColor);
        clickedDot.setColor(selectColor);
    }

    public void selectDot(int xval, int yval) {
        //To change body of created methods use File | Settings | File Templates.
        // Make the dot "selected"
    }
}
