package com.dots.models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 11/19/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SelectionModel {

    private BoardModel boardModel; // The board this selection is on.
    ArrayList<DotModel> selectedDots; // The dots for this selection. In the order which they can be drawn.
    private int value; // The points this selection would generate.
    private Color color; // Color of the dots in this selection.

    public SelectionModel(BoardModel boardModel, ArrayList<DotModel> selectedDots) {
        this.boardModel = boardModel;
        this.selectedDots = selectedDots;
        value = selectedDots.size();
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
    }

    public ArrayList<DotModel> getSelectedDots() {
        return selectedDots;
    }

    public void setSelectedDots(ArrayList<DotModel> selectedDots) {
        this.selectedDots = selectedDots;
    }

    public int getValue() {
        return value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        String s = "Points: ";
        for (DotModel dot : selectedDots) {
            s += "(" + dot.getX() + ", " + dot.getY() + ") ";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectionModel that = (SelectionModel) o;

        if (selectedDots.size() == that.getSelectedDots().size()) {
            for (DotModel dot : selectedDots) {
                if (! that.getSelectedDots().contains(dot))
                    return false;
            }
        }

        return true;
    }


}
