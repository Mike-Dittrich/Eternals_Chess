package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Bishop extends Piece implements Serializable {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {
        ArrayList<Tile_Node> moves = new ArrayList<>();

        boolean sentinal = true;
        int offset = 1;

        while (sentinal) {

            try {

                if (board[column + offset][row + offset].is_not_pothole()) {
                    if (board[column + offset][row + offset].has_piece()) {
                        if (board[column + offset][row + offset].team().equals(board[column][row].team())) {
                            sentinal = false;
                            break;
                        } else {
                            moves.add(board[column + offset][row + offset]);
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column + offset][row + offset]);
                        offset++;
                        continue;
                    }

                } else {
                    sentinal = false;
                    break;
                }

            } catch (Exception e) {
                sentinal = false;
                break;
            }

        }//end outer while loop

        sentinal = true;
        offset = 1;

        while (sentinal) {

            try {

                if (board[column + offset][row - offset].is_not_pothole()) {
                    if (board[column + offset][row - offset].has_piece()) {
                        if (board[column + offset][row - offset].team().equals(board[column][row].team())) {
                            sentinal = false;
                            break;
                        } else {
                            moves.add(board[column + offset][row - offset]);
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column + offset][row - offset]);
                        offset++;
                        continue;
                    }

                } else {
                    sentinal = false;
                    break;
                }

            } catch (Exception e) {
                sentinal = false;
                break;
            }

        }//end outer while loop

        sentinal = true;
        offset = 1;

        while (sentinal) {

            try {

                if (board[column - offset][row - offset].is_not_pothole()) {
                    if (board[column - offset][row - offset].has_piece()) {
                        if (board[column - offset][row - offset].team().equals(board[column][row].team())) {
                            sentinal = false;
                            break;
                        } else {
                            moves.add(board[column - offset][row - offset]);
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column - offset][row - offset]);
                        offset++;
                        continue;
                    }

                } else {
                    sentinal = false;
                    break;
                }

            } catch (Exception e) {
                sentinal = false;
                break;
            }

        }//end outer while loop

        sentinal = true;
        offset = 1;

        while (sentinal) {

            try {

                if (board[column - offset][row + offset].is_not_pothole()) {
                    if (board[column - offset][row + offset].has_piece()) {
                        if (board[column - offset][row + offset].team().equals(board[column][row].team())) {
                            sentinal = false;
                            break;
                        } else {
                            moves.add(board[column - offset][row + offset]);
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column - offset][row + offset]);
                        offset++;
                        continue;
                    }

                } else {
                    sentinal = false;
                    break;
                }

            } catch (Exception e) {
                sentinal = false;
                break;
            }

        }//end outer while loop

        return moves;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_BISHOP.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_BISHOP.png";
        }
        return "";

    }

}
