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
    private boolean pothole;
    private boolean game_active;
    private boolean apocalypse;

    //non default constructor
    public PotholeChess_ApplicationLayer() {

//        pothole = false;
//        set_column_size(8);
//        set_row_size(8);
//        board = new Board(get_column_size(), get_row_size());
//        white = new Team("WHITE");
//        black = new Team("BLACK");
//        game_active = true;
        standardize_board_size();

        try {
            //bind_pieces();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
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
        game_active = true;
        pothole = true;
        apocalypse = false;
        Random random = new Random();
        set_row_size(random.nextInt(5) + 8);
        set_column_size(random.nextInt(5) + 8);
        board = new Board(get_column_size(), get_row_size());
        white = new Team("WHITE");
        black = new Team("BLACK");
        bind_pieces();
    }

    public void standardize_board_size() {
        game_active = true;
        pothole = false;
        apocalypse = false;
        set_row_size(8);
        set_column_size(8);
        board = new Board(get_column_size(), get_row_size());
        white = new Team("WHITE");
        black = new Team("BLACK");
        bind_pieces();
    }

    public void apocalypse_board_size() {
        game_active = true;
        pothole = false;
        apocalypse = true;
        set_row_size(12);
        set_column_size(12);
        board = new Board(get_column_size(), get_row_size());
        white = new Team("WHITE");
        black = new Team("BLACK");
        bind_pieces();

    }

    public void reset_board() {
        pothole = false;
        white = new Team("WHITE");
        black = new Team("BLACK");
        board.clear_pieces();
        board.set_turn();
        bind_pieces();
    }

    public void display_pieces() {
        for (int i = 0; i < get_row_size(); i++) {
            for (int j = 0; j < get_column_size(); j++) {
                if (board.has_piece(j, i)) {
                    board.display(j, i);
                }
            }
        }//end outer for loop
    }

    public void select(int column, int row) {

        try {
            if (game_active) {
                System.out.println(column + " " + row);
                board.select(column, row);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void bind_pieces() {
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

        if (pothole) {
            Random random = new Random();
            int number_of_potholes;
            int potholes;
            if (get_column_size() * get_row_size() < 85) {
                number_of_potholes = random.nextInt(4) + 1;
            } else if (get_column_size() * get_row_size() < 105) {
                number_of_potholes = random.nextInt(5) + 2;
            } else if (get_column_size() * get_row_size() < 120) {
                number_of_potholes = random.nextInt(6) + 3;
            } else {
                number_of_potholes = random.nextInt(7) + 4;
            }

            potholes = 0;
            while (potholes <= number_of_potholes) {
                int column, row;
                column = random.nextInt(get_column_size());
                row = random.nextInt(get_row_size());

                if (!board.has_piece(column, row)) {
                    try {
                        board.bind(new Pothole("POTHOLE"), column, row);
                        potholes++;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }

            }

        }

        if (apocalypse) {
            Random random = new Random();
            int number_of_potholes;
            int potholes;

            number_of_potholes = random.nextInt(10) + 10;
            
            potholes = 0;
            while (potholes <= number_of_potholes) {
                int column, row;
                column = random.nextInt(get_column_size());
                row = random.nextInt(get_row_size());

                if (!board.has_piece(column, row)) {
                    try {
                        board.bind(new Pothole("POTHOLE"), column, row);
                        potholes++;
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }

            }
        }

    }

    public void bind(Piece piece, int column, int row) {
        board.bind(piece, column, row);
    }

    public void bind(Rectangle tile, int column, int row) {
        board.bind(tile, column, row);
    }

    public String get_game_info_text() {
        return board.get_game_info_text();
    }

    /**
     * Serialize the PotholeChess_ApplicationLayer object
     */
    public void serializeObject() {

        board.unbind();

        //Attempt to serialize object into SerializedObject.ser file
        try {
            try (FileOutputStream serializedObject = new FileOutputStream("SerializedObject.ser"); ObjectOutputStream out = new ObjectOutputStream(serializedObject)) {

                out.writeObject(this);
            }
            System.out.println("Game Successfully Serialized");

        } catch (IOException e) {
            System.out.println("Failure in serializeObject() file i/o.  PotholeChess_ApplicationLayer Class.  Exception not tracked.");
            System.out.println(e.toString());
        }

    }//end serializeObject()

    /**
     ********************For Use Instead of a
     * Constructor***********************************************
     * *******************Don't Use the Constructor except to reset the
     * object***************************
     *
     * Pulls a PotholeChess_ApplicationLayer object out of serialization
     *
     * @return either a deserialized object or a new object
     */
    public static PotholeChess_ApplicationLayer deserializeObject() {

        //Attempt to Deserialize an object from storage
        try {
            PotholeChess_ApplicationLayer from_cold_storage;
            try (FileInputStream serializedObject = new FileInputStream("SerializedObject.ser"); ObjectInputStream in = new ObjectInputStream(serializedObject)) {
                from_cold_storage = (PotholeChess_ApplicationLayer) in.readObject();
            }

            System.out.println("Game Successfully Deserialized");
            return from_cold_storage;

        } catch (Exception e) {
            //default action if Deserialize file i/o failed
            System.out.println("Game Unsuccessfully Deserialized, New Object Returned");
            return new PotholeChess_ApplicationLayer();
        }
    }//end deserializeObject()

}// end class
