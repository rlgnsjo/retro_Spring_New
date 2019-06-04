package com.retro.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.retro.domain.member.MemberDTO;
import com.retro.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "member/*") // 리퀘스트 맵핑을 클래스 위에 작성해줘서 member의 경로를 위에서 한번만 작성해준다.
public class MemberController {
	
	@Inject
	private MemberService service; 
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO mDto, HttpSession session) {
		log.info(">>>>>>>> AJAX:로그인");
		
		boolean result = service.login(mDto, session);  // boolean 논리 자료형이니 true와 false만 들어감.
		String flag ="-1";
		if(result) {
			flag ="1";
		}
		
		return flag;
	}
	
	
	
	
	
	@RequestMapping(value = "/constract", method = RequestMethod.GET)
	public String constract() {
		log.info(">>>>>>>>회원가입 동의");
		return "member/constract";  
	}	
	
	@ResponseBody // return 값을 순수 데이터로 인식.
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public int idcheck(String id) {
		log.info("AJAX:ID 중복체크");		 		
		return service.idCheck(id);
	}
	
	// 회원가입 페이지 출력
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createview() {
		log.info(">>>>>>>>회원 가입 페이지 출력");
		return "member/member_join";
	}
	
	// DB를 통한 회원가입 액션 .
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createplay(MemberDTO mDto) {
		
		log.info(">>>>>>>>DB를 통한 회원 가입 액션");
		
		log.info(mDto.toString());
		
		int result = service.create(mDto);
		
		if (result > 0) {
			log.info("가입 성공!");
			return "redirect:/";
		} else {
			log.info("가입 실패!");
			return "/member/constract";
		}
				
	}
	

	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		log.info(">>>>>>>>회원 수정.");
		return "";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		log.info(">>>>>>>>회원 삭제.");
		return "";
	}

}
