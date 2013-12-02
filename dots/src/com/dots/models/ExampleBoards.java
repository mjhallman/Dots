package com.dots.models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 12/2/13
 * Time: 2:43 PM
 * Example board
 */
public class ExampleBoards {

    public static BoardModel getExample1() {
        BoardModel boardModel = new BoardModel(null);

        // Column 0
        boardModel.setDot(new DotModel(0, 0, Color.BLUE));
        boardModel.setDot(new DotModel(0, 1, Color.BLUE));
        boardModel.setDot(new DotModel(0, 2, Color.BLUE));
        boardModel.setDot(new DotModel(0, 3, Color.BLUE));
        boardModel.setDot(new DotModel(0, 4, Color.BLUE));
        boardModel.setDot(new DotModel(0, 5, Color.BLUE));

        // Column 1
        boardModel.setDot(new DotModel(1, 0, Color.BLUE));
        boardModel.setDot(new DotModel(1, 1, Color.BLUE));
        boardModel.setDot(new DotModel(1, 2, Color.BLUE));
        boardModel.setDot(new DotModel(1, 3, Color.BLUE));
        boardModel.setDot(new DotModel(1, 4, Color.BLUE));
        boardModel.setDot(new DotModel(1, 5, Color.BLUE));

        // Column 2
        boardModel.setDot(new DotModel(2, 0, Color.BLUE));
        boardModel.setDot(new DotModel(2, 1, Color.BLUE));
        boardModel.setDot(new DotModel(2, 2, Color.BLUE));
        boardModel.setDot(new DotModel(2, 3, Color.BLUE));
        boardModel.setDot(new DotModel(2, 4, Color.BLUE));
        boardModel.setDot(new DotModel(2, 5, Color.BLUE));

        // Column 3
        boardModel.setDot(new DotModel(3, 0, Color.BLUE));
        boardModel.setDot(new DotModel(3, 1, Color.BLUE));
        boardModel.setDot(new DotModel(3, 2, Color.BLUE));
        boardModel.setDot(new DotModel(3, 3, Color.BLUE));
        boardModel.setDot(new DotModel(3, 4, Color.BLUE));
        boardModel.setDot(new DotModel(3, 5, Color.BLUE));

        // Column 4
        boardModel.setDot(new DotModel(4, 0, Color.BLUE));
        boardModel.setDot(new DotModel(4, 1, Color.BLUE));
        boardModel.setDot(new DotModel(4, 2, Color.BLUE));
        boardModel.setDot(new DotModel(4, 3, Color.BLUE));
        boardModel.setDot(new DotModel(4, 4, Color.BLUE));
        boardModel.setDot(new DotModel(4, 5, Color.BLUE));

        // Column 5
        boardModel.setDot(new DotModel(5, 0, Color.BLUE));
        boardModel.setDot(new DotModel(5, 1, Color.BLUE));
        boardModel.setDot(new DotModel(5, 2, Color.BLUE));
        boardModel.setDot(new DotModel(5, 3, Color.BLUE));
        boardModel.setDot(new DotModel(5, 4, Color.BLUE));
        boardModel.setDot(new DotModel(5, 5, Color.BLUE));

        return boardModel;
    }

    public static BoardModel getExample2() {
        BoardModel boardModel = new BoardModel(null);

        // Column 0
        boardModel.setDot(new DotModel(0, 0, Color.BLUE));
        boardModel.setDot(new DotModel(0, 1, Color.RED));
        boardModel.setDot(new DotModel(0, 2, Color.MAGENTA));
        boardModel.setDot(new DotModel(0, 3, Color.RED));
        boardModel.setDot(new DotModel(0, 4, Color.GREEN));
        boardModel.setDot(new DotModel(0, 5, Color.BLUE));

        // Column 1
        boardModel.setDot(new DotModel(1, 0, Color.YELLOW));
        boardModel.setDot(new DotModel(1, 1, Color.MAGENTA));
        boardModel.setDot(new DotModel(1, 2, Color.GREEN));
        boardModel.setDot(new DotModel(1, 3, Color.RED));
        boardModel.setDot(new DotModel(1, 4, Color.BLUE));
        boardModel.setDot(new DotModel(1, 5, Color.GREEN));

        // Column 2
        boardModel.setDot(new DotModel(2, 0, Color.RED));
        boardModel.setDot(new DotModel(2, 1, Color.YELLOW));
        boardModel.setDot(new DotModel(2, 2, Color.MAGENTA));
        boardModel.setDot(new DotModel(2, 3, Color.YELLOW));
        boardModel.setDot(new DotModel(2, 4, Color.MAGENTA));
        boardModel.setDot(new DotModel(2, 5, Color.GREEN));

        // Column 3
        boardModel.setDot(new DotModel(3, 0, Color.YELLOW));
        boardModel.setDot(new DotModel(3, 1, Color.RED));
        boardModel.setDot(new DotModel(3, 2, Color.YELLOW));
        boardModel.setDot(new DotModel(3, 3, Color.YELLOW));
        boardModel.setDot(new DotModel(3, 4, Color.GREEN));
        boardModel.setDot(new DotModel(3, 5, Color.BLUE));

        // Column 4
        boardModel.setDot(new DotModel(4, 0, Color.BLUE));
        boardModel.setDot(new DotModel(4, 1, Color.GREEN));
        boardModel.setDot(new DotModel(4, 2, Color.MAGENTA));
        boardModel.setDot(new DotModel(4, 3, Color.MAGENTA));
        boardModel.setDot(new DotModel(4, 4, Color.YELLOW));
        boardModel.setDot(new DotModel(4, 5, Color.MAGENTA));

        // Column 5
        boardModel.setDot(new DotModel(5, 0, Color.BLUE));
        boardModel.setDot(new DotModel(5, 1, Color.BLUE));
        boardModel.setDot(new DotModel(5, 2, Color.YELLOW));
        boardModel.setDot(new DotModel(5, 3, Color.YELLOW));
        boardModel.setDot(new DotModel(5, 4, Color.GREEN));
        boardModel.setDot(new DotModel(5, 5, Color.MAGENTA));

        ArrayList<DotModel> selectedDots = new ArrayList<DotModel>();
        selectedDots.add(boardModel.getDot(4, 5));
        selectedDots.add(boardModel.getDot(5, 5));
        SelectionModel selectionModel = new SelectionModel(boardModel, selectedDots);
        boardModel.setSelectionModel(selectionModel);

        return boardModel;
    }

    public static BoardModel getExample3() {
        BoardModel bm = getExample2();
        ArrayList<DotModel> selectedDots = new ArrayList<DotModel>();
        selectedDots.add(bm.getDot(4, 0));
        selectedDots.add(bm.getDot(5, 0));
        SelectionModel selectionModel = new SelectionModel(bm, selectedDots);
        bm.setSelectionModel(selectionModel);

        return bm;
    }


}
