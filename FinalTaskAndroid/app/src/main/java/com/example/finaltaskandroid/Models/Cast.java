package com.example.finaltaskandroid.Models;

public class Cast {
    int id;
    String name;
    String character;
    String profile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return "("+character+")";
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
