package com.retro.persistence.member;

import com.retro.domain.member.MemberDTO;

public interface MemberDAO {
	public int idCheck(String id);
	
	public int create(MemberDTO mDto);
	
	public String login(MemberDTO mDto);

}
