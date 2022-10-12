CREATE TABLE guild (
    guildID VARCHAR NOT NULL PRIMARY KEY,
    requestsChannelID VARCHAR(100),
    moderatorMessagesChannelID VARCHAR(100),
    enforceServerLanguage BOOLEAN
);
CREATE TABLE "user" (
    userID VARCHAR NOT NULL PRIMARY KEY,
    accentColour VARCHAR(100),
    language VARCHAR(100)
);