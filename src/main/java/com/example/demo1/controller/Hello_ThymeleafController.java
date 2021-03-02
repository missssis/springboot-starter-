package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping()
public class Hello_ThymeleafController {

    @GetMapping("/home")
    public String toHello(HttpServletResponse response) throws IOException {
//        response.sendRedirect("hello.html");
        return "hello";
    }

    @GetMapping("/page")
    public void toPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("hello.html");
    }

}
