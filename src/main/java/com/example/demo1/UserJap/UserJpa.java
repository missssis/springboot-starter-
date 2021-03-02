package com.example.demo1.UserJap;

import com.example.demo1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Student,Integer> {

}
