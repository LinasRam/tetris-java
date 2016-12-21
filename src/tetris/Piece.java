package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

public class Piece extends JPanel {

    private final Point[][][] Tetrominos = {
        // I-Piece
        {
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}
        },
        // J-Piece
        {
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0)}
        },
        // L-Piece
        {
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0)},
            {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)}
        },
        // O-Piece
        {
            {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1)}
        },
        // S-Piece
        {
            {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
            {new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1)},
            {new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)}
        },
        // T-Piece
        {
            {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1)},
            {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)},
            {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2)},
            {new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2)}
        },
        // Z-Piece
        {
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
            {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)},
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)},
            {new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2)}
        }
    };

    private final Color[] tetrominoColors = {
        Color.cyan, Color.blue, Color.orange, Color.yellow, Color.green, Color.pink, Color.red
    };

    private Point pieceOrigin;
    private int currentPiece;
    private int rotation;

    public Piece() {
        this.pieceOrigin = new Point(5, 0);
        this.currentPiece = new Random().nextInt(7);
        this.rotation = 0;
    }

    public Point[] getPiecePoints() {
        Point[] piecePoints = new Point[4];
        int index = 0;

        for (Point piecePoint : this.Tetrominos[this.currentPiece][this.rotation]) {
            piecePoints[index] = piecePoint;
            index++;
        }

        return piecePoints;
    }

    public Point[] getRotatedPiecePoints() {
        Point[] piecePoints = new Point[4];
        int index = 0;
        int newRotation = (rotation + 1) % 4;
        if (newRotation < 0) {
            newRotation = 3;
        }

        for (Point piecePoint : this.Tetrominos[this.currentPiece][newRotation]) {
            piecePoints[index] = piecePoint;
            index++;
        }

        return piecePoints;
    }

    public Point getPieceOrigin() {
        return this.pieceOrigin;
    }

    public Color getCurrentPieceColor() {
        return this.tetrominoColors[this.currentPiece];
    }

    public void rotate() {
        int newRotation = (rotation + 1) % 4;
        if (newRotation < 0) {
            newRotation = 3;
        }
        this.rotation = newRotation;
    }

    public void moveLeft() {
        this.pieceOrigin.x -= 1;
    }

    public void moveRight() {
        this.pieceOrigin.x += 1;
    }

    public void dropDown() {
        this.pieceOrigin.y += 1;
    }

    public void draw(Graphics g) {
        Point[] piecePoints = this.getPiecePoints();

        g.setColor(this.tetrominoColors[this.currentPiece]);
        for (Point piecePoint : piecePoints) {
            g.fillRect((piecePoint.x + pieceOrigin.x) * 26,
                    (piecePoint.y + pieceOrigin.y) * 26,
                    25, 25);
        }
    }

//    class LShape {
//
//        State1  = {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
//
//    }
}
