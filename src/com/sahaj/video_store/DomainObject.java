package com.sahaj.video_store;

public class DomainObject {
  protected String _name = "no _name";

  public DomainObject() {
  }

  public DomainObject(String _name) {
    this._name = _name;
  }

  public String name() {
    return _name;
  }

  public String toString() {
    return _name;
  }
}
