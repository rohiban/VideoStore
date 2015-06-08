package com.sahaj.video_store;

public class Rental extends DomainObject {
    private Tape tape;
    private PriceCode priceCode;
    private int daysRented;

    public Rental(Tape tape, PriceCode code, int days) {
        super(tape.movieName());
        this.tape = tape;
        this.priceCode = code;
        this.daysRented = days;
    }

    public Tape getTape() {
        return this.tape;
    }

    public boolean isOfTape(Tape tape) {
        return this.tape.equals(tape);
    }

    public String movieName() {
        return this.tape.movieName();
    }

    public double computeCharges() {
        return priceCode.computeRental(this.daysRented);
    }

    public int computeLoyaltyPoints() {
        return priceCode.computeLoyaltyPoints(this.daysRented);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Rental) {
            Rental r = (Rental) o;
            return this.tape.equals(r.tape) && this.priceCode.equals(r.priceCode) && (this.daysRented == r.daysRented);
        }
        return false;
    }
}