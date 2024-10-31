import Rest.RestTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class RestTourTest {

    private RestTour restTour;

    @BeforeEach
    public void setUp() {
        restTour = new RestTour();
    }

    @Test
    public void testTotalCost_PlaneFullBoard() {
        // Тестуємо розрахунок вартості для літака та повного пансіону
        restTour.quantity = 2;
        restTour.days = 5;
        restTour.nutrition = "Full Board";
        restTour.ticketPrice = 150;
        restTour.accommodationCost = 80;
        restTour.foodCost = 30;
        restTour.calculateTotalCost();

        double expectedTotalCost = (150 + (80 * 5) + (30 * 5)) * 2;
        assertEquals(expectedTotalCost, restTour.totalCost, 0.01);
    }

    @Test
    public void testTotalCost_BusNoMeals() {
        // Тестуємо розрахунок вартості для автобуса без харчування
        restTour.quantity = 3;
        restTour.days = 3;
        restTour.nutrition = "Full Board";
        restTour.ticketPrice = 40;
        restTour.accommodationCost = 25;
        restTour.foodCost = 0;

        restTour.calculateTotalCost();

        double expectedTotalCost = (40 + (25 * 3)) * 3;
        assertEquals(expectedTotalCost, restTour.totalCost, 0.01);
    }




    @Test
    void testChoiceMarchValidChoice1() {
        String input = "1\n3\n5\n2\n1\n"; // Route 1 (UK), 3 people, 5 days, Bus, 3-star hotel
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        boolean result = tour.choiceMarch(1);

        // Assertions
        assertTrue(result);
        assertEquals("£", tour.getCurrency());
        assertEquals("UK (London)", tour.getDestination());
    }


    @Test
    void testChoiceMarchValidChoice2() {
        String input = "2\n3\n2\n1\n"; // Adds choice for accommodation (e.g., 1 for 3-star hotel)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        boolean result = tour.choiceMarch(2);

        assertTrue(result);
        assertEquals("€", tour.getCurrency());
        assertEquals("Spain (Barcelona)", tour.getDestination());
    }

    @Test
    void testChoiceMarchValidChoice3() {
        String input = "2\n3\n2\n1\n"; // Adds choice for accommodation (e.g., 1 for 3-star hotel)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        boolean result = tour.choiceMarch(3);

        assertTrue(result);
        assertEquals("€", tour.getCurrency());
        assertEquals("Italy (Rome)", tour.getDestination());
    }


    @Test
    void testChoiceMarchValidChoice4() {
        String input = "2\n3\n2\n3\n"; // Adds choice for accommodation (e.g., 1 for 3-star hotel)
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        boolean result = tour.choiceMarch(4);

        assertTrue(result);
        assertEquals("$", tour.getCurrency());
        assertEquals("Mauritius", tour.getDestination());
    }
    @Test
    void testChoiceMarchInvalidChoice() {
        String input = "5\n"; // Некоректний вибір
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        boolean result = tour.choiceMarch(5);

        assertFalse(result);
        assertNull(tour.getCurrency());
        assertNull(tour.getDestination());
    }

    @Test
    void testInputDetailsValid() {
        String input = "1\n2\n3\n2\n1\n1\n"; // Route 1, 2 people, 3 days, Bus, 3-star hotel, Breakfast
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RestTour tour = new RestTour(new Scanner(System.in));
        tour.inputDetails(); // Calls method that leads to choiceMarch

        // Assertions
        assertEquals(3, tour.days);
        assertEquals(2, tour.quantity);
        assertEquals("Breakfast", tour.nutrition);
        assertNotNull(tour.getCurrency());
        assertNotNull(tour.getDestination());
        assertEquals("UK (London)", tour.getDestination()); // Based on input choice 1
    }



    @Test
    public void testRouteDetails_Plane() {
        // Тестуємо деталі маршруту для літака
        String input = "2\n5\n1\n3\n";
        restTour = new RestTour(new Scanner(input));

        restTour.displayRouteDetails("UK (London)", 150, 40, "£");

        assertEquals(150, restTour.ticketPrice);
        assertEquals(5, restTour.days);
        assertEquals(3, restTour.hostelNum);
        assertEquals(0, restTour.foodCost);
    }

    @Test
    public void testInvalidChoiceMarch() {
        // Тестуємо некоректний вибір валюти та пункту призначення
        boolean result = restTour.choiceMarch(5);
        assertFalse(result);
        assertNull(restTour.currency);
        assertNull(restTour.destination);
    }

    @Test
    public void testDisplayDetails() {
        // Тестуємо відображення деталей маршруту
        restTour.quantity = 2;
        restTour.days = 4;
        restTour.nutrition = "Full Board";
        restTour.transport = 1;
        restTour.totalCost = 800;
        restTour.currency = "£";

        restTour.displayDetails();

        assertEquals(2, restTour.quantity);
        assertEquals(4, restTour.days);
        assertEquals("Full Board", restTour.nutrition);
        assertEquals(1, restTour.transport);
        assertEquals(800, restTour.totalCost, 0.01);
    }

    @Test
    public void testInvalidDestChoice() {
        // Тестуємо некоректний вибір пункту призначення
        String input = "5\n";
        restTour = new RestTour(new Scanner(input));
        restTour.choiceMarch(5);

        assertNull(restTour.currency);
        assertNull(restTour.destination);
    }

    @Test
    public void testRouteDetails_Bus() {
        // Тестуємо деталі маршруту для автобуса
        String input = "3\n3\n2\n4\n2\n";
        restTour = new RestTour(new Scanner(input));

        restTour.displayRouteDetails("Spain (Barcelona)", 150, 40, "€");

        assertEquals(40, restTour.ticketPrice);
        assertEquals(3, restTour.days);
        assertEquals(4, restTour.hostelNum);
        assertEquals("Half Board", restTour.nutrition);
        assertEquals(20, restTour.foodCost);
    }

    @Test
    public void testRouteDetails_ValidInput() {
        // Тестуємо коректні значення маршруту
        String input = "2\n5\n1\n1\n1\n";
        restTour = new RestTour(new Scanner(input));

        restTour.displayRouteDetails("UK (London)", 150, 40, "£");

        assertEquals("UK (London)", restTour.destination);
        assertEquals("£", restTour.currency);
        assertEquals(150, restTour.ticketPrice);
        assertEquals(2, restTour.quantity);
        assertEquals(5, restTour.days);
        assertEquals(1, restTour.transport);
        assertEquals(1, restTour.hostelNum);
        assertEquals("Breakfast", restTour.nutrition);
        assertEquals(10, restTour.foodCost);
    }

    @Test
    public void testRouteDetails_NoMeal() {
        // Тестуємо відсутність харчування у маршруті
        String input = "1\n3\n2\n4\n";
        restTour = new RestTour(new Scanner(input));

        restTour.displayRouteDetails("Spain (Barcelona)", 150, 40, "€");

        assertEquals("Spain (Barcelona)", restTour.destination);
        assertEquals("€", restTour.currency);
        assertEquals(40, restTour.ticketPrice);
        assertEquals(1, restTour.quantity);
        assertEquals(3, restTour.days);
        assertEquals(2, restTour.transport);
        assertEquals(4, restTour.hostelNum);
        assertEquals("No meal option selected", restTour.nutrition);
        assertEquals(0, restTour.foodCost);
    }

    @Test
    public void testRouteDetails_MealsIncluded() {
        // Тестуємо включене харчування
        String input = "1\n4\n1\n3\n";
        restTour = new RestTour(new Scanner(input));

        restTour.displayRouteDetails("Mauritius", 300, 100, "$");

        assertEquals("Mauritius", restTour.destination);
        assertEquals("$", restTour.currency);
        assertEquals(300, restTour.ticketPrice);
        assertEquals(1, restTour.quantity);
        assertEquals(4, restTour.days);
        assertEquals(1, restTour.transport);
        assertEquals(3, restTour.hostelNum);
        assertEquals("Meals included", restTour.nutrition);
        assertEquals(0, restTour.foodCost);
    }

    @Test
    public void testTotalCost_3StarHotel() {
        // Тестуємо розрахунок вартості для 3-зіркового готелю
        restTour.quantity = 1;
        restTour.days = 3;
        restTour.hostelNum = 1;
        restTour.accommodationCost = 50;
        restTour.calculateTotalCost();

        assertEquals((restTour.ticketPrice + restTour.accommodationCost * 3) * 1, restTour.totalCost, 0.01);
    }

    @Test
    public void testTotalCost_5StarMealsIncluded() {
        // Тестуємо розрахунок вартості для 5-зіркового готелю з харчуванням
        restTour.quantity = 2;
        restTour.days = 4;
        restTour.hostelNum = 3;
        restTour.accommodationCost = 150;
        restTour.foodCost = 0;
        restTour.calculateTotalCost();

        double expectedTotalCost = (restTour.ticketPrice + (150 * 4)) * 2;
        assertEquals(expectedTotalCost, restTour.totalCost, 0.01);
    }
}
