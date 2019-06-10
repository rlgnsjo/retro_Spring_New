package com.retro.service.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.retro.domain.board.BoardDTO;
import com.retro.persistence.board.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bDao;
	
	
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
		
		return bDao.listAll(sort_option, search_option, keyword, start, end);
	}

	@Override
	public void increaseViewCnt(int bno, HttpSession session) {
		
		
	}

	@Override
	public int countArticle(String search_option, String keyword) {	
		return bDao.countArticle(search_option, keyword);
	}

}
