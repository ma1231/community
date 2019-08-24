package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.impl.OrderServiceImpl;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    /*@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Orders> orders=orderService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("ordersList",orders);
        mv.setViewName("orders-list");
        return mv;
    }
*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(
            @RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
            @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        List<Orders> orders=orderService.findAll(page,size);
        ModelAndView mv=new ModelAndView();
        //分页Bean
        PageInfo pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Orders orders=orderService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }



}
