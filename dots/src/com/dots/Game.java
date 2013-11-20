package com.dots;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: matthallman
 * Date: 9/24/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame {

    public Game() {
        add(new BoardPanel());



        setSize(500, 500);
        setTitle("Dots");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
