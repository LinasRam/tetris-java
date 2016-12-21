package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class Game extends JPanel {

    private static Game instance = new Game();
    
    private Board board = Board.getInstance();
    private Piece piece;
    private long score;

    private Game() {
        this.piece = new Piece();
    }

    public static Game getInstance() {
        return instance;
    }

    public Board getBoard() {
        return this.board;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public long getScore() {
        return this.score;
    }

    private boolean collidesOnDropDown() {
        Point[] piecePoints = this.piece.getPiecePoints();
        Color[][] boardArray = this.board.toArray();

        for (Point piecePoint : piecePoints) {
            if (boardArray[piecePoint.x + this.piece.getPieceOrigin().x][piecePoint.y
                    + this.piece.getPieceOrigin().y + 1] != Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    private boolean collidesOnMove(String side) {
        Point[] piecePoints = this.piece.getPiecePoints();
        Color[][] boardArray = this.board.toArray();

        for (Point piecePoint : piecePoints) {
            switch (side) {
                case "left":
                    if (boardArray[piecePoint.x + this.piece.getPieceOrigin().x - 1][piecePoint.y + this.piece.getPieceOrigin().y] != Color.BLACK) {
                        return true;
                    }
                    break;
                case "right":
                    if (boardArray[piecePoint.x + this.piece.getPieceOrigin().x + 1][piecePoint.y + this.piece.getPieceOrigin().y + 1] != Color.BLACK) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private boolean collidesOnRotation() {
        Point[] piecePoints = this.piece.getRotatedPiecePoints();
        Color[][] boardArray = this.board.toArray();

        for (Point piecePoint : piecePoints) {
            if (boardArray[piecePoint.x + this.piece.getPieceOrigin().x][piecePoint.y + this.piece.getPieceOrigin().y] != Color.BLACK) {
                return true;
            }
        }
        return false;
    }

    public boolean isOver() {
        Point[] piecePoints = this.piece.getPiecePoints();
        Color[][] boardArray = this.board.toArray();

        for (Point piecePoint : piecePoints) {
            if (boardArray[piecePoint.x + this.piece.getPieceOrigin().x][piecePoint.y + this.piece.getPieceOrigin().y] != Color.BLACK
                    && (piecePoint.y == 1 || piecePoint.y == 0)) {
                return true;
            }
        }
        return false;
    }

    public void rotatePiece() {
        if (!this.collidesOnRotation()) {
            piece.rotate();
        }
        this.repaint();
    }

    public void movePieceLeft() {
        if (!collidesOnMove("left")) {
            this.piece.moveLeft();
        }
        this.repaint();
    }

    public void movePieceRight() {
        if (!collidesOnMove("right")) {
            this.piece.moveRight();
        }
        this.repaint();
    }

    public void dropPieceDown() {
        if (!this.collidesOnDropDown()) {
            this.piece.dropDown();
        } else {
            board.stickPiece(piece);
            this.score += board.clearRows();
            this.piece = new Piece();
        }
        this.repaint();
    }

    public void addScore(int points) {
        this.score += points;
    }

    @Override
    public void paintComponent(Graphics g) {
        this.board.paint(g);

        g.setColor(Color.WHITE);
        g.drawString("" + score, 19 * 12, 25);

        this.piece.draw(g);
    }

}
