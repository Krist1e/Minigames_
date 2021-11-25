package com.minigames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TicTacToe implements Initializable {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text winnerText;

    public static Boolean TicMenu = false;

    private int playerTurn = 0;

    private int Turn = 0;

    public ArrayList<Button> buttons;

    public ImageView X = new ImageView(getClass().getResource("xicon.png").toExternalForm());
    public ImageView O = new ImageView(getClass().getResource("oicon.png").toExternalForm());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    public void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
        playerTurn = 0;
        Turn = 0;
    }

    @FXML
    public void ReturnToMenu(ActionEvent event) {
        button1.getScene().getWindow().hide();
        TicMenu = true;
        MainMenuController.SceneControl();
    }

    public void resetButton(Button button){
        button.setDisable(false);
        button.setGraphic(null);
    }

    public void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            Turn++;
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button){
        if(playerTurn % 2 == 0) {
            button.setGraphic(X);
            playerTurn = 1;
        } else {
            button.setGraphic(O);
            playerTurn = 0;
        }
    }

    public void checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line;
            switch (a) {
                case 0:
                    line = new StringBuilder().append(button1.getGraphic()).append(button2.getGraphic()).append(button3.getGraphic()).toString();
                    break;
                case 1:
                    line = new StringBuilder().append(button4.getGraphic()).append(button5.getGraphic()).append(button6.getGraphic()).toString();
                    break;
                case 2:
                    line = new StringBuilder().append(button7.getGraphic()).append(button8.getGraphic()).append(button9.getGraphic()).toString();
                    break;
                case 3:
                    line = new StringBuilder().append(button1.getGraphic()).append(button5.getGraphic()).append(button9.getGraphic()).toString();
                    break;
                case 4:
                    line = new StringBuilder().append(button3.getGraphic()).append(button5.getGraphic()).append(button7.getGraphic()).toString();
                    break;
                case 5:
                    line = new StringBuilder().append(button1.getGraphic()).append(button4.getGraphic()).append(button7.getGraphic()).toString();
                    break;
                case 6:
                    line = new StringBuilder().append(button2.getGraphic()).append(button5.getGraphic()).append(button8.getGraphic()).toString();
                    break;
                case 7:
                    line = new StringBuilder().append(button3.getGraphic()).append(button6.getGraphic()).append(button9.getGraphic()).toString();
                    break;
                default:
                    line = null;
                    break;
            }

            //First player is a winner
            if (line.equals(new StringBuilder().append(X).append(X).append(X).toString())) {
                winnerText.setText("Player 1 won!");
            }

            //Second player is a winner
            else if (line.equals(new StringBuilder().append(O).append(O).append(O).toString())) {
                winnerText.setText("Player 2 won!");

            }

            //Draw condition
            if (!line.equals(new StringBuilder().append(O).append(O).append(O).toString()) && !line.equals(new StringBuilder().append(X).append(X).append(X).toString()) && (Turn==9)) {
                     winnerText.setText("Draw!");

            }

        }

    }
}
