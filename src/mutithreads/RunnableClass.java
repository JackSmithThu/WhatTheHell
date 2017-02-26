package mutithreads;

/**
 * Created by Lenovo on 2017/2/26.
 */
public class RunnableClass implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + "printed by Class impl Runable");
    }
}
