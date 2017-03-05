package testreflect;

/**
 * Created by Lenovo on 2017/3/5.
 */
public class TestReflectClass {
    public int attr1;
    private int attr2;

    public TestReflectClass()
    {
         attr1 = 0;
         attr2 = 1;
    }

    public TestReflectClass(int a, int b)
    {
         attr1 = a;
         attr2 = b;
    }

    public void show()
    {
        System.out.println("show() attr1 = " + attr1 + " attr2 = " + attr2);
    }

    public void attrshow(int x, int y)
    {
        System.out.println("attrshow() x = " + x + " y = " + y);
    }

    public String toString() {
        return "TestReflectClass [attr1=" + attr1 + ", attr2=" + attr2 + "]";
    }
}
