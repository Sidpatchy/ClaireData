package com.sidpatchy.ClaireData.DAO.Guild;

import com.sidpatchy.ClaireData.Model.Guild;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("testDAO")
public class TestGuildDataAccessService implements GuildDAO {

    private static List<Guild> db = new ArrayList<>();

    @Override
    public int insertGuild(String guildID, Guild guild) {
        db.add(new Guild(guildID, guild.getRequestsChannelId(), guild.getModeratorMessagesChannelID(), guild.isEnforceServerLanguage(), guild.getLocale()));
        return 1;
    }

    @Override
    public List<Guild> selectAllGuilds() {
        return db;
    }

    @Override
    public Optional<Guild> selectGuildByID(String guildID) {
        return db.stream()
                .filter(guild -> guild.getGuildID().equals(guildID))
                .findFirst();
    }

    @Override
    public int deleteGuildByID(String guildID) {
        Optional<Guild> guild = selectGuildByID(guildID);
        if (guild.isEmpty()) {
            return 0;
        }
        db.remove(guild.get());
        return 1;
    }

    @Override
    public int updateGuildByID(String guildID, Guild guild) {
        return selectGuildByID(guildID)
                .map(g -> {
                    int indexOfGuildToUpdate = db.indexOf(g);
                    if (indexOfGuildToUpdate >= 0) {
                        db.set(indexOfGuildToUpdate, new Guild(guildID, guild.getRequestsChannelId(), guild.getModeratorMessagesChannelID(), guild.isEnforceServerLanguage(), guild.getLocale()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
