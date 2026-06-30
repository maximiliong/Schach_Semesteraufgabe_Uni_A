package gui.data;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Square extends JPanel {
    private Color backgroundColor;
    private String text = "";
    private Color textColor;
    private Font font;

    public Square() {
        super();
    }
    public Square(Color backgroundColor) {
        JPanel square = new JPanel();
        square.setBackground(backgroundColor);
        add(square);
    }
    public Square(Color backgroundColor, String text, Color textColor, Font font) {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(backgroundColor);
        setText(text);
        JLabel label = new JLabel(this.text);
        label.setForeground(textColor);
        label.setFont(font);
        wrapper.add(label, BorderLayout.CENTER);
        this.add(wrapper, BorderLayout.CENTER);
    }

    private void setText(String text) {
        if (text == null)
            throw new IllegalArgumentException();
        this.text = text;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }
    public String getText() {
        return this.text;
    }
    public Color getTextColor() {
        return this.textColor;
    }
    public Font getFont() {
        return this.font;
    }
}
