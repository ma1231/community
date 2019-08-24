package com.itheima.ssm.controller;

import com.itheima.domain.SysLog;
import com.itheima.service.impl.SysLogServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogServiceImpl sysLogService;

    private Date visitTime;
    private Class clazz;
    private Method method;

    @Before("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visitTime = new Date();
        clazz = jp.getTarget().getClass();//得到要访问的类
        String methodName = jp.getSignature().getName();//得到方法名
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    @After("execution(* com.itheima.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        long time = new Date().getTime() - visitTime.getTime();
        String url = null;
        RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
        RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
        if (clazzAnnotation != null && methodAnnotation != null) {
            url = clazzAnnotation.value()[0] + methodAnnotation.value()[0];
        }
        String ip = request.getRemoteAddr();
        String username = (String) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        SysLog sysLog=new SysLog();
        sysLog.setIp(ip);
        sysLog.setVisitTime(visitTime);
        sysLog.setExecutionTime(time);
        sysLog.setIp(url);
        sysLog.setUsername(username);
        sysLog.setMethod("类名"+clazz.getName()+"方法名"+method.getName());
        sysLogService.save(sysLog);
    }
}
