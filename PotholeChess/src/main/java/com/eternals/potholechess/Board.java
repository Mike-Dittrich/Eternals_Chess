


package com.eternals.potholechess;

import javafx.scene.shape.Rectangle;



public class Board {
    
    private Tile_Node[][] board; 
    
    public Board(int column, int row){
        
        board = new Tile_Node[row][column];
    }
    
    public void bind(Rectangle rectangle, int column, int row){
        
        board[column][row].bind(rectangle);
        board[column][row].display();
        
    }
}
