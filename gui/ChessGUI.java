package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import gui.data.ChessPanel;

public class ChessGUI extends JFrame {

    public ChessGUI() {
        JFrame chessFrame = new JFrame();
        chessFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        chessFrame.add(new ChessPanel(), BorderLayout.CENTER);
        chessFrame.pack();
        chessFrame.setVisible(true);
        chessFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
