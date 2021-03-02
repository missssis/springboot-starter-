package com.example.demo1.controller;

import com.example.demo1.Entity.Student;
import com.example.demo1.Service.StudentService;
import com.example.demo1.UserJap.UserJpa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
//@Api(tags={"用户接口"})
@Controller
public class UserController {



    @Autowired
    private StudentService studentService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

//    @ApiOperation(value = "查询用户")
//    @GetMapping("userName")
//    public String getUserInfo(){
//
//        Optional<Student> stu = userJpa.findById(1);
//        Student student = stu.get();
//        int id = student.getId();
//        String name = student.getName();
//        log.info("UserController-getUserInfo:出参，{},用户ID",id);
//        log.info("UserController-getUserInfo:出参，{},用户姓名",name);
//        return name;
//    }
//    @ApiOperation(value = "添加用户")
    @GetMapping("adduser")
    public void addUser(HttpServletRequest request) throws IOException {
        String name = request.getParameter("username");
        String age = request.getParameter("age");
        Student student = new Student(name,Integer.parseInt(age));
        studentService.addStu(student);
        log.info("UserController-addUser 添加用户 ");
    }

    @ResponseBody
//    @ApiOperation(value = "修改用户")
    @GetMapping("updateStu/{id}/{age}/{name}")
    public void updateStu(@PathVariable Integer id,@PathVariable Integer age,@PathVariable String name) throws IOException {
        studentService.update(name,age,id);
        log.info("UserController-updateStu 修改用户 ");
    }

    @ResponseBody
    @GetMapping("delStu/{id}")
    public void delStu(@PathVariable Integer id) throws IOException {
        studentService.delStu(id);
        log.info("UserController-delStu 根据id删除用户 ");
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public Student findById(@PathVariable Integer id) throws IOException {
        log.info("UserController-findById 根据id搜索用户 ");
        return studentService.selectById(id);

    }

    @ResponseBody
    @GetMapping("findAll")
    public List<Student> findAll(){
        log.info("UserController-findAll 查询所有用户 ");
        return studentService.selectAllStu();
    }




//    @ApiOperation(value = "返回")
    @GetMapping("/")
    public String toHome(HttpServletRequest request,HttpServletResponse response) throws IOException {

        return "home";
    }
}
