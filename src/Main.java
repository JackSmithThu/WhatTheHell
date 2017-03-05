import java.lang.reflect.Method;

public class Main {


    public static void main(String[] args) throws Exception {

        //String ClassName = "MutiThreads";
        String ClassName = "TestReflect";
        Class<?> aClass = Class.forName(ClassName);
        Object obj = aClass.newInstance();
        Method aMethod = aClass.getMethod("show");
        aMethod.invoke(obj);
    }
}