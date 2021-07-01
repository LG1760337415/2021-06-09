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
@Table ( name ="tb_specification" )
public class Specification  implements Serializable {

	private static final long serialVersionUID =  1901210687637550646L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * 规格名称
	 */
   	@Column(name = "spec_name" )
	private String specName;

	/**
	 * 分类ID
	 */
   	@Column(name = "category_id" )
	private Integer categoryId;

}
