package com.dots;

import com.dots.models.BoardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame implements ActionListener, MouseListener{

    JPanel buttonPanel;
    BoardPanel boardPanel;

    JButton resetButton;
    JButton changeButton;
    JButton runButton;

    private int changeColors = 0;
    private int xval, yval;

    MouseListener mouseListener;

    public Game() {

        setSize(500, 500);
        setTitle("Dots");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();     //create panels
        boardPanel = new BoardPanel();

        resetButton = new JButton("Reset");    //create buttons
        runButton = new JButton("Run");
        changeButton = new JButton("Change");

        buttonPanel.add(resetButton);   //add buttons to panel
        buttonPanel.add(runButton);
        buttonPanel.add(changeButton);

        buttonPanel.setBackground(Color.black);

        add(buttonPanel,BorderLayout.EAST);   //add panels to frame
        add(boardPanel);

        resetButton.addActionListener(this);   //add action listeners
        buttonPanel.add(resetButton);
        changeButton.addActionListener(this);
        buttonPanel.add(changeButton);
        runButton.addActionListener(this);
        buttonPanel.add(runButton);

        boardPanel.addMouseListener(this);   //add mouse listener
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == resetButton) {
            boardPanel.setBoardModel(new BoardModel());
        }
        if (event.getSource() == changeButton) {
            if(changeColors == 0)
                changeColors = 1;
            if (changeColors == 1)
                changeColors = 0;
        }
        if (event.getSource() == runButton) {
            System.out.println("run"); }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        xval = e.getX();
        yval = e.getY();

        System.out.println(xval + " , " + yval);
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
