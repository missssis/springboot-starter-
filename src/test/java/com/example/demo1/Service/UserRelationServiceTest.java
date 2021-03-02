package com.example.demo1.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRelationServiceTest {

    @Autowired
    private UserRelationService userRelationService;
    @Test
    void print() {
        userRelationService.print();
    }
}
