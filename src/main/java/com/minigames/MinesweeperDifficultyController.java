package com.minigames;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class MinesweeperDifficultyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  Button MinesweeperEasy;

    @FXML
    private Button MinesweeperHard;

    @FXML
    private Button MinesweeperMedium;

    @FXML
    private Button ReturnToMainMenu;

    public static Boolean EasyDiff  = false;

    public static Boolean MediumDiff = false;

    public static Boolean Menu = false;

    @FXML
    public void MinesweeperChooseEasy(ActionEvent event) {

    }

    @FXML
    public void MinesweeperChooseHard(ActionEvent event) {

    }

    @FXML
    public void MinesweeperChooseMedium(ActionEvent event) {

    }

    @FXML
    public void MinesweeperReturnToMenu(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        MinesweeperEasy.setOnAction(event -> {
            EasyDiff = true;
            MinesweeperEasy.getScene().getWindow().hide();
            MineApp();

        });
        MinesweeperMedium.setOnAction(event -> {
            MediumDiff = true;
            MinesweeperMedium.getScene().getWindow().hide();
            MineApp();

        });
        MinesweeperHard.setOnAction(event -> {
            MinesweeperHard.getScene().getWindow().hide();
            MineApp();
        });

        ReturnToMainMenu.setOnAction(event -> {
            ReturnToMainMenu.getScene().getWindow().hide();
            Menu = true;
            MainMenuController.SceneControl();
        });
    }

    private void MineApp() {
        Minesweeper OpenMineSweeper = new Minesweeper();
        OpenMineSweeper.start(Minesweeper.classStage);
    }
}