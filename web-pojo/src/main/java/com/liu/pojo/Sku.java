package com.liu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 * @Description  
 * @Author  LiuGang
 * @Date 2021-06-29 
 */

@Data
@Entity
@Table ( name ="tb_sku" )
public class Sku  implements Serializable {

	private static final long serialVersionUID =  6886595138413330289L;

	/**
	 * sku id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 存储数量
	 */
   	@Column(name = "stock" )
	private Integer stock;

	/**
	 * spu id
	 */
   	@Column(name = "spu_id" )
	private Integer spuId;

	/**
	 * 商品标题
	 */
   	@Column(name = "sku_name" )
	private String skuName;

	/**
	 * 商品的图片，多个图片以‘,’分割
	 */
   	@Column(name = "images" )
	private String images;

	/**
	 * 销售价格，单位为分
	 */
   	@Column(name = "price" )
	private Double price;

   	@Column(name = "spec_list" )
	private String specList;

	/**
	 * sku的特有规格参数键值对，json格式，反序列化时请使用linkedHashMap，保证有序
	 */
   	@Column(name = "spec_list_code" )
	private String specListCode;

	/**
	 * 添加时间
	 */
   	@Column(name = "created_at" )
	private Date createdAt;

	/**
	 * 最后修改时间
	 */
   	@Column(name = "updated_at" )
	private Date updatedAt;

}
