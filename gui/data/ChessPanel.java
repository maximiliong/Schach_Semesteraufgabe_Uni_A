package gui.data;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ChessPanel extends JPanel {

    public ChessPanel() {
        setBackground(Color.BLACK);

        this.add(new myBoard(), BorderLayout.CENTER);
    }
}
