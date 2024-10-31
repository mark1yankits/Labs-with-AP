

import Command.CruiseCommand;
import Cruise.CruiseTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class CruiseCommandTest {
    private CruiseTour mockCruiseTour;
    private CruiseCommand cruiseCommand;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of CruiseTour
        mockCruiseTour = Mockito.mock(CruiseTour.class);
        // Initialize CruiseCommand with the mocked CruiseTour
        cruiseCommand = new CruiseCommand(mockCruiseTour);
    }

    @Test
    public void testExecute() {
        // Call execute() on CruiseCommand
        cruiseCommand.execute();

        // Verify that inputDetails() was called on the mocked CruiseTour
        verify(mockCruiseTour).inputDetails();
    }
}
