package com.eternals.potholechess;

import java.io.Serializable;

public class Pothole extends Piece implements Serializable {

    public Pothole(String color) {
        super(color);
    }

    @Override
    public boolean is_not_pothole() {
        return false;
    }

    @Override
    public String get_image_file() {
        return "Images/POTHOLE2.png";

    }
}
