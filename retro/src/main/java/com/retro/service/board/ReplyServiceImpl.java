package com.retro.service.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retro.domain.board.ReplyDTO;
import com.retro.persistence.board.BoardDAO;
import com.retro.persistence.board.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	private ReplyDAO rDao;
	
	@Inject  // 의존성 주입은 각각에 하나씩 들어와야함.
	private BoardDAO bDao;
	
	
	@Override
	public List<ReplyDTO> list(int bno) {
		
		return rDao.list(bno);
	}
	
	@Transactional
	@Override
	public void create(ReplyDTO rDto) {
		// 비즈니스 로직 정리
		// 1)댓글 등록 
		 rDao.create(rDto);
	    // 2) 해당 게시글 replycnt +1 
		HashMap<String, Object> map = new HashMap<>();
		map.put("flag", "plus");
		map.put("bno", rDto.getBno());
		 
		bDao.updateReplyCnt(map);
	}

	@Transactional
	@Override
	public void delete(ReplyDTO rDto) {
		// 비즈니스 로직 정리
		// 1)댓글 삭제  
		rDao.delete(rDto.getRno());
		//2) 해당 게시글 replycnt -1
		HashMap<String, Object> map = new HashMap<>();
		map.put("flag", "minus");
		map.put("bno", rDto.getBno());
		 
		bDao.updateReplyCnt(map);
		
	}

}
