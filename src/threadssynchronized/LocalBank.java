package threadssynchronized;

/**
 * Created by Lenovo on 2017/3/6.
 */
public class LocalBank implements Bank{
    //使用ThreadLocal类管理共享变量account

//    ThreadLocal 类的常用方法
//    ThreadLocal() : 创建一个线程本地变量
//    get() : 返回此线程局部变量的当前线程副本中的值
//    initialValue() : 返回此线程局部变量的当前线程的"初始值"
//    set(T value) : 将此线程局部变量的当前线程副本中的值设置为value

    private static ThreadLocal<Integer> account = new ThreadLocal<Integer>()
    {
        @Override
        protected Integer initialValue(){
            return 100;
        }
    };
    public void save(int money){
        account.set(account.get()+money);
    }
    public int getAccount(){
        return account.get();
    }
}
