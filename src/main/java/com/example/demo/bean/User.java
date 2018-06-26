package com.example.demo.bean;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_user")   // 声明了Person对象的数据表
public class User {

    @Id       // 表示该字段为一个自增长的Id,注意,是数据库表中自增!!
    private int id;

    @NotEmpty(message="用户名不能为空")
    @Name    // 表示该字段可以用来标识此对象，或者是字符型主键，或者是唯一性约束
    private String username;

    @NotEmpty(message="密码不能为空")
    @Length(min=6, message="密码长度不能少于六位")
    @Column      // 表示该对象属性可以映射到数据库里作为一个字段
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}