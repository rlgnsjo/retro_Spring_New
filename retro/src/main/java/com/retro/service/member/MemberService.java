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
	
	public void logout(HttpSession session);
	
	// 현재로그인 회원정보 1건 검색
	public MemberDTO viewMember(HttpSession session);
}
