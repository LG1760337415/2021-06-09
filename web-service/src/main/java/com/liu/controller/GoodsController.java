package com.liu.controller;

import com.liu.entity.BaseResult;
import com.liu.entity.ResultCode;
import com.liu.entity.SkuResult;
import com.liu.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/7/1 9:29
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;
    @GetMapping("/{id}")
    public BaseResult findByGoodsId(@PathVariable Integer id){
        SkuResult sku = goodsService.findByGoodsId(id);
        return new BaseResult(ResultCode.SUCCESS,"查询成功",sku);
    }
}
