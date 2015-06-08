package com.sahaj.video_store;

public class Tape extends DomainObject {
    private Movie movie;
    private boolean available;

    public Tape(String serialNumber, Movie movie) {
        super(serialNumber);
        this.movie = movie;
        this.available = true;
    }

    public String movieName() {
        return movie.name();
    }

    public boolean isOfMovie(Movie mov) {
        return this.movie.equals(mov);
    }

    public void rentItOut() {
        this.available = false;
    }

    public void makeItAvailable() {
        this.available = true;
    }

    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Tape) {
            Tape t = (Tape) o ;
            return this.name().equals(t.name()) && this.movie.equals(t.movie);
        }
        return false;
    }

    @Override
    public String toString() {
        return "[Serial # " + super.toString() + ", " + movie.toString() + "]";
    }
}