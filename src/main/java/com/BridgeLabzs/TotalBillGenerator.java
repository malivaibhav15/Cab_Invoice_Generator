package com.BridgeLabzs;

public class TotalBillGenerator {
    //CONSTANTS
    public static final int COST_PER_KILOMETER = 10;
    public static final int MINIMUM_FARE = 5;
    public static final int COST_PER_MINUTE = 1;

    public double calculateFare(double kiloMeters, int time) {
        double totalFare = ((kiloMeters * COST_PER_KILOMETER) + (COST_PER_MINUTE * time));
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        else
            return totalFare;
    }

    public double calculateFare(MultipleRIdes[] multipleRIdes) {
        double totalFare = 0;
        for (MultipleRIdes multipleRIdes1 : multipleRIdes) {
            totalFare = totalFare + this.calculateFare(multipleRIdes1.kiloMeters, multipleRIdes1.time);
        }
        return totalFare;
    }
}
