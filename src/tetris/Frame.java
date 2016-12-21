package tetris;

import javax.swing.JFrame;

public class Frame extends JFrame {

    Panel panel;

    public Frame() {
        this.setName("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(12 * 26 + 10, 26 * 23 + 25);
        this.setVisible(true);

        this.panel = new Panel();
        this.add(this.panel);
        this.addKeyListener(new KeyController(this.panel.getGame()));
    }

}
