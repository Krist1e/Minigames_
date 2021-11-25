package Tests;

import com.minigames.SettingsController;
import javafx.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;

public class SettingsControllerTest {

    private SettingsController settingsControllerUnderTest;

    @Before
    public void setUp() {
        settingsControllerUnderTest = new SettingsController();
    }

    @Test
    public void testInitialize() {
        // Setup

        // Run the test
        settingsControllerUnderTest.initialize();

        // Verify the results
    }

    @Test
    public void testReturnClick() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        settingsControllerUnderTest.ReturnClick(event);

        // Verify the results
    }

    @Test
    public void testSoundClick() {
        // Setup
        final ActionEvent event = new ActionEvent("o", null);

        // Run the test
        settingsControllerUnderTest.SoundClick(event);

        // Verify the results
    }
}
