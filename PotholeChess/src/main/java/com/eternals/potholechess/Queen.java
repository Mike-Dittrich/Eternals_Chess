package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Queen extends Piece implements Serializable {

    public Queen(String color) {
        super(color);
    }

    public ArrayList<Tile_Node> get_moves(Board board) {
        ArrayList<Tile_Node> moves = null;

        return moves;
    }

    @Override
    public String get_image_file() {
        if (get_color().equals("WHITE")) {
            return "Images/WHITE_QUEEN.png";
        } else if (get_color().equals("BLACK")) {
            return "Images/BLACK_QUEEN.png";
        }
        return "";

    }
}
