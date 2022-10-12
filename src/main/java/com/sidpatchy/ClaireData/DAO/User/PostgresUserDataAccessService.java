package com.sidpatchy.ClaireData.DAO.User;

import com.sidpatchy.ClaireData.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                "language) " +
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                user.getUserID(),
                user.getAccentColour(),
                user.getLanguage()
        );
    }

    @Override
    public List<User> selectAllUsers() {
        final String sql = "SELECT userid, accentcolour, language FROM \"user\"";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String id = resultSet.getString("userid");
            String accentColour = resultSet.getString("accentColour");
            String language = resultSet.getString("language");

            return new User(
                    id,
                    accentColour,
                    language
            );
        });
    }

    @Override
    public Optional<User> selectUserByID(String userID) {
        final String sql = "SELECT userid, accentcolour, language FROM \"user\" WHERE userid = ?";

        User user = jdbcTemplate.queryForObject(sql, new Object[]{userID}, (resultSet, i) -> {
            String id = resultSet.getString("userid");
            String accentColour = resultSet.getString("accentColour");
            String language = resultSet.getString("language");

            return new User(
                    id,
                    accentColour,
                    language
            );
        });
        return Optional.ofNullable(user);
    }
    //https://github.com/amigoscode/spring-boot-react-fullstack/blob/master/src/main/java/com/amigoscode/demo/student/StudentDataAccessService.java
    @Override
    public int updateUserByID(String userID, User user) {
        String sql = "" +
                "UPDATE \"user\" " +
                "SET accentColour=?, " +
                "language=? " +
                "WHERE userID=?";
        return jdbcTemplate.update(sql,
                user.getAccentColour(),
                user.getLanguage(),
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
