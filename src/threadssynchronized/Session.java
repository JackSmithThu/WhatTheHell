package threadssynchronized;

/**
 * Created by Lenovo on 2017/3/6.
 */
class Session implements Runnable {
    private Bank bank;

    public Session(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // bank.save1(10);
            bank.save(10);
            System.out.println(i + "账户余额为：" + bank.getAccount() + " printed by " + Thread.currentThread().getName());
        }
    }

}
