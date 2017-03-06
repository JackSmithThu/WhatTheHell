package threadssynchronized;

import java.util.concurrent.locks.*;

/**
 * Created by Lenovo on 2017/3/6.
 */
class ReentrantLockBank implements Bank {

    private int account = 100;
    //需要声明这个锁
    private Lock lock = new ReentrantLock();

    public int getAccount() {
        return account;
    }

    //这里不再需要synchronized
    public void save(int money) {
        lock.lock();
        try {
            account += money;
        } finally {
            lock.unlock();
        }

    }
}