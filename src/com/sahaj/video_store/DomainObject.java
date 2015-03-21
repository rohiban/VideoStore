package com.sahaj.video_store;

public class DomainObject {
  protected String name = "no name";

  public DomainObject() {
  }

  public DomainObject(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  public String toString() {
    return name;
  }
}
