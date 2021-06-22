package com.liu.auth.conf;

import com.liu.auth.util.RsaUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.naming.directory.SearchResult;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Random;

@Data
@ConfigurationProperties(prefix = "jmit.jwt",ignoreInvalidFields = true)
public class JwtProperties {
    private String publicKeyPath;
    private String privateKeyPath;
    private String secret;
    private PublicKey publicKey;
    private PrivateKey privateKey;
//    @Autowired
//    private RedisTemplate redisTemplate;

//    public JwtProperties(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }

    /**
     * 初始化方法
     */
    @PostConstruct
    public void init(){
        try {
//            File file = new File("%temp%");
//            System.out.println(file.exists());
//            secret = (String) redisTemplate.opsForValue().get("secret_"+privateKeyPath);
//            if(secret!=null||secret!=""){
//                Random rd = new Random();
//                生成随机盐
//                secret = rd.nextInt(20)+"";
//         /   }
            File pub = new File(publicKeyPath);
            File pri = new File(privateKeyPath);
            if(!pub.exists() || !pri.exists()){
                pub.getParentFile().mkdirs();
                pri.getParentFile().mkdirs();
                RsaUtils.generateKey(publicKeyPath,privateKeyPath,secret);
            }
            //如果已经存在了，直接取出公钥和私钥
            privateKey = RsaUtils.getPrivateKey(privateKeyPath);
            publicKey = RsaUtils.getPublicKey(publicKeyPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 销毁方法
     */
    @PreDestroy
    public void destroy(){

    }
}