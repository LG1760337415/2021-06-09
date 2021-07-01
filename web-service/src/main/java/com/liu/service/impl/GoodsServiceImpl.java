package com.liu.service.impl;

import com.liu.dao.SkuMapper;
import com.liu.entity.SkuResult;
import com.liu.pojo.Sku;
import com.liu.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public SkuResult findByGoodsId(Integer id) {
        SkuResult skuResult = new SkuResult();
        skuResult.setSkuId(id+"");
        Sku sku = skuMapper.findById(id);
        skuResult.setSpuId(sku.getSpuId()+"");

        return skuResult;
    }
}
