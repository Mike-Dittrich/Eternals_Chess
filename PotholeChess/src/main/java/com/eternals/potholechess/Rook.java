package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Rook extends Piece implements Serializable {

    public Rook(String color) {
        super(color);
    }

    @Override
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {
        ArrayList<Tile_Node> moves = new ArrayList<>();

        for (int offset = 1; offset < 15; offset++) {

            try {
                if (board[column - offset][row].is_not_pothole()) {
                    if (board[column - offset][row].has_piece()) {

                        if (!board[column - offset][row].team().equals(board[column][row].team())) {
                            moves.add(board[column - offset][row]);
                            break;
                        } else if (board[column - offset][row].get_piece() instanceof King) {
                            if (this.move_count == 0 && board[column - offset][row].get_piece().get_move_count() == 0) {
                                moves.add(board[column - offset][row]);
                            }
                            break;
                        }
                        if (board[column - offset][row].team().equals(board[column][row].team())){
                            break;
                        }

                    } else {
                        moves.add(board[column - offset][row]);
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }//end outer for loop

        for (int offset = 1; offset < 15; offset++) {

            try {
                if (board[column + offset][row].is_not_pothole()) {
                    if (board[column + offset][row].has_piece()) {

                        if (!board[column + offset][row].team().equals(board[column][row].team())) {
                            moves.add(board[column + offset][row]);
                            break;
                        } else if (board[column + offset][row].get_piece() instanceof King) {
                            if (this.move_count == 0 && board[column + offset][row].get_piece().get_move_count() == 0) {
                                moves.add(board[column + offset][row]);
                            }
                            break;
                        }

                    } else {
                        moves.add(board[column + offset][row]);
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }//end outer for loop

        for (int offset = 1; offset < 15; offset++) {

            try {
                if (board[column][row - offset].is_not_pothole()) {
                    if (board[column][row - offset].has_piece()) {

                        if (!board[column][row - offset].team().equals(board[column][row].team())) {
                            moves.add(board[column][row - offset]);
                            break;
                        } else if (board[column][row - offset].get_piece() instanceof King) {
                            if (this.move_count == 0 && board[column][row - offset].get_piece().get_move_count() == 0) {
                                moves.add(board[column][row - offset]);
                            }
                            break;
                        }

                    } else {
                        moves.add(board[column][row - offset]);
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }//end outer for loop

        for (int offset = 1; offset < 15; offset++) {

            try {
                if (board[column][row + offset].is_not_pothole()) {
                    if (board[column][row + offset].has_piece()) {

                        if (!board[column][row + offset].team().equals(board[column][row].team())) {
                            moves.add(board[column][row + offset]);
                            break;
                        } else if (board[column][row + offset].get_piece() instanceof King) {
                            if (this.move_count == 0 && board[column][row + offset].get_piece().get_move_count() == 0) {
                                moves.add(board[column][row + offset]);
                            }
                            break;
                        }

                    } else {
                        moves.add(board[column - offset][row + offset]);
                    }
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }//end outer for loop

        return moves;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_ROOK.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_ROOK.png";
        }
        return "";

    }
}
