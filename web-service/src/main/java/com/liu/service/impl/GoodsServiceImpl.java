package com.liu.service.impl;

import com.liu.dao.SkuCommentMapper;
import com.liu.dao.SkuMapper;
import com.liu.dao.SpuMapper;
import com.liu.entity.SkuResult;
import com.liu.pojo.Sku;
import com.liu.pojo.Spu;
import com.liu.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/7/1 9:34
 */
@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    SkuMapper skuMapper;
    @Autowired
    SpuMapper spuMapper;
    @Autowired
    SkuCommentMapper skuCommentMapper;

    @Transactional(readOnly = true,propagation = Propagation.REQUIRED)
    @Override
    public SkuResult findByGoodsId(Integer id) {
        SkuResult skuResult = new SkuResult();
        skuResult.setSkuId(id);
        //根据Id查询sku
        Sku sku = skuMapper.findById(id);
        Spu spu = spuMapper.findById(sku.getSpuId());
//        System.out.println(spu);
        //给Id赋值
        skuResult.setSpuId(sku.getSpuId());
        //库存
        skuResult.setStock(sku.getStock());
        //给分类赋值
        skuResult.setCat3Info(spu.getCat3());
        skuResult.setCat2Info(spu.getCat3());
        skuResult.setCat1Info(spu.getCat1());
        //售后
        skuResult.setAfterSale(spu.getAftersale());
        //商品名称
        skuResult.setGoodsName(sku.getSkuName());
        //
        skuResult.setOnSaleDate(spu.getOnSaleTime());
        //价格
        skuResult.setPrice(sku.getPrice());
        //描述
        skuResult.setDescription(spu.getDescription());
        //获取评论数量
        skuResult.setCommentCount(skuCommentMapper.countBySkuId(sku.getId()));
        //获取评论等级
        Integer level = (int) Math.round(skuCommentMapper.levelBySkuId(sku.getId()));
        skuResult.setCommentLevel(level);
        //查询规格
        return skuResult;
    }
}