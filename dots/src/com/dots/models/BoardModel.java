package com.dots.models;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

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
    private RepaintRequestHandler repaintHandler;

    public int getNumberOfDotsWithColor(Color color) {
        int totalFound = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (getDot(i,j).getColor().equals(color))
                    totalFound++;
            }
        }
        return totalFound;
    }

    public interface RepaintRequestHandler {
        public void requestRepaint();
    }

    public void setDotModels(DotModel[][] dotModels) {
        this.dotModels = dotModels;
    }

    public BoardModel(RepaintRequestHandler repaintHandler) {
        this.repaintHandler = repaintHandler;
        this.dotModels = new DotModel[BOARD_SIZE][BOARD_SIZE];


        // set this selection model. (for testing)
        this.selectionModel = new SelectionModel(this, new ArrayList<DotModel>());
//        this.selectionModel.setColor(Color.BLUE);

        populateRandomBoard();
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


    /** Updates this board's SelectionModel to be the best move to take.
     *
     */
    public void updateSelection() {
        System.out.println("--------------------------------------");

        HashSet<SelectionModel> possibleSelections = new HashSet<SelectionModel>();

        // Find all pairs:
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                for (SelectionModel selModel : getPossibleSelectionModelsForPosition(i, j)) {
                    if (!possibleSelections.contains(selModel))
                        possibleSelections.add(selModel);
                }
            }
        }

//        System.out.println("Found: " + possibleSelections.size() + " paris.");
//        for (SelectionModel selModel : possibleSelections) {
//            System.out.println(selModel);
//        }


        // Display a random pair: (just for testing)
//        int i = new Random().nextInt(possibleSelections.size());
//        int j = 0;
//        for (SelectionModel selModel : possibleSelections) {
//            if (i == j) {
//                setSelectionModel(selModel);
//                break;
//            }
//            j++;
//        }


        ArrayDeque<SelectionModel> selectionsToTest = new ArrayDeque<SelectionModel>();
        selectionsToTest.addAll(possibleSelections);


        while (!selectionsToTest.isEmpty()) {
        // For each possible selection, try to increase it by looking backwards, and forwards.
        // For every new possible selection found using this method, add it to the set of possible selections.
//            System.out.println("Looking for more possible selections. Found " + possibleSelections.size() + " so far.");

            // Look backwards (at first dot in each selection)
            SelectionModel selModel = selectionsToTest.remove();
//            for (SelectionModel selModel : selectionsToTestold) {
                // Find all possible selections by looking backwards:
                for (DotModel dot : getSurroundingDotsWithSameColor(selModel.getFirstDot())) {
                    if (!dot.equals(selModel.getSelectedDots().get(1))) {
                        ArrayList<DotModel> dots = new ArrayList<DotModel>();
                        dots.add(dot);
                        dots.addAll(selModel.getSelectedDots());
                        SelectionModel possibleSelection = new SelectionModel(this, dots);
                        if (!possibleSelections.contains(possibleSelection)) {
                            if (!possibleSelection.containsSquare()) {
                                selectionsToTest.add(possibleSelection);
                            }
//                            System.out.println("Found new selection: " + possibleSelection);
                            possibleSelections.add(possibleSelection);
                        }
                    }
                }

                // Look forwards (at last dot in each selection)
                for (DotModel dot : getSurroundingDotsWithSameColor(selModel.getLastDot())) {
                    if (!dot.equals(selModel.getSelectedDots().get(selModel.getSelectedDots().size()-2))) {
                        ArrayList<DotModel> dots = new ArrayList<DotModel>();
                        dots.addAll(selModel.getSelectedDots());
                        dots.add(dot);
                        SelectionModel possibleSelection = new SelectionModel(this, dots);
                        if (!possibleSelections.contains(possibleSelection)) {
                            if (!possibleSelection.containsSquare()) {
                                selectionsToTest.add(possibleSelection); // Any selections found from looking backwards will not be equivalent to any selection found looking forwards. No need to check if it is already contained. (I think?)
                            }
//                            System.out.println("Found new selection: " + possibleSelection);
                            possibleSelections.add(possibleSelection);
                        }
                    }
                }



        }

