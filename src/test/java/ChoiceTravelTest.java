import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import Command.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class ChoiceTravelTest {
    private ChoiceTravel choiceTravel;
    private RestCommand restCommandMock;
    private ExcursionCommand excursionCommandMock;
    private MedicalCommand medicalCommandMock;
    private ShoppingCommand shoppingCommandMock;
    private CruiseCommand cruiseCommandMock;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        // Mock each command
        restCommandMock = mock(RestCommand.class);
        excursionCommandMock = mock(ExcursionCommand.class);
        medicalCommandMock = mock(MedicalCommand.class);
        shoppingCommandMock = mock(ShoppingCommand.class);
        cruiseCommandMock = mock(CruiseCommand.class);

        // Initialize ChoiceTravel with mocked commands
        choiceTravel = new ChoiceTravel(restCommandMock, excursionCommandMock,
                medicalCommandMock, shoppingCommandMock, cruiseCommandMock);

        // Capture output to verify messages
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        // Reset System.out to original
        System.setOut(standardOut);
    }

    @Test
    void testExecuteRest() {
        choiceTravel.executeRest();
        verify(restCommandMock, times(1)).execute();
    }

    @Test
    void testExecuteExcursion() {
        choiceTravel.executeExcursion();
        verify(excursionCommandMock, times(1)).execute();
    }

    @Test
    void testExecuteMedical() {
        choiceTravel.executeMedical(new Scanner(System.in)); // Scanner passed as per original design
        verify(medicalCommandMock, times(1)).execute();
    }

    @Test
    void testExecuteShopping() {
        choiceTravel.executeShopping();
        verify(shoppingCommandMock, times(1)).execute();
    }

    @Test
    void testExecuteCruise() {
        choiceTravel.executeCruise();
        verify(cruiseCommandMock, times(1)).execute();
    }

    @Test
    void testShowMenuRestOption() {
        // Simulate input: 1 (Rest) then 6 (Exit)
        String simulatedInput = "1\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Verify RestCommand execute() is called once
        verify(restCommandMock, times(1)).execute();

        // Check output to verify correct menu options and exit message
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1. Rest"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testShowMenuExcursionOption() {
        // Simulate input: 2 (Excursion) then 6 (Exit)
        String simulatedInput = "2\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Verify ExcursionCommand execute() is called once
        verify(excursionCommandMock, times(1)).execute();

        // Check output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("2. Excursion"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testShowMenuMedicalOption() {
        // Simulate input: 3 (Treatment) then 6 (Exit)
        String simulatedInput = "3\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Verify MedicalCommand execute() is called once
        verify(medicalCommandMock, times(1)).execute();

        // Check output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("3. Treatment"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testShowMenuShoppingOption() {
        // Simulate input: 4 (Shopping) then 6 (Exit)
        String simulatedInput = "4\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Verify ShoppingCommand execute() is called once
        verify(shoppingCommandMock, times(1)).execute();

        // Check output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("4. Shopping"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testShowMenuCruiseOption() {
        // Simulate input: 5 (Cruise) then 6 (Exit)
        String simulatedInput = "5\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Verify CruiseCommand execute() is called once
        verify(cruiseCommandMock, times(1)).execute();

        // Check output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("5. Cruise"));
        assertTrue(output.contains("Exiting program..."));
    }

    @Test
    void testShowMenuInvalidOption() {
        // Simulate input: 7 (Invalid) then 6 (Exit)
        String simulatedInput = "7\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        choiceTravel.showMenu();

        // Check that no command execute() methods were called
        verifyNoInteractions(restCommandMock, excursionCommandMock, medicalCommandMock,
                shoppingCommandMock, cruiseCommandMock);

        // Check output
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Invalid choice. Please select again."));
        assertTrue(output.contains("Exiting program..."));
    }
}
