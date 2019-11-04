package ReflectDemo02;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReText01 {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //1.1.创建properties对象

        Properties pro =new Properties();
        //1.2加载配置文件，转化为一个集合
        //1.2.1 获取class目录下配置文件
        ClassLoader classLoader = ReText01.class.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //2,获取配置文件中都定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object o = cls.newInstance();
        //5.获取对象的方法
        Method methodName1 = cls.getMethod(methodName);
        methodName1.invoke(o);

    }
}
