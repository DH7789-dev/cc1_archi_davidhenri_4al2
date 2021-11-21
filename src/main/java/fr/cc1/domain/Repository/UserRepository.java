package fr.cc1.domain.Repository;

import fr.cc1.domain.model.User;
import fr.cc1.domain.model.UserId;

import java.util.List;

public interface UserRepository {
    void save(User user);

    User byId(UserId userId);

    UserId nextIdentity();

    List<User> findAll();
}
