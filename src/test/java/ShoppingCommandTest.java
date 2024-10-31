
import Command.ShoppingCommand;
import Shopping.ShoppingTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

public class ShoppingCommandTest {
    private ShoppingTour mockShoppingTour;
    private ShoppingCommand shoppingCommand;

    @BeforeEach
    public void setUp() {
        // Create a mock instance of ShoppingTour
        mockShoppingTour = Mockito.mock(ShoppingTour.class);
        // Initialize ShoppingCommand with the mocked ShoppingTour
        shoppingCommand = new ShoppingCommand(mockShoppingTour);
    }

    @Test
    public void testExecute() {
        // Call execute() on ShoppingCommand
        shoppingCommand.execute();

        // Verify that shoppingDetails() was called on the mocked ShoppingTour
        verify(mockShoppingTour).shoppingDetails();
    }
}
