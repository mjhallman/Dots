package com.dots.models;

import java.awt.*;

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
        boardModel.setDot(new DotModel(0, 0, Color.BLUE));


        return boardModel;

    }


}
