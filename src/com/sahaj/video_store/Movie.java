package com.sahaj.video_store;

public class Movie extends DomainObject {
    public static Movie PIKU = new Movie("Piku");
    public static Movie MADAGASCAR = new Movie("Madagascar");
    public static Movie RAAKH = new Movie("Raakh");
    public static Movie ANKUSH = new Movie("Ankush");

    protected Movie(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Movie) {
            Movie movie = (Movie) o;
            return this.name().equals(movie.name());
        }
        return false;
    }
}
