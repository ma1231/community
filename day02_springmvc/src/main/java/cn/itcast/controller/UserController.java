package cn.itcast.controller;


import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("执行力");
        User user=new User();
        user.setUsername("ma");
        user.setPassword("123");
        user.setAge(30);

        model.addAttribute("user",user);

        return "success";
    }

    @RequestMapping("/testString")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行力");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

    }
}
