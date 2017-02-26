/**
 * Created by Lenovo on 2017/2/26.
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import mutithreads.*;
//参考链接
// http://www.cnblogs.com/wxd0108/p/5479442.html
public class MutiThreads implements WthInterface{

    public void show()
    {
        //显示该类作用
        System.out.println("=================================================");
        System.out.println("MutiThreads: The Three methods to start a thread.");
        System.out.println("=================================================");

        //显示主线程名称
        System.out.println(Thread.currentThread().getName() + " " + "printed by MutiThreads");

        //实现Runnable接口的线程调用方式
        Thread messageThread1 = new Thread(new RunnableClass());
        messageThread1.start();

        //实现Thread类继承的调用方式
        Thread messageThread2 = new ExtendsThread();
        messageThread2.start();

        //类型改为继承来的子类，代码同样可以正常运行
        ExtendsThread messageThread3 = new ExtendsThread();
        messageThread3.start();

        //如果重载Thread继承类的构造函数，就可以传入具有Runnable接口的对象，不过如果不进行构造函数重载的话就会报错
        //在这种情况下，优先执行ExtendsThreadSuper的run()函数
        //不过注释掉ExtendsThreadSuper的run()，就会执行Runnable对象中的run()函数了
        RunnableClass runnableClass4 = new RunnableClass();
        Thread messageThread4 = new ExtendsThreadSuper(runnableClass4);
        messageThread4.start();

        //用Callable和Future创建线程
        Callable<Integer> callableClass = new CallableClass();    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(callableClass); //使用FutureTask来包装MyCallable对象
        Thread messageThread5 = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
        messageThread5.start();
    }
}