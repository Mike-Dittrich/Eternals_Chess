package com.eternals.potholechess;

import java.io.Serializable;
import java.util.Random;
import javafx.scene.shape.Rectangle;

public class Board implements Serializable {

    private Tile_Node[][] board;
    private int column, row;
    private Tile_Node selected_tile, destination_tile, temp_tile;
    private String turn;

    public Board(int column, int row) {

        this.turn = "WHITE";
        this.column = column;
        this.row = row;
        board = new Tile_Node[column][row];
        allocate(column, row);
    }

    public void select(int column, int row) {

        if (selected_tile == null) {
            if (board[column][row].has_piece() && board[column][row].is_not_pothole() && board[column][row].team().equals(turn)) {
                selected_tile = board[column][row];
            }
        } else if (board[column][row].is_not_pothole() && !board[column][row].team().equals(turn)) {
            destination_tile = board[column][row];
            move();
        } else {
            selected_tile = null;
            destination_tile = null;
            temp_tile = null;
        }
    }

    public void move() {
        
        destination_tile.bind(selected_tile.get_piece());
        selected_tile.clear_piece();
        selected_tile = null;
        destination_tile = null;
        temp_tile = null;
        switch_turn();
    }

    public void switch_turn() {
        if (turn.equals("WHITE")) {
            turn = "BLACK";
        } else if (turn.equals("BLACK")) {
            turn = "WHITE";
        }
    }
    
    public String get_game_info_text(){
        return turn + "'s turn!";
    }
    
    public void set_turn(){
        turn = "WHITE";
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
        
        selected_tile = null;
        destination_tile = null;
        temp_tile = null;
    }

    public void bind(Piece piece, int column, int row) {
        board[column][row].bind(piece);
        try {
            board[column][row].display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public boolean has_piece(int column, int row) {

        if (board[column][row].has_piece()) {
            return true;
        } else {
            return false;
        }
    }

    void display(int i, int j) {
        try {
            board[i][j].display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void clear_pieces() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j].clear_piece();
            }
        }
    }

}
