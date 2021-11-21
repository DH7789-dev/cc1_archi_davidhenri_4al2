package fr.cc1.domain.service;

import fr.cc1.domain.model.User;

import java.util.function.Predicate;

public class UserValidatorService implements Predicate<User>  {

    private static final UserValidatorService INSTANCE = new UserValidatorService();

    private UserValidatorService() {
    }

    public static UserValidatorService getInstance() {
        return INSTANCE;
    }


    @Override
    public boolean test(User user) {
        return true;
    }
}
