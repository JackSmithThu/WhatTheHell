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
        VolatileBank vbank = new VolatileBank();
        session = new Session(vbank);
        thread1 = new Thread(session);
        thread1.start();
        thread2 = new Thread(session);
        thread2.start();
        Thread.currentThread().sleep(100);
    }
}
