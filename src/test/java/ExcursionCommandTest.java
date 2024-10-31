

import Command.ExcursionCommand;
import Excursion.ExcursionTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class ExcursionCommandTest {
    private ExcursionTour mockExcursionTour;
    private ExcursionCommand excursionCommand;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of ExcursionTour
        mockExcursionTour = Mockito.mock(ExcursionTour.class);
        // Initialize ExcursionCommand with the mocked ExcursionTour
        excursionCommand = new ExcursionCommand(mockExcursionTour);
    }

    @Test
    public void testExecute() {
        // Call execute() on ExcursionCommand
        excursionCommand.execute();

        // Verify that excursionDetails() was called on the mocked ExcursionTour
        verify(mockExcursionTour).excursionDetails();
    }
}
