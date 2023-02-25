package com.sidpatchy.ClaireData.DAO.User;

import com.sidpatchy.ClaireData.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

@Repository("user_postgres")
public class PostgresUserDataAccessService implements UserDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresUserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(String userID, User user) {
        String sql = "" +
                "INSERT INTO \"user\" (" +
                "userID, " +
                "accentColour, " +
                "language, " +
                "pointsGuildID, " +
                "pointsMessages, " +
                "pointsVoiceChat) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                user.getUserID(),
                user.getAccentColour(),
                user.getLanguage(),
                user.getPointsGuildID(),
                user.getPointsMessages(),
                user.getPointsVoiceChat()
        );
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT userid, accentcolour, language, pointsGuildID, pointsMessages, pointsVoiceChat FROM \"user\"";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String id = resultSet.getString("userid");
            String accentColour = resultSet.getString("accentColour");
            String language = resultSet.getString("language");
            String[] pointsGuildID = (String[]) resultSet.getArray("pointsGuildID").getArray();
            Integer[] pointsMessages = (Integer[]) resultSet.getArray("pointsMessages").getArray();
            Integer[] pointsVoiceChat = (Integer[]) resultSet.getArray("pointsVoiceChat").getArray();

            return new User(
                    id,
                    accentColour,
                    language,
                    pointsGuildID,
                    pointsMessages,
                    pointsVoiceChat
            );
        });
    }


    @Override
    public Optional<User> selectUserByID(String userID) {
        final String sql = "SELECT userid, accentcolour, language, pointsGuildID, pointsMessages, pointsVoiceChat FROM \"user\" WHERE userid = ?";

        User user = jdbcTemplate.queryForObject(sql, new Object[]{userID}, (resultSet, i) -> {
            String id = resultSet.getString("userid");
            String accentColour = resultSet.getString("accentColour");
            String language = resultSet.getString("language");
            String[] pointsGuildID = (String[]) resultSet.getArray("pointsGuildID").getArray();
            Integer[] pointsMessages = (Integer[]) resultSet.getArray("pointsMessages").getArray();
            Integer[] pointsVoiceChat = (Integer[]) resultSet.getArray("pointsVoiceChat").getArray();

            return new User(
                    id,
                    accentColour,
                    language,
                    pointsGuildID,
                    pointsMessages,
                    pointsVoiceChat
            );
        });
        return Optional.ofNullable(user);
    }

    @Override
    public int updateUserByID(String userID, User user) {
        String sql = "" +
                "UPDATE \"user\" " +
                "SET accentColour=?, " +
                "language=?, " +
                "pointsGuildID=?, " +
                "pointsMessages=?, " +
                "pointsVoiceChat=? " +
                "WHERE userID=?";
        return jdbcTemplate.update(sql,
                user.getAccentColour(),
                user.getLanguage(),
                user.getPointsGuildID(),
                user.getPointsMessages(),
                user.getPointsVoiceChat(),
                user.getUserID());
    }

    @Override
    public int deleteUserByID(String userID) {
        String sql = "" +
                "DELETE FROM \"user\" " +
                "WHERE userID = ?";
        return jdbcTemplate.update(sql, userID);
    }
}
