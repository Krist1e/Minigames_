package com.minigames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane RootPane;

    @FXML
    private Button ChooseSettingsButton;

    @FXML
    private Button MinesweeperStartButton;

    @FXML
    private Button TicTacToeStartButton;

    @FXML
    private void MinesweeperClick(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MinesweeperChooseDifficulty.fxml"));
        RootPane.getChildren().setAll(pane);
    }

    @FXML
    void SettingsClick(ActionEvent event) {

    }

    @FXML
    void TicTacToeClick(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChooseSettingsButton.setOnAction(event -> {

        });
        MinesweeperStartButton.setOnAction(event -> {

        });
        TicTacToeStartButton.setOnAction(event -> {

        });
    }
}


