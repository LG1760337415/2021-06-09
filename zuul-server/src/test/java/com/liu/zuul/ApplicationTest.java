package com.liu.zuul;

//import com.liu.zuul.config.AuthConfig;
import com.liu.zuul.config.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 19:22
 */
//@SpringBootTest
public class ApplicationTest {



//    @Test
    public static void  main(String[] args){
        String str1 = "//web/news";
        String str2 = "//web/news";

        String[] strs1 = disposeUri(str1);
        System.out.println(Arrays.toString(strs1));
//
//        String[] strs2 = disposeUri(str2);
//        System.out.println(Arrays.toString(strs2));
//        for (int i = 0;i<strs2.length;i++){
//            System.out.print(strs2[i]+"---"+strs2[i]+" ");
//            System.out.println(strs2[i].equalsIgnoreCase(strs1[i]));
//            if (strs2[i].equalsIgnoreCase(strs1[i]))
//                System.out.println("op");
//            else if (strs2[i].equalsIgnoreCase("**")){
//                System.out.println("op");
//            }
//        }
    }
    private static String[] disposeUri(String uri){
        uri = uri.replaceAll("//+","/");
        uri = uri.replaceAll("///+","/");
        int i = uri.indexOf("/");
        if (i==0)
            uri = uri.substring(1,uri.length());
        System.out.println(uri);
        return uri.split("/");
    }
}
