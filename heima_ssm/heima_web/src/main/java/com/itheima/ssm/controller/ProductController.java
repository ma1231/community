package com.itheima.ssm.controller;

import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    //产品保存
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    //产品查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Product> ps=productService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("productList",ps);
        mv.setViewName("product-list");
        return mv;
    }
}
