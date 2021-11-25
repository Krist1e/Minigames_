package com.minigames;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SettingsController1 extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SettingsLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        String musicFile = "com/minigames/soundtrack1.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        stage.setTitle("Minigames");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
