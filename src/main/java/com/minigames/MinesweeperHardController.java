package com.minigames;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;

public class MinesweeperHardController implements Initializable {


    @FXML
    private TilePane tilePane;

    Button[][] AllTiles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AllTiles = new Button[24][18];
        for (int y = 0; y < 18; y++) {
            for (int x = 0; x < 24; x++) {
                Button tile = new Button();
                tile.setLayoutX(74 + x * 100);
                tile.setLayoutY(64);
                tile.setPrefSize(48, 42);
                tile.setText("");
                tilePane.getChildren().add(tile);
                AllTiles[x][y] = tile;
            }

        }

        SecureRandom rand = new SecureRandom();
        for (int b = 1; b < 72; b++) {
            int random1 = 1 + rand.nextInt(22), random2 = 1 + rand.nextInt(16);
            AllTiles[random1][random2].setText("X");

        }
        for (int x = 1; x < 23; x++) {
            for (int y = 1; y < 17; y++) {
                int NumberOfBombs = 0;
                String HasBomb = AllTiles[x][y].getText();
                if (HasBomb.equals("")) {
                    String AroundBombs;

                    AroundBombs = AllTiles[x + 1][y].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x+1][y+1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x][y + 1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x - 1][y + 1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x - 1][y].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x - 1][y - 1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x][y - 1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AroundBombs = AllTiles[x + 1][y - 1].getText();
                    if (AroundBombs.equals("X")) {
                        NumberOfBombs++;
                    }

                    AllTiles[x][y].setText(String.valueOf(NumberOfBombs));
                }
            }
        }
        for (int y = 0; y < 18; y++) {
            for (int x = 0; x < 24; x++) {
                String UnNessButton = AllTiles[x][y].getText();
                if (UnNessButton.equals("")) {
                    AllTiles[x][y].setVisible(false);
                }

                if (UnNessButton.equals("0")) {
                    AllTiles[x][y].setText(" ");
                }
            }
        }
    }
}