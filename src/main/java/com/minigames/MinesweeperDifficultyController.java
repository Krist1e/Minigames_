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

public class MinesweeperDifficultyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MinesweeperEasy;

    @FXML
    private Button MinesweeperHard;

    @FXML
    private Button MinesweeperMedium;

    @FXML
    private Button ReturnToMainMenu;

    @FXML
    void MinesweeperChooseEasy(ActionEvent event) {

    }

    @FXML
    void MinesweeperChooseHard(ActionEvent event) {

    }

    @FXML
    void MinesweeperChooseMedium(ActionEvent event) {

    }

    @FXML
    void MinesweeperReturnToMenu(ActionEvent event) {

    }

    @FXML
    void initialize() {
        MinesweeperEasy.setOnAction(event -> {
            MinesweeperEasy.getScene().getWindow().hide();
            Minesweeper ctc = new Minesweeper();
            ctc.start(Minesweeper.classStage);


        });
        MinesweeperMedium.setOnAction(event -> {
            //Need to add boolean to change length and width of minesweeper
            MinesweeperMedium.getScene().getWindow().hide();
            Minesweeper ctc = new Minesweeper();
            ctc.start(Minesweeper.classStage);

        });
        MinesweeperHard.setOnAction(event -> {
            MinesweeperHard.getScene().getWindow().hide();
            Minesweeper ctc = new Minesweeper();
            ctc.start(Minesweeper.classStage);
        });

        ReturnToMainMenu.setOnAction(event -> {
            ReturnToMainMenu.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("SceneLayout.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        });


    }
}