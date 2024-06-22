package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Knight extends Piece implements Serializable {

    public Knight(String color) {
        super(color);
    }

    @Override
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {
        ArrayList<Tile_Node> moves = new ArrayList<>();
        
        try{ //quadrant 3 moves
            if (board[column - 2][row - 1].is_not_pothole()){
                if (!board[column - 2][row - 1].team().equals(board[column][row].team())){
                    moves.add(board[column - 2][row - 1]);
                }
            }
        } catch (Exception e){
        }
        
        try{
            if (board[column - 1][row - 2].is_not_pothole()){
                if (!board[column - 1][row - 2].team().equals(board[column][row].team())){
                    moves.add(board[column - 1][row - 2]);
                }
            }
        } catch (Exception e){
        }

        try{ //quadrant 2 moves
            if (board[column - 2][row + 1].is_not_pothole()){
                if (!board[column - 2][row + 1].team().equals(board[column][row].team())){
                    moves.add(board[column - 2][row + 1]);
                }
            }
        } catch (Exception e){
        }

        try{
            if (board[column - 1][row + 2].is_not_pothole()){
                if (!board[column - 1][row + 2].team().equals(board[column][row].team())){
                    moves.add(board[column - 1][row + 2]);
                }
            }
        } catch (Exception e){
        }

        try{ //quadrant 4 moves
            if (board[column + 2][row - 1].is_not_pothole()){
                if (!board[column + 2][row - 1].team().equals(board[column][row].team())){
                    moves.add(board[column + 2][row - 1]);
                }
            }
        } catch (Exception e){
        }

        try{ 
            if (board[column + 1][row - 2].is_not_pothole()){
                if (!board[column + 1][row - 2].team().equals(board[column][row].team())){
                    moves.add(board[column + 1][row - 2]);
                }
            }
        } catch (Exception e){
        }

        try{ //quadrant 1 moves
            if (board[column + 2][row + 1].is_not_pothole()){
                if (!board[column + 2][row + 1].team().equals(board[column][row].team())){
                    moves.add(board[column + 2][row + 1]);
                }
            }
        } catch (Exception e){
        }

        try{
            if (board[column + 1][row + 2].is_not_pothole()){
                if (!board[column + 1][row + 2].team().equals(board[column][row].team())){
                    moves.add(board[column + 1][row + 2]);
                }
            }
        } catch (Exception e){
        }


        return moves;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_KNIGHT.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_KNIGHT.png";
        }
        return "";

    }
}
