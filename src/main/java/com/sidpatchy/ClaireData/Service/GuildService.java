package com.sidpatchy.ClaireData.Service;

import com.sidpatchy.ClaireData.DAO.Guild.GuildDAO;
import com.sidpatchy.ClaireData.Model.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuildService {

    private final GuildDAO guildDAO;

    @Autowired
    public GuildService(@Qualifier("guild_postgres") GuildDAO guildDAO) {
        this.guildDAO = guildDAO;
    }

    public int addGuild(String guildID, Guild guild) {
        return guildDAO.insertGuild(guildID, guild);
    }
    public List<Guild> getAllGuilds() {
        return guildDAO.selectAllGuilds();
    }

    public Optional<Guild> getGuildByID(String guildID) {
        return guildDAO.selectGuildByID(guildID);
    }

    public int deleteGuild(String guildID) {
        return guildDAO.deleteGuildByID(guildID);
    }

    public int updateGuild(String guildID, Guild guild) {
        return guildDAO.updateGuildByID(guildID, guild);
    }
}
