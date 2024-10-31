
import Shopping.ShoppingTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingTourTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testShoppingDetails_Italy() {
        // Simulate user input for Italy
        String simulatedInput = "1\n1\n1\n1\n3\n"; // Italy, Plane, Luxury, Yes, 3 days
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ShoppingTour shoppingTour = new ShoppingTour();
        shoppingTour.shoppingDetails();

        // Capture the output and verify it contains expected details
        String output = outputStreamCaptor.toString();

        // Assertions to check if the output contains expected strings
        assertTrue(output.contains("Top brands in Italy:"));
        assertTrue(output.contains("Gucci"));
        assertTrue(output.contains("Transport: Plane"));
        assertTrue(output.contains("Hotel: Luxury Hotel"));
        assertTrue(output.contains("Car rental: Yes"));
        assertTrue(output.contains("Total cost: 750.0 €")); // Calculated as (200 + 50) * 3
    }

    @Test
    public void testShoppingDetails_France() {
        // Simulate user input for France
        String simulatedInput = "2\n2\n2\n2\n3\n"; // France, Train, Standard, No, 3 days
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ShoppingTour shoppingTour = new ShoppingTour();
        shoppingTour.shoppingDetails();

        // Capture the output and verify it contains expected details
        String output = outputStreamCaptor.toString();

        // Assertions to check if the output contains expected strings
        assertTrue(output.contains("Top brands in France:"));
        assertTrue(output.contains("Louis Vuitton"));
        assertTrue(output.contains("Transport: Train"));
        assertTrue(output.contains("Hotel: Standard Hotel"));
        assertTrue(output.contains("Car rental: No"));
        assertTrue(output.contains("Total cost: 300.0 €")); // Calculated as (100 * 3)
    }

    @Test
    public void testShoppingDetails_USA() {
        // Simulate user input for USA
        String simulatedInput = "3\n3\n3\n3\n3\n"; // USA, Bus, Budget, No, 3 days
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ShoppingTour shoppingTour = new ShoppingTour();
        shoppingTour.shoppingDetails();

        // Capture the output and verify it contains expected details
        String output = outputStreamCaptor.toString();

        // Assertions to check if the output contains expected strings
        assertTrue(output.contains("Top brands in USA:"));
        assertTrue(output.contains("Nike"));
        assertTrue(output.contains("Transport: Bus"));
        assertTrue(output.contains("Hotel: Budget Hotel"));
        assertTrue(output.contains("Car rental: No"));
        assertTrue(output.contains("Total cost: 150.0 €")); // Calculated as (50 * 3)
    }

    @Test
    public void testShoppingDetails_Japan() {
        // Simulate user input for Japan
        String simulatedInput = "4\n1\n1\n2\n2\n"; // Japan, Plane, Luxury, No, 2 days
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ShoppingTour shoppingTour = new ShoppingTour();
        shoppingTour.shoppingDetails();

        // Capture the output and verify it contains expected details
        String output = outputStreamCaptor.toString();

        // Debugging: Print the output to understand what the method produced
        System.out.println(output);

        // Assertions to check if the output contains expected strings
        assertTrue(output.contains("Top brands in Japan:"));
        assertTrue(output.contains("Uniqlo"));
        assertTrue(output.contains("Transport: Plane"));
        assertTrue(output.contains("Hotel: Luxury Hotel"));
        assertTrue(output.contains("Car rental: No"));
        assertTrue(output.contains("Total cost: 400.0 €")); // Calculated as (200 * 2)
    }





}
