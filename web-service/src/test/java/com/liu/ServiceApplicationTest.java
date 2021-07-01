package com.liu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.dao.CategoryMapper;
import com.liu.pojo.Category;
import com.liu.pojo.User;
import com.liu.service.ICategoryService;
import com.liu.service.IUserService;
import org.antlr.stringtemplate.language.Cat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/16 17:04
 */
@SpringBootTest
public class ServiceApplicationTest {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IUserService userService;
    @Test
    public void testB() throws JsonProcessingException {
//        Category category = new Category();
        System.out.println("......");
        List<Category> list = categoryService.findOneStair();
        Category category = list.get(0);

        ObjectMapper objectMapper = new ObjectMapper();
        //将对象序列化为json字符串
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //忽略为null的字段
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
//        System.out.println(category);
//        print(category);
        System.out.println(json);
    }

    public void print(Category category){
        System.out.println(category+"\t");
        List<Category> list = category.getChildrenCategories();
        if (list.size()==0)
            return;
        for (Category c:list){
            print(c);
        }

    }
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void testA(){
        redisTemplate.opsForValue().set("mn",12);
        System.out.println(redisTemplate.opsForValue().get("mn"));
    }
}