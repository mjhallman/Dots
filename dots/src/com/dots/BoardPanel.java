package com.dots;


import com.dots.models.BoardModel;
import com.dots.models.DotModel;
import com.dots.models.SelectionModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class BoardPanel extends JPanel {

    private BoardModel boardModel;
    private Color selectionColor;

    int X_OFFSET = 20;
    int Y_OFFSET = 20;

    public BoardPanel(){
        boardModel = new BoardModel();
        boardModel.populateRandomBoard();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < BoardModel.BOARD_SIZE; i++) {
            for (int j = 0; j <BoardModel.BOARD_SIZE; j++) {
                DotModel d = boardModel.getDot(i, j);
                g2.setColor(d.getColor());
                g2.fillOval(X_OFFSET + (d.getX() * 40) , Y_OFFSET + (d.getY() * 40), 30, 30);
            }
        }

        SelectionModel selectionModel = boardModel.getSelectionModel();


        // Draw the selection:
        if (selectionModel != null) {
            g2.setColor(selectionModel.getColor());
            g2.setStroke(new BasicStroke(6));
            for (int i = 0; i < selectionModel.getSelectedDots().size() - 1; i++) {
                DotModel thisDot = selectionModel.getSelectedDots().get(i);
                DotModel nextDot = selectionModel.getSelectedDots().get(i+1);
                g2.drawLine(15 + X_OFFSET + (thisDot.getX() * 40), 15 +  Y_OFFSET + (thisDot.getY() * 40), 15 + X_OFFSET + (nextDot.getX() * 40), 15 + Y_OFFSET + (nextDot.getY() * 40));
            }
        }
    }
//        g2.drawOval(10, 10, 50, 50);
//        g2.draw((Shape) circle);

//        RenderingHints rh =
//                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
//                        RenderingHints.VALUE_ANTIALIAS_ON);
//
//        rh.put(RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY);
//
//        g2.setRenderingHints(rh);
//
//        Dimension size = getSize();
//        double w = size.getWidth();
//        double h = size.getHeight();
//
//        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
//        g2.setStroke(new BasicStroke(1));
//        g2.setColor(Color.gray);
//
//
//        for (double deg = 0; deg < 360; deg += 5) {
//            AffineTransform at =
//                    AffineTransform.getTranslateInstance(w / 2, h / 2);
//            at.rotate(Math.toRadians(deg));
//            g2.draw(at.createTransformedShape(e));
//        }

//    private int getBoardPosition(DotModel dotModel) {
//        return new Posn(X_OFFSET + dotModel.getX())
//    }

//    private class Posn {
//        int x;
//        int y;
//
//        private Posn(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        private int getX() {
//            return x;
//        }
//
//        private void setX(int x) {
//            this.x = x;
//        }
//
//        private int getY() {
//            return y;
//        }
//
//        private void setY(int y) {
//            this.y = y;
//        }
//    }


    public BoardModel getBoardModel() {
        return boardModel;
    }

    public void setBoardModel(BoardModel boardModel) {
        this.boardModel = boardModel;
        repaint();
    }
}
