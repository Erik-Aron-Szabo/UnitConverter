package com.easz.unitconverter;

public class Utility {

    private static double kmToMileRatio = 0.621371;
    private static double miToKmRatio = 1.60934;


    // Dependency injection
    private static Utility singleton = null;
    private Utility() {

    }

    public static Utility getUtility() {
        if (singleton == null) {
            singleton = new Utility();
        }
        return singleton;
    }

    public double kmToMi(double km) {
        return km * kmToMileRatio;
    }

    public double miToKm(double mi) {
        return mi * miToKmRatio;
    }

}
