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
	public int create(BoardDTO bDto) {
		return sqlSession.insert("board.create", bDto);
		
	}

	@Override
	public void update(BoardDTO bDto) {
		
		
	}

	@Override
	public void delete(int bno) {
		
		
	}

	@Override
	public BoardDTO read(int bno) {
		
		return sqlSession.selectOne("board.read", bno);	
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
	public void increaseViewCnt(int bno) {
		
		sqlSession.update("board.increaseViewCnt", bno);
	}

	@Override
	public int countArticle(String search_option, String keyword) { // all ""
		Map<String, String> map = new HashMap<>(); // key value 한쌍으로감. DTO list도 담아서 보낼수 있음. 
		//Map<String, String> map = new HashMap<>(); =  다형성은 상속이나 구현받은 클래스만 사용가능 
		// 다형성을 사용할 경우 하나의 타입으로 여러가지 타입으로 사용이 가능.
	
		map.put("search_option", search_option);  
		map.put("keyword", "%"+keyword+"%"); //"%"+keyword+"%" = "%%"
		
		return sqlSession.selectOne("board.countArticle", map); // 쿼리문의 한줄만 조회. 단건하나이니 resulttype = int
	}

	@Override
	public void updateReplyCnt(HashMap<String, Object> map) {
		sqlSession.update("board.updateReplyCnt", map);
		
		
	}

}
