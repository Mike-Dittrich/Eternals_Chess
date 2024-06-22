package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public final class Board implements Serializable {

    private final Tile_Node[][] board;
    private final int column_size;
    private final int row_size;
    private Tile_Node selected_tile, destination_tile, temp_tile;
    private ArrayList<Tile_Node> moves;
    private String turn;

    public Board(int column, int row) {

        this.turn = "WHITE";
        this.column_size = column;
        this.row_size = row;
        board = new Tile_Node[column][row];
        allocate(column, row);
    }

    public void select(int column, int row) {

        if (selected_tile == null) {
            if (board[column][row].has_piece() && board[column][row].is_not_pothole() && board[column][row].team().equals(turn)) {
                if (!board[column][row].get_moves(board, column, row).isEmpty()) {
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

    public void unhighlight() {
        if (!moves.isEmpty()) {
            for (Tile_Node move : moves) {
                move.display();
            }
        }
    }

    public void highlight_moves() {
        if (!moves.isEmpty()) {
            for (Tile_Node move : moves) {
                move.highlight();
            }
        }
    }

    public void move() {

        for (Tile_Node move : moves) {
            move.display();
        }

        if (selected_tile.get_piece() instanceof Rook) {
            move_rook();
        } else  if (selected_tile.get_piece() instanceof Pawn){
            move_pawn();
            
        } else {
        standard_move();            
        }


    }
    
    public void move_pawn(){
        if (!selected_tile.get_piece().is_pawn()){
            standard_move();
        } else if (selected_tile.team().equals("BLACK")  && (destination_tile.get_row() == (row_size - 1))){
            selected_tile.get_piece().promote();
            standard_move();
        } else if (selected_tile.team().equals("WHITE")  && (destination_tile.get_row() == 0)){
            selected_tile.get_piece().promote();
            standard_move();
        } else {
            standard_move();
        }
            
    }

    public void move_rook() {

        if (destination_tile.has_piece()) {
            if (destination_tile.team().equals(selected_tile.team())) {

                if (destination_tile.get_column() > selected_tile.get_column()){
                    board[destination_tile.get_column() - 1][destination_tile.get_row()].bind(destination_tile.get_piece());
                    destination_tile.clear_piece();
                    standard_move();
                } else {
                     board[destination_tile.get_column() + 1][destination_tile.get_row()].bind(destination_tile.get_piece());
                     destination_tile.clear_piece();
                    standard_move();                   
                }
                
                
                
            } else {
                standard_move();
            }

        } else {

            standard_move();

        }

    }

    public void standard_move() {
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

    public String get_game_info_text() {
        return turn + "'s turn!";
    }

    public void set_turn() {
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
        for (int i = 0; i < column_size; i++) {
            for (int j = 0; j < row_size; j++) {
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
        for (int i = 0; i < column_size; i++) {
            for (int j = 0; j < row_size; j++) {
                board[i][j].clear_piece();
            }
        }
    }

}
