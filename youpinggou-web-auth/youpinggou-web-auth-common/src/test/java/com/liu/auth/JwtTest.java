package com.liu.auth;

import com.liu.auth.pojo.UserInfo;
import com.liu.auth.util.JwtUtils;
import com.liu.auth.util.RsaUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "D:\\rsa\\pub.rsa";

    private static final String priKeyPath = "D:\\rsa\\pri.rsa";

    private PublicKey publicKey;

    private PrivateKey privateKey;
    @Test
    public void testGenerateRsa() throws Exception {
//        RsaUtils.generateKey(pubKeyPath,priKeyPath,"d2123dfadsf");
    }

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20, "jack"),
                privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6NDksInVzZXJuYW1lIjoiYWRtaW4iLCJleHAiOjE2MjQyNzU4Mzh9.iLJw2nbBkecYowEBUGDo1q-ZC5op86w-3d-GwN7QsZVZfXvblitwN7RrsVZ-bsbOi5vlrGsRzmWOWrYpMTCeJ3b9HPe6oEx25rhZHijfLX_ZuYkFMm4nQr4iy6726EuVA5IdjeGuYTIAC7EdMXyiLSqI_8lcsJORE_5GMJ3NAHw";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}