package Tests;

import com.minigames.TicTacToe;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.mockito.Mockito.mock;

public class TicTacToeTest {

    private TicTacToe ticTacToeUnderTest;

    @Before
    public void setUp() {
        ticTacToeUnderTest = new TicTacToe();
        ticTacToeUnderTest.buttons = new ArrayList<>(List.of(new Button("s")));
        ticTacToeUnderTest.X = mock(ImageView.class);
        ticTacToeUnderTest.O = mock(ImageView.class);
    }

    @Test
    public void testInitialize() throws Exception {
        // Setup
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("baseName");

        // Run the test
        ticTacToeUnderTest.initialize(new URL("https://example.com/"), resourceBundle);

        // Verify the results
    }

    @Test
    public void testResetButton() {
        // Setup
        final Button button = new Button("s");

        // Run the test
        ticTacToeUnderTest.resetButton(button);

        // Verify the results
    }

    @Test
    public void testSetupButton() {
        // Setup
        final Button button = new Button("s");

        // Run the test
        ticTacToeUnderTest.setupButton(button);

        // Verify the results
    }

    @Test
    public void testSetPlayerSymbol() {
        // Setup
        final Button button = new Button("s");

        // Run the test
        ticTacToeUnderTest.setPlayerSymbol(button);

        // Verify the results
    }

    @Test
    public void testCheckIfGameIsOver() {
        // Setup

        // Run the test
        ticTacToeUnderTest.checkIfGameIsOver();

        // Verify the results
    }

    @Test
    public void testRestartGame() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        ticTacToeUnderTest.restartGame(event);

        // Verify the results
    }

    @Test
    public void testReturnToMenu() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        ticTacToeUnderTest.ReturnToMenu(event);

        // Verify the results
    }
}
