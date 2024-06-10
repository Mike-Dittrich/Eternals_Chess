
package com.eternals.potholechess;


public class Pothole extends Piece {
    
    public Pothole(String color) {
        super(color);
    }
    
    @Override
    public boolean is_not_pothole(){
        return false;
    }
}
