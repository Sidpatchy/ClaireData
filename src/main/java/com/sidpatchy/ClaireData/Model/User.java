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
    private final Array pointsGuildID;
    private final Array pointsMessages;
    private final Array pointsVoiceChat;

    public User(@JsonProperty("userID") String userID,
                @JsonProperty("accentColour") String accentColour,
                @JsonProperty("language") String language,
                @JsonProperty("pointsGuildID") Array pointsGuildID,
                @JsonProperty("pointsMessages") Array pointsMessages,
                @JsonProperty("pointsVoiceChat") Array pointsVoiceChat) {
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

    public Array getPointsGuildID() {
        return pointsGuildID;
    }

    public Array getPointsMessages() {
        return pointsMessages;
    }

    public Array getPointsVoiceChat() {
        return pointsVoiceChat;
    }
}
