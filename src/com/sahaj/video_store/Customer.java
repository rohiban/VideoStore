package com.sahaj.video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer extends DomainObject {
    private List<Tape> tapes = new ArrayList<Tape>();

    public Customer(String name) {
        super(name);
    }

//    public String printStatement() {
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
//
//        String result = "Rental Record for " + this.name() + "\n";
//        for (Rental rental : tapes) {
//            totalAmount += rental.computeCharges(5);
//
//            // add frequent renter points
//            frequentRenterPoints += rental.computeLoyaltyPoints(5);
//
//            //show figures for this rental
//            result += "\t" + rental.movieName() + "\t" + String.valueOf(rental.computeCharges(5)) + "\n";
//        }
//
//        //add footer lines
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
//        return result;
//    }

    public void checkingOut(Tape tape) {
        tapes.add(tape);
        System.out.println(this.name + " is checking out : " + tape.toString());
    }

    public void droppingOff(Tape tape) {
        tapes.remove(tape);
        System.out.println(this.name + " is returning : " + tape.toString());
    }

    @Override
    public String toString() {
        return this.name();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Customer) {
            Customer customer = (Customer) o;
            return this.name.equals(customer.name);
        }
        return false;
    }
}