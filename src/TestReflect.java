/**
 * Created by Lenovo on 2017/3/5.
 */
import testreflect.*;
public class TestReflect implements WthInterface {
    public void show()
    {
        TestReflectClass trc = new TestReflectClass();
        System.out.println(trc.getClass().getName());
    }
}
