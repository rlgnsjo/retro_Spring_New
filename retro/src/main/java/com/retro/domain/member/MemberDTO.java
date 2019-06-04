package com.retro.domain.member;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor  // 기본생성자 생성
@AllArgsConstructor  // 전체생성자 생성
@Getter   // getter
@Setter  // setter
@ToString  // tostring
public class MemberDTO {  //   DTO의 변수값과 input 태그의 name값이 같아야함. 
	private String id;  
	private String pw; 
	private String name; 
	private String phone; 
	private String email; 
	private String zipcode; // 우편주소 
	private String addr1;  // 주소
	private String addr2;  // 상세주소
	private Date regdate; 
}
