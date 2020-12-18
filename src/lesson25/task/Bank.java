package lesson25.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bank {
    List<Account> accounts;


    public Bank(int accountsAmount) {
        accounts = getAccounts(accountsAmount);
    }

    public void transferMoney(Account src, Account dst, int money) {
        Thread transaction = new Thread(new Transaction(src, dst, money));
        transaction.start();
    }

    private static List<Account> getAccounts(int amount) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            accounts.add(Account.getAccount());
        }
        return accounts;
    }

    public Account getSomeAccount() {
        return accounts.get((int) (Math.random() * accounts.size()));
    }

    public void startTransactions(int operationsAmount) {
        for (int i = 0; i < operationsAmount; i++) {
            transferMoney(getSomeAccount(),getSomeAccount(), (int) (Math.random() * 200));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}