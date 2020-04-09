package com.BridgeLabzs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<MultipleRides>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void calculateFare(String userName, MultipleRides[] multipleRides) {
        ArrayList<MultipleRides> rideList = this.userRides.get(userName);
        if (rideList == null) {
            this.userRides.put(userName, new ArrayList<>(Arrays.asList(multipleRides)));
        }

    }

    public MultipleRides[] getRides(String userName) {
        return this.userRides.get(userName).toArray(new MultipleRides[0]);
    }
}
