package threadssynchronized;

import wthinterface.WthInterface;

/**
 * Created by Lenovo on 2017/3/6.
 */
public class ThreadsSynchronized implements WthInterface {
    public void show() throws Exception
    {
        System.out.println("============代码块同步===========");
        CodeBlockBank cbbank = new CodeBlockBank();
        Session session = new Session(cbbank);
        Thread thread1 = new Thread(session);
        thread1.start();
        Thread thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
        System.out.println("============方法同步===========");
        FunctionBank fbank = new FunctionBank();
        session = new Session(fbank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
        System.out.println("============Volatile变量同步===========");
        //发薪资时，会计每次都把员工叫来登记他们的银行卡号；一次会计为了省事，没有即时登记，用了以前登记的银行卡号；刚好一个员工的银行卡丢了，已挂失该银行卡号；从而造成该员工领不到工资
        VolatileBank vbank = new VolatileBank();
        session = new Session(vbank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
        System.out.println("============重入锁同步===========");
        ReentrantLockBank rlbank = new ReentrantLockBank();
        session = new Session(rlbank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
        System.out.println("============局部变量同步===========");
        LocalBank lbank = new LocalBank();
        session = new Session(lbank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
        System.out.println("============原子变量同步===========");
        AtomBank abank = new AtomBank();
        session = new Session(abank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);


    }
}
