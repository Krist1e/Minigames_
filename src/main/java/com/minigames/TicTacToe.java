package com.minigames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
                    line = String.valueOf(button1.getGraphic()) + button2.getGraphic() + button3.getGraphic();
                    break;
                case 1:
                    line = String.valueOf(button4.getGraphic()) + button5.getGraphic() + button6.getGraphic();
                    break;
                case 2:
                    line = String.valueOf(button7.getGraphic()) + button8.getGraphic() + button9.getGraphic();
                    break;
                case 3:
                    line = String.valueOf(button1.getGraphic()) + button5.getGraphic() + button9.getGraphic();
                    break;
                case 4:
                    line = String.valueOf(button3.getGraphic()) + button5.getGraphic() + button7.getGraphic();
                    break;
                case 5:
                    line = String.valueOf(button1.getGraphic()) + button4.getGraphic() + button7.getGraphic();
                    break;
                case 6:
                    line = String.valueOf(button2.getGraphic()) + button5.getGraphic() + button8.getGraphic();
                    break;
                case 7:
                    line = String.valueOf(button3.getGraphic()) + button6.getGraphic() + button9.getGraphic();
                    break;
                default:
                    line = null;
                    break;
            }

            //First player is a winner
            if (line.equals(String.valueOf(X) + X + X)) {
                winnerText.setText("Player 1 won!");
                buttons.forEach(this::disableButton);
            }

            //Second player is a winner
            else if (line.equals(String.valueOf(O) + O + O)) {
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
