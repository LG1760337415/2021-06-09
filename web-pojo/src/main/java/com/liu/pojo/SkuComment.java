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
@Table ( name ="tb_sku_comment" )
public class SkuComment  implements Serializable {

	private static final long serialVersionUID =  4960734671281488445L;

   	@Column(name = "id" )
	private Integer id;

   	@Column(name = "created_at" )
	private Date createdAt;

   	@Column(name = "updated_at" )
	private Date updatedAt;

	/**
	 * 用户ID
	 */
   	@Column(name = "user_id" )
	private Integer userId;

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
	 * 0好评 1  中评   2 差评 
	 */
   	@Column(name = "ratio" )
	private String ratio;

	/**
	 * 规格列表
	 */
   	@Column(name = "spec_list" )
	private String specList;

	/**
	 * 评论内容，最大600个字符
	 */
   	@Column(name = "content" )
	private String content;

	/**
	 * 打分，1~5分
	 */
   	@Column(name = "star" )
	private Integer star;

	/**
	 * 0 显示 1 不显示
	 */
   	@Column(name = "isshow" )
	private Integer isshow;

   	@Column(name = "sn" )
	private String sn;

}
