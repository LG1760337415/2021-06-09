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
@Table ( name ="tb_seckill" )
public class Seckill  implements Serializable {

	private static final long serialVersionUID =  8545885658314450981L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * 商家ID
	 */
   	@Column(name = "seller_id" )
	private Integer sellerId;

	/**
	 * SPUID
	 */
   	@Column(name = "spu_id" )
	private Integer spuId;

	/**
	 * SKUID
	 */
   	@Column(name = "sku_id" )
	private Integer skuId;

	/**
	 * 开始时间
	 */
   	@Column(name = "start_time" )
	private Date startTime;

	/**
	 * 结束时间
	 */
   	@Column(name = "end_time" )
	private Date endTime;

	/**
	 * 库存量
	 */
   	@Column(name = "stock" )
	private Integer stock;

	/**
	 * 秒杀价格
	 */
   	@Column(name = "price" )
	private Double price;

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

}
