package com.liu.zuul.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.BaseResult;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/22 10:37
 */
public class ResponseUtil {
    public static void sendResponse(RequestContext context, BaseResult result,Integer statusCode) throws IOException {
        HttpServletResponse response = context.getResponse();
        response.setHeader("Content-Type","application/json;charset=utf-8");
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(statusCode);
        ObjectMapper objectMapper = new ObjectMapper();
        //将对象序列化为json字符串
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); //忽略为null的字段
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
//                    context.setResponseBody(json);
//                    context.setres
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.flush();

    }
}
