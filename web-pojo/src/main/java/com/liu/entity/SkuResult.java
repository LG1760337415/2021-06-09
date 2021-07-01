package com.liu.entity;

import com.liu.pojo.Category;
import com.liu.pojo.Sku;
import com.liu.pojo.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/29 10:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkuResult{
    public class Logo{
        private String smlogo;
        private String bigimg;
        private String xbiglogo;
    }
    private Integer skuId;
    private Integer spuId;
    private String goodsName;//商品名称
    private Double price;//价格
    private Date onSaleDate;//上架时间
    private Integer commentCount;//评论数量
    private Integer commentLevel;//评论级别（1-5）
    private Category cat1Info;//
    private Category cat2Info;//
    private Category cat3Info;//

    private Logo logo;
    private List<Logo> photos;
    private String description;//描述
    private String afterSale;//售后
    private Integer stock;//库存量
    private List<Specification> specList;//规格
    private List<Map<String,String>> skuList;//所有的排列组合对应它的skuid


//    private I

    /**
     * skuid:"SKUID",
     *     spuid:"SPUID",
     *     goods_name:"商品名称",
     *     price:"价格",
     *     on_sale_date:"上架时间",
     *     comment_count:"评论数量",
     *     comment_level:"评论级别(1-5)",
     *     cat1_info:{
     *         id:"分类ID",
     *         cat_name:"分类名称"
     *     },
     *     cat2_info:{
     *         id:"分类ID",
     *         cat_name:"分类名称"
     *     },
     *     cat3_info:{
     *         id:"分类ID",
     *         cat_name:"分类名称"
     *     },
     *     logo:{// 默认首张大图
     *         smlogo:"小LOGO(50x50)",
     *         biglogo:"大LOGO(350x350)",
     *         xbiglogo:"超大LOGO(800x800)"
     *     },
     *     photos:[// 其余的当前商品图片
     *         {
     *             smimg:"商品图片(50x50)",
     *             bigimg:"商品图片(350x350)",
     *             xbigimg:"商品图片(800x800)"
     *         }
     *         ...
     *     ],
     *     description:"商品描述",
     *     aftersale:"售后",
     *     stock:"库存量",
     *     spec_list:[
     *         {
     *             id:"规格ID",
     *             spec_name:"规格名称",
     *             options:[
     *                 {
     *                     id:"选项ID",
     *                     option_name:"选项名称"
     *                 }
     *                 ...
     *             ]
     *         }
     *         ...
     *     ],
     *     spec_info:{ //当前sku的排列组合（当前商品信息）
     *      	id_list:'规格ID:选项ID|规格ID:选项ID|...',
     *                 // 1:2|2:6|3:10 --->唯一  通过这个唯一的标识可以确认这个商品
     *         id_txt:'规格名称:选项名称|规格名称:选项名称|...'
     *               // 颜色：亮黑|内存：64g|网络制式:全网通
     *     },
     *     sku_list:[// 所有的排列组合对应它的skuid
     *         {
     *             skuid:"SKUID",
     *             id_list:'规格ID:选项ID|规格ID:选项ID|...'
     *                    //1:2|2:6|3:10  skuid    颜色：亮黑|内存：64g|网络制式:全网通
     *                    //1:1|2:6|3:10  skuid    颜色：红|内存：64g|网络制式:全网通
     *         }
     *         ...
     *     ]
     *  }
     */
}
