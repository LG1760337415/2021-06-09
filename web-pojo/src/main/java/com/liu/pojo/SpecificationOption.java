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
@Table ( name ="tb_specification_option" )
public class SpecificationOption  implements Serializable {

	private static final long serialVersionUID =  6352857056070827010L;

   	@Column(name = "id" )
	private Integer id;

	/**
	 * 规格ID
	 */
   	@Column(name = "spec_id" )
	private Integer specId;

	/**
	 * 选项名称
	 */
   	@Column(name = "option_name" )
	private String optionName;

}
