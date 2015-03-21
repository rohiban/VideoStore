package com.sahaj.video_store;

public class Tape extends DomainObject {
  private String _serialNumber;
  private Movie _movie;

  public Tape(String serialNumber, Movie movie) {
    _serialNumber = serialNumber;
    _movie = movie;
  }

  public Movie movie() {
    return _movie;
  }
}