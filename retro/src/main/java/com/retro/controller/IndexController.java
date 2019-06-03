package com.retro.controller;



import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retro.domain.product.ProductDTO;
import com.retro.service.product.ProductService;

import lombok.extern.slf4j.Slf4j;



@Controller // 컨트롤러 생성시 객체권한을 넘기기 위한 어노테이션 작성.
@Slf4j  // 롬복설치시 추가되는 어노테이션!
public class IndexController {
	
	@Inject  // 의존성주입.
	private ProductService service;
	
	
	@RequestMapping("/")  // 경로 설정 어노테이션!
	public String index(Model model) {
		log.info(">>>>>>>> Index 페이지");
		HashMap<String, List<ProductDTO>> map = service.productList();	
		
		model.addAttribute("pLists", map);  // plsts에는 현재 총12개의 사진이 걸려있음.
		                                    
		
		return "index";
	}
	
}
