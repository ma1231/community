package cn.itcast.mybatis.io;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String xmlPath){
        return Resources.class.getClassLoader().getResourceAsStream(xmlPath);
    }
}
