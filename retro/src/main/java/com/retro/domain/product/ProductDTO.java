package com.retro.domain.product;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 기본생성자
@Getter  // getter()
@Setter  // setter()
@ToString // toString()
public class ProductDTO {
	private String p_code;	
	private String p_name; 
	private int p_price; 
	private String p_img; 
	private String p_type; 
	private int p_cnt; 
	private int p_good;
	private Date p_indate;
}


