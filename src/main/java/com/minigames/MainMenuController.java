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

    public static Boolean Settings = false;

    public static Boolean MineSweepDiff1 = false;

    public static Boolean TicTac = false;

    @FXML
    public void MinesweeperClick(ActionEvent event) {

    }

    @FXML
    public void SettingsClick(ActionEvent event) {

    }

    @FXML
    public void TicTacToeClick(ActionEvent event) {

    }


    @FXML
    public void initialize() {
        ChooseSettingsButton.setOnAction(event -> {
            ChooseSettingsButton.getScene().getWindow().hide();
            Settings = true;
            SceneControl();
        });

        MinesweeperStartButton.setOnAction(event -> {
            MinesweeperStartButton.getScene().getWindow().hide();
            MineSweepDiff1 = true;
            SceneControl();
        });


        TicTacToeStartButton.setOnAction(event -> {
            TicTacToeStartButton.getScene().getWindow().hide();
            TicTac = true;
            SceneControl();
        });
    }

    public static void SceneControl() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        if (TicTac)
            fxmlLoader.setLocation(MainMenuController.class.getResource("TicTacToeLayout.fxml"));
        if (MineSweepDiff1)
            fxmlLoader.setLocation(MainMenuController.class.getResource("MinesweeperDifficultyLayout.fxml"));
        if (Settings)
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

        TicTac = false;
        MineSweepDiff1 = false;
        Settings = false;
        Minesweeper.mineSweepDiff2 = false;
        MinesweeperDifficultyController.Menu = false;
        TicTacToe.TicMenu = false;
        SettingsController.SettingMenu = false;
    }
}


