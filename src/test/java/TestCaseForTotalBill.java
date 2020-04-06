import com.BridgeLabzs.TotalBillGenerator;
import org.junit.Assert;
import org.junit.Test;

public class TestCaseForTotalBill {
    @Test
    public void givenDistanceNTime_WhenProper_ShouldRtuenTotalFare() {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator();
        double kiloMeters = 15;
        int time = 20;
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(170, totalFare, 0.0);
    }

    @Test
    public void givenNigligibleDistanceNTime_ShouldReturnMinimumFare() {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator();
        double kiloMeters = 0.2;
        int time = 2;
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(5, totalFare, 0.0);

    }

}
