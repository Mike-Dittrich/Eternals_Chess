package com.eternals.potholechess;

import java.io.Serializable;
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
        } else if (rectangle != null){
            if ((row + column) % 2 == 0) {
                rectangle.setFill(Color.WHITE);
            } else {
                rectangle.setFill(Color.BLACK);
            }
        }

    }
}
