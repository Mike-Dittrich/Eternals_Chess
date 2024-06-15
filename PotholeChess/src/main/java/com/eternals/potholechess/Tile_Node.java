package com.eternals.potholechess;

import java.io.Serializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tile_Node implements Serializable {

    private Rectangle rectangle;
    private Piece piece;
    private String allocation;

    public Tile_Node() {
        this.allocation = "Memory Allocated";
    }
    


    public void bind(Rectangle rectangle) {

        this.rectangle = rectangle;
    }
    
    public void unbind(){
        this.rectangle = null;
    }

    public void bind(Piece piece) {
        this.piece = piece;
        display();
    }
    
    public void remove_piece(){
        this.piece = null;
    }
    
    public boolean has_piece(){
        if (piece != null){
            return true;
        } else{
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

        if (piece != null) {
            Image image = new Image(piece.get_image_file());

            rectangle.setFill(new ImagePattern(image));
        }

    }
}
