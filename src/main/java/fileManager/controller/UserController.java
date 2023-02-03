package fileManager.controller;

import fileManager.model.User;
import fileManager.services.UserService;

import java.util.List;

public class UserController {
    private UserService userService = new UserService();

    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        return userService.saveUser(user);
    }

    public User updateUser(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userService.updateUser(user);
    }

    public void deleteUser(Integer id) {
        userService.deleteUser(id);
    }

    public User getByIdUser(Integer id) {
        return userService.getByIdUser(id);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
