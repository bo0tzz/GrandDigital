package me.bo0tzz.granddigital.model;

public enum OS {

    IOS,
    ANDROID;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
