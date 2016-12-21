package tetris;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Frame extends JFrame {

    private static Frame instance = new Frame();

    Panel panel = Panel.getInstance();

    private Frame() {
        this.setName("Tetris");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(12 * 26 + 10, 26 * 23 + 25);
        this.setVisible(true);

        this.add(this.panel);
        this.addKeyListener(KeyController.getInstance());
    }

    public static Frame getInstance() {
        return instance;
    }

    public void start() {
        final Frame frame = getInstance();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        panel.getGame().dropPieceDown();
                        panel.repaint();

                        if (panel.getGame().isOver()) {
                            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }

}
