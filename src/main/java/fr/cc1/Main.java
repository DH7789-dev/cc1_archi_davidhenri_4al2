package fr.cc1;

import fr.cc1.domain.Repository.UserRepository;
import fr.cc1.domain.model.BankAccount;
import fr.cc1.domain.model.User;
import fr.cc1.domain.model.UserId;
import fr.cc1.domain.service.BankAccountValidatorService;
import fr.cc1.domain.service.UserService;
import fr.cc1.domain.service.UserValidatorService;
import fr.cc1.infrastructure.InMemoryUserRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static final Logger LOGGER = Logger.getLogger( User.class.getPackage().getName() );
    private InMemoryUserRepository inMemoryUserRepository;

    public static void main(String[] args){
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        final UserId myUserId = userRepository.nextIdentity();

        createUser(userService, myUserId);
        printAllUsers(userService);
        paymentUser(userService);

    }

    private static void printAllUsers(UserService userService) {
        final List<User> users = userService.all();
        users.forEach(currentUser -> System.out.println(currentUser));
    }

    private static void createUser(UserService userService, UserId myUserId) {
        BankAccount bankAccountUser = BankAccount.of(20);
        User user = User.of(myUserId, "BOISSINOT",bankAccountUser , "Dharnaud77@hotmailL.Fr","CHANGEME","password");
        if (UserValidatorService.getInstance().test(user)) {
            LOGGER.log(Level.INFO, "User Acceped" );
            userService.create(user);
        }else{
            throw new IllegalArgumentException("Illegal arguments");
        }
    }

    private static void paymentUser(UserService userService){
        final List<User> users = userService.all();
        users.forEach(currentUser -> {
            if (BankAccountValidatorService.getInstance().test(currentUser.getBankAccount())) {
                LOGGER.log(Level.INFO, "Payment Acceped" );
            }else{
                throw new IllegalArgumentException("Illegal arguments");
            }
        });
    }


}
