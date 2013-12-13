package com.dots;

import com.dots.models.BoardModel;
import com.dots.models.DotModel;
import com.dots.models.ExampleBoards;
import com.dots.models.SelectionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame implements ActionListener, MouseListener {

    private int NUM_SIMULATIONS_TO_RUN = 1000;

    JPanel buttonPanel;
    BoardPanel boardPanel;
    SelectionModel selectionModel;

    JButton resetButton;
    JButton changeButton;
    JButton runButton;
    JButton findBestMoveWithLookaheadButton;
    JButton findBestMoveNoLookaheadButton;
    JButton loadExample1Button;
    JButton loadExample2Button;
    JButton loadExample4Button;
    JButton fillInDotsButton;
    JButton runSimulationNoLookaheadButton;
    JButton runSimulationWithLookaheadButton;


    JLabel compModeLabel;
    JLabel runModeLabel;

    private int editColor = 1;
    private int compMode = 0;
    private int xval, yval;
    private int selectedColorFlag = 0;
    private Color selectionColor;

    MouseListener mouseListener;

    public Game() {
        setSize(500, 500);
        setTitle("Dots");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();     //create panels
        FlowLayout flowLayout = new FlowLayout();
        GridLayout gridLayout = new GridLayout(10, 0);
        buttonPanel.setLayout(gridLayout);
        boardPanel = new BoardPanel();

        resetButton = new JButton("Reset");    //create buttons
        runButton = new JButton("Run");
        changeButton = new JButton("Change");
        findBestMoveWithLookaheadButton = new JButton("<html>Find Best Move<br />with lookahead</html>");
        findBestMoveNoLookaheadButton = new JButton("<html>Find Best Move<br />no lookahead</html>");

        fillInDotsButton = new JButton("Fill in empty dots");
        runSimulationNoLookaheadButton = new JButton("<html>Run Simulations<br />no lookahead</html>");
        runSimulationWithLookaheadButton = new JButton("<html>Run Simulations<br />with lookahead</html>");

//        loadExample1Button = new JButton("Example 1");
        loadExample2Button = new JButton("Load Example");
//        loadExample4Button = new JButton("Example 4");

        compModeLabel = new JLabel("User is playing");

        buttonPanel.add(resetButton);   //add buttons to panel
        buttonPanel.add(findBestMoveWithLookaheadButton);
        buttonPanel.add(findBestMoveNoLookaheadButton);
        buttonPanel.add(runButton);
//        buttonPanel.add(changeButton);
//        buttonPanel.add(loadExample1Button);
        buttonPanel.add(loadExample2Button);
        buttonPanel.add(fillInDotsButton);
        buttonPanel.add(runSimulationNoLookaheadButton);
        buttonPanel.add(runSimulationWithLookaheadButton);

        buttonPanel.setBackground(Color.black);

        add(buttonPanel,BorderLayout.EAST);   //add panels to frame
        add(boardPanel);

        resetButton.addActionListener(this);   //add action listeners
//        buttonPanel.add(resetButton);
        changeButton.addActionListener(this);
//        buttonPanel.add(changeButton);
        runButton.addActionListener(this);
//        buttonPanel.add(runButton);
        findBestMoveWithLookaheadButton.addActionListener(this);
        findBestMoveNoLookaheadButton.addActionListener(this);
//        loadExample1Button.addActionListener(this);
        loadExample2Button.addActionListener(this);
        fillInDotsButton.addActionListener(this);
        runSimulationWithLookaheadButton.addActionListener(this);
        runSimulationNoLookaheadButton.addActionListener(this);
        boardPanel.addMouseListener(this);   //add mouse listener


        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == resetButton) {
            boardPanel.setBoardModel(new BoardModel(boardPanel));
            selectedColorFlag = 0;
            repaint();
        }
        if (event.getSource() == changeButton) {
            if(editColor == 0){
                editColor = 1;          //enableColorChange();
            } else editColor = 0;         //disableColorChange();
        }
        if (event.getSource() == runButton) {
            if(compMode == 0){
                compMode = 1;            //
            }else compMode = 0;

            if (boardPanel.getBoardModel().getSelectionModel() != null) {
                boardPanel.setBoardModel(boardPanel.getBoardModel().getNextState());
                boardPanel.getBoardModel().setSelectionModel(null);
                repaint();
            }



//            System.out.println("run");
        } else if (event.getSource() == findBestMoveWithLookaheadButton) {
            try {
                boardPanel.getBoardModel().updateSelection(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        } else if (event.getSource() == findBestMoveNoLookaheadButton) {
            try {
                boardPanel.getBoardModel().updateSelection(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            repaint();
        } else if (event.getSource() == loadExample1Button) {
            boardPanel.setBoardModel(ExampleBoards.getExample1());
            repaint();
        } else if (event.getSource() == loadExample2Button) {
            boardPanel.setBoardModel(ExampleBoards.getExample2());
            repaint();
        } else if (event.getSource() == loadExample4Button) {
//            boardPanel.setBoardModel(ExampleBoards.getExample5());
//            repaint();
            try {
                boardPanel.getBoardModel().updateSelection(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (event.getSource() == fillInDotsButton) {
            boardPanel.getBoardModel().fillInNullDots();
            repaint();
        } else if (event.getSource() == runSimulationNoLookaheadButton) {

            ArrayList<Integer> scores = new ArrayList<Integer>();

            for (int i = 0; i < NUM_SIMULATIONS_TO_RUN; i++) {

                try {
                    boardPanel.setBoardModel(new BoardModel(boardPanel));
                    repaint();

                    int totalScore = 0;
                    for (int j = 1; j <= 30; j++) {
                        boardPanel.getBoardModel().updateSelection(0);
                        totalScore += boardPanel.getBoardModel().getSelectionModel().getImmediateScore();
                        boardPanel.setBoardModel(boardPanel.getBoardModel().getNextState());
                        boardPanel.getBoardModel().fillInNullDots();
                        boardPanel.getBoardModel().setSelectionModel(null);
                        repaint();
    //                    System.out.println("Executed " + j + " moves.  -- Score: " + totalScore);
                    }
                    System.out.println("Finished executing simulation with no lookahead. Total score: " + totalScore);
                    scores.add(totalScore);

                } catch (Exception e) {
                    System.err.println("Error in this trial. Ignoring.");
                }
            }

            System.out.println("Finished executing " + NUM_SIMULATIONS_TO_RUN + "simulations. Overall average: " + getAverage(scores));


        } else if (event.getSource() == runSimulationWithLookaheadButton) {

            ArrayList<Integer> scores = new ArrayList<Integer>();
            for (int i = 0; i < NUM_SIMULATIONS_TO_RUN; i++) {
                try {
                    // Limit the execution time to 10 seconds:
                    long start = System.currentTimeMillis();
                    long end = start + 10 * 1000;
                    boardPanel.setBoardModel(new BoardModel(boardPanel));
                    repaint();
                    int totalScore = 0;
                    for (int j = 1; j < 30; j++) {
                        if (start > end) {
                            throw new Exception("Taking too much time... Exiting!");
                        }
                                boardPanel.getBoardModel().updateSelection(1);
                        totalScore += boardPanel.getBoardModel().getSelectionModel().getImmediateScore();
                        boardPanel.setBoardModel(boardPanel.getBoardModel().getNextState());
                        boardPanel.getBoardModel().fillInNullDots();
                        repaint();
                    }
                    // The last move should not lookahead.
                    boardPanel.getBoardModel().updateSelection(0);
                    totalScore += boardPanel.getBoardModel().getSelectionModel().getImmediateScore();
                    boardPanel.getBoardModel().fillInNullDots();
                    boardPanel.getBoardModel().setSelectionModel(null);
                    repaint();
                    scores.add(totalScore);
                    System.out.println("Finished executing simulation with lookahead. Total score: " + totalScore + "  -- Average so far: " + getAverage(scores));

                } catch (Exception e) {
//                    e.printStackTrace();
                    System.err.println("Error in this trial. Ignoring.");
                }
            }

            System.out.println("Finished executing " + NUM_SIMULATIONS_TO_RUN + "simulations. Overall average: " + getAverage(scores));
        }
    }

    private double getAverage(ArrayList<Integer> scores) {
        int sum = 0;
        for (Integer i : scores) {
            sum += i;
        }
        return sum / scores.size();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xval = (e.getX()-20)/40;
        yval = (e.getY()-20)/40;

        BoardModel currentBoard = boardPanel.getBoardModel();
        DotModel clickedDot = currentBoard.getDot(xval,yval);

        if(editColor == 1){
            currentBoard.nextColor(xval,yval,clickedDot);
            repaint();
        } else {
        }

//        if(compMode == 0){
//            if(selectedColorFlag == 0) {           //if no selection color has been specified
//                selectionColor = clickedDot.getColor();         //set the selection color
//                currentBoard.selectColor(xval,yval,clickedDot); //change the dots color to the "selected" color
//                selectedColorFlag = 1;
//                //todo add dot to arrayList
//            } else {
//                if(selectionColor == clickedDot.getColor()) { //if clicked dot is the same as the selection color
//                    System.out.println("same color");
//                    //check if the dot is a possible move
//                    //add dot to selected dots
//
//                }
//            }
//            repaint();
//        } else {
//
//            //runs the program to decide on a move
//        }



        //System.out.println("(" + (e.getX() - 20) / 40 + ", " + (e.getY() - 20) / 40 + ")") ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {
        new Game();
    }

}
