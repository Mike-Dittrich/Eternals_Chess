
package com.eternals.potholechess;

import java.util.ArrayList;


class Team {
    ArrayList<Piece> team;
    String color;

    public Team(String color) {
        this.color = color;
        initialize_team(team); 
    }

    private void initialize_team(ArrayList<Piece> team) {
        for (int i = 0; i < 8; i++){
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
    }
    
    
}
