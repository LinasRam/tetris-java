package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

    private static KeyController instance = new KeyController();

    private Panel panel = Panel.getInstance();
    private Game game = Game.getInstance();

    private KeyController() {

    }

    public static KeyController getInstance() {
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.game.rotatePiece();
                this.panel.repaint();
                break;
            case KeyEvent.VK_DOWN:
                this.game.dropPieceDown();
                this.game.addScore(1);
                this.panel.repaint();
                break;
            case KeyEvent.VK_LEFT:
                this.game.movePieceLeft();
                this.panel.repaint();
                break;
            case KeyEvent.VK_RIGHT:
                this.game.movePieceRight();
                this.panel.repaint();
                break;
            case KeyEvent.VK_SPACE:
                this.game.dropPieceDown();
                this.game.addScore(1);
                this.panel.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
