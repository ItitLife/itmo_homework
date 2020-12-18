package lesson25.task;

import java.util.HashSet;
import java.util.Set;

public class Account {
    private int id; // unique
    private int balance; // доступные средства на аккаунте

    public Account(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static Account getAccount() {
        return new Account((int) (Math.random() * Integer.MAX_VALUE), 100 + (int) (Math.random() * 200));
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}