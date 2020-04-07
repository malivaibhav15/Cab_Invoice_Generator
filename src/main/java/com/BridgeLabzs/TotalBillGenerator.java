package com.BridgeLabzs;

public class TotalBillGenerator {

    //CONSTANTS
    public static final int COST_PER_KILOMETER = 10;
    public static final int MINIMUM_FARE = 5;
    public static final int COST_PER_MINUTE = 1;
    private RideRepository rideRepository;

    public TotalBillGenerator() {
        this.rideRepository = new RideRepository();
    }

    //METHOD FOR CALCULATING THE TOTAL FARE
    public double calculateFare(double kiloMeters, int time) {
        double totalFare = ((kiloMeters * COST_PER_KILOMETER) + (COST_PER_MINUTE * time));
        return totalFare < MINIMUM_FARE ? MINIMUM_FARE : totalFare;
    }

    //METHOD FOR CALCULATING THE AGGRIGATE OF MULTIPLE RIDES
    public FareSummery calculateFare(MultipleRides[] multipleRides) {
        double totalFare = 0;
        for (MultipleRides multipleRides1 : multipleRides) {
            totalFare = totalFare + this.calculateFare(multipleRides1.kiloMeters, multipleRides1.time);
        }
        return new FareSummery(multipleRides.length, totalFare);
    }

    public void calculateFare(String userName, MultipleRides[] multipleRides) {
        rideRepository.addRides(userName,multipleRides);
    }

    public FareSummery getFareSummery(String userName) {
        return this.calculateFare(rideRepository.getRides(userName));
    }
}
