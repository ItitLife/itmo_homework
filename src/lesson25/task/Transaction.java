package lesson25.task;

public class Transaction implements Runnable {
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // TODO перевод денежных средств со счета src на счет dst
        //  в количестве money

        synchronized (src) {
            synchronized (dst) {
                if (src.getId() != dst.getId()) {
                    if (src.getBalance() >= money) {
                        src.setBalance(src.getBalance() - money);
                        dst.setBalance(dst.getBalance() + money);
                        System.out.println("С аккаунта " + src.getId() + " на аккаунт " + dst.getId() + " переведено: " +
                                money);
                    } else {
                        System.out.println("На аккаунте " + src.getId() + " недостаточно средств");
                    }
                } else {
                    System.out.println("Нельзя проводить транзакции на одном аккаунте");
                }
            }
        }
    }
}