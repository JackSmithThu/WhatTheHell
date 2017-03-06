package threadssynchronized;
import java.util.concurrent.atomic.*;
/**
 * Created by Lenovo on 2017/3/6.
 */
class AtomBank implements Bank {

//    AtomicInteger类常用方法：
//    AtomicInteger(int initialValue) : 创建具有给定初始值的新的AtomicInteger
//    addAddGet(int dalta) : 以原子方式将给定值与当前值相加
//    get() : 获取当前值


    private AtomicInteger account = new AtomicInteger(100);

    public AtomicInteger AgetAccount() {
        return account;
    }

    public int getAccount() {
        return AgetAccount().get();
    }

    public void save(int money) {
        account.addAndGet(money);
    }
}