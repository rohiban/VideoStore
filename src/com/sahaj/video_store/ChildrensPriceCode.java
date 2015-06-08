package com.sahaj.video_store;

/**
 * Created by rbansal on 23/03/15.
 */
public class ChildrensPriceCode implements PriceCode {
    @Override
    public double computeRental(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3)
            charge = (daysRented - 3) * 1.5;

        return charge;
    }

    @Override
    public int computeLoyaltyPoints(int daysRented) {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof ChildrensPriceCode) {
            return true;
        }
        return false;
    }
}
