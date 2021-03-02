package com.example.demo1.Dao;


import com.example.demo1.Entity.Student;
import com.example.demo1.UserJap.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class StudentDao {

    @Autowired
    private UserJpa userJpa;

    public void addStu(Student student){
        userJpa.save(student);
    }

    public void updateStu(String name,int id){
        Student student = userJpa.findById(id).get();
        student.setName(name);
        userJpa.save(student);
    }

    public void deleteById(int id){
        userJpa.deleteById(id);
    }

    public List<Student> findAllStu(){
        List<Student> students = userJpa.findAll();
        return students;
    }

    public Student findById(int id){
        Student student = userJpa.findById(id).get();
        return student;
    }
}
