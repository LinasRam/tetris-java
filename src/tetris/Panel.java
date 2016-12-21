package tetris;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private static Panel instance = new Panel();

    private Game game = Game.getInstance();

    private Panel() {

    }

    public Game getGame() {
        return this.game;
    }

    public static Panel getInstance() {
        return instance;
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
