package com.retro.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.retro.domain.board.BoardDTO;
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
			@RequestParam(defaultValue = "all") String search_option,
			@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int curPage ) {						
		log.info(">>>>>>>> 게시글 목록 출력");
		// 레코드 갯수 계산 
		int count = service.countArticle(search_option, keyword);
		
		// 페이지 관련설정 		
		Pager pager = new Pager(count, curPage);
		log.info(">>>>>>>> 게시글 목록 출력");
		int start = pager.getPageBegin();	
		int end = pager.getPageEnd();
		log.info(">>>>>>>start end!!!>"+start+">>>>>>>>>>>>"+end);
		
		// 페이지에 출력할 게시글 목록
		List<BoardDTO> list = service.listAll(sort_option, search_option, keyword, start, end);
		
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("sort_option", sort_option);
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		
				
		
		mav.setViewName("board/viewtable");
		mav.addObject("map", map);  
		
		return mav;
	}
	
	
}
