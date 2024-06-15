
package com.eternals.potholechess;

import java.io.Serializable;


public class Pothole extends Piece implements Serializable {
    
    public Pothole(String color) {
        super(color);
    }
    
    @Override
    public boolean is_not_pothole(){
        return false;
    }
}
