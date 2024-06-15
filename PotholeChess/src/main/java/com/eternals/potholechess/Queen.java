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
}
