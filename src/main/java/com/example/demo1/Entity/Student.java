package com.example.demo1.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "com.biancheng.auth.param.AddUserParam", description = "新增用户参数")
@Entity
//@Table(name = "user") // 不配置为驼峰
@Table
public class Student {
    @ApiModelProperty(value = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value = "名称")
    @Column
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer old;

    public Student() {
    }

    public Student(String name, Integer old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", old=" + old +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }
}
