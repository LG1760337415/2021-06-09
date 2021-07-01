package com.liu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table ( name ="tb_spu" )
public class Spu  implements Serializable {

	private static final long serialVersionUID =  4115880652576529399L;

	/**
	 * spu id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 标题
	 */
   	@Column(name = "spu_name" )
	private String spuName;

	/**
	 * 子标题
	 */
   	@Column(name = "spu_subname" )
	private String spuSubname;

   	@Column(name = "logo" )
	private String logo;

	/**
	 * 1级类目id
	 */
	@Transient
   	@Column(name = "cat1_id" )
	private Category cat1;

	/**
	 * 2级类目id
	 */
	@Transient
   	@Column(name = "cat2_id" )
	private Category cat2;

	/**
	 * 3级类目id
	 */
	@Transient
   	@Column(name = "cat3_id" )
	private Category cat3;

	/**
	 * 商品所属品牌id
	 */
   	@Column(name = "brand_id" )
	private Integer brandId;

	/**
	 * 审核时间
	 */
   	@Column(name = "check_time" )
	private Date checkTime;

	/**
	 * 审核状态，0：未审核，1：已通过，2：未通过
	 */
   	@Column(name = "check_status" )
	private Integer checkStatus;

	/**
	 * 商品价格，单位：元
	 */
   	@Column(name = "price" )
	private Double price;

	/**
	 * 是否上架 0 未上架 1 上架
	 */
   	@Column(name = "is_on_sale" )
	private Integer isOnSale;

	/**
	 * 上架时间
	 */
   	@Column(name = "on_sale_time" )
	private Date onSaleTime;

	/**
	 * 删除时间
	 */
   	@Column(name = "deleted_at" )
	private Date deletedAt;

	/**
	 * 重量
	 */
   	@Column(name = "weight" )
	private Double weight;

	/**
	 * 商品详情
	 */
   	@Column(name = "description" )
	private String description;

	/**
	 * 包装
	 */
   	@Column(name = "packages" )
	private String packages;

	/**
	 * 售后
	 */
   	@Column(name = "aftersale" )
	private String aftersale;

	/**
	 * 规格列表
	 */
   	@Column(name = "spec_list" )
	private String specList;

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
