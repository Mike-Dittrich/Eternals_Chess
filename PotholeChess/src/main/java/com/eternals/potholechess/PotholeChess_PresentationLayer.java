/*
Programmers: Mike Dittrich, Ricky Hodge, Noah Meduvsky, Phillip Shmoan

CSI 2999 Sophmore Project Team Eternals

Purpose: The presentation layer of Pothole Chess.
Provides GUI interface for users to interact with.



 */
package com.eternals.potholechess;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX PotholeChess_PresentationLayer
 */
public class PotholeChess_PresentationLayer extends Application {

    private PotholeChess_ApplicationLayer game = PotholeChess_ApplicationLayer.deserializeObject();
    private Stage primary_stage;
    private Label game_info;

    @Override
    public void start(Stage stage) {

        this.primary_stage = stage;

        //set title
        stage.setTitle("Team Eternals Pothole Chess!");

        //create outer_grid
        ScrollPane scroll_content = create_content();

        //Create scene using our outer_grid object
        Scene scene = new Scene(scroll_content, 1100, 800);

//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }//end start()

    public static void main(String[] args) {
        launch();
    }

    public ScrollPane create_content() {
        //create outer_grid
        GridPane outer_grid = new GridPane();

        //format outer_grid
        outer_grid.setAlignment(Pos.TOP_LEFT);
        outer_grid.setPadding(new Insets(25, 25, 25, 25));
        outer_grid.setHgap(10);
        outer_grid.setVgap(10);

        //Format Eternals Chess Label
        Label eternals_label = new Label("Eternals Chess");
        eternals_label.setFont(new Font("Cambria", 30));

        //Add a new game button
        Button new_game_button = new Button("New Game");
        new_game_button.setOnAction(event -> new_game_button_clicked());

        //Add a new pothole chess button
        Button new_game_pothole_button = new Button("New Pothole Game");
        new_game_pothole_button.setOnAction(event -> new_game_pothole_button_clicked());
        
        //Add a new Apocalypse Mode button
        Button apocalypse_mode_button = new Button("Apocalypse Mode");
        apocalypse_mode_button.setOnAction(event -> apocalypse_mode_button_clicked());

        //Add a reset button
        Button reset_button = new Button("Reset");
        reset_button.setOnAction(event -> reset_button_clicked());
        
        //Add a game info label
        game_info = new Label(game.get_game_info_text());
        game_info.setFont(new Font("Cambria", 20));

        //Create and add Vbox for labels & control buttons
        VBox controls = new VBox(10);
        controls.getChildren().add(eternals_label);
        controls.getChildren().add(new_game_button);
        controls.getChildren().add(new_game_pothole_button);
        controls.getChildren().add(apocalypse_mode_button);
        controls.getChildren().add(reset_button);
        controls.getChildren().add(game_info);

        //Add HBox controls object to the outer_grid
        outer_grid.add(controls, 0, 0);

        //generate the board
        GridPane inner_grid = new GridPane();

        for (int row = 0; row < game.get_row_size(); row++) {
            for (int column = 0; column < game.get_column_size(); column++) {
                Rectangle tile = new Rectangle(60, 60);
                final int final_column = column;
                final int final_row = row;
                tile.setOnMouseClicked(event -> tile_clicked(final_column, final_row));

                if ((row + column) % 2 == 0) {
                    tile.setFill(Color.WHITE);
                    tile.setStroke(Color.WHITE);
                    tile.setStrokeWidth(5);
                } else {
                    tile.setFill(Color.BLACK);
                    tile.setStroke(Color.BLACK);
                    tile.setStrokeWidth(5);
                }
                game.bind(tile, column, row);
                inner_grid.add(tile, column, row);
            }
        }//end outer for loop

        try{
        game.display_pieces();
        } catch (Exception e){
            System.out.println(e.toString());
        }
        //format inner_grid
        inner_grid.setStyle("-fx-grid-lines-visible: true");

        //add inner_grid object containing board to the outer_grid
        outer_grid.add(inner_grid, 1, 0);
        
        
        ScrollPane scroll_content = new ScrollPane();
        scroll_content.setContent(outer_grid);
        scroll_content.setStyle("-fx-background:#FAF0E6;");

        return scroll_content;
    }//end create_content()
    
    private void tile_clicked(int column, int row){
        game.select(column, row);
        game_info.setText(game.get_game_info_text());
    }

    //regenerates the scene content and displays the new scene
    private void refresh_scene() {
        ScrollPane scroll_content = create_content();

        Scene current_scene = primary_stage.getScene();
        current_scene.setRoot(scroll_content);

    }//end refresh_scene()

    //override the close button behavior
    @Override
    public void stop() {
        game.serializeObject();
        System.exit(0);

    }//end stop()

    //clears the board and starts a new game
    private void new_game_button_clicked() {
        game.standardize_board_size();
        refresh_scene();

    }//end new_game_button_clicked()

    //clears the board and starts a new pothole game
    private void new_game_pothole_button_clicked() {
        game.randomize_board_size();
        refresh_scene();
    }//end new_game_pothole_button_clicked()

    //resets the application layer object
    private void reset_button_clicked() {
        game.reset_board();
        refresh_scene();
    }//end reset_button_clicked()

    private void apocalypse_mode_button_clicked() {
        game.apocalypse_board_size();
        refresh_scene();
    }

}//end class PotholeChess_PresentationLayer
