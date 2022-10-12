package com.sidpatchy.ClaireData.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Guild {

    private final String guildID;
    private final String requestsChannelId;
    private final String moderatorMessagesChannelID;
    private final boolean enforceServerLanguage;

    public Guild(@JsonProperty("guildID") String guildID,
                 @JsonProperty("requestsChannelID") String requestsChannelId,
                 @JsonProperty("moderatorMessagesChannelID") String moderatorMessagesChannelID,
                 @JsonProperty("enforceServerLanguage") boolean enforceServerLanguage){
        this.guildID = guildID;
        this.requestsChannelId = requestsChannelId;
        this.moderatorMessagesChannelID = moderatorMessagesChannelID;
        this.enforceServerLanguage = enforceServerLanguage;
    }

    public String getGuildID() {
        return guildID;
    }

    public String getRequestsChannelId() {
        return requestsChannelId;
    }

    public String getModeratorMessagesChannelID() {
        return moderatorMessagesChannelID;
    }

    public boolean isEnforceServerLanguage() {
        return enforceServerLanguage;
    }
}
