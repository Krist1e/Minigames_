package com.minigames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerDiff {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DifficultyEasyButton;

    @FXML
    private Button DifficultyNormalButton;

    @FXML
    private Button DifficultyHardButton;

    @FXML
    void DifficultyEasyClick(ActionEvent event) {
    }

    @FXML
    void DifficultyNormalClick(ActionEvent event) {
    }

    @FXML
    void DifficultyHardClick(ActionEvent event) {
    }

    @FXML
    void initialize() {
        DifficultyEasyButton.setOnAction(event -> {
            DifficultyEasyButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MineSweeperLayout.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        DifficultyNormalButton.setOnAction(event -> {
            DifficultyNormalButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MineSweeperLayout.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        DifficultyHardButton.setOnAction(event -> {
            DifficultyHardButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("MineSweeperLayout.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });


    }

}
