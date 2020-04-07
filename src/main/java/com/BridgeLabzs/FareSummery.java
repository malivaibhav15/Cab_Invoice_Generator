package com.BridgeLabzs;

public class FareSummery {
    public int numberOfRides;
    public double totalFare;
    public double avgFarePerRide;

    public FareSummery(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = totalFare / numberOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FareSummery that = (FareSummery) o;
        return numberOfRides == that.numberOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.avgFarePerRide, avgFarePerRide) == 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
