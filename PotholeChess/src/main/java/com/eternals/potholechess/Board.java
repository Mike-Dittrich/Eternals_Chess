package com.eternals.potholechess;

import java.io.Serializable;
import java.util.Random;
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
            board[column][row].bind(rectangle, column, row);
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
        try {
            board[column][row].display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
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

    void bind_potholes(int potholes) {
        int i = 0;
        Random random = new Random();
        //(random.nextInt(column);

        while (i != potholes) {
            int x = random.nextInt(column);
            int y = random.nextInt(row);
            if (!board[x][y].has_piece()){
                board[x][y].bind(new Pothole("POTHOLE"));
                
            }
        }
    }
}
