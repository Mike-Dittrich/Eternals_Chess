package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Pawn extends Piece implements Serializable {

    private boolean promotion;

    public Pawn(String color) {
        super(color);
        promotion = false;
    }

    @Override
    public void promote() {
        promotion = true;
    }
    
    @Override
    public void set_double_jump(){
        double_jump = true;
    }
    
    
    @Override
    public boolean double_jump(){
        return (double_jump && get_move_count() == 1);
    }

    @Override
    public boolean is_pawn() {
        return !promotion;
    }

    private ArrayList<Tile_Node> get_black_moves(Tile_Node[][] board, int column, int row) {
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

            if (board[column + 1][row].is_not_pothole() && board[column + 1][row].has_piece()) {
                if (!board[column + 1][row].team().equals(board[column][row].team())) {
                    if (board[column + 1][row].get_piece() instanceof Pawn && board[column + 1][row].get_piece().double_jump()) {
                        if (board[column + 1][row + 1].is_not_pothole() && !board[column + 1][row + 1].team().equals(board[column][row].team())) {
                            moves.add(board[column + 1][row + 1]);
                        }
                    }
                }

            }

        } catch (Exception e) {
        }

        try {

            if (board[column - 1][row].is_not_pothole() && board[column - 1][row].has_piece()) {
                if (!board[column - 1][row].team().equals(board[column][row].team())) {
                    if (board[column - 1][row].get_piece() instanceof Pawn && board[column - 1][row].get_piece().double_jump()) {
                        if (board[column - 1][row + 1].is_not_pothole() && !board[column - 1][row + 1].team().equals(board[column][row].team())) {
                            moves.add(board[column - 1][row + 1]);
                        }
                    }
                }

            }


        } catch (Exception e) {
        }

        return moves;
    }

    private ArrayList<Tile_Node> get_white_moves(Tile_Node[][] board, int column, int row) {
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

            if (board[column + 1][row].is_not_pothole() && board[column + 1][row].has_piece()) {
                if (!board[column + 1][row].team().equals(board[column][row].team())) {
                    if (board[column + 1][row].get_piece() instanceof Pawn && board[column + 1][row].get_piece().get_move_count() == 1) {
                        if (board[column + 1][row - 1].is_not_pothole() && !board[column + 1][row - 1].team().equals(board[column][row].team())) {
                            moves.add(board[column + 1][row - 1]);
                        }
                    }
                }

            }

        } catch (Exception e) {
        }

        try {

            if (board[column - 1][row].is_not_pothole() && board[column - 1][row].has_piece()) {
                if (!board[column - 1][row].team().equals(board[column][row].team())) {
                    if (board[column - 1][row].get_piece() instanceof Pawn && board[column - 1][row].get_piece().get_move_count() == 1) {
                        if (board[column - 1][row - 1].is_not_pothole() && !board[column - 1][row - 1].team().equals(board[column][row].team())) {
                            moves.add(board[column - 1][row - 1]);
                        }
                    }
                }

            }


        } catch (Exception e) {
        }

        return moves;
    }

    private ArrayList<Tile_Node> get_queen_moves(Tile_Node[][] board, int column, int row) {
        ArrayList<Tile_Node> moves = new ArrayList<>();

        boolean sentinal = true;
        int offset = 1;

        while (sentinal) {

            try {
                if (board[column - offset][row].is_not_pothole()) {
                    if (board[column - offset][row].has_piece()) {

                        if (!board[column - offset][row].team().equals(board[column][row].team())) {
                            moves.add(board[column - offset][row]);
                            sentinal = false;
                            break;
                        } else {
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column - offset][row]);
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
                if (board[column + offset][row].is_not_pothole()) {
                    if (board[column + offset][row].has_piece()) {

                        if (!board[column + offset][row].team().equals(board[column][row].team())) {
                            moves.add(board[column + offset][row]);
                            sentinal = false;
                            break;
                        } else {
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column + offset][row]);
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
                if (board[column][row - offset].is_not_pothole()) {
                    if (board[column][row - offset].has_piece()) {

                        if (!board[column][row - offset].team().equals(board[column][row].team())) {
                            moves.add(board[column][row - offset]);
                            sentinal = false;
                            break;
                        } else {
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column][row - offset]);
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
                if (board[column][row + offset].is_not_pothole()) {
                    if (board[column][row + offset].has_piece()) {

                        if (!board[column][row + offset].team().equals(board[column][row].team())) {
                            moves.add(board[column][row + offset]);
                            sentinal = false;
                            break;
                        } else {
                            sentinal = false;
                            break;
                        }

                    } else {
                        moves.add(board[column][row + offset]);
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
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row) {

        if (this.color.equals("BLACK") && !promotion) {
            return get_black_moves(board, column, row);
        } else if (this.color.equals("WHITE") && !promotion) {
            return get_white_moves(board, column, row);
        } else {
            return get_queen_moves(board, column, row);
        }

    }

    @Override
    public String get_image_file() {

        if (!promotion) {
            if (get_color().equals("WHITE")) {
                return "Images/WHITE_PAWN.png";
            } else if (get_color().equals("BLACK")) {
                return "Images/BLACK_PAWN.png";
            }
        } else if (promotion) {

            if (get_color().equals("WHITE")) {
                return "Images/WHITE_QUEEN.png";
            } else if (get_color().equals("BLACK")) {
                return "Images/BLACK_QUEEN.png";
            }

        }

        return "";

    }
}
