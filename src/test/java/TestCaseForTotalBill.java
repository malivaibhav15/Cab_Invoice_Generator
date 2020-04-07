import com.BridgeLabzs.FareSummery;
import com.BridgeLabzs.MultipleRides;
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
        MultipleRides[] multipleRides = {new MultipleRides(10, 15),
                new MultipleRides(0.2, 2)};
        double totalFare = totalBillGenerator.calculateFare(multipleRides);
        Assert.assertEquals(120, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_GenerateTotalFare_ShouldReturnInvoiceSummery()
    {
        MultipleRides[] multipleRides = {new MultipleRides(10,15),
                                         new MultipleRides(0.2,2) };
        FareSummery fareSummery = totalBillGenerator.getFareSummery(multipleRides);
        FareSummery expectedSummery = new FareSummery(2,120);
        Assert.assertEquals(expectedSummery,fareSummery);
    }
}