//        System.out.println("--------------------------------------");
        System.out.println("Total number of possible selections: " + possibleSelections.size());
        int maxScore = 0;
        SelectionModel bestSelection = null;
        for (SelectionModel selModel : possibleSelections) {
            if (selModel.getImmediateScore() > maxScore) {
                maxScore = selModel.getImmediateScore();
                bestSelection = selModel;
            }
        }
        selectionModel = bestSelection;

        System.out.println("Best selection score: " + maxScore);




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
        return new ArrayList<SelectionModel>();
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

    public BoardModel copy() {
        BoardModel copy = new BoardModel(this.repaintHandler);
        DotModel[][] copyDotModels = new DotModel[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                copyDotModels[i][j] = new DotModel(i, j, getDot(i,j).getColor());
            }
        }
        copy.setDotModels(this.dotModels);
        copy.setDotModels(copyDotModels);
        ArrayList<DotModel> copySelectedDots = new ArrayList<DotModel>();
        copySelectedDots.addAll(this.selectionModel.getSelectedDots());
        SelectionModel copySelectionModel = new SelectionModel(copy, copySelectedDots);
        copy.setSelectionModel(copySelectionModel);
        return copy;
    }

    public DotModel[][] getDotModels() {
        return dotModels;
    }

    public ArrayList<DotModel> getAllDots() {
        ArrayList<DotModel> dots = new ArrayList<DotModel>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                dots.add(dotModels[i][j]);
            }
        }
        return dots;
    }

     public ArrayList<DotModel> getAllDotsWithColor(Color color) {
        ArrayList<DotModel> dotsWithSameColor = new ArrayList<DotModel>();
        for (DotModel dot: getAllDots()) {
            if (dot.getColor().equals(color)) {
                dotsWithSameColor.add(dot);
            }
        }
         return dotsWithSameColor;
     }


    /**
     * @return A new board model, as if the current selection
     * were to be performed. All positions which are unknown
     * are set to null. (All of these positions will be at the
     * top of the board, due to the shifting.)
     */
    public BoardModel getNextState() {
        BoardModel newBoard = copy();
        // Find all dots to be removed, and add them to a queue:
        ArrayDeque<DotModel> dotsToRemove = new ArrayDeque<DotModel>();
        if (selectionModel.containsSquare()) { // Special handling for squares.
            dotsToRemove.addAll(getAllDotsWithColor(selectionModel.getColor()));
        }
        else {
            for (DotModel dot : newBoard.getSelectionModel().getSelectedDots()) {
                if (!dotsToRemove.contains(dot)){
                    dotsToRemove.add(dot);
                }
            }
        }
        // Set all dots to remove to null.
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (dotsToRemove.contains(newBoard.getDot(i,j)))
                    newBoard.getDotModels()[i][j] = null;
            }
        }

       // Shift all null spaces to the top:

        for (int col = 0; col < BOARD_SIZE; col++) {
            int numToShift = 0;
            for (int row = BOARD_SIZE-1; row >= 0; row--) {
                DotModel currentDot = newBoard.getDot(col, row);
                if (currentDot == null) {
                    numToShift++;
                    continue;
                } else {
                    if (numToShift > 0) {
                        // Shift dot down numToShift spaces.
                        newBoard.setDot(new DotModel(col, row+numToShift, currentDot.getColor()));
                        newBoard.getDotModels()[col][row] = null;
                    }
                }
            }
        }

        return newBoard;
    }


    /**
     * Compares each dot in the two boards for equality.
     * Doesn't look at the selectino model.
     * @param otherBoard
     * @return True if the boards contain the same dots. False otherwise.
     */
    public boolean hasSameDots(BoardModel otherBoard) {
        boolean equal = true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (getDot(i, j) != null) {
                    if (!getDot(i, j).equals(otherBoard.getDot(i,j)))
                        equal = false;
                } else {
                    if (otherBoard.getDot(i, j) != null)
                        equal = false;
                }

            }
        }
        return equal;
    }


}
