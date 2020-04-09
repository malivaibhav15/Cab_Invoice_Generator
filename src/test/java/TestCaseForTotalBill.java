import com.BridgeLabzs.FareSummery;
import com.BridgeLabzs.MultipleRides;
import com.BridgeLabzs.TotalBillGenerator;
import com.BridgeLabzs.TypesOfCabs;
import org.junit.Assert;
import org.junit.Test;

public class TestCaseForTotalBill {

    @Test
    public void givenDistanceNTime_WhenProper_ShouldRtuenTotalFare() {
        double kiloMeters = 15;
        int time = 20;
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.NORMAL_RIDES);
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(170, totalFare, 0.0);
    }

    @Test
    public void givenNigligibleDistanceNTime_ShouldReturnMinimumFare() {
        double kiloMeters = 0.2;
        int time = 2;
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.NORMAL_RIDES);
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenProper_ShouldReturnAggrigate() {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.NORMAL_RIDES);
        MultipleRides[] multipleRides = {new MultipleRides(10, 15),
                                         new MultipleRides(0.2, 2)};
        FareSummery fareSummery = totalBillGenerator.calculateFare(multipleRides);
        FareSummery expectedResult = new FareSummery(2,120);
        Assert.assertEquals(fareSummery,expectedResult);
    }


    @Test
    public void givenUserName_WhenProper_ShouldReturnInvoiceSummery()
    {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.NORMAL_RIDES);
        String userName = "abc@123";
        MultipleRides[] multipleRides = { new MultipleRides(10,15),
                                          new MultipleRides(0.2,2) };
        totalBillGenerator.calculateFare(userName,multipleRides);
        FareSummery fareSummery = totalBillGenerator.getFareSummery(userName);
        FareSummery expectedFareSummery = new FareSummery(2,120);
        Assert.assertEquals(expectedFareSummery,fareSummery);
    }

    @Test
    public void givenDistanceNTime_WhenProper_ShouldRtuenTotalFareForPremium() {
        double kiloMeters = 15;
        int time = 20;
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.PREMIUM_RIDES);
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(265, totalFare, 0.0);
    }

    @Test
    public void givenNigligibleDistanceNTime_ShouldReturnMinimumFareForPremium() {
        double kiloMeters = 0.2;
        int time = 2;
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.PREMIUM_RIDES);
        double totalFare = totalBillGenerator.calculateFare(kiloMeters, time);
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenProper_ShouldReturnAggrigateForPremium() {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.PREMIUM_RIDES);
        MultipleRides[] multipleRides = {new MultipleRides(10, 15),
                new MultipleRides(0.2, 2)};
        FareSummery fareSummery = totalBillGenerator.calculateFare(multipleRides);
        FareSummery expectedResult = new FareSummery(2,200);
        Assert.assertEquals(fareSummery,expectedResult);
    }


    @Test
    public void givenUserName_WhenProper_ShouldReturnInvoiceSummeryForPremium ()
    {
        TotalBillGenerator totalBillGenerator = new TotalBillGenerator(TypesOfCabs.PREMIUM_RIDES);
        String userName = "abc@123";
        MultipleRides[] multipleRides = { new MultipleRides(10,15),
                                          new MultipleRides(0.2,2) };
        totalBillGenerator.calculateFare(userName,multipleRides);
        FareSummery fareSummery = totalBillGenerator.getFareSummery(userName);
        FareSummery expectedFareSummery = new FareSummery(2,200);
        Assert.assertEquals(expectedFareSummery,fareSummery);
    }

}