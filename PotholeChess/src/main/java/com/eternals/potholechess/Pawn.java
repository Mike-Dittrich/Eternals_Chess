package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Pawn extends Piece implements Serializable {
    private boolean promotion;

    public Pawn(String color) {
        super(color);
        promotion = false;
    }
    
    private ArrayList<Tile_Node> get_black_moves(Tile_Node[][]board, int column, int row){
            ArrayList<Tile_Node> moves = new ArrayList<>();

        try {
            if (board[column][row + 1].team().equals("EMPTY")) {
                moves.add(board[column][row + 1]);
            }
        } catch (Exception e) {

        }

        try {
            if (board[column - 1][row + 1].is_not_pothole() && board[column - 1][row + 1].has_piece()) {
                if (!board[column - 1][row + 1].team().equals(board[column][row].team())) {
                    moves.add(board[column - 1][row + 1]);
                }
            }
        } catch (Exception e) {

        }

        try {
            if (board[column + 1][row + 1].is_not_pothole() && board[column + 1][row + 1].has_piece()) {
                if (!board[column + 1][row + 1].team().equals(board[column][row].team())) {
                    moves.add(board[column + 1][row + 1]);
                }
            }
        } catch (Exception e) {

        }

        try {
            if (board[column][row + 1].team().equals("EMPTY") && this.move_count == 0) {
                if (board[column][row + 2].team().equals("EMPTY")) {
                    moves.add(board[column][row + 2]);
                }
            }

        } catch (Exception e) {
        }

        try {
            if (board[column + 1][row + 2].is_not_pothole() && !board[column + 1][row + 2].team().equals("EMPTY") && this.move_count == 0) {
                if (!board[column + 1][row + 2].team().equals(board[column][row].team())){
                    moves.add(board[column + 1][row + 2]);
                }
            }

        } catch (Exception e) {
        }
        
        try {
            if (board[column - 1][row + 2].is_not_pothole() && !board[column - 1][row + 2].team().equals("EMPTY") && this.move_count == 0) {
                if (!board[column - 1][row + 2].team().equals(board[column][row].team())){
                    moves.add(board[column - 1][row + 2]);
                }
                
            }

        } catch (Exception e) {
        }


        return moves;
    }
    
    
    private ArrayList<Tile_Node> get_white_moves(Tile_Node[][]board, int column, int row){
            ArrayList<Tile_Node> moves = new ArrayList<>();

        try {
            if (board[column][row - 1].team().equals("EMPTY")) {
                moves.add(board[column][row - 1]);
            }
        } catch (Exception e) {

        }

        try {
            if (board[column - 1][row - 1].is_not_pothole() && board[column - 1][row - 1].has_piece()) {
                if (!board[column - 1][row - 1].team().equals(board[column][row].team())) {
                    moves.add(board[column - 1][row - 1]);
                }
            }
        } catch (Exception e) {

        }

        try {
            if (board[column + 1][row - 1].is_not_pothole() && board[column + 1][row - 1].has_piece()) {
                if (!board[column + 1][row - 1].team().equals(board[column][row].team())) {
                    moves.add(board[column + 1][row - 1]);
                }
            }
        } catch (Exception e) {

        }

        try {
            if (board[column][row - 1].team().equals("EMPTY") && this.move_count == 0) {
                if (board[column][row - 2].team().equals("EMPTY")) {
                    moves.add(board[column][row - 2]);
                }
            }

        } catch (Exception e) {
        }

        try {
            if (board[column + 1][row - 2].is_not_pothole() && !board[column + 1][row - 2].team().equals("EMPTY") && this.move_count == 0) {
                if (!board[column + 1][row - 2].team().equals(board[column][row].team())){
                    moves.add(board[column + 1][row - 2]);
                }
            }

        } catch (Exception e) {
        }
        
        try {
            if (board[column - 1][row - 2].is_not_pothole() && !board[column - 1][row - 2].team().equals("EMPTY") && this.move_count == 0) {
                if (!board[column - 1][row - 2].team().equals(board[column][row].team())){
                    moves.add(board[column - 1][row - 2]);
                }
                
            }

        } catch (Exception e) {
        }


        return moves;
    }
    
    
        private ArrayList<Tile_Node> get_queen_moves(Tile_Node[][]board, int column, int row){
            
        return null;
            
        }

    @Override
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {
        
        if (this.color.equals("BLACK") && !promotion){
            return get_black_moves(board, column, row);
        } else if (this.color.equals("WHITE") && !promotion){
            return get_white_moves(board, column, row);
        } else if (promotion){
            return get_queen_moves(board, column, row);
        }
                
                
                
        return null;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_PAWN.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_PAWN.png";
        }
        return "";

    }
}
