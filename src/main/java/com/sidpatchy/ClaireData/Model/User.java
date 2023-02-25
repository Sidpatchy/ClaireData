package com.sidpatchy.ClaireData.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Array;

/**
 * User-specific customizations will not be implemented until further down the line.
 */
public class User {

    private final String userID;
    private final String accentColour;
    private final String language;
    private final String[] pointsGuildID;
    private final Integer[] pointsMessages;
    private final Integer[] pointsVoiceChat;

    public User(@JsonProperty("userID") String userID,
                @JsonProperty("accentColour") String accentColour,
                @JsonProperty("language") String language,
                @JsonProperty("pointsGuildID") String[] pointsGuildID,
                @JsonProperty("pointsMessages") Integer[] pointsMessages,
                @JsonProperty("pointsVoiceChat") Integer[] pointsVoiceChat) {
        this.userID = userID;
        this.accentColour = accentColour;
        this.language = language;
        this.pointsGuildID = pointsGuildID;
        this.pointsMessages = pointsMessages;
        this.pointsVoiceChat = pointsVoiceChat;
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

    public String[] getPointsGuildID() {
        return pointsGuildID;
    }

    public Integer[] getPointsMessages() {
        return pointsMessages;
    }

    public Integer[] getPointsVoiceChat() {
        return pointsVoiceChat;
    }
}
