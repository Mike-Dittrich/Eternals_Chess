package com.eternals.potholechess;

import java.io.Serializable;

public class Piece implements Serializable {

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
            this.color = color;
        
    }
    
    String get_color(){
        
        return color;
    }

    public boolean is_not_pothole() {
        return true;
    }

    String get_image_file() {
        return "";
    }


}
