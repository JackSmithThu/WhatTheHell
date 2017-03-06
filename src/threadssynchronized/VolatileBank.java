package threadssynchronized;

/**
 * Created by Lenovo on 2017/3/6.
 */
public class VolatileBank implements Bank{
    //需要同步的变量加上volatile
    private volatile int account = 100;

    public int getAccount() {
        return account;
    }
    //这里不再需要synchronized
    public void save(int money) {
        account += money;
    }
}
