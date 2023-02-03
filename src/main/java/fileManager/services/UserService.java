package fileManager.services;

import fileManager.model.User;
import fileManager.repository.repo.UserRepo;

import java.util.List;

public class UserService {

    private UserRepo userRepo = new UserRepo();

public User saveUser(User user) {
    userRepo.createUser(user);
    return user;
}

public User updateUser(User user) {
    userRepo.updateUser(user);
    return user;
}

public void deleteUser(Integer id) {
    userRepo.deleteUser(id);
}

public List<User> getAllUsers() {
    return userRepo.getAllUsers();
}

public User getByIdUser(Integer id) {
    return userRepo.getByIdUser(id);
}

}
