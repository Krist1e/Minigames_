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


public class MainMenuController {

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

    static Boolean settings = false;

    static Boolean mineSweepDiff1 = false;

    public static Boolean ticTac = false;

    @FXML
    public void minesweeperClick(ActionEvent event) {
        // Click on Minesweeper 
    }

    @FXML
    public void settingsClick(ActionEvent event) {
        // Click on Settings 
    }

    @FXML
    public void ticTacToeClick(ActionEvent event) {
        // Click on Tic-Tac-Toe 
    }


    @FXML
    public void initialize() {
        ChooseSettingsButton.setOnAction(event -> {
            ChooseSettingsButton.getScene().getWindow().hide();
            settings = true;
            SceneControl();
        });

        MinesweeperStartButton.setOnAction(event -> {
            MinesweeperStartButton.getScene().getWindow().hide();
            mineSweepDiff1 = true;
            SceneControl();
        });


        TicTacToeStartButton.setOnAction(event -> {
            TicTacToeStartButton.getScene().getWindow().hide();
            ticTac = true;
            SceneControl();
        });
    }

    public static void SceneControl() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        if (ticTac)
            fxmlLoader.setLocation(MainMenuController.class.getResource("TicTacToeLayout.fxml"));
        if (mineSweepDiff1)
            fxmlLoader.setLocation(MainMenuController.class.getResource("MinesweeperDifficultyLayout.fxml"));
        if (settings)
            fxmlLoader.setLocation(MainMenuController.class.getResource("SettingsLayout.fxml"));
        if (Minesweeper.mineSweepDiff2)
            fxmlLoader.setLocation(Minesweeper.class.getResource("MinesweeperDifficultyLayout.fxml"));
        if (MinesweeperDifficultyController.Menu)
            fxmlLoader.setLocation(MinesweeperDifficultyController.class.getResource("SceneLayout.fxml"));
        if (TicTacToe.TicMenu)
            fxmlLoader.setLocation(TicTacToe.class.getResource("SceneLayout.fxml"));
        if (SettingsController.SettingMenu)
            fxmlLoader.setLocation(SettingsController.class.getResource("SceneLayout.fxml"));

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

        ticTac = false;
        mineSweepDiff1 = false;
        settings = false;
        Minesweeper.mineSweepDiff2 = false;
        MinesweeperDifficultyController.Menu = false;
        TicTacToe.TicMenu = false;
        SettingsController.SettingMenu = false;
    }
}


