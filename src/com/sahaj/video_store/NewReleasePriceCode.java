package com.sahaj.video_store;

/**
 * Created by rbansal on 23/03/15.
 */
public class NewReleasePriceCode implements PriceCode {
    @Override
    public double computeRental(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int computeLoyaltyPoints(int daysRented) {
        int points = 1;
        if (daysRented > 1) {
            points++;
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof NewReleasePriceCode) {
            return true;
        }
        return false;
    }
}
