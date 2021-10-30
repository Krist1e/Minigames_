package com.minigames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

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
    public void MinesweeperClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = FXMLLoader.load(getClass().getResource("MinesweeperChooseDifficulty.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SettingsClick(ActionEvent event) {

    }

    @FXML
    void TicTacToeClick(ActionEvent event) {

    }
}


