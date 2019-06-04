package com.retro.persistence.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.retro.domain.member.MemberDTO;



@Repository  // 해당 class가 dao작업을 하는 class 라는것을 명시!
public class MemberDAOImpl implements MemberDAO{

	@Inject 
	private SqlSession sqlSession;
	
	@Override
	public int idCheck(String id) {
		
		return sqlSession.selectOne("member.idCheck", id);
	}
	@Override
	public int create(MemberDTO mDto) {
		
		return sqlSession.insert("member.create", mDto);
	}
	@Override
	public String login(MemberDTO mDto) {
		return sqlSession.selectOne("member.login", mDto);	
		
	}
	@Override
	public MemberDTO viewMember(String id) {
		
		return sqlSession.selectOne("member.viewMember", id);
	}

}
