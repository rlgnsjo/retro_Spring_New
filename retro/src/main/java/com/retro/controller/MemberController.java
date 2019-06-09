package com.retro.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)  // 로그인정보가 session에 담아있으니
		public void logout(HttpSession session){	            	 // session 부분만 확인하면된다.		
		log.info(">>>>>>>로그아웃");
		service.logout(session);
		
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
			/* rttr.addFlashAttribute("message", "1회성 데이터"); */
			return "redirect:/";
		} else {
			log.info("가입 실패!");
			return "/member/constract";
		}
				
	}
		
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpSession session, Model model) {
		log.info(">>>>>>>>회원 수정페이지 출력");
				
		MemberDTO mDto = service.viewMember(session);
	    model.addAttribute("one", mDto);
	 
		return "member/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePlay(MemberDTO mDto, HttpSession session) {  // 주소값 반환위해 String 사용!
		log.info(">>>>>>>>회원 수정성공.");
		log.info(mDto.toString());
		service.update(mDto, session);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/pwupdate", method = RequestMethod.GET)
	public String pwUpdateView() {
		log.info(">>>>>>>>비밀번호 수정페이지 출력");
					 
		return "member/pwupdate";
		
	}
	@RequestMapping(value = "/pwupdate", method = RequestMethod.POST)
 	public String pwUpdatePlay(MemberDTO mDto) {
		log.info(">>>>>>>>비밀번호 수정페이지 출력");
			
		service.pwUpdate(mDto);
		return "redirect:/";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/pwcheck", method = RequestMethod.POST)
	public String pwCheck(MemberDTO mDto) {
		
		log.info(">>>>>>>>AJAX 현재 비밀번호 체크");
		
		String result = service.pwCheck(mDto);
		// id => 현재 로그인 유저의 id
		// pw => 사용자가 입력한 현재 비밀번호값
		// DB에 등록되있는 비밀번호값
					 
		return result;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteView() {
		log.info(">>>>>>>>회원 삭제페이지 출력");
		
		
		return "member/member_delete";
	}
	
	@RequestMapping(value = "/deleteplay", method = RequestMethod.GET)
	public String deletePlay(HttpSession session) {
		log.info(">>>>>>>>회원 삭제액션");
		 service.delete(session);
		return "redirect:/";
	}

}
