package com.sidpatchy.ClaireData.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * User-specific customizations will not be implemented until further down the line.
 */
public class User {

    private final String userID;
    private final String accentColour;
    private final String language;

    public User(@JsonProperty("userID") String userID,
                @JsonProperty("accentColour") String accentColour,
                @JsonProperty("language") String language) {
        this.userID = userID;
        this.accentColour = accentColour;
        this.language = language;
    }

    public String getUserID() {
        return userID;
    }

    public String getAccentColour() {
        return accentColour;
    }

    public String getLanguage() {
        return language;
    }
}
