package threadssynchronized;

/**
 * Created by Lenovo on 2017/3/6.
 */
public class CodeBlockBank implements Bank {

    private int account = 100;

    public int getAccount() {
        return account;
    }

    /**
     * 用同步代码块实现
     *
     * @param money
     */
    public void save(int money) {
        synchronized (this) {
            account += money;
        }
    }
}
