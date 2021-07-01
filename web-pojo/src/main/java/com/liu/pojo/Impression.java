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
@Table ( name ="tb_impression" )
public class Impression  implements Serializable {

	private static final long serialVersionUID =  6107037659863683185L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * 印象
	 */
   	@Column(name = "title" )
	private String title;

   	@Column(name = "count" )
	private Integer count;

   	@Column(name = "spu_id" )
	private Integer spuId;

   	@Column(name = "sku_id" )
	private Integer skuId;

}
