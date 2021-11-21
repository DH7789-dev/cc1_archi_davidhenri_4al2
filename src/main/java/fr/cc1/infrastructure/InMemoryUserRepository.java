package fr.cc1.infrastructure;

import fr.cc1.domain.Repository.UserRepository;
import fr.cc1.domain.common.exception.UserExceptions;
import fr.cc1.domain.model.User;
import fr.cc1.domain.model.UserId;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getUserId(), user);
    }

    @Override
    public User byId(UserId userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new UserExceptions("No user for " + userId.getValue());
        }
        return user;
    }

    @Override
    public UserId nextIdentity() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public List<User> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
