package com.eternals.potholechess;

public class Piece {

    int move_count;
    String color;

    public Piece(String color) {
        set_move_count();
        set_color(color);

    }

    void set_move_count() {
        move_count = 0;
    }

    void set_color(String color) {
        if (color.equals("WHITE") || color.equals("BLACK")) {
            this.color = color;
        }
    }

    public boolean is_not_pothole() {
        return true;
    }
}
