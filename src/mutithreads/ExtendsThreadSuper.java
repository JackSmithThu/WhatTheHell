package mutithreads;

/**
 * Created by Lenovo on 2017/2/26.
 */
public class ExtendsThreadSuper extends Thread{

    public ExtendsThreadSuper(Runnable runnable){
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + "printed by Extended Thread");
    }
}

