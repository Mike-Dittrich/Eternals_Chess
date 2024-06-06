/*
Programmers: Mike Dittrich, Ricky Hodge, Noah Meduvsky, Phillip Shmoan

CSI 2999 Sophmore Project Team Eternals

Purpose: The application layer of Pothole Chess.
Provides data and logic layers for GUI to interact with.



*/

package com.eternals.potholechess;


import java.io.*;
import java.util.Random;


public class PotholeChess_ApplicationLayer implements Serializable {
    
    private int column_size;
    private int row_size;
    
    
    //non default constructor
    public PotholeChess_ApplicationLayer(){
        
        set_column_size(8);
        set_row_size(8);
        
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
    
    public void randomize_board_size(){
        Random random = new Random();
        set_row_size(random.nextInt(5) + 8);
        set_column_size(random.nextInt(5) + 8);
        
    }
    
    public void standardize_board_size(){
        
        set_row_size(8);
        set_column_size(8);
    }
    
    
    
    //Application logic for the chess game will go here
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     *Serialize the PotholeChess_ApplicationLayer object
     */
    public void serializeObject(){
        
            //Attempt to serialize object into SerializedObject.ser file
        try{
            try(FileOutputStream serializedObject = new FileOutputStream("SerializedObject.ser");
                    ObjectOutputStream out = new ObjectOutputStream(serializedObject)){
                
                out.writeObject(this);
            }
                System.out.println("Game Successfully Serialized");
                
        } catch(Exception e){
            System.out.println("Failure in serializeObject() file i/o.  PotholeChess_ApplicationLayer Class.  Exception not tracked.");
        }
        
    }//end serializeObject()
    
    
    /**
     *          *******************For Use Instead of a Constructor***********************************************
     *          *******************Don't Use the Constructor except to reset the object***************************
     * 
     * Pulls a PotholeChess_ApplicationLayer object out of serialization
     * @return either a deserialized object or a new object 
     */
    
    public static PotholeChess_ApplicationLayer deserializeObject(){
        
        //Attempt to Deserialize an object from storage
        try{
            PotholeChess_ApplicationLayer from_cold_storage;
            try (FileInputStream serializedObject = new FileInputStream("SerializedObject.ser");
                    ObjectInputStream in = new ObjectInputStream(serializedObject)){
                from_cold_storage = (PotholeChess_ApplicationLayer)in.readObject();
            }
            
            return from_cold_storage;
            
        } catch(Exception e){
            //default action if Deserialize file i/o failed
            return new PotholeChess_ApplicationLayer();
        }
    }//end deserializeObject()
}// end class
