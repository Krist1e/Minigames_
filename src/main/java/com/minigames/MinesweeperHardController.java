package com.minigames;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import java.net.URL;
import java.util.ResourceBundle;

public class MinesweeperHardController implements Initializable {


    @FXML
    private TilePane tilePane;

    Button[] AllTiles;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AllTiles = new Button[352];
        for (int i = 0; i<352; i++) {
            Button tile = new Button();
            tile.setLayoutX(122+i*100);
            tile.setLayoutY(64);
            tile.setPrefSize(48,42);
            tile.setText(String.valueOf(i));
            tilePane.getChildren().add(tile);
            AllTiles[i] = tile;
        }
        for (int b = 1; b<72; b++) {
            int random = (int )(Math.random()*352);
            AllTiles[random].setText("X");

        }
    }
}
