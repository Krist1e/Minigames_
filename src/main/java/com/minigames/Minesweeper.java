package com.minigames;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Minesweeper extends Application {

        private static final int tileSize = 100;
        private static final int length = 1100;
        private static final int height = 700;

        private static final int xTiles = length / tileSize;
        private static final int yTiles = height / tileSize;

        private Tile[][] grid = new Tile[xTiles][yTiles];
        private Scene scene;

        private Parent generateField() {
            Pane root = new Pane();
            root.setPrefSize(length, height);

            for (int y = 0; y < yTiles; y++) {
                for (int x = 0; x < xTiles; x++) {
                    Tile tile = new Tile(x, y, Math.random() < 0.2);

                    grid[x][y] = tile;
                    root.getChildren().add(tile);
                }
            }

            for (int y = 0; y < yTiles; y++) {
                for (int x = 0; x < xTiles; x++) {
                    Tile tile = grid[x][y];

                    if (tile.hasBomb)
                        continue;

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

            private Rectangle border = new Rectangle(tileSize - 2, tileSize - 2);
            private Text text = new Text();

            public Tile(int x, int y, boolean hasBomb) {
                this.x = x;
                this.y = y;
                this.hasBomb = hasBomb;

                border.setStroke(Color.LIGHTGRAY);

                text.setFont(Font.font(18));
                text.setText(hasBomb ? "X" : "");
                text.setVisible(false);

                getChildren().addAll(border, text);

                setTranslateX(x * tileSize);
                setTranslateY(y * tileSize);

                setOnMouseClicked(e -> open());
            }

            public void open() {
                if (isOpen)
                    return;

                if (hasBomb) {
                    System.out.println("Game Over");
                    scene.setRoot(generateField());
                    return;
                }

                isOpen = true;
                text.setVisible(true);
                border.setFill(null);

                if (text.getText().isEmpty()) {
                    getNeighbors(this).forEach(Tile::open);
                }
            }
        }

        @Override
        public void start(Stage stage) {
            scene = new Scene(generateField());
            stage.setScene(scene);
            stage.show();
        }
}
