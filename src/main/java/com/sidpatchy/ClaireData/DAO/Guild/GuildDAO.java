package com.sidpatchy.ClaireData.DAO.Guild;

import com.sidpatchy.ClaireData.Model.Guild;

import java.util.List;
import java.util.Optional;

public interface GuildDAO {

    int insertGuild(String guildID, Guild guild);

    List<Guild> selectAllGuilds();

    Optional<Guild> selectGuildByID(String guildID);

    int deleteGuildByID(String guildID);

    int updateGuildByID(String guildID, Guild guild);
}
