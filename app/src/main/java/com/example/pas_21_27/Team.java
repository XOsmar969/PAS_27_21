package com.example.pas_21_27;

public class Team {
    private String name;
    private String logoUrl;

    public Team(String name, String logoUrl) {
        this.name = name;
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
}
