package com.sidpatchy.ClaireData.DAO.User;

import com.sidpatchy.ClaireData.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    int insertUser(String userID, User user);

    List<User> selectAllUsers();

    Optional<User> selectUserByID(String userID);

    int deleteUserByID(String userID);

    int updateUserByID(String userID, User user);
}
