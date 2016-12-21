package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Painter {

    public void paintPiece(Piece piece, Graphics g) {
        Point[] piecePoints = piece.getPiecePoints();
        Color pieceColor = piece.getCurrentPieceColor();
        Point pieceOrigin = piece.getPieceOrigin();

        g.setColor(pieceColor);
        for (Point piecePoint : piecePoints) {
            g.fillRect((piecePoint.x + pieceOrigin.x) * 26,
                    (piecePoint.y + pieceOrigin.y) * 26,
                    25, 25);
        }
    }

    public void paintBoard(Board board, Graphics g) {
        Color[][] boardArray = board.toArray();

        g.fillRect(0, 0, 26 * 12, 26 * 23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(boardArray[i][j]);
                g.fillRect(26 * i, 26 * j, 25, 25);
            }
        }
    }

    public void paintScore(long score, Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("" + score, 19 * 12, 25);
    }

}
