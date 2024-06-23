package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;

public class Piece implements Serializable {

    int move_count;
    String color;
    boolean double_jump;

    public Piece(String color) {
        set_move_count();
        set_color(color);
        double_jump = false;

    }
    
    public boolean double_jump(){
        return double_jump;
    }
    
    public void set_double_jump(){
        
    }
    
    public void increment_move(){
        move_count++;
    }
    
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row){
        ArrayList<Tile_Node> moves = new ArrayList<>();
        
        return moves;
    }
    public void promote(){
        
    }
    public boolean is_pawn(){
     return true;   
    }

    void set_move_count() {
        move_count = 0;
    }

    void set_color(String color) {
            this.color = color;
        
    }
    
    public int get_move_count(){
        return move_count;
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
