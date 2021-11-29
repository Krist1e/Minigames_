package com.minigames;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;


public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ReturnButton;

    @FXML
    private Button SoundButton;

    @FXML
    public void ReturnClick(ActionEvent event) {

    }

    @FXML
    public void SoundClick(ActionEvent event) {

    }

    public static Boolean OnOffSound = false;

    public static Boolean SettingMenu = false;

    @FXML
    public void initialize() {
        ReturnButton.setOnAction(event -> {
            ReturnButton.getScene().getWindow().hide();
            SettingMenu = true;
            MainMenuController.SceneControl();
        });

        SoundButton.setOnAction(event -> {
            AudioClip Music;
            Music = new AudioClip(new File("src/main/resources/com/minigames/soundtrack1.mp3").toURI().toString());
            if (!OnOffSound) {
                Music.play();
                OnOffSound = true;
            }
            else {
                Music.stop();
                OnOffSound = false;
            }

        });
    }
}


