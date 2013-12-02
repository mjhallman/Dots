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

        correct.setDot(new DotModel(5, 1, Color.RED));
        correct.setDot(new DotModel(5, 2, Color.BLUE));
        correct.setDot(new DotModel(5, 3, Color.YELLOW));
        correct.setDot(new DotModel(5, 4, Color.YELLOW));
        correct.setDot(new DotModel(5, 5, Color.GREEN));

        Assert.assertTrue(test.hasSameDots(correct));

        test = ExampleBoards.getExample3().getNextState();
        correct = ExampleBoards.getExample3();

        correct.getDotModels()[4][0] = null;
        correct.getDotModels()[5][0] = null;

        Assert.assertTrue(test.hasSameDots(correct));



    }
}
