package com.sahaj.video_store;

/**
 * Created by rbansal on 23/03/15.
 */
public class RegularPriceCode implements PriceCode {
    @Override
    public double computeRental(int daysRented) {
        double charge = 2;
        if (daysRented > 2)
            charge += (daysRented - 2) * 1.5;
        return charge;
    }

    @Override
    public int computeLoyaltyPoints(int daysRented) {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof RegularPriceCode) {
            return true;
        }
        return false;
    }
}
