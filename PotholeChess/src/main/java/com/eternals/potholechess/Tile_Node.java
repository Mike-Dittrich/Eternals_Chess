package com.eternals.potholechess;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tile_Node implements Serializable {

    private Rectangle rectangle;
    private Piece piece;
    private String allocation;
    private int column, row;

    public Tile_Node() {
        this.allocation = "Memory Allocated";
    }
    
    public int get_column(){
        return column;
    }
    
    public int get_row(){
        return row;
    }
    
    public ArrayList<Tile_Node> get_moves(Tile_Node[][] board, int column, int row){
        return piece.get_moves(board, column, row);
    }
    
    public void highlight(){
        rectangle.setStroke(Color.GREEN);
        rectangle.setStrokeWidth(5);
    }
    
    public void increment_move(){
        piece.increment_move();
    }

    public void bind(Rectangle rectangle, int column, int row) {

        this.rectangle = rectangle;
        this.column = column;
        this.row = row;
    }

    public void unbind() {
        this.rectangle = null;
    }
    
    public void clear_piece(){
        
        if (piece != null && piece.is_not_pothole()){
        this.piece = null;
        display();
        }
        
    }

    public void bind(Piece piece) {
        this.piece = piece;
        if (rectangle != null){
        display();
        }
    }
    
    public String team(){
        if (piece != null){
        return piece.get_color();
        } else {
            return "EMPTY";
        }
    }

    public Piece get_piece() {
        return piece;
    }

    public void remove_piece() {
        this.piece = null;
    }

    public boolean has_piece() {
        if (piece != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean is_not_pothole() {

        if (piece instanceof Pothole) {
            return false;
        } else {
            return true;
        }
    }

    public void display() {

        if (piece != null && rectangle != null) {
            Image image = new Image("file:" + piece.get_image_file());
            
            rectangle.setFill(new ImagePattern(image));        
            
            if ((row + column) % 2 == 0){
                rectangle.setStroke(Color.WHITE);
                rectangle.setStrokeWidth(5);                
            } else {
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(5);                
            }


        } else if (rectangle != null){
            if ((row + column) % 2 == 0) {
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.WHITE);
                rectangle.setStrokeWidth(5);
            } else {
                rectangle.setFill(Color.BLACK);
                rectangle.setStroke(Color.BLACK);
                rectangle.setStrokeWidth(5);
            }
        }

    }
}
