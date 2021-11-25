package com.minigames;

import javafx.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;

public class MainMenuControllerTest {

    private MainMenuController mainMenuControllerUnderTest;

    @Before
    public void setUp() {
        mainMenuControllerUnderTest = new MainMenuController();
    }

    @Test
    public void testInitialize() {
        // Setup

        // Run the test
        mainMenuControllerUnderTest.initialize();

        // Verify the results
    }

    @Test
    public void testMinesweeperClick() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        mainMenuControllerUnderTest.MinesweeperClick(event);

        // Verify the results
    }

    @Test
    public void testSettingsClick() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        mainMenuControllerUnderTest.SettingsClick(event);

        // Verify the results
    }

    @Test
    public void testTicTacToeClick() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        mainMenuControllerUnderTest.TicTacToeClick(event);

        // Verify the results
    }

    @Test
    public void testSceneControl() {
        // Setup

        // Run the test
        MainMenuController.SceneControl();

        // Verify the results
    }
}
