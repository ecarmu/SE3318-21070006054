import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.EconomyVehicle;
import org.example.LuxuryVehicle;
import org.example.RentalRecord;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * Unit tests to verify pricing and rental record calculations.
 */
public class SmokeTest {

    @Test
    public void testLuxuryPricing() {
        LuxuryVehicle lux = new LuxuryVehicle("BMW", "X5", "ABC-123", true, true);
        assertEquals(150.0, lux.calculateDailyPrice());
    }

    @Test
    public void testEconomyPricing() {
        EconomyVehicle eco = new EconomyVehicle("Toyota", "Corolla", "XYZ-789", false);
        assertEquals(50.0, eco.calculateDailyPrice());
    }

    @Test
    public void testRentalRecordTotal() {
        LuxuryVehicle lux = new LuxuryVehicle("Audi", "A8", "LMN-456", false, true);
        RentalRecord record = new RentalRecord(
                lux,
                "cust001",
                LocalDate.of(2024, 3, 1),
                LocalDate.of(2024, 3, 3)
        );
        // 3 days * (100 + 30) = 390
        assertEquals(390.0, record.calculateTotalPrice());
    }
}
