package com.sahaj.video_store;

/**
 * Created by rbansal on 23/03/15.
 */
public interface PriceCode {
    double computeRental(int daysRented);

    int computeLoyaltyPoints(int daysRented);
}
