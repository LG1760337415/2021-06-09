package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/23 19:11
 */
@Table(name = "tb_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
//在所有相关的类前加上@JsonIgnoreProperties, 作用是json序列化时忽略bean中的一些属性序列化和反序列化时抛出的异常.
@JsonIgnoreProperties(value = {"handler"})
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//分类ID
    @Column(name="cat_name")
    private String catName;//分类名称
    @Column(name = "parent_id")
    private Integer parentId;

//    @Transient
//    private Category parentCategory;//父分类

    @Transient
//    @JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
    private List<Category> childrenCategories;
}