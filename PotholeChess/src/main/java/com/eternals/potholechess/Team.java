package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

class Team implements Serializable {

    ArrayList<Piece> team;
    String color;

    public Team(String color) {
        this.color = color;

        initialize_team();
    }

    public void initialize_team() {

        team = new ArrayList<>();

        if (color.equals("WHITE")) {
            for (int i = 0; i < 8; i++) {
                team.add(new Pawn(color));
            }
            team.add(new Rook(color));
            team.add(new Knight(color));
            team.add(new Bishop(color));
            team.add(new Queen(color));
            team.add(new King(color));
            team.add(new Bishop(color));
            team.add(new Knight(color));
            team.add(new Rook(color));
        } else if (color.equals("BLACK")) {
            for (int i = 0; i < 8; i++) {
                team.add(new Pawn(color));
            }
            team.add(new Rook(color));
            team.add(new Knight(color));
            team.add(new Bishop(color));
            team.add(new King(color));
            team.add(new Queen(color));
            team.add(new Bishop(color));
            team.add(new Knight(color));
            team.add(new Rook(color));
        }
    }

    public Piece get(int i) {
        return team.get(i);
    }

}
