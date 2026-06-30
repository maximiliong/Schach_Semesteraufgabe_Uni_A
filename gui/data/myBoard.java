package gui.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class myBoard extends JPanel {
    private Color whiteSquare = new Color(245, 222, 179);   // white
    private Color redSquare = new Color(139, 0, 0);       // it's actually bordeau red
    private Color rimColor = new Color(128, 0, 0);
    private Color borderColor = new Color(222, 184, 135);   // dark red

    public myBoard() {
        setBorder(new LineBorder(borderColor, 4));
        setLayout(new GridLayout(10, 10));
        setPreferredSize(new Dimension(1000, 1000));
        // setup grid
        boolean alternate = true;
        int index = 9;
        for (int rows = 1; rows <= 10; ++rows) {
            String[] letterLabels = new String[] {"A", "B", "C", "D", "E", "F","G", "H"};
            for (int columns = 1; columns <= 10; ++columns) {
                JPanel square = new JPanel();

                if (rows == 1 || rows == 10) {
                    square.setBackground(rimColor);
                    if (columns == 1 || columns == 10) {
                        // add logo to rim corners
                        // JLabel logo = new JLabel("☭");
                        // logo.setForeground(whiteSquare);
                        // logo.setFont(new Font("Arial", Font.PLAIN, 32));
                        square.add(new Square(rimColor, "☭", whiteSquare, new Font("Arial", Font.PLAIN, 32)));
                        this.add(square);
                    } else {
                        // add labels A-H to rim
                        JLabel letters = new JLabel(letterLabels[columns - 2]);
                        letters.setForeground(whiteSquare);
                        letters.setFont(new Font("Arial", Font.PLAIN, 24));
                        square.add(letters, JLabel.CENTER);
                        this.add(square);
                    }
                } else {
                    if (columns == 1 || columns == 10) {
                        // add 1-8 to rim
                        square.setBackground(rimColor);
                        JLabel numbers = new JLabel(String.valueOf(index));
                        numbers.setForeground(whiteSquare);
                        numbers.setFont(new Font("Arial", Font.PLAIN, 24));
                        square.add(numbers, JLabel.CENTER);
                        this.add(square);
                    } else {
                        // add playing field
                        square.setBackground(alternate ? redSquare : whiteSquare);
                        this.add(square);
                        alternate = !alternate;
                    }
                }
                if (columns % 10 == 0)
                    alternate = !alternate;
            }
            index--;
        }
    }
}
