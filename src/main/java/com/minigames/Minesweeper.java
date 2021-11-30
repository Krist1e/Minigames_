package com.minigames;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Minesweeper extends Application {

    private static final double TileSize = 50;
    private static final double length = 1100;
    private static final double height = 700;

    private static double xTiles = length / TileSize;
    private static double yTiles = height / TileSize;

    private final Tile[][] grid = new Tile[(int) xTiles][(int) yTiles];
    private Scene scene;
    static int flagCounter = 0;
    public int allBombs = 0;
    public int winReq = 0;
    static Stage classStage = new Stage();
    private final Rectangle rootRectangle= new Rectangle();
    private final Label endText = new Label();
    private final Label bombCounter = new Label();
    private final Rectangle topFlag = new Rectangle(40, 40);
    private final Rectangle endRectangle = new Rectangle();
    private final Button diffReturn = new Button();
    private final Button restartGame = new Button();
    public static Boolean mineSweepDiff2 = false;
    public Boolean youWin = false;
    public Boolean firstTurn = true;
    public static final Image flag = new Image(String.valueOf(Minesweeper.class.getResource("flag.jpg")));

    public Parent generateField() {
        Pane root = new Pane();
        if (MinesweeperDifficultyController.EasyDiff) {
            xTiles = (length-600)/TileSize;
            yTiles = (height-400)/TileSize;
            root.setPrefSize(length-600, height-350);
            rootRectangle.setWidth(length-600);
            rootRectangle.setHeight(height-350);
            topFlag.setTranslateX(length-700);
            bombCounter.setTranslateX(length-742);
            endRectangle.setWidth(length-600);
            endRectangle.setHeight(height-500);
            endRectangle.setTranslateY(75);
            restartGame.setTranslateX(150);
            restartGame.setTranslateY(290);
            endText.setFont(Font.font(80));
            endText.setTranslateY(110);
            endText.setTranslateX(65);
        }

        else if (MinesweeperDifficultyController.MediumDiff) {
            xTiles = (length-300)/TileSize;
            yTiles = (height-150)/TileSize;
            root.setPrefSize(length-300, height-100);
            rootRectangle.setWidth(length-300);
            rootRectangle.setHeight(height-100);
            endRectangle.setWidth(length-300);
            endRectangle.setHeight(height-400);
            endRectangle.setTranslateY((height-100)/4);
            topFlag.setTranslateX(length-400);
            endText.setFont(Font.font(120));
            restartGame.setTranslateX((length-200)/3);
            restartGame.setTranslateY(height-160);
            endText.setTranslateY(200);
            endText.setTranslateX(115);
            bombCounter.setTranslateX(length-442);
        }

        else {
            root.setPrefSize(length, height + 50);
            rootRectangle.setWidth(length);
            rootRectangle.setHeight(height+50);
            topFlag.setTranslateX(length-120);
            bombCounter.setTranslateX(length-162);
            endRectangle.setWidth(length);
            endRectangle.setHeight(height-300);
            endRectangle.setTranslateY(height/4);
            restartGame.setTranslateX(length/2-100);
            restartGame.setTranslateY(height-15);
            endText.setFont(Font.font(160));
            endText.setTranslateY(250);
            endText.setTranslateX(170);
        }

        root.setStyle("-fx-background-color: INDIANRED");
        rootRectangle.setFill(Color.SEAGREEN);
        rootRectangle.setVisible(false);

        diffReturn.setText("Return");
        diffReturn.setFont(Font.font(20));
        diffReturn.setTranslateX(2);
        diffReturn.setTranslateY(2.5);
        diffReturn.setPrefSize(130, 30);
        diffReturn.setStyle("-fx-background-color: DARKSALMON");
        diffReturn.setOnMouseClicked(event -> {
            flagCounter = 0;
            diffReturn.getScene().getWindow().hide();
            mineSweepDiff2 = true;
            MinesweeperDifficultyController.EasyDiff = false;
            MinesweeperDifficultyController.MediumDiff = false;
            xTiles = length / TileSize;
            yTiles = height / TileSize;
            MainMenuController.SceneControl();

        });

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2 );

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }



        topFlag.setFill(new ImagePattern(flag));
        topFlag.setTranslateY(5);


        bombCounter.setFont(Font.font(25));
        bombCounter.setTranslateY(5);
        bombCounter.setVisible(false);

        restartGame.setPrefSize(200, 35);
        restartGame.setText("Restart");
        restartGame.setFont(Font.font(22));
        restartGame.setStyle("-fx-background-color: DARKSALMON");
        restartGame.setVisible(false);
        restartGame.setDisable(false);
        restartGame.setOnMouseClicked(event -> {
            youWin = false;
            allBombs = 0;
            flagCounter = 0;
            winReq = 0;
            bombCounter.setVisible(true);
            topFlag.setVisible(true);
            firstTurn = true;
            scene.setRoot(generateField());
        });

        endRectangle.setFill(Color.SALMON);
        endRectangle.setVisible(false);
        endText.setVisible(false);

        root.getChildren().addAll(rootRectangle,topFlag, bombCounter, diffReturn, restartGame, endRectangle, endText);
        return root;
    }

    private void AddingBombs() {
        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb) {
                    allBombs++;
                    continue;
                }

                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (bombs > 0)
                    tile.text.setText(String.valueOf(bombs));
            }
        }
        bombCounter.setText(String.valueOf(allBombs));
    }

    private List<Tile> getNeighbors(Tile tile) {
        List<Tile> neighbors = new ArrayList<>();

        // ttt
        // tXt
        // ttt

        int[] points = new int[] {
                -1, -1,
                -1, 0,
                -1, 1,
                0, -1,
                0, 1,
                1, -1,
                1, 0,
                1, 1
        };

        for (int i = 0; i < points.length; i++) {
            int dx = points[i];
            int dy = points[++i];

            int newX = tile.x + dx;
            int newY = tile.y + dy;

            if (newX >= 0 && newX < xTiles
                    && newY >= 0 && newY < yTiles) {
                neighbors.add(grid[newX][newY]);
            }
        }

        return neighbors;
    }

    private class Tile extends StackPane {
        private final int x, y;
        private boolean hasBomb;
        private boolean isOpen = false;


        private final Rectangle border = new Rectangle(TileSize - 2, TileSize - 2);
        private final Text text = new Text();

        public Tile(int x, int y, boolean hasBomb) {
            this.x = x;
            this.y = y;
            this.hasBomb = hasBomb;

            border.setStroke(Color.BLACK);
            border.setFill(Color.LIGHTGRAY);


            text.setFont(Font.font(18));
            text.setText(hasBomb ? "X" : "");
            text.setVisible(false);

            getChildren().addAll(border, text);

            setTranslateX(x * TileSize);
            setTranslateY(y * TileSize + 50);

            setOnMouseClicked(e -> {
                if(e.getButton() == MouseButton.SECONDARY){
                    Paint Flag =border.getFill();
                    if (Flag == Color.LIGHTGRAY) {
                        border.setFill(new ImagePattern(flag));
                        flagCounter++;
                    }

                    else if (Flag != Color.DARKSALMON) {
                        border.setFill(Color.LIGHTGRAY);
                        flagCounter--;
                    }
                    bombCounter.setText(String.valueOf(allBombs-flagCounter));
                }
                else
                    open();
            });
        }

        public void open() {
            if (firstTurn) {
                hasBomb=false;
                text.setText("");
                getNeighbors(this).forEach(Tile::SecureOpen);
                AddingBombs();
                bombCounter.setVisible(true);
                firstTurn=false;
            }

            else if (isOpen) {
                return;
            }

            else if (hasBomb) {
                EndGame();
                return;
            }


            isOpen = true;
            text.setVisible(true);
            border.setFill(Color.DARKSALMON);
            winReq++;
            CheckIfWin();

            if (text.getText().isEmpty()) {
                getNeighbors(this).forEach(Tile::open);
            }
        }

        public void SecureOpen() {
            String BombCheck = text.getText();
            if (BombCheck.equals("X")) {
                hasBomb= false;
                text.setText("");
            }


        }


        private void CheckIfWin() {
            if (winReq == xTiles*yTiles-allBombs) {
                youWin = true;
                EndGame();
            }
        }

        private void EndGame() {
            for (int y = 0; y < yTiles; y++) {
                for (int x = 0; x < xTiles; x++) {
                    Tile tile = grid[x][y];
                    tile.setVisible(false);
                    tile.setDisable(true);
                }
            }
            bombCounter.setVisible(false);
            topFlag.setVisible(false);
            restartGame.setDisable(false);
            restartGame.setVisible(true);
            endRectangle.setVisible(true);
            endText.setVisible(true);
            if (youWin) {
                endText.setText("YOU WIN!");
                endRectangle.setFill(Color.MEDIUMSEAGREEN);
                restartGame.setStyle("-fx-background-color: LIGHTGREEN");
                diffReturn.setStyle("-fx-background-color: LIGHTGREEN");
                rootRectangle.setVisible(true);
            }
            else
                endText.setText("YOU LOSE");
        }
    }

    @Override
    public void start(Stage stage) {
        classStage = stage;
        scene = new Scene(generateField());
        stage.setScene(scene);
        stage.show();
    }
}

