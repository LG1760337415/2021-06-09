package com.liu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/10 9:56
 */

@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="face")
    private String face;

    @Column(name="expriece")
    private Integer expriece;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private String mobile;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    //对应着数据库中没有的列，存储到数据库中不会保存进去
    @Transient
    private String code;
    @Transient
    private String repassword;
}
