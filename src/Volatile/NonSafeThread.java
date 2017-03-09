package Volatile;

/**
 * Created by Lenovo on 2017/3/9.
 */
public class NonSafeThread implements Runnable {

    /** 共享资源, 每个线程执行完之后加 1 */
    private volatile int volatileCount = 0;

    public void run() {

        /*
         * 每个线程调用sum100()方法，1000次
         */
        System.out.println( Thread.currentThread().getName() + "  =========== increase:  ==========");
        for (int i = 1; i <= 1000; i++) {
            sum100();
        }

        /*
         * 计算完毕之后， volatileCount 加 1
         */

        increase();
        System.out.println( Thread.currentThread().getName() + "  =========== increase end:  ==========");
    }

    private void increase()
    {
        volatileCount++;
    }

    /**
     * 对 1 到 100 求和
     */
    private int sum100() {
        //System.out.println("=========== sum100:  ==========");
        int result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }
        return result;
    }

    /**
     * @return the volatileCount
     */
    public int getVolatileCount() {
        return volatileCount;
    }

}
