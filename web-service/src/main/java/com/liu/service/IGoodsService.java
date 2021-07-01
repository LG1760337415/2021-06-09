package com.liu.service;

import com.liu.entity.SkuResult;

public interface IGoodsService {
    SkuResult findByGoodsId(Integer id);
}
