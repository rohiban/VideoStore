package com.sahaj.video_store;

public class DomainObject {
    protected String name;

    public DomainObject(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof DomainObject) {
            DomainObject domainObject = (DomainObject) o;

            return this.name.equals(domainObject.name);
        }
        return false;
    }
}
