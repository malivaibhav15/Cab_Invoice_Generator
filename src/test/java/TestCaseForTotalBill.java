import com.BridgeLabzs.MultipleRIdes;
import com.BridgeLabzs.TotalBillGenerator;
import org.junit.Assert;
import org.junit.Test;

public class TestCaseForTotalBill {

    TotalBillGenerator totalBillGenerator = new TotalBillGenerator();

    @Test
    public void givenDistanceNTime_WhenProper_ShouldRtuenTotalFare() {
        double kiloMeters = 15;
        int time = 20;
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(170, totalFare, 0.0);
    }

    @Test
    public void givenNigligibleDistanceNTime_ShouldReturnMinimumFare() {
        double kiloMeters = 0.2;
        int time = 2;
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenProper_ShouldReturnAggrigate() {
        MultipleRIdes[] multipleRIdes = {new MultipleRIdes(10, 15),
                new MultipleRIdes(0.2, 2)};
        double totalFare = totalBillGenerator.calculateFare(multipleRIdes);
        Assert.assertEquals(120, totalFare, 0.0);
    }
}
