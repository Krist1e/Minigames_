package com.minigames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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

    public ImageView X = new ImageView(String.valueOf(getClass().getResource("xicon.png")));
    public ImageView O = new ImageView(String.valueOf(getClass().getResource("oicon.png")));

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
        button.setText("");
        button.setDisable(false);
        button.setGraphic(null);
    }

    public void disableButton(Button buttons) {
        buttons.setDisable(true);
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
            button.setText("X");
            button.setTextFill(Color.RED);
            playerTurn = 1;
        } else {
            button.setText("O");
            button.setTextFill(Color.BLUE);
            playerTurn = 0;
        }
        button.setFont(Font.font(30));
    }

    public void checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line;
            switch (a) {
                case 0:
                    line = button1.getText() + button2.getText() + button3.getText();
                    break;
                case 1:
                    line = button4.getText() + button5.getText() + button6.getText();
                    break;
                case 2:
                    line = button7.getText() + button8.getText() + button9.getText();
                    break;
                case 3:
                    line = button1.getText() + button5.getText() + button9.getText();
                    break;
                case 4:
                    line = button3.getText() + button5.getText() + button7.getText();
                    break;
                case 5:
                    line = button1.getText() + button4.getText() + button7.getText();
                    break;
                case 6:
                    line = button2.getText() + button5.getText() + button8.getText();
                    break;
                case 7:
                    line = button3.getText() + button6.getText() + button9.getText();
                    break;
                default:
                    line = null;
                    break;
            }

            //First player is a winner
            if (line.equals("XXX")) {
                winnerText.setText("Player 1 won!");
                buttons.forEach(this::disableButton);
            }

            //Second player is a winner
            else if (line.equals("OOO")) {
                winnerText.setText("Player 2 won!");
                buttons.forEach(this::disableButton);
            }

            //Draw condition
            if (!line.equals(String.valueOf(O) + O + O) && !line.equals(String.valueOf(X) + X + X) && (Turn==9)) {
                     winnerText.setText("Draw!");
                buttons.forEach(this::disableButton);
            }

        }

    }
}
