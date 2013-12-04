package com.dots.models;

import junit.framework.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 12/2/13
 * Time: 3:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardModelTest {



    @Test
    public void testPerformSelection() throws Exception {

        // Test a selection in last row:
        BoardModel bm = ExampleBoards.getExample2();
        BoardModel test = bm.getNextState();

        BoardModel correct = ExampleBoards.getExample2();

        correct.getDotModels()[4][0] = null;
        correct.getDotModels()[5][0] = null;
        correct.setDot(new DotModel(4, 1, Color.BLUE));
        correct.setDot(new DotModel(4, 2, Color.GREEN));
        correct.setDot(new DotModel(4, 3, Color.MAGENTA));
        correct.setDot(new DotModel(4, 4, Color.MAGENTA));
        correct.setDot(new DotModel(4, 5, Color.YELLOW));

        correct.setDot(new DotModel(5, 1, Color.BLUE));
        correct.setDot(new DotModel(5, 2, Color.BLUE));
        correct.setDot(new DotModel(5, 3, Color.YELLOW));
        correct.setDot(new DotModel(5, 4, Color.YELLOW));
        correct.setDot(new DotModel(5, 5, Color.GREEN));

        Assert.assertTrue(test.hasSameDots(correct));


        // Test a selection in first row:
        test = ExampleBoards.getExample3().getNextState();
        correct = ExampleBoards.getExample3();

        correct.getDotModels()[4][0] = null;
        correct.getDotModels()[5][0] = null;

        Assert.assertTrue(test.hasSameDots(correct));



        // Test a vertical selection:
        test = ExampleBoards.getExample4().getNextState();
        correct = ExampleBoards.getExample4();
        correct.getDotModels()[4][0] = null;
        correct.getDotModels()[4][1] = null;
        correct.setDot(new DotModel(4, 2, Color.BLUE));
        correct.setDot(new DotModel(4, 3, Color.GREEN));

        Assert.assertTrue(test.hasSameDots(correct));


        // Test a square:
        test = ExampleBoards.getExample5().getNextState();

        correct = ExampleBoards.getExample5();
        correct.getDotModels()[0][0] = null;
        correct.getDotModels()[1][0] = null;
        correct.getDotModels()[2][0] = null;
        correct.getDotModels()[2][1] = null;
        correct.getDotModels()[4][0] = null;
        correct.getDotModels()[4][1] = null;
        correct.getDotModels()[4][2] = null;
        correct.getDotModels()[5][0] = null;
        correct.getDotModels()[5][1] = null;
        correct.getDotModels()[5][2] = null;

        correct.setDot(new DotModel(0, 2, Color.RED));
        correct.setDot(new DotModel(0, 1, Color.BLUE));
        correct.setDot(new DotModel(1, 1, Color.YELLOW));
        correct.setDot(new DotModel(2, 2, Color.RED));
        correct.setDot(new DotModel(2, 3, Color.YELLOW));
        correct.setDot(new DotModel(2, 4, Color.YELLOW));
        correct.setDot(new DotModel(4, 3, Color.BLUE));
        correct.setDot(new DotModel(4, 4, Color.GREEN));
        correct.setDot(new DotModel(4, 5, Color.YELLOW));
        correct.setDot(new DotModel(5, 3, Color.BLUE));
        correct.setDot(new DotModel(5, 4, Color.BLUE));
        correct.setDot(new DotModel(5, 5, Color.GREEN));




        Assert.assertTrue(test.hasSameDots(correct));


        










    }
}
