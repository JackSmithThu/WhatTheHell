package mutithreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Lenovo on 2017/2/26.
 */
public class CallableClass implements Callable<Integer> {
    //public int i = 0;
    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        System.out.println(Thread.currentThread().getName() + " " + "printed by Class impl Callable");
        return sum;
    }

}