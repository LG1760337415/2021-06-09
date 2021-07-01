package com.liu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 * @Description  
 * @Author  LiuGang
 * @Date 2021-06-29 
 */

@Data
@Entity
@Table ( name ="tb_order_good" )
public class OrderGood  implements Serializable {

	private static final long serialVersionUID =  9199249411667084824L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * 订单ID
	 */
   	@Column(name = "sn" )
	private Integer sn;

	/**
	 * SKUID
	 */
   	@Column(name = "sku_id" )
	private Integer skuId;

	/**
	 * 购买数量
	 */
   	@Column(name = "number" )
	private Integer number;

	/**
	 * 规格列表
	 */
   	@Column(name = "spec_list" )
	private String specList;

	/**
	 * 商品名称
	 */
   	@Column(name = "sku_name" )
	private String skuName;

	/**
	 * 图片
	 */
   	@Column(name = "logo" )
	private String logo;

	/**
	 * 价格
	 */
   	@Column(name = "price" )
	private Double price;

}
