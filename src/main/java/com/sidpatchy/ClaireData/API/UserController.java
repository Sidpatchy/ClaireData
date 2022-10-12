package com.sidpatchy.ClaireData.API;

import com.sidpatchy.ClaireData.Model.User;
import com.sidpatchy.ClaireData.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user.getUserID(), user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "{userID}")
    public User getUserById(@PathVariable("userID") String userID) {
        return userService.getUserByID(userID)
                .orElse(null);
    }

    @DeleteMapping(path = "{userID}")
    public void deleteUserById(@PathVariable("userID") String userID) {
        userService.deleteUser(userID);
    }

    @PutMapping(path = "{userID}")
    public void updateUser(@PathVariable("userID") String userID, @RequestBody User userToUpdate) {
        userService.updateUser(userID, userToUpdate);
    }
}
