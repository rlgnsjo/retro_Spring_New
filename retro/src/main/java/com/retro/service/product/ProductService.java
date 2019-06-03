package com.retro.service.product;

import java.util.HashMap;
import java.util.List;

import com.retro.domain.product.ProductDTO;

public interface ProductService {
	// 베스트 상품과 신상품 목록 
	public  HashMap<String, List<ProductDTO>> productList();  // 베스트상품
	
}
