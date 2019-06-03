package com.retro.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.retro.service.member.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "member/*") // 리퀘스트 맵핑을 클래스 위에 작성해줘서 member의 경로를 위에서 한번만 작성해준다.
public class MemberController {
	
	@Inject
	private MemberService service; 
	
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
	
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		log.info(">>>>>>>>회원 가입 페이지 출력");
		return "member/member_join";
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
