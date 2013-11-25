package com.dots.models;

import java.util.ArrayList;

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
    SelectionModel selectionModel;

    public BoardModel() {
        this.dotModels = new DotModel[BOARD_SIZE][BOARD_SIZE];

        // set this selection model. (for testing)
        this.selectionModel = new SelectionModel(this, new ArrayList<DotModel>());
//        this.selectionModel.setColor(Color.BLUE);

        populateRandomBoard();

        //TODO : set selection model somewher else. Where?  Game manager class??
//        this.selectionModel.getSelectedDots().add(getDot(0,0));
//        this.selectionModel.getSelectedDots().add(getDot(1, 0));
//        this.selectionModel.getSelectedDots().add(getDot(1,1));
//        this.selectionModel.getSelectedDots().add(getDot(2,1));
       /* ArrayList<SelectionModel> possibleSelections = getPossibleSelectionModelsForPosition(0,0);
        if (possibleSelections != null && possibleSelections.size() > 0) {
            selectionModel = possibleSelections.get(0);
            selectionModel.setColor(possibleSelections.get(0).getSelectedDots().get(0).getColor());
        }*/
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

    public SelectionModel getSelectionModel() {
        return selectionModel;
    }

    public void setSelectionModel(SelectionModel selectionModel) {
        this.selectionModel = selectionModel;
    }
    /*
     * @param x
     * @param y
     * @return An ArrayList of all possible selections including the given position.
     */
    public ArrayList<SelectionModel> getPossibleSelectionModelsForPosition(int x, int y) {
        ArrayList<DotModel> surroundingDots = getSurroundingDotsWithSameColor(getDot(x, y));
        if (surroundingDots.size() > 0) {
            ArrayList<DotModel> selection = new ArrayList<DotModel>();
            selection.add(getDot(x,y));
            selection.add(surroundingDots.get(0));
            SelectionModel newSelection = new SelectionModel(this, selection);
            ArrayList<SelectionModel> selectionModels = new ArrayList<SelectionModel>();
            selectionModels.add(newSelection);
            return selectionModels;
        }
        return null;
    }

    private ArrayList<DotModel> getSurroundingDotsWithSameColor(DotModel d) {
        ArrayList<DotModel> surroundingDots = new ArrayList<DotModel>();
        // above
        if (d.getY()-1 >= 0) {
            DotModel above = getDot(d.getX(), d.getY()-1);
            if (d.getColor().equals(above.getColor()))
                surroundingDots.add(above);
        }
        // right
        if (d.getX()+1 < BOARD_SIZE) {
            DotModel right = getDot(d.getX()+1, d.getY());
            if (d.getColor().equals(right.getColor()))
                surroundingDots.add(right);
        }

        // down
        if (d.getY()+1 < BOARD_SIZE) {
            DotModel down = getDot(d.getX(), d.getY()+1);
            if (d.getColor().equals(down.getColor()))
                surroundingDots.add(down);
        }

        // left
        if (d.getX()-1 >= 0) {
            DotModel left = getDot(d.getX()-1, d.getY());
            if (d.getColor().equals(left.getColor()))
                surroundingDots.add(left);
        }

        return surroundingDots;
    }
}
