package com.sahaj.video_store;

public class Tape extends DomainObject {
  private String serialNumber;
  private Movie movie;

  public Tape(String serialNumber, Movie movie) {
    this.serialNumber = serialNumber;
    this.movie = movie;
  }

  public Movie movie() {
    return movie;
  }
}