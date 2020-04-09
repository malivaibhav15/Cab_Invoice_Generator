package com.BridgeLabzs;

public class TotalBillGenerator {

    //CONSTANTS
    public static final int COST_PER_KILOMETER = 10;
    public static final int MINIMUM_FARE = 5;
    public static final int COST_PER_MINUTE = 1;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final int PREMIUM_COST_PER_MIN = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    private TypesOfCabs types;
    RideRepository rideRepository = new RideRepository();

    public TotalBillGenerator(TypesOfCabs types) {
        this.types = types;
    }

    //METHOD FOR CALCULATING THE TOTAL FARE
    public double calculateFare(double distance, int time) {
        switch (this.types) {
            case NORMAL_RIDES: {
                double totalFare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
                return Math.max(totalFare, MINIMUM_FARE);
            }
            case PREMIUM_RIDES: {
                double totalFare = (distance * PREMIUM_MINIMUM_COST_PER_KILOMETER) + (time * PREMIUM_COST_PER_MIN);
                return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
            }
        }
        return 0.0;
    }

    //METHOD FOR CALCULATING THE AGGRIGATE OF MULTIPLE RIDES
    public FareSummery calculateFare(MultipleRides[] multipleRides) {
        double totalFare = 0;
        double[] result = new double[3];
        for (MultipleRides multipleRides1 : multipleRides) {
            totalFare = totalFare + this.calculateFare(multipleRides1.kiloMeters, multipleRides1.time);
        }
        return new FareSummery(multipleRides.length, totalFare);
    }

    public void calculateFare(String userName, MultipleRides[] multipleRides) {
        rideRepository.calculateFare(userName,multipleRides);
    }

    public FareSummery getFareSummery(String userName) {
        return this.calculateFare(rideRepository.getRides(userName));
    }
}
