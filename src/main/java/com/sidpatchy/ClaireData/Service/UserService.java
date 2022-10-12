package com.sidpatchy.ClaireData.Service;

import com.sidpatchy.ClaireData.DAO.User.UserDAO;
import com.sidpatchy.ClaireData.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("user_postgres") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int addUser(String userID, User user) {
        return userDAO.insertUser(userID, user);
    }
    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }

    public Optional<User> getUserByID(String userID) {
        return userDAO.selectUserByID(userID);
    }

    public int deleteUser(String userID) {
        return userDAO.deleteUserByID(userID);
    }

    public int updateUser(String userID, User user) {
        return userDAO.updateUserByID(userID, user);
    }
}
