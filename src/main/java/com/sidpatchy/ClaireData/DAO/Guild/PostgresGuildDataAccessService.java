package com.sidpatchy.ClaireData.DAO.Guild;

import com.sidpatchy.ClaireData.Model.Guild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("guild_postgres")
public class PostgresGuildDataAccessService implements GuildDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresGuildDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertGuild(String guildID, Guild guild) {
        String sql = "" +
                "INSERT INTO guild (" +
                "guildID, " +
                "requestsChannelID, " +
                "moderatorMessagesChannelID, " +
                "enforceServerLanguage, " +
                "locale) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                guild.getGuildID(),
                guild.getRequestsChannelId(),
                guild.getModeratorMessagesChannelID(),
                guild.isEnforceServerLanguage(),
                guild.getLocale()
        );
    }

    @Override
    public List<Guild> selectAllGuilds() {
        final String sql = "SELECT guildid, requestschannelid, moderatormessageschannelid, enforceServerLanguage, locale FROM guild";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String guildID = resultSet.getString("guildid");
            String requestChannelID = resultSet.getString("requestschannelid");
            String moderatorMessageChannelID = resultSet.getString("moderatormessageschannelid");
            boolean enforceServerLanguage = resultSet.getBoolean("enforceServerLanguage");
            String locale = resultSet.getString("locale");

            return new Guild(
                    guildID,
                    requestChannelID,
                    moderatorMessageChannelID,
                    enforceServerLanguage,
                    locale
            );
        });
    }

    @Override
    public Optional<Guild> selectGuildByID(String guildID) {
        final String sql = "SELECT guildid, requestschannelid, moderatormessageschannelid, enforceServerLanguage, locale FROM guild WHERE guildid = ?";

        Guild guild = jdbcTemplate.queryForObject(sql, new Object[]{guildID}, (resultSet, i) -> {
            String id = resultSet.getString("guildid");
            String requestChannelID = resultSet.getString("requestschannelid");
            String moderatorMessageChannelID = resultSet.getString("moderatormessageschannelid");
            boolean enforceServerLanguage = resultSet.getBoolean("enforceServerLanguage");
            String locale = resultSet.getString("locale");

            return new Guild(
                    id,
                    requestChannelID,
                    moderatorMessageChannelID,
                    enforceServerLanguage,
                    locale
            );
        });
        return Optional.ofNullable(guild);
    }
    //https://github.com/amigoscode/spring-boot-react-fullstack/blob/master/src/main/java/com/amigoscode/demo/student/StudentDataAccessService.java
    @Override
    public int updateGuildByID(String guildID, Guild guild) {
        String sql = "" +
                "UPDATE guild " +
                "SET requestsChannelID=?, " +
                "moderatorMessagesChannelID=?, " +
                "enforceServerLanguage=?, " +
                "locale=? " +
                "WHERE guildID=?";
        return jdbcTemplate.update(sql,
                guild.getRequestsChannelId(),
                guild.getModeratorMessagesChannelID(),
                guild.isEnforceServerLanguage(),
                guild.getLocale(),
                guild.getGuildID());
    }

    @Override
    public int deleteGuildByID(String guildID) {
        String sql = "" +
                "DELETE FROM guild " +
                "WHERE guildID = ?";
        return jdbcTemplate.update(sql, guildID);
    }
}
