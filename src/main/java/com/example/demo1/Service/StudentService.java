package com.example.demo1.Service;

import com.example.demo1.Dao.StudentDao;
import com.example.demo1.Entity.Student;
import com.example.demo1.UserJap.UserJpa;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @ApiOperation("添加用户")
    public void addStu(Student student){
        studentDao.addStu(student);
    }

    @ApiOperation("修改用户")
    public void update(String name ,Integer age, int id){
        studentDao.updateStu(name,age,id);
    }
//
    @ApiOperation("删除用户")
    public void delStu(int id){
        studentDao.deleteById(id);
    }
    @ApiOperation("查询所有用户")
    public List<Student> selectAllStu(){

        return studentDao.findAllStu();
    }
    @ApiOperation("根据id查询学生")
    public Student selectById(int id){
        return  studentDao.findById(id);
    }


}
