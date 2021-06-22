package com.liu.zuul.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.auth.conf.JwtProperties;
import com.liu.auth.pojo.UserInfo;
import com.liu.auth.util.JwtUtils;
import com.liu.pojo.BaseResult;
import com.liu.pojo.ResultCode;
import com.liu.zuul.util.ResponseUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/21 17:11
 */

public class JWTJurisdiction extends ZuulFilter {

    @Autowired
    JwtProperties jwtProperties;
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        try {
            if (!uri.endsWith("auth/login")){
                String token = request.getParameter("token");
                if (token==null||token==""){
                    System.out.println("未携带token。。。");
                    BaseResult result = new BaseResult(ResultCode.NOT_TOKEN,"请求参数必须包含token");
                    ResponseUtil.sendResponse(context,result,200);
                    return null;
                }
//
                UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
                System.out.println(userInfo);
                if (userInfo.getId()==-1){
                    System.out.println("token是无效的");

                    BaseResult result = new BaseResult(ResultCode.ERROR,"token参数有误");
                    ResponseUtil.sendResponse(context,result,200);
                    return null;
                }
                System.out.println("验证通过。。。");
            }
        }catch (Exception e){
            try {
                BaseResult result = new BaseResult(ResultCode.ERROR,"服务器出现问题："+e.getMessage());
                ResponseUtil.sendResponse(context,result,200);
            }catch (Exception e1){
                System.out.println(e1);
            }
            System.out.println(e);
        }
        return null;
    }
}