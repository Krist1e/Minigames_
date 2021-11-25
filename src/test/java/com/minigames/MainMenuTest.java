package com.minigames;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertThrows;

public class MainMenuTest {

    private MainMenu mainMenuUnderTest;

    @Before
    public void setUp() {
        mainMenuUnderTest = new MainMenu();
    }

    @Test
    public void testStart() throws Exception {
        // Setup
        final Stage stage = new Stage(StageStyle.DECORATED);

        // Run the test
        mainMenuUnderTest.start(stage);

        // Verify the results
    }

    @Test
    public void testStart_ThrowsIOException() {
        // Setup
        final Stage stage = new Stage(StageStyle.DECORATED);

        // Run the test
        assertThrows(IOException.class, () -> mainMenuUnderTest.start(stage));
    }

    @Test
    public void testStop() {
        // Setup

        // Run the test
        mainMenuUnderTest.stop();

        // Verify the results
    }
}
