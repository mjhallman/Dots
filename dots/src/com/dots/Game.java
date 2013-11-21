package com.dots;

import com.dots.models.BoardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame implements ActionListener{

    private JFrame f;

    JPanel buttonPanel;
    BoardPanel boardPanel;

    JButton resetButton;
    JButton changeButton;
    JButton runButton;

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

        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        changeButton.addActionListener(this);
        buttonPanel.add(changeButton);
        runButton.addActionListener(this);
        buttonPanel.add(runButton);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == resetButton) {
            System.out.println("reset");
            boardPanel.setBoardModel(new BoardModel());
        }
        if (event.getSource() == changeButton) {
            System.out.println("change"); }
        if (event.getSource() == runButton) {
            System.out.println("run"); }
    }

    public static void main(String[] args) {
        new Game();
    }
}
