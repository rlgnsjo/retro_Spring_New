package com.retro.persistence.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.retro.domain.board.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject 
	private SqlSession sqlSession;  //SqlSession은 데이터타입명으로써 session은 변수명이다.
	
	@Override
	public void create(BoardDTO bDto) {
		
		
	}

	@Override
	public void update(BoardDTO bDto) {
		
		
	}

	@Override
	public void delete(int bno) {
		
		
	}

	@Override
	public BoardDTO read(int bno) {
		
		return null;
	}

	@Override
	public List<BoardDTO> listAll(String sort_option, String search_option, String keyword, int start, int end) {
		Map<String, Object> map = new HashMap<>();
		map.put("sort_option", sort_option);
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
				
	
		return sqlSession.selectList("board.listAll", map);
	}

	@Override
	public void increaseViewCnt(int bno, HttpSession session) {
		
		
	}

	@Override
	public int countArticle(String search_option, String keyword) {
		Map<String, String> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", "%"+keyword+"%");
		
		return sqlSession.selectOne("board.countArticle", map);
	}

}
