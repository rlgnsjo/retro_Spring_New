package com.retro.service.product;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.retro.domain.product.ProductDTO;
import com.retro.persistence.product.ProductDAO;

// 실제 Service를 동작하는 class에는 @Service를 추가해야함.
@Service
public class ProductServiceImpl implements ProductService{
	
	@Inject
	private ProductDAO pDao;
	
	@Override
	public HashMap<String,List<ProductDTO>> productList() {
		//DB에 있는 베스트 상품과 신상품을
		//받아서 Index로 전달.
		List<ProductDTO> bList = pDao.bestList();
		List<ProductDTO> nList = pDao.newList();
		List<ProductDTO> vList = pDao.newList();
		
		HashMap<String,List<ProductDTO>> map = new HashMap<>();
		map.put("bList",bList);
		map.put("nList",nList);
		map.put("vList",vList);
		
		
		return map;
	}

}
