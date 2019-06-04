package com.retro.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.retro.controller.MemberController;
import com.retro.domain.member.MemberDTO;
import com.retro.persistence.member.MemberDAO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO mDao;
	
	
	@Override
	public int idCheck(String id) {
		
		return mDao.idCheck(id);
	}

	@Override
	public int create(MemberDTO mDto) {
		// 비즈니스 로직을 처리하는부분.
		// 비즈니스로직: 회원가입
		// 회원가입을 하기위해서는 DB를 사용해야함.		
		return mDao.create(mDto);
	}

	@Override
	public boolean login(MemberDTO mDto, HttpSession session) {
		// 비즈니스로직  [세션은 서비스에서만 사용됨.]
		//1) 기존DB에 있던 ID와 PW가 현재입력되는 값이 매칭되는치 check
		//2) Check 가 맞으면 (로그인 성공) => session에 담음
		//3) Check가 틀리면 (로그인 실패) => modal창에 경고문 출력
		
		String name = mDao.login(mDto); 
		boolean result = false;
		if (name != null) { // 로그인 성공
			// session에 로그인 정보를 담음.
			// id, name만 담음.
			session.removeAttribute("userid");
			session.removeAttribute("name");
			session.setAttribute("userid", mDto.getId()); //session에 값을담아 view부분에 출력시킴.
			session.setAttribute("name", name);
			result = true;
			log.info("session>" + session.getAttribute("name"));
			
		}
		
		return result;
	}

	@Override
	public void logout(HttpSession session) {
		// 세션 초기화
		session.invalidate();  // 세션초기화 변수.
		
		
	}

	@Override
	public MemberDTO viewMember(HttpSession session) {
	 String id = (String)session.getAttribute("userid");
	 MemberDTO mDto = mDao.viewMember(id);
		
		
		return mDto;
	}

}
