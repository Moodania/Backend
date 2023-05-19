package com.mood.Moodania.dataAccess.models;

public enum ERole {
    DEFAULT,
    PREMIUM,
    ADMIN;


    @Override
    public String toString() {
        return this.name();
    }
}
