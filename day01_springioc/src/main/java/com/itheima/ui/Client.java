package com.itheima.ui;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


//模拟一个表现层，调用业务层
public class Client {

    //获取spring的Ioc核心容器，并根据id获取对象
    public static void main(String[] args) {
        //获取核心容器
       // ApplicationContext ac  = new FileSystemXmlApplicationContext("bean.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        IAccountService as= (IAccountService) ac.getBean("accountService2");
        //IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);

       // System.out.println(as);
       // System.out.println(adao);
        as.saveAccount();

        /*Resource resource= new ClassPathResource("bean.xml");
        BeanFactory factory =new XmlBeanFactory(resource);
        IAccountService as= (IAccountService) factory.getBean("accountService");
        System.out.println(as);*/
    }
}
