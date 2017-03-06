package testreflect; /**
 * Created by Lenovo on 2017/3/5.
 */

import testreflect.*;
import wthinterface.WthInterface;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.lang.reflect.Array;

public class TestReflect implements WthInterface {
    public void show() throws Exception {
        //获得对象类型名称
        System.out.println("==========获得对象类型名称==========");
        TestReflectClass trc = new TestReflectClass();
        System.out.println(trc.getClass().getName());

        //实例化类对象的三种方法
        System.out.println("==========实例化类对象的三种方法==========");
        //方法1：这里需要抛出异常，否则会报错

        Class<?> class1 = null;
        class1 = Class.forName("testreflect.TestReflectClass");
        System.out.println("类名称   " + class1.getName());


        //方法2
        Class<?> class2 = null;
        class2 = new TestReflectClass().getClass();
        System.out.println("类名称   " + class2.getName());

        //方法3
        Class<?> class3 = null;
        class3 = TestReflectClass.class;
        System.out.println("类名称   " + class3.getName());


        //更深入的操作
        System.out.println("=============== clazz ===============");
        Class<?> clazz = null;

        clazz = Class.forName("testreflect.TestReflectClass");
        System.out.println("类名称   " + clazz.getName());


        // 取得父类
        Class<?> parentClass = clazz.getSuperclass();
        System.out.println("clazz的父类为：" + parentClass.getName());

        // 获取所有的接口
        Class<?> intes[] = clazz.getInterfaces();
        System.out.println("clazz实现的接口有：");
        for (int i = 0; i < intes.length; i++) {
            System.out.println((i + 1) + "：" + intes[i].getName());
        }

        //获取一个类的全部属性
        System.out.println("===============本类属性===============");
        // 取得本类的全部属性
        Field[] field = clazz.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }

        System.out.println("==========实现的接口或者父类的属性==========");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = clazz.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }

        //获取一个类的所有方法
        System.out.println("==========该类的所有方法==========");
        Method method[] = clazz.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        //获取全部构造函数
        System.out.println("==========获取全部构造函数==========");
        Constructor<?> cons[] = clazz.getConstructors();
        // 查看每个构造方法需要的参数
        for (int i = 0; i < cons.length; i++) {
            Class<?> clazzs[] = cons[i].getParameterTypes();
            System.out.print("cons[" + i + "] (");
            for (int j = 0; j < clazzs.length; j++) {
                if (j == clazzs.length - 1)
                    System.out.print(clazzs[j].getName());
                else
                    System.out.print(clazzs[j].getName() + ",");
            }
            System.out.println(")");
        }


        //构建对象
        System.out.println("==========构建对象==========");
        Object obj1 = cons[0].newInstance();
        System.out.println(obj1);
        Object obj2 = cons[1].newInstance(3, 4);
        System.out.println(obj2);

        //通过反射修改属性
        System.out.println("==========通过反射修改属性==========");
        Field ClzAttr1 = clazz.getDeclaredField("attr1");
        ClzAttr1.setAccessible(true);
        ClzAttr1.set(obj1, 5);
        System.out.println("obj1 attr1 = " + ClzAttr1.get(obj1));

        //通过反射调用方法
        System.out.println("==========通过反射调用方法==========");
        Method Clzmethod = clazz.getMethod("show");
        Clzmethod.invoke(clazz.newInstance());
        Clzmethod = clazz.getMethod("attrshow", int.class, int.class);
        Clzmethod.invoke(clazz.newInstance(), 6, 7);


        System.out.println("==========通过反射在泛型为Integer的ArrayList中存放一个String类型的对象==========");
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method Arrmethod = list.getClass().getMethod("add", Object.class);
        Arrmethod.invoke(list, "Add String to ArrayList<Integer>");
        System.out.println(list.get(0));

        System.out.println("==========通过反射取得并修改数组的信息==========");
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));

        System.out.println("==========通过反射修改数组的大小==========");
        int[] temp1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newTemp = (int[]) arrayInc(temp1, 15);
        print(newTemp);
        String[] atr = {"a", "b", "c"};
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);


    }

    // 修改数组大小
    public static Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    // 打印数组
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
        System.out.println();
    }
}
