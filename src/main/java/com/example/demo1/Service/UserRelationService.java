package com.example.demo1.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;



@Service
@PropertySource("classpath:db.properties")
public class UserRelationService {
    private Logger logger =  LoggerFactory.getLogger(UserRelationService.class);
    @Value("${avatarPath}")
    private  String avatar;

    @Value("${jdbc.user}")
    private  String user;

    public void print(){
//        System.out.println(avatar);
//        System.out.println(user);
        logger.info("打印变量："+avatar);
        logger.error("打印变量："+user);
    }

}
