
import Command.RestCommand;
import Rest.RestTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class RestCommandTest {
    private RestTour mockRestTour;
    private RestCommand restCommand;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of RestTour
        mockRestTour = Mockito.mock(RestTour.class);
        // Initialize RestCommand with the mocked RestTour
        restCommand = new RestCommand(mockRestTour);
    }

    @Test
    public void testExecute() {
        // Call execute() on RestCommand
        restCommand.execute();

        // Verify that inputDetails() was called on the mocked RestTour
        verify(mockRestTour).inputDetails();
    }
}
