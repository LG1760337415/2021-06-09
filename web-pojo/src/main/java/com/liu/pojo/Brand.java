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
@Table ( name ="tb_brand" )
public class Brand  implements Serializable {

	private static final long serialVersionUID =  1418106250074959945L;

	/**
	 * 品牌id
	 */
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 品牌名称
	 */
   	@Column(name = "brand_name" )
	private String brandName;

	/**
	 * 品牌图片地址
	 */
   	@Column(name = "logo" )
	private String logo;

}
