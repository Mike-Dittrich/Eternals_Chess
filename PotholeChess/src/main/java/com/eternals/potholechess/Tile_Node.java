
package com.eternals.potholechess;

import javafx.scene.shape.Rectangle;


public class Tile_Node {
    
    private Rectangle rectangle;
    private Piece piece;
    
    
    
    
    public void bind(Rectangle rectangle){
        
        this.rectangle = rectangle;
    }
    
    public void bind(Piece piece){
        this.piece = piece;
    }
    
    public boolean is_not_pothole(){
        
        if (piece instanceof Pothole){
            return false;
        } else {
            return true;            
        }
    }
    
    public void display(){
     //stub   
     
     
    }
}
