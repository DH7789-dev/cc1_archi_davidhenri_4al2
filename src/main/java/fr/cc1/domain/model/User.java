package fr.cc1.domain.model;
import java.util.Objects;


public class User {

    private final UserId userId;
    private final String lastname;
    private final String firstname;
    private final BankAccount BankAccount;
    private final String email;
    private String password;

    private User(UserId userId, String lastname, String firstname, BankAccount bankAccount, String email, String password) {
        this.userId = Objects.requireNonNull(userId);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        BankAccount = Objects.requireNonNull(bankAccount);
        this.password = Objects.requireNonNull(password);
        this.email = Objects.requireNonNull(email);
    }

    public static User of(UserId userId, String lastname,BankAccount bankAccount,String email, String firstname, String password) {
        return new User(userId, lastname, firstname, bankAccount, email, password);
    }

    public BankAccount getBankAccount() {
        return BankAccount;
    }

    public UserId getUserId() {
        return userId;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
