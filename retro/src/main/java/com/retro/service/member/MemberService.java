package com.retro.service.member;

import javax.servlet.http.HttpSession;

import com.retro.domain.member.MemberDTO;

public interface MemberService  {
	// AJAX: ID중복체크
	public int idCheck(String id);
	
	// 회원가입.
	public int create(MemberDTO mDto);
	
	// 로그인
	public boolean login(MemberDTO mDto, HttpSession session);
}
