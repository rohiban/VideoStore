package com.sahaj.video_store;

public class Rental extends DomainObject {
  private Tape _tape;
  private int _daysRented;

  public Rental(Tape tape, int daysRented) {
    _tape = tape;
    _daysRented = daysRented;
  }

  public int daysRented() {
    return _daysRented;
  }

  public Tape tape() {
    return _tape;
  }
}