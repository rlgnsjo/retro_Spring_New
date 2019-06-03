package com.retro.persistence.product;

import java.util.List;

import com.retro.domain.product.ProductDTO;

public interface ProductDAO {
	public List<ProductDTO> bestList();  // 베스트상품 위한 추상매서드 생성
	public List<ProductDTO> newList();   // 신상품 위한 추상매서드 생성
	public List<ProductDTO> viewList();  // 조회수 순으로 정렬 
}
