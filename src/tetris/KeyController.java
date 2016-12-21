package tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

    private Game game;

    public KeyController(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.game.rotatePiece();
                break;
            case KeyEvent.VK_DOWN:
                this.game.dropPieceDown();
                this.game.addScore(1);
                break;
            case KeyEvent.VK_LEFT:
                this.game.movePieceLeft();
                break;
            case KeyEvent.VK_RIGHT:
                this.game.movePieceRight();
                break;
            case KeyEvent.VK_SPACE:
                this.game.dropPieceDown();
                this.game.addScore(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
