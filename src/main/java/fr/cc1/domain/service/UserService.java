package fr.cc1.domain.service;

import fr.cc1.domain.Repository.UserRepository;
import fr.cc1.domain.model.User;
import fr.cc1.domain.model.UserId;

import java.util.List;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }

    public void changePassword(UserId userId, String newPassword) {
        var user = this.userRepository.byId(userId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }

    public List<User> all() {
        return this.userRepository.findAll();
    }

}
