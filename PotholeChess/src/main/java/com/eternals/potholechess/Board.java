package com.eternals.potholechess;

import javafx.scene.shape.Rectangle;

public class Board {

    private Tile_Node[][] board;

    public Board(int column, int row) {

        board = new Tile_Node[row][column];
    }

    public void bind(Rectangle rectangle, int column, int row) {

        board[column][row].bind(rectangle);
        board[column][row].display();

    }
    
    public void bind(Piece piece, int column, int row){
        board[column][row].bind(piece);
        board[column][row].display();
    }

    public boolean has_piece(int i, int j) {

        if (board[i][j].has_piece()) {
            return true;
        } else {
            return false;
        }
    }

    void display(int i, int j) {
        board[i][j].display();
    }
}
