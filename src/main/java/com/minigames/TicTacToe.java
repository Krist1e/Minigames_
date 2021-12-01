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

/**
 * contains methods for game TicTacToe
 */
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

    public static Boolean DrawReq = true;

    private int playerTurn = 0;

    private int Turn = 0;

    public ArrayList<Button> buttons;

    /**
     * create array list of buttons of game field and set instructions for them
     * @param url set url
     * @param resourceBundle set resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1,button2,button3,button4,button5,button6,button7,button8,button9));

        buttons.forEach(button ->{
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    /**
     * reset all parameters of TicTacToe game
     * @param event action taking of the method restartGame
     */
    @FXML
    public void restartGame(ActionEvent event) {
        buttons.forEach(this::resetButton);
        winnerText.setText("Tic-Tac-Toe");
        playerTurn = 0;
        Turn = 0;
        DrawReq = true;
    }

    /**
     * opening MainMenu scene by calling SceneControl
     * @param event action taking of the method ReturnToMenu
     */
    @FXML
    public void ReturnToMenu(ActionEvent event) {
        button1.getScene().getWindow().hide();
        TicMenu = true;
        MainMenuController.SceneControl();
    }

    /**
     * resume buttons abilities
     * @param button common element of array list buttons
     */
    public void resetButton(Button button){
        button.setText("");
        button.setDisable(false);
        button.setGraphic(null);
    }

    /**
     * set buttons disable after taking actions
     * @param buttons all buttons of TicTacToe field
     */
    public void disableButton(Button buttons) {
        buttons.setDisable(true);
    }

    /**
     * set parameters for taking actions of the buttons
     * @param button common element of array list buttons
     */
    public void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            Turn++;
            checkIfGameIsOver();
        });
    }

    /**
     * set text into button according to the turn
     * @param button common element of array of buttons
     */
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

    /**
     * check text positions and fill, and do actions
     * according to that information
     */
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
                DrawReq = false;
                winnerText.setText("Player 1 won!");
                buttons.forEach(this::disableButton);
            }

            //Second player is a winner
            else if (line.equals("OOO")) {
                DrawReq = false;
                winnerText.setText("Player 2 won!");
                buttons.forEach(this::disableButton);
            }

            //Draw condition
            if ((DrawReq) && (Turn==9)) {
                winnerText.setText("Draw!");
                buttons.forEach(this::disableButton);
            }

        }

    }
}
