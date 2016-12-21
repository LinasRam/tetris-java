package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Board {

    private static Board instance = new Board();
    
    private Color[][] board;

    private Board() {
        this.board = new Color[12][24];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                if (i == 0 || i == 11 || j == 22) {
                    board[i][j] = Color.GRAY;
                } else {
                    board[i][j] = Color.BLACK;
                }
            }
        }
    }

    public static Board getInstance() {
        return instance;
    }

    public Color[][] toArray() {
        return this.board;
    }

    public void stickPiece(Piece piece) {
        Point[] piecePoints = piece.getPiecePoints();
        Point pieceOrigin = piece.getPieceOrigin();

        for (Point piecePoint : piecePoints) {
            this.board[pieceOrigin.x + piecePoint.x][pieceOrigin.y + piecePoint.y] = piece.getCurrentPieceColor();
        }
    }

    public int clearRows() {
        int score = 0;
        boolean gap;
        int numClears = 0;

        for (int j = 21; j > 0; j--) {
            gap = false;
            for (int i = 1; i < 11; i++) {
                if (this.board[i][j] == Color.BLACK) {
                    gap = true;
                    break;
                }
            }
            if (!gap) {
                deleteRow(j);
                j += 1;
                numClears += 1;
            }
        }

        switch (numClears) {
            case 1:
                score += 100;
                break;
            case 2:
                score += 300;
                break;
            case 3:
                score += 500;
                break;
            case 4:
                score += 800;
                break;
        }

        return score;
    }

    private void deleteRow(int row) {
        for (int j = row - 1; j > 0; j--) {
            for (int i = 1; i < 11; i++) {
                this.board[i][j + 1] = this.board[i][j];
            }
        }
    }

    public void paint(Graphics g) {
        g.fillRect(0, 0, 26 * 12, 26 * 23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(this.board[i][j]);
                g.fillRect(26 * i, 26 * j, 25, 25);
            }
        }
    }

}
