

import Medical.MedicalTour;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicalTourTest {
    private MedicalTour medicalTour;

    @BeforeEach
    public void setUp() {
        medicalTour = new MedicalTour(new Scanner(System.in));
    }

    @Test
    public void testChooseCountry_UK() {
        medicalTour.chooseCountry(1);
        assertEquals("UK (London)", medicalTour.country);
        assertEquals(150, medicalTour.accommodationCost);
        assertEquals("£", medicalTour.currency);
    }

    @Test
    public void testChooseCountry_Spain() {
        medicalTour.chooseCountry(2);
        assertEquals("Spain (Barcelona)", medicalTour.country);
        assertEquals(120, medicalTour.accommodationCost);
        assertEquals("€", medicalTour.currency);
    }

    @Test
    public void testChooseCountry_Italy() {
        medicalTour.chooseCountry(3);
        assertEquals("Italy (Rome)", medicalTour.country);
        assertEquals(130, medicalTour.accommodationCost);
        assertEquals("€", medicalTour.currency);
    }
    @Test
    public void testChooseCountry_Mauritius() {
        medicalTour.chooseCountry(4);
        assertEquals("Mauritius", medicalTour.country);
        assertEquals(110, medicalTour.accommodationCost);
        assertEquals("$", medicalTour.currency);
    }



    @Test
    public void testChooseAccommodation_Hospital() {
        medicalTour.chooseCountry(1); // Set to UK to use £ currency
        medicalTour.sc = new Scanner("1\n7\n"); // Simulate hospital choice and 7 days of stay
        medicalTour.chooseAccommodation();

        assertEquals("Hospital", medicalTour.accommodationType);
        assertEquals(225, medicalTour.accommodationCost); // 150 * 1.5 for hospital
        assertEquals(50, medicalTour.foodCost);
        assertEquals(7, medicalTour.days);
    }

    @Test
    public void testChooseAccommodation_Hotel() {
        medicalTour.chooseCountry(1);
        medicalTour.sc = new Scanner("2\n5\n"); // Simulate hotel choice and 5 days of stay
        medicalTour.chooseAccommodation();

        assertEquals("Hotel", medicalTour.accommodationType);
        assertEquals(150, medicalTour.accommodationCost); // No change for hotel
        assertEquals(30, medicalTour.foodCost);
        assertEquals(5, medicalTour.days);
    }

    @Test
    public void testChooseTransport_Airplane() {
        medicalTour.sc = new Scanner("1\n"); // Simulate airplane choice
        medicalTour.chooseTransport();

        assertEquals("Airplane", medicalTour.transport);
        assertEquals(300, medicalTour.transportCost);
    }

    @Test
    public void testChooseTransport_Bus() {
        medicalTour.sc = new Scanner("2\n"); // Simulate bus choice
        medicalTour.chooseTransport();

        assertEquals("Bus", medicalTour.transport);
        assertEquals(100, medicalTour.transportCost);
    }



    @Test
    public void testChooseCondition_Cancer() {
        medicalTour.sc = new Scanner("1\n"); // Simulate Cancer treatment choice
        medicalTour.chooseCondition();

        assertEquals("Cancer", medicalTour.getCondition());
        assertEquals(5000, medicalTour.getTreatmentCost());
    }
    @Test
    public void testChooseCondition_Skin_Infection() {
        medicalTour.sc = new Scanner("2\n");
        medicalTour.chooseCondition();

        assertEquals("Skin Infection", medicalTour.getCondition());
        assertEquals(2000, medicalTour.getTreatmentCost());
    }
    @Test
    public void testChooseCondition_Childbirth() {
        medicalTour.sc = new Scanner("3\n");
        medicalTour.chooseCondition();

        assertEquals("Childbirth", medicalTour.getCondition());
        assertEquals(3000, medicalTour.getTreatmentCost());
    }

    @Test
    public void testChooseCondition_Heart_Surgery() {
        medicalTour.sc = new Scanner("4\n");
        medicalTour.chooseCondition();

        assertEquals("Heart Surgery", medicalTour.getCondition());
        assertEquals(8000, medicalTour.getTreatmentCost());
    }
    @Test
    public void testChooseCondition_Default() {
        medicalTour.sc = new Scanner("5\n"); // Invalid choice, should default to Skin Infection
        medicalTour.chooseCondition();

        assertEquals("Skin Infection", medicalTour.getCondition());
        assertEquals(2000, medicalTour.getTreatmentCost());
    }

    @Test
    public void testCalculateTotalCost() {
        // Setting up a typical selection for total cost calculation
        medicalTour.country = "Spain (Barcelona)";
        medicalTour.accommodationType = "Hotel";
        medicalTour.condition = "Childbirth";
        medicalTour.transport = "Bus";
        medicalTour.currency = "€";
        medicalTour.accommodationCost = 120; // Base cost for Spain
        medicalTour.treatmentCost = 3000; // Cost for childbirth
        medicalTour.transportCost = 100; // Bus cost
        medicalTour.foodCost = 30; // Food cost in hotel
        medicalTour.days = 5;

        medicalTour.calculateTotalCost();

        // Calculation: (120 * 5) + 3000 + (30 * 5) + 100 = 3850
        assertEquals(3850, medicalTour.totalCost);
    }



}
