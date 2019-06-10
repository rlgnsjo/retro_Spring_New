package com.retro.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;








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
			log.info("session >" + session.getAttribute("name"));
			
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

	@Override
	public String pwCheck(MemberDTO mDto) {
		// id => DB에서 가져온 현재 비밀번호와
		// pw => 사용자가 입력한 현재 비밀번호가 
		// 같은지 체크해서
		// 같으면 1, 틀리면 -1을 view 단으로 전송
		String name = mDao.login(mDto);
		String result = "-1";
		
		if (name != null) {
			result = "1";
		}
						
		return result;
	}

	@Override
	public void pwUpdate(MemberDTO mDto) {
		//DB에 있는 비밀번호를  수정 
		// data id, pw => mDto
		mDao.pwUpdate(mDto);
	}

	@Override
	public void update(MemberDTO mDto, HttpSession session) {
		// 비즈니스 로직 
		//1) 회원정보 수정
		int result = mDao.update(mDto);
		//2) 회원정보 수정 성공하면
		// -session의 name 값을 수정한 이름으로 변경
						
		if (result > 0) {
			session.setAttribute("name", mDto.getName());
		}		
	}

	@Override
	public void delete(HttpSession session) {
		// 비즈니스 로직
		// 1) 회원삭제 
		// -id 필요 => seesion
		// 2) 삭제 성공시 세션값을 초기화
		String id = (String)session.getAttribute("userid");
		int result = mDao.delete(id);
		
		if (result > 0) {
			session.invalidate();  // 세션값 무효화
		}
	}

}
