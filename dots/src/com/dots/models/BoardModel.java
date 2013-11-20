package com.dots.models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardModel {

    public static final int BOARD_SIZE = 5;

    DotModel[][] dotModels;
    SelectionModel selectionModel;

    public BoardModel() {
        this.dotModels = new DotModel[BOARD_SIZE][BOARD_SIZE];


        // set this selection model. (for testing)
        this.selectionModel = new SelectionModel(this, new ArrayList<DotModel>());
        this.selectionModel.setColor(Color.BLUE);



        populateRandomBoard();
        //TODO : set selection model somewher else. Where? ??
        this.selectionModel.getSelectedDots().add(getDot(0,0));
        this.selectionModel.getSelectedDots().add(getDot(1, 0));
        this.selectionModel.getSelectedDots().add(getDot(1,1));
        this.selectionModel.getSelectedDots().add(getDot(2,1));


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

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
}
