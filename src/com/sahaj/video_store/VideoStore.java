package com.sahaj.video_store;

/**
 * Created by rbansal on 26/05/15.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VideoStore {
    private int lastSerialNum;
    private Map<Tape, PriceCode> tapeList;
    protected Map<Customer, List<Rental>> customerRentals;

    public VideoStore() {
        this.lastSerialNum = 10000;
        this.tapeList = new HashMap<Tape, PriceCode>();
        this.customerRentals = new HashMap<Customer, List<Rental>>();
    }

    public void initialize() {
        this.tapeList.put(new Tape(String.valueOf(this.lastSerialNum++), Movie.MADAGASCAR), new ChildrensPriceCode());
        this.tapeList.put(new Tape(String.valueOf(this.lastSerialNum++), Movie.PIKU), new NewReleasePriceCode());
        this.tapeList.put(new Tape(String.valueOf(this.lastSerialNum++), Movie.RAAKH), new RegularPriceCode());
        this.tapeList.put(new Tape(String.valueOf(this.lastSerialNum++), Movie.PIKU), new NewReleasePriceCode());
    }

    public boolean register(Customer cust) {
        if (this.customerRentals.containsKey(cust)) {
            return true;
        } else {
            this.customerRentals.put(cust, new ArrayList<Rental>());
            return true;
        }
    }

    public boolean unRegister(Customer cust) {
        if (this.customerRentals.containsKey(cust)) {
            this.customerRentals.remove(cust);
            return true;
        } else {
            // customer is not registered
            return false;
        }
    }

    public boolean hasMovie(Movie mov) {
        for (Tape tape : this.tapeList.keySet()) {
            if (tape.isOfMovie(mov) && tape.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public Tape checkOut(Customer forCustomer, Movie theMovie, int forDays) {
        // check if the customer is registered
        if (this.customerRentals.containsKey(forCustomer)) {
            for (Tape tape : this.tapeList.keySet()) {
                if (tape.isOfMovie(theMovie) && tape.isAvailable()) {
                    // add a new rental for this tape and customer
                    this.customerRentals.get(forCustomer).add(new Rental(tape, this.tapeList.get(tape), forDays));

                    forCustomer.checkingOut(tape);

                    // update the tape status as "rented out"
                    tape.rentItOut();

                    return tape;
                }
            }
        }
        return null;
    }

    public boolean doReturn(Customer customer) {
        if (this.customerRentals.containsKey(customer)) {
            List<Rental> rentalList = this.customerRentals.get(customer);

            for (Rental rental : rentalList) {
                customer.droppingOff(rental.getTape());

                // make the tape available
                rental.getTape().makeItAvailable();
            }

            // remove the rental
            rentalList.clear();
        }
        return true;
    }

    public boolean addMovie(Movie movie, PriceCode priceCode) {
        this.tapeList.put(new Tape(String.valueOf(lastSerialNum++), movie), priceCode);
        return true;
    }

    public String printStatement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + customer.name() + "\n";
        for (Rental rental : this.customerRentals.get(customer)) {
            totalAmount += rental.computeCharges();

            // add frequent renter points
            frequentRenterPoints += rental.computeLoyaltyPoints();

            //show figures for this rental
            result += "\t" + rental.movieName() + "\t" + String.valueOf(rental.computeCharges()) + "\n";
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public static void main (String[] args) {
        VideoStore videoLibrary = new VideoStore();
        videoLibrary.initialize();

        // add a customer
        Customer rohit = new Customer("Rohit");
        videoLibrary.register(rohit);

        Customer bansal = new Customer("Bansal");
        videoLibrary.register(bansal);

        // find a tape and check it out
        if (videoLibrary.hasMovie(Movie.PIKU)) {
            videoLibrary.checkOut(rohit, Movie.PIKU, 7);
            videoLibrary.checkOut(rohit, Movie.RAAKH, 7);
            //System.out.println(videoLibrary.printStatement(rohit));
        }

        // find a tape and check it out
        if (videoLibrary.hasMovie(Movie.RAAKH)) {
            videoLibrary.checkOut(bansal, Movie.RAAKH, 1);
        } else {
            System.out.println(bansal + " didn't find the movie :-(");
        }

        // return the tapes
        System.out.println(videoLibrary.printStatement(rohit));
        videoLibrary.doReturn(rohit);
    }

}
