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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public void addUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        Student student = new Student(name,1);
        studentService.addStu(student);
//        PrintWriter pw = response.getWriter();
//        pw.write("true");
//        pw.flush();
//        pw.close();
    }
//    @ApiOperation(value = "查询用户")
    @ResponseBody
    @PostMapping("findAllStu")
    public String findAllStu(HttpServletRequest request,HttpServletResponse response) throws IOException {
       List<Student> students = studentService.selectAllStu();
        for (Student student:students) {
            System.out.println(student);
        }
        return students.toString();
    }
//    @ApiOperation(value = "修改用户")
    @GetMapping("updateStu")
    public String updateStu(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if(id!=null&&id!=""){
            int userid= Integer.parseInt(id);
            String username = request.getParameter("username");
            studentService.update(username,userid);
        }

        return "wait";
    }


//    @ApiOperation(value = "返回")
    @GetMapping("/")
    public String toHome(HttpServletRequest request,HttpServletResponse response) throws IOException {

        return "updateStu";
    }
}
