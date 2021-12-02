package com.minigames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * main class that contains starting layout
 */
public class MainMenu extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    /**
     * start primary scene
     * @param stage set functions and scene for primary stage
     * @throws IOException signals about exceptions in method
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("SceneLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 700);
        stage.setTitle("Minigames");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * set text of greetings
     */
    public void stop() {

        System.out.println("Thank you for playing! Have a great day! ");
    }
}