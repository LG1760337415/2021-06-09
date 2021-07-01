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
@Table ( name ="tb_admin" )
public class Admin  implements Serializable {

	private static final long serialVersionUID =  1495636810946365211L;

   	@Column(name = "id" )
	private Integer id;

   	@Column(name = "created_at" )
	private Date createdAt;

   	@Column(name = "updated_at" )
	private Date updatedAt;

	/**
	 * 账号
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 密码
	 */
   	@Column(name = "password" )
	private String password;

}
