package com.minigames;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

        private Stage stage;
        private Scene scene;
        private Parent root;

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
    void MinesweeperClick(ActionEvent event){

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

