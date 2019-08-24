package com.itheima.ssm.controller;

import com.itheima.domain.SysLog;
import com.itheima.service.impl.SysLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    SysLogServiceImpl sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<SysLog> sysLogList=sysLogService.findAll();
        mv.addObject("sysLogs",sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
