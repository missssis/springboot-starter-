package com.example.demo1.controller;

import com.example.demo1.Entity.Student;
import com.example.demo1.Service.UserRelationService;
import com.example.demo1.UserJap.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;


@RestController
public class HelloWorldController {
    private Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private UserRelationService userRelationService;

    @Autowired
    private UserJpa userJpa;


    @GetMapping()
    public String index(){
        userRelationService.print();
//        log.info("HelloWorldController-index 测试info");
//        log.debug("HelloWorldController-index 测试debug");
//        log.error("HelloWorldController-index 测试error");
        Student student = new Student("xm",17);
        userJpa.save(student);
        List<Student> stus = userJpa.findAll();
        System.out.println(stus.size());
        return "Hello World!";
    }
}
