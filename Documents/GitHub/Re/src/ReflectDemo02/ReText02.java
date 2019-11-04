package ReflectDemo02;

import reflectDemo01.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
1 获取成员变量
Field[] getFields()
Field[] getField(String name ) //这两个方法都是获取类中的public方法


Field[] getDeclaredFields()
Field[] getDeclaredField() //这两个方法是获取所有的方法
 Constructor constructor = personClass.getConstructor(String.class,int.class);
 */

public class ReText02 {
    public static void main(String[] args) throws Exception {
        //0 获取Person的class对象
        Class personClass = Person.class;
        //1。Field[] gerFields()
        Field[] fieleds = personClass.getFields();
        for (Field fieled : fieleds) {
            System.out.println(fieled);
        }
        System.out.println("------------");
        Field a=personClass.getField("a");
        //获取成员变量a的值
        Person p=new Person();
        Object o = a.get(p);
        System.out.println(o);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);
        System.out.println("-----------------");


        Constructor constructor = personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);
        System.out.println("=============");
        Constructor constructor1= personClass.getConstructor();
        System.out.println(constructor1);
        //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        //获取成员方法
        Method eat = personClass.getMethod("eat");
        eat.invoke(new Person());
        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(new Person(),"饭");
        System.out.println("-------");

        //获取所有的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }

        String name = personClass.getName();
        System.out.println(name);


    }
}
