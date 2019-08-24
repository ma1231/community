package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//创建Bean对象的工厂
//Bean:有可重用组件的含义
//JavaBean > 实体类 ，含义：用Java语言编写的可重用组件
//创建service和dao对象的
//1.需要一个配置文件来配置service和dao
//2.通过读取配置文件中的内容，反射创建对象
//  配置内容：唯一标识=全限定类名（key=value）
//  xml和properties
public class BeanFactory {
    private static Properties props;

    private static Map<String, Object> beans;

    static {
        try {
            props = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
            props.load(in);
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //根据bean的名称获取bean对象
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
