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
@Table ( name ="tb_sku_photo" )
public class SkuPhoto  implements Serializable {

	private static final long serialVersionUID =  5152651935028460120L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * SPUID
	 */
   	@Column(name = "sku_id" )
	private Integer skuId;

	/**
	 * 原图路径
	 */
   	@Column(name = "url" )
	private String url;

}
