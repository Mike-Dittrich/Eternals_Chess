/*
Programmers: Mike Dittrich, Ricky Hodge, Noah Meduvsky, Phillip Shmoan

CSI 2999 Sophmore Project Team Eternals

Purpose: The application layer of Pothole Chess.
Provides data and logic layers for GUI to interact with.



 */
package com.eternals.potholechess;

import java.io.*;
import java.util.Random;
import javafx.scene.shape.Rectangle;

public class PotholeChess_ApplicationLayer implements Serializable {

    private int column_size;
    private int row_size;
    private Board board;
    private Team white;
    private Team black;

    //non default constructor
    public PotholeChess_ApplicationLayer() {

        set_column_size(8);
        set_row_size(8);
        board = new Board(get_column_size(), get_row_size());
        white = new Team("WHITE");
        black = new Team("BLACK");
    }

    /**
     * @return the column_size
     */
    public int get_column_size() {
        return column_size;
    }

    /**
     * @param column_size the column_size to set
     */
    public void set_column_size(int column_size) {
        this.column_size = column_size;
    }

    /**
     * @return the row_size
     */
    public int get_row_size() {
        return row_size;
    }

    /**
     * @param row_size the row_size to set
     */
    public void set_row_size(int row_size) {
        this.row_size = row_size;
    }

    public void randomize_board_size() {
        Random random = new Random();
        set_row_size(random.nextInt(5) + 8);
        set_column_size(random.nextInt(5) + 8);
        board = new Board(get_column_size(), get_row_size());
        white = new Team("WHITE");
        black = new Team("BLACK");
    }

    public void standardize_board_size() {

        set_row_size(8);
        set_column_size(8);
        white = new Team("WHITE");
        black = new Team("BLACK");
    }
    
    public void display_pieces(){
        for (int i = 0; i < get_row_size(); i++){
            for (int j = 0; j < get_column_size(); j++){
                if (board.has_piece(i, j)){
                    board.display(i, j);
                }
            }
        }//end outer for loop
    }
    
    public void bind_pieces(){
        int white_x = ((get_column_size() - 1) / 2) - 3;
        int white_y = (get_row_size() - 2);
        
        board.bind(white.get(0), white_x++, white_y);
        board.bind(white.get(1), white_x++, white_y);
        board.bind(white.get(2), white_x++, white_y);
        board.bind(white.get(3), white_x++, white_y);
        board.bind(white.get(4), white_x++, white_y);
        board.bind(white.get(5), white_x++, white_y);
        board.bind(white.get(6), white_x++, white_y);
        board.bind(white.get(7), white_x, white_y++);
        
        white_x -= 7;
        
        board.bind(white.get(8), white_x++, white_y);
        board.bind(white.get(9), white_x++, white_y);
        board.bind(white.get(10), white_x++, white_y);
        board.bind(white.get(11), white_x++, white_y);
        board.bind(white.get(12), white_x++, white_y);
        board.bind(white.get(13), white_x++, white_y);
        board.bind(white.get(14), white_x++, white_y);
        board.bind(white.get(15), white_x, white_y);
        
        
        int black_x = ((get_column_size() - 1) / 2) - 3;
        int black_y = 1;
        
        board.bind(black.get(0), black_x++, black_y);
        board.bind(black.get(1), black_x++, black_y);
        board.bind(black.get(2), black_x++, black_y);
        board.bind(black.get(3), black_x++, black_y);
        board.bind(black.get(4), black_x++, black_y);
        board.bind(black.get(5), black_x++, black_y);
        board.bind(black.get(6), black_x++, black_y);
        board.bind(black.get(7), black_x, black_y--);
        
        black_x -= 7;
        
        board.bind(black.get(8), black_x++, black_y);
        board.bind(black.get(9), black_x++, black_y);
        board.bind(black.get(10), black_x++, black_y);
        board.bind(black.get(11), black_x++, black_y);
        board.bind(black.get(12), black_x++, black_y);
        board.bind(black.get(13), black_x++, black_y);
        board.bind(black.get(14), black_x++, black_y);
        board.bind(black.get(15), black_x, black_y);
        
        
        
    }
    
    public void bind(Piece piece, int column, int row){
        board.bind(piece, column, row);
    }

    public void bind(Rectangle tile, int column, int row) {
        board.bind(tile, column, row);
    }

    //Application logic for the chess game will go here
    /**
     * Serialize the PotholeChess_ApplicationLayer object
     */
    public void serializeObject() {

        //Attempt to serialize object into SerializedObject.ser file
        try {
            try (FileOutputStream serializedObject = new FileOutputStream("SerializedObject.ser"); ObjectOutputStream out = new ObjectOutputStream(serializedObject)) {

                out.writeObject(this);
            }
            System.out.println("Game Successfully Serialized");

        } catch (Exception e) {
            System.out.println("Failure in serializeObject() file i/o.  PotholeChess_ApplicationLayer Class.  Exception not tracked.");
        }

    }//end serializeObject()

    /**
     ********************For Use Instead of a Constructor***********************************************
     * *******************Don't Use the Constructor except to reset the object***************************
     *
     * Pulls a PotholeChess_ApplicationLayer object out of serialization
     *
     * @return either a deserialized object or a new object
     */
    public static PotholeChess_ApplicationLayer deserializeObject() {

        //Attempt to Deserialize an object from storage
        try {
            PotholeChess_ApplicationLayer from_cold_storage;
            try (FileInputStream serializedObject = new FileInputStream("SerializedObject.ser"); 
                    ObjectInputStream in = new ObjectInputStream(serializedObject))
            {
                from_cold_storage = (PotholeChess_ApplicationLayer) in.readObject();
            }

            return from_cold_storage;

        } catch (Exception e) {
            //default action if Deserialize file i/o failed
            return new PotholeChess_ApplicationLayer();
        }
    }//end deserializeObject()

}// end class
