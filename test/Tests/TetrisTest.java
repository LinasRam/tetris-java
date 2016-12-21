/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Game;

/**
 *
 * @author Linas
 */
public class TetrisTest {

    public TetrisTest() {
    }

    @Test
    public void rotationTest() {
        Game game = Game.getInstance();
        int rotation = game.getPiece().getRotation();
        
        game.rotatePiece();
        
        Assert.assertTrue(rotation != game.getPiece().getRotation());
    }
    
    @Test
    public void drowDownTest() throws InterruptedException {
        Game game = Game.getInstance();
        double pieceOrigin = game.getPiece().getPieceOrigin().getY();
        
        game.getPiece().dropDown();
        
        Assert.assertTrue(pieceOrigin < game.getPiece().getPieceOrigin().getY());
    }

}
