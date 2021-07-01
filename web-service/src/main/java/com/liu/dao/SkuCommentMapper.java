package com.liu.dao;

import com.liu.pojo.SkuComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
@Repository
public interface SkuCommentMapper extends BaseMapper<SkuComment> {
    @Select("select *  from tb_sku_comment where sku_id = #{skuId}")
    List<SkuComment> findBySkuId(Integer skuId);
    @Select("select count(id)  from tb_sku_comment where sku_id = #{skuId}")
    Integer countBySkuId(Integer skuId);

    @Select("select avg(star) from tb_sku_comment where sku_id = #{skuId}")
    Double levelBySkuId(Integer skuId);
}
