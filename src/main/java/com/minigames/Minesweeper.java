package com.minigames;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private static final int tileSize = 50;
    private static final int length = 1100;
    private static final int height = 700;

    private static int xTiles = length / tileSize;
    private static int yTiles = height / tileSize;

    private Tile[][] grid = new Tile[xTiles][yTiles];
    private Scene scene;
    public int AllBombs = 0;
    public int WinReq = 0;
    static Stage classStage = new Stage();

    private Parent generateField() {
        Pane root = new Pane();

        if (MinesweeperDifficultyController.EasyDiff) {
            root.setPrefSize(length-600, height-350);
            xTiles = (length-600)/tileSize;
            yTiles = (height-400)/tileSize;
        }

        else if (MinesweeperDifficultyController.MediumDiff) {
            root.setPrefSize(length-300, height-100);
            xTiles = (length-300)/tileSize;
            yTiles = (height-150)/tileSize;
        }

        else
            root.setPrefSize(length, height+50);

        root.setStyle("-fx-background-color: INDIANRED");

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = new Tile(x, y, Math.random() < 0.2 );

                grid[x][y] = tile;
                root.getChildren().add(tile);
            }
        }

        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                Tile tile = grid[x][y];

                if (tile.hasBomb) {
                    AllBombs++;
                    continue;
                }

                long bombs = getNeighbors(tile).stream().filter(t -> t.hasBomb).count();

                if (bombs > 0)
                    tile.text.setText(String.valueOf(bombs));
            }
        }

        return root;
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
        private int x, y;
        private boolean hasBomb;
        private boolean isOpen = false;
        Image flag = new Image(getClass().getResource("flag.jpg").toExternalForm());

        private Rectangle border = new Rectangle(tileSize - 2, tileSize - 2);
        private Text text = new Text();

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

            setTranslateX(x * tileSize);
            setTranslateY(y * tileSize + 50);

            setOnMouseClicked(e -> {
                if(e.getButton() == MouseButton.SECONDARY){
                    Paint Flag =border.getFill();
                    if (Flag == Color.LIGHTGRAY)
                        border.setFill(new ImagePattern(flag));

                    else if (Flag != Color.DARKSALMON)
                        border.setFill(Color.LIGHTGRAY);

                }
                else
                    open();
            });
        }

        public void open() {
            if (isOpen) {
                return;
            }

            if (hasBomb) {
                AllBombs = 0;
                WinReq = 0;
                System.out.println("Game Over");
                scene.setRoot(generateField());
                return;
            }


            isOpen = true;
            text.setVisible(true);
            border.setFill(Color.DARKSALMON);
            WinReq++;
            CheckIfWin();

            if (text.getText().isEmpty()) {
                getNeighbors(this).forEach(Tile::open);
            }
        }

        private void CheckIfWin() {
            if (WinReq == xTiles*yTiles-AllBombs) {
                AllBombs = 0;
                WinReq = 0;
                System.out.println("You're a Winner!");
                scene.setRoot(generateField());
            }
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
