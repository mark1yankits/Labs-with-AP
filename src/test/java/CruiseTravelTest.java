import Cruise.CruiseTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CruiseTourTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private CruiseTour cruiseTour;

    @BeforeEach
    public void setUp() {
        cruiseTour = new CruiseTour();
    }

    @Test
    public void testValidInput() {
        String input = "100\n7\n5\n1\n2\n"; // Valid inputs: base price, days, quantity, cabin class, food choice
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output)); // Capture console output

        CruiseTour cruiseTour = new CruiseTour();
        cruiseTour.createCustomTour(100, 7, 5, 1, 2, 0);  // Valid inputs here

        cruiseTour.displayDetails();  // Make sure this method outputs the expected details

        String consoleOutput = output.toString();
        System.out.println("Actual Output: " + consoleOutput);  // Debugging

        assertTrue(consoleOutput.contains("Total cost of the cruise: $2950.0 USD"));  // Check this matches the expected output
    }





    @Test
    public void testInvalidCabinClass() {
        String input = "100\n7\n5\n4\n"; // Invalid cabin class: 4
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output)); // Capture console output

        CruiseTour cruiseTour = new CruiseTour();
        cruiseTour.createCustomTour(100, 7, 5, 4, 1, 0);

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Error: Invalid cabin class selection."));
    }

    @Test
    public void testInvalidFoodChoice() {
        String input = "100\n7\n5\n1\n4\n"; // Invalid food choice: 4
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output)); // Capture console output

        CruiseTour cruiseTour = new CruiseTour();
        cruiseTour.createCustomTour(100, 7, 5, 1, 4, 0);

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Error: Invalid food choice selection."));
    }


    @Test
    void testGetDestination() {
        cruiseTour.nutrition = "Mediterranean Cruise";
        assertEquals("Mediterranean Cruise", cruiseTour.getDestination());
    }
    @Test
    void testGetTicketPrice() {
        cruiseTour.ticketPrice = 1200.0;
        assertEquals(1200.0, cruiseTour.getTicketPrice(), 0.01);
    }

    @Test
    void testGetDays() {
        cruiseTour.days = 10;
        assertEquals(10, cruiseTour.getDays());
    }

    @Test
    void testGetQuantity() {
        cruiseTour.quantity = 4;
        assertEquals(4, cruiseTour.getQuantity());
    }

    @Test
    void testGetCabinClass() {
        cruiseTour.cabinClass = 2;
        assertEquals(2, cruiseTour.getCabinClass());
    }

    @Test
    void testGetFoodChoice() {
        cruiseTour.foodChoice = 1;
        assertEquals(1, cruiseTour.getFoodChoice());
    }

    @Test
    void testGetFoodCost() {
        cruiseTour.foodCost = 300.0;
        assertEquals(300.0, cruiseTour.getFoodCost(), 0.01);
    }



    @Test
    public void testDisplayCruiseDetailsWithValidInputs() {
        // Імітуємо введення даних через консоль
        String input = "2\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Перевірка виведення методу displayCruiseDetails
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        cruiseTour.displayCruiseDetails("Caribbean Cruise", 100, 7, "USD");

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Cruise: Caribbean Cruise"));
        assertTrue(consoleOutput.contains("Base Price per person: 100 USD"));
        assertTrue(consoleOutput.contains("Duration: 7 days"));
    }
    @Test
    public void testDisplayDetailsOutput() {
        // Імітуємо введення даних через консоль
        String input = "2\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        cruiseTour.displayCruiseDetails("Caribbean Cruise", 100, 7, "USD");

        // Перевірка виведення методу displayDetails
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        cruiseTour.displayDetails();

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Booking for 2 people."));
        assertTrue(consoleOutput.contains("Days: 7"));
        assertTrue(consoleOutput.contains("Cabin Class: Economy"));
    }

    @Test
    public void testDisplayCruiseDetailsWithInvalidQuantity() {
        // Встановлення неправильного введення
        String input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        cruiseTour.displayCruiseDetails("Caribbean Cruise", 100, 7, "USD");

        String consoleOutput = output.toString();
        assertTrue(consoleOutput.contains("Invalid input for quantity. Exiting..."));
    }








    @Test
    public void testTotalCost_MediterraneanEconomyBreakfast() {
        cruiseTour.quantity = 2;
        cruiseTour.days = 7;
        cruiseTour.cabinClass = 1; // Economy
        cruiseTour.foodChoice = 1; // Breakfast
        cruiseTour.ticketPrice = 1000;
        cruiseTour.foodCost = 10;
        cruiseTour.accommodationCost = 50;
        cruiseTour.calculateTotalCost();

        double expectedTotalCost = (1000 + (50 * 7) + (10 * 7)) * 2;
        assertEquals(expectedTotalCost, cruiseTour.totalCost, 0.01);
    }

    @Test
    public void testDisplayDetails() {
        cruiseTour.quantity = 2;
        cruiseTour.days = 7;
        cruiseTour.nutrition = "Full Board";
        cruiseTour.cabinClass = 2; // Premium
        cruiseTour.totalCost = 3000;
        cruiseTour.currency = "$";

        cruiseTour.displayDetails();

        assertEquals(2, cruiseTour.quantity);
        assertEquals(7, cruiseTour.days);
        assertEquals("Full Board", cruiseTour.nutrition);
        assertEquals(2, cruiseTour.cabinClass);
        assertEquals(3000, cruiseTour.totalCost, 0.01);
    }

    @Test
    public void testCalculateTotalCost_CustomTour() {
        cruiseTour.quantity = 1;
        cruiseTour.days = 5;
        cruiseTour.ticketPrice = 500;
        cruiseTour.cabinClass = 2; // Premium
        cruiseTour.foodChoice = 2; // Half Board
        cruiseTour.foodCost = 20;
        cruiseTour.accommodationCost = 80;

        cruiseTour.calculateTotalCost();

        double expectedTotalCost = (500 + (80 * 5) + (20 * 5)) * 1;
        assertEquals(expectedTotalCost, cruiseTour.totalCost, 0.01);
    }





    @Test
    public void testCalculateTotalCost_NoPeople() {
        cruiseTour.quantity = 0;
        cruiseTour.days = 5;
        cruiseTour.cabinClass = 2;
        cruiseTour.ticketPrice = 1200;
        cruiseTour.foodCost = 20;
        cruiseTour.accommodationCost = 80;

        cruiseTour.calculateTotalCost();
        assertEquals(0, cruiseTour.totalCost, 0.01);
    }

    @Test
    public void testInitCustomTour_WithEconomyAndHalfBoard() {
        cruiseTour.initCustomTour("Bahamas", 650, 7, 1, 1, 2);

        assertEquals(1, cruiseTour.quantity);
        assertEquals(7, cruiseTour.days);
        assertEquals(650, cruiseTour.ticketPrice, 0.01);
        assertEquals(1, cruiseTour.cabinClass);
        assertEquals("Half Board", cruiseTour.nutrition);
        assertEquals(20, cruiseTour.foodCost, 0.01);
    }
}
