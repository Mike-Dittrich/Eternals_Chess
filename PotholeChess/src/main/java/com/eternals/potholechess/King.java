package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class King extends Piece implements Serializable {

    public King(String color) {
        super(color);
    }

    @Override
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {
        ArrayList<Tile_Node> moves = new ArrayList<>();

        try {
            if (board[column][row + 1].is_not_pothole()) {
                if (!board[column][row + 1].team().equals(board[column][row].team())) {
                    moves.add(board[column][row + 1]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column + 1][row + 1].is_not_pothole()) {
                if (!board[column + 1][row + 1].team().equals(board[column][row].team())) {
                    moves.add(board[column + 1][row + 1]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column + 1][row].is_not_pothole()) {
                if (!board[column + 1][row].team().equals(board[column][row].team())) {
                    moves.add(board[column + 1][row]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column + 1][row - 1].is_not_pothole()) {
                if (!board[column + 1][row - 1].team().equals(board[column][row].team())) {
                    moves.add(board[column + 1][row - 1]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column][row - 1].is_not_pothole()) {
                if (!board[column][row - 1].team().equals(board[column][row].team())) {
                    moves.add(board[column][row - 1]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column - 1][row - 1].is_not_pothole()) {
                if (!board[column - 1][row - 1].team().equals(board[column][row].team())) {
                    moves.add(board[column - 1][row - 1]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column - 1][row].is_not_pothole()) {
                if (!board[column - 1][row].team().equals(board[column][row].team())) {
                    moves.add(board[column - 1][row]);
                }
            }
        } catch (Exception e) {
        }

        try {
            if (board[column - 1][row + 1].is_not_pothole()) {
                if (!board[column - 1][row + 1].team().equals(board[column][row].team())) {
                    moves.add(board[column - 1][row + 1]);
                }
            }
        } catch (Exception e) {
        }

        return moves;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_KING.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_KING.png";
        }
        return "";

    }
}
