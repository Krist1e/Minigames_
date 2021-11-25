import com.minigames.MinesweeperDifficultyController;
import javafx.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;

public class MinesweeperDifficultyControllerTest {

    private MinesweeperDifficultyController minesweeperDifficultyControllerUnderTest;

    @Before
    public void setUp() {
        minesweeperDifficultyControllerUnderTest = new MinesweeperDifficultyController();
    }

    @Test
    public void testInitialize() {
        // Setup

        // Run the test
        minesweeperDifficultyControllerUnderTest.initialize();

        // Verify the results
    }

    @Test
    public void testMinesweeperChooseEasy() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        minesweeperDifficultyControllerUnderTest.MinesweeperChooseEasy(event);

        // Verify the results
    }

    @Test
    public void testMinesweeperChooseHard() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        minesweeperDifficultyControllerUnderTest.MinesweeperChooseHard(event);

        // Verify the results
    }

    @Test
    public void testMinesweeperChooseMedium() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        minesweeperDifficultyControllerUnderTest.MinesweeperChooseMedium(event);

        // Verify the results
    }

    @Test
    public void testMinesweeperReturnToMenu() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        minesweeperDifficultyControllerUnderTest.MinesweeperReturnToMenu(event);

        // Verify the results
    }
}
