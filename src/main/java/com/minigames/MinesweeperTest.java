package com.minigames;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class MinesweeperTest {

    private Minesweeper minesweeperUnderTest;

    @Before
    public void setUp() {
        minesweeperUnderTest = new Minesweeper();
        minesweeperUnderTest.flag = mock(Image.class);
    }

    @Test
    public void testStart() {
        // Setup
        final Stage stage = new Stage(StageStyle.DECORATED);

        // Run the test
        minesweeperUnderTest.start(stage);

        // Verify the results
    }
}
