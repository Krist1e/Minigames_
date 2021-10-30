package com.minigames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ChooseSettingsButton;

    @FXML
    private Button MinesweeperStartButton;

    @FXML
    private Button TicTacToeStartButton;

    @FXML
    void MinesweeperClick(MouseEvent event) {

    }

    @FXML
    void SettingsClick(ActionEvent event) {

    }

    @FXML
    void TicTacToeClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        ChooseSettingsButton.setOnAction(event -> {

        });
        MinesweeperStartButton.setOnAction(event -> {

        });
        TicTacToeStartButton.setOnAction(event -> {

        });
    }

}


