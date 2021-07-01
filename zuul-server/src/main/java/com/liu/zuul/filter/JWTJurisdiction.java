package com.liu.zuul.filter;
import com.liu.auth.conf.JwtProperties;
import com.liu.auth.pojo.UserInfo;
import com.liu.auth.util.JwtUtils;
import com.liu.entity.BaseResult;
import com.liu.entity.ResultCode;
import com.liu.zuul.config.AuthConfig;
import com.liu.zuul.config.Permission;
import com.liu.zuul.util.ResponseUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        String method = request.getMethod();
        try {
            if (isNeedToken(uri,method)){
                String token = request.getHeader("Authorization");
//                String token = request.getParameter("token");
                if (token==null||token==""){
                    System.out.println("未携带token。。。");
                    BaseResult result = new BaseResult(ResultCode.NOT_TOKEN,"请求参数必须包含token");
                    ResponseUtil.sendResponse(context,result,200);
                    return null;
                }
                UserInfo userInfo = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
                System.out.println(userInfo);
//                if (userInfo.getId()==-1){
//                    System.out.println("token是无效的");
//
//                    BaseResult result = new BaseResult(ResultCode.ERROR,"token参数有误");
//                    ResponseUtil.sendResponse(context,result,200);
//                    return null;
//                }
                System.out.println("验证通过。。。");
            }
        }catch (MalformedJwtException e){
            try {
                BaseResult result = new BaseResult(ResultCode.FAILURE_OF_THE_TOKEN,"token验证出错，原因是："+e.getMessage());
                ResponseUtil.sendResponse(context,result,403);
            }catch (Exception e1){
                System.out.println(e1);
            }
        } catch (ExpiredJwtException e){
            try {
                BaseResult result = new BaseResult(ResultCode.FAILURE_OF_THE_TOKEN,"token失效了，请重新获取！");
                ResponseUtil.sendResponse(context,result,403);
            }catch (Exception e1){
                System.out.println(e1);
            }
        }catch (Exception e){
            try {
                BaseResult result = new BaseResult(ResultCode.ERROR,"服务器出现问题："+e.getMessage());
                ResponseUtil.sendResponse(context,result,500);
            }catch (Exception e1){
                System.out.println(e1);
            }
            System.out.println(e);
        }
        return null;
    }
    @Autowired
    AuthConfig authConfig;

    /**
     * 权限验证，返回false表示不需要token，true表示需要token
     * @param uri
     * @return
     */
    public boolean isNeedToken(String uri,String method){
        System.out.println("uri:"+uri);
        //除去多余的斜杠
        String[] uris = disposeUri(uri);
        List<Permission> notNeedToken = authConfig.getNotNeedToken();
//        if (uri.endsWith("auth/login"))
//            return false;

        for (Permission permission:notNeedToken){
            boolean isAllow = false;
            int n = 0;
            String[] strs = disposeUri(permission.getPath());
            for (int i = 0;i<uris.length;i++){
                if(strs[i].equalsIgnoreCase("**")){
                    isAllow = true;
                    break;
                }else if (!uris[i].equalsIgnoreCase(strs[i]))
                    break;
                else
                    n++;
                if (n==uris.length){
                    isAllow = true;
                    break;
                }
            }
            if (isAllow&&method.equalsIgnoreCase(permission.getMethod())){
                return false;
            }
        }
        return true;
    }

    private String[] disposeUri(String uri){
        uri = uri.replaceAll("//+","/");
        uri = uri.replaceAll("///+","/");
        int i = uri.indexOf("/");
        if (i==0)
            uri = uri.substring(1,uri.length());
        return uri.split("/");
    }
}