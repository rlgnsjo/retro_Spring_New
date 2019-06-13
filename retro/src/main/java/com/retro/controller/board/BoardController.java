package com.retro.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.retro.domain.board.BoardDTO;
import com.retro.domain.member.MemberDTO;
import com.retro.service.board.BoardService;
import com.retro.service.board.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("board/*") 
public class BoardController {

	@Inject
	private BoardService service; 
	
	
	// 게시글 전체리스트 출력 
	@RequestMapping(value ="list", method =RequestMethod.GET)
	public ModelAndView list(
			@RequestParam(defaultValue = "new") String sort_option, //@RequestParam은 생략 가능하나  defaultValue 작성시 반드시 작성해야함
			@RequestParam(defaultValue = "all") String search_option, // 현재 search_option에 all이 들어감. 
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int curPage ) {						
		log.info(">>>>>>>> 게시글 목록 출력");
		// 레코드 갯수 계산 
		int count = service.countArticle(search_option, keyword); 
		
		// 페이지 관련설정 		
		Pager pager = new Pager(count, curPage); // 상속받은 클래스의 매서드를 매개변수 안에 집어넣어 재정의 오버로딩.
		log.info(">>>>>>>> 게시글 목록 출력");
		int start = pager.getPageBegin();	// 1
		int end = pager.getPageEnd();       // 10
		log.info(">>>>>>>start end!!!>"+start+">>>>>>>>>>>>"+end);
		
		// 페이지에 출력할 게시글 목록
		List<BoardDTO> list = service.listAll(sort_option, search_option, keyword, start, end);
		// list boardimpl에 전부 담아줌.
		ModelAndView mav = new ModelAndView(); // 페이지이동과 url 경로를 같이 해주는것! 
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list); 
		map.put("count", count);
		map.put("pager", pager);
		map.put("sort_option", sort_option);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
				
		
		mav.setViewName("board/viewtable"); // 전송할 페이지 경로 modelandview가 아니면 return 으로보냄.
		mav.addObject("map", map);   // 애드어튜리뷰트와 동일한기능.
		
		return mav;
	}

	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(int bno, Model model, HttpSession session) {
		log.info(">>>>>>>>상세 게시글 출력");
		
		service.increaseViewCnt(bno, session);
		BoardDTO bDto = service.read(bno); // 서비스read에서 받은 값을 bDto에 뿌려줌.
		
	    model.addAttribute("one", bDto);
	  
	    
		return "board/replyboard";  // 반환활 jsp 주소값
	}
	
	// 게시글 등록 페이지 출력
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createView() {
		log.info("게시글 등록 페이지 출력");
		
		return "board/register";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPlay(BoardDTO bDto) {
		log.info("게시글 등록 페이지 출력! 실제입력!");
		service.create(bDto);
		
		
		return "redirect:/board/list"; 
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateView() {
		
				
		return "board/modify"; 
	}
	
}
