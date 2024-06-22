package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.shape.Rectangle;

public class Board implements Serializable {

    private Tile_Node[][] board;
    private int column, row;
    private Tile_Node selected_tile, destination_tile, temp_tile;
    private ArrayList<Tile_Node> moves;
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
                if (!board[column][row].get_moves(board, column, row).isEmpty()){
                selected_tile = board[column][row];
                moves = board[column][row].get_moves(board, column, row);
                highlight_moves();
                }
            }
        } else if (moves.contains(board[column][row])) {
            destination_tile = board[column][row];
            move();
        } else {
            unhighlight();
            selected_tile = null;
            destination_tile = null;
            temp_tile = null;
            moves = null;
        }
    }
    
    
    public void unhighlight(){
        if (!moves.isEmpty()){
            for (Tile_Node move : moves){
                move.display();
            }
        }        
    }
    
    public void highlight_moves(){
        if (!moves.isEmpty()){
            for (Tile_Node move : moves){
                move.highlight();
            }
        }
    }

    public void move() {
        
        for (Tile_Node move : moves){
            move.display();
        }
        
        destination_tile.bind(selected_tile.get_piece());
        destination_tile.increment_move();
        selected_tile.clear_piece();
        selected_tile = null;
        destination_tile = null;
        temp_tile = null;
        moves = null;
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
        
        moves = null;
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
        return board[column][row].has_piece();
    }

    void display(int i, int j) {
        try {
            board[i][j].display();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void clear_pieces() {
        
        selected_tile = null;
        destination_tile = null;
        temp_tile = null;
        moves = null;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j].clear_piece();
            }
        }
    }

}
