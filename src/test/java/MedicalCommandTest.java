
import Command.MedicalCommand;
import Medical.MedicalTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class MedicalCommandTest {
    private MedicalTour mockMedicalTour;
    private MedicalCommand medicalCommand;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of MedicalTour
        mockMedicalTour = Mockito.mock(MedicalTour.class);
        // Initialize MedicalCommand with the mocked MedicalTour
        medicalCommand = new MedicalCommand(mockMedicalTour);
    }

    @Test
    public void testExecute() {
        // Call execute() on MedicalCommand
        medicalCommand.execute();

        // Verify that inputDetails() was called on the mocked MedicalTour
        verify(mockMedicalTour).inputDetails();
    }
}
