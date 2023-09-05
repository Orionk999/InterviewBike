package com.codebehind;

import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame implements KeyListener {
    private static final int GRID_SIZE = 7;
    private char[][] grid = new char[GRID_SIZE][GRID_SIZE];
    private Integer bikeX, bikeY;
    private Integer CooY = 0,CooX = 0;
    private JLabel label = new JLabel("");
    JLabel label1 = new JLabel("GPS_REPORT");
    public App() {
        this.label.setBounds(75, 250, 200, 20);
        this.label1.setBounds(75, 230, 200, 20);
        add(label);
        add(label1);
        setTitle("Bike Maps");
        setSize(300, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 'X';
            }
        }

        bikeX = 0;
        bikeY = 0;
        grid[bikeY][bikeX] = 'B';
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        grid[bikeY][bikeX] = 'X';

        if (key == KeyEvent.VK_LEFT && bikeX > 0) {
            bikeX--;
            this.label.setText("The bike is: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
            System.out.println("The beautiful bike is in: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
        } else if (key == KeyEvent.VK_RIGHT && bikeX < GRID_SIZE - 1) {
            bikeX++;
            this.label.setText("The bike is: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
            System.out.println("The beautiful bike is in: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
        } else if (key == KeyEvent.VK_DOWN && bikeY > 0) {
            bikeY--;
            this.label.setText("The bike is: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
            System.out.println("The beautiful bike is in: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
        } else if (key == KeyEvent.VK_UP && bikeY < GRID_SIZE - 1) {
            bikeY++;
            this.label.setText("The bike is: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
            System.out.println("The beautiful bike is in: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
        }else if (key == KeyEvent.VK_SPACE) {
            this.label.setText("The bike is: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
            System.out.println("The beautiful bike is in: ("+ bikeX.toString()+ "),("+bikeY.toString()+")");
        }

        grid[bikeY][bikeX] = 'B';
        this.CooY = bikeY;
        this.CooX = bikeX;
        repaint();
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    @Override
    public void paint(java.awt.Graphics g) {
        super.paint(g);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                g.drawString(String.valueOf(grid[i][j]), j * 30 + 50, (GRID_SIZE - i - 1) * 30 + 50);
            }
        }
    }
}
