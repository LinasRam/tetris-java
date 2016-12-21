package tetris;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private Game game;

    public Panel() {
        this.game = new Game();
    }

    public Game getGame() {
        return this.game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Painter painter = new Painter();

        Board board = this.game.getBoard();
        Piece piece = this.game.getPiece();
        long score = this.game.getScore();

        painter.paintBoard(board, g);
        painter.paintScore(score, g);
        painter.paintPiece(piece, g);
    }

}
