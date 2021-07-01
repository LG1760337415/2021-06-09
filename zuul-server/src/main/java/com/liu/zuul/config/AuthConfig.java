package com.liu.zuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 19:32
 */
@Component
@ConfigurationProperties(prefix = "jmit.auth")
public class AuthConfig {
//    @ConfigurationProperties(prefix = "jmit.auth")
    private List<Permission> notNeedToken;
//    @ConfigurationProperties(prefix = "jmit.auth")
    public List<Permission> getNotNeedToken() {
        return notNeedToken;
    }
    public void setNotNeedToken(List<Permission> notNeedToken) {
        this.notNeedToken = notNeedToken;
    }
}
