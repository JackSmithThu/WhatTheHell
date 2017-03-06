package threadssynchronized;

/**
 * Created by Lenovo on 2017/3/6.
 */
public class FunctionBank implements Bank {
    private int account = 100;

    public int getAccount() {
        return account;
    }

    /**
     * 用同步方法实现
     *
     * @param money
     */
    public synchronized void save(int money) {
        account += money;
    }
}
