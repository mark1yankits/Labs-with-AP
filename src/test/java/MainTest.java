import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor)); // Capture system output
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut); // Reset standard output
    }

    @Test
    void testMainChoiceOfTravel() {
        String simulatedUserInput = "1\n2\n"; // Simulate user choosing "1" then "2" to exit
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        ChoiceTravel travelMock = mock(ChoiceTravel.class);

        // Run main method
        Main.main(new String[]{});

        // Check that "showMenu" on ChoiceTravel was called once
        verify(travelMock, times(1)).showMenu();

        // Verify output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1. Choice of travel"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testMainInvalidChoice() {
        String simulatedUserInput = "3\n2\n"; // Simulate invalid choice "3", then "2" to exit
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        // Run main method
        Main.main(new String[]{});

        // Verify output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid choice. Please select again."));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testMainExitOption() {
        String simulatedUserInput = "2\n"; // Simulate user choosing "2" to exit
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        // Run main method
        Main.main(new String[]{});

        // Verify output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Exiting program..."));
    }
}
