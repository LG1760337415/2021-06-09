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
@Table ( name ="tb_category_brand" )
public class CategoryBrand  implements Serializable {

	private static final long serialVersionUID =  4941204519828224995L;

	/**
	 * 商品类目id
	 */
   	@Column(name = "category_id" )
	private Integer categoryId;

	/**
	 * 品牌id
	 */
   	@Column(name = "brand_id" )
	private Integer brandId;

}
