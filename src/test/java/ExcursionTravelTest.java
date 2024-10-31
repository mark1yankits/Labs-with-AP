import Excursion.ExcursionTour;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ExcursionTourTest {

    @Test
    void testCalculateTotalCostWithDiscount() {
        ExcursionTour excursion = new ExcursionTour();
        int people = 5;
        double pricePerPerson = 500;
        double foodCost = 150;
        double guideCost = 250;
        double discount = excursion.calculateDiscount(people);

        double expectedTotalCost = (pricePerPerson * people + foodCost + guideCost) * (1 - discount);
        double actualTotalCost = excursion.calculateTotalCost(people, pricePerPerson, foodCost, guideCost, discount);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    void testCalculateTotalCostWithoutDiscount() {
        ExcursionTour excursion = new ExcursionTour();
        int people = 3;
        double pricePerPerson = 500;
        double foodCost = 100;
        double guideCost = 200;
        double discount = excursion.calculateDiscount(people);

        double expectedTotalCost = (pricePerPerson * people + foodCost + guideCost);
        double actualTotalCost = excursion.calculateTotalCost(people, pricePerPerson, foodCost, guideCost, discount);

        assertEquals(expectedTotalCost, actualTotalCost, 0.01);
    }

    @Test
    void testCalculateDiscountForLargeGroup() {
        ExcursionTour excursion = new ExcursionTour();
        int people = 5;
        double discount = excursion.calculateDiscount(people);

        assertEquals(0.1, discount, 0.01);
    }

    @Test
    void testCalculateDiscountForSmallGroup() {
        ExcursionTour excursion = new ExcursionTour();
        int people = 3;
        double discount = excursion.calculateDiscount(people);

        assertEquals(0.0, discount, 0.01);
    }

    @Test
    void testExcursionDetailsWithFullOptions() {
        // Simulate user input for each step (5 people, Germany, Nature, Full board, Personal guide)
        String input = "5\n2\n2\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ExcursionTour excursion = new ExcursionTour();
        excursion.excursionDetails();

        // Additional assertions can be made by refactoring excursionDetails to return calculated results.
    }
    @Test
    void testExcursionDetailsWithFullOptions_2() {
        // Simulate user input for each step (5 people, Germany, Nature, Full board, Personal guide)
        String input = "5\n3\n3\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ExcursionTour excursion = new ExcursionTour();
        excursion.excursionDetails();

        // Additional assertions can be made by refactoring excursionDetails to return calculated results.
    }
    @Test
    void testExcursionDetailsWithFullOptions_3() {
        // Simulate user input for each step (5 people, Germany, Nature, Full board, Personal guide)
        String input = "5\n1\n1\n1\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ExcursionTour excursion = new ExcursionTour();
        excursion.excursionDetails();

        // Additional assertions can be made by refactoring excursionDetails to return calculated results.
    }
    @Test
    void testExcursionDetailsWithDefaultOptions() {
        // Simulate user input with invalid excursion and type selections
        String input = "3\n5\n4\n2\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ExcursionTour excursion = new ExcursionTour();
        excursion.excursionDetails();

        // Further validations would involve checking printed values or refactoring methods to enable direct testing.
    }
}
