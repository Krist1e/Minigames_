package com.minigames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SceneLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setTitle("Minigames");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public void stop() {

        System.out.println("Thank you for playing! Have a great day! ");
    }
}