package com.eternals.potholechess;

import java.io.Serializable;
import javafx.scene.shape.Rectangle;

public class Board implements Serializable {

    private Tile_Node[][] board;
    private int column, row;

    public Board(int column, int row) {

        this.column = column;
        this.row = row;
        board = new Tile_Node[column][row];
        allocate(column, row);
    }

    public void allocate(int column, int row) {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = new Tile_Node();
            }
        }

    }

    public void bind(Rectangle rectangle, int column, int row) {

        try {
            board[column][row].bind(rectangle);
            board[column][row].display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void unbind() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j].unbind();
            }
        }
    }

    public void bind(Piece piece, int column, int row) {
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
