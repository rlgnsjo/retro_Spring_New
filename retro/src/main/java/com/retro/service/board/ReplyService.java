package com.retro.service.board;

import java.util.List;

import com.retro.domain.board.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> list(int bno);
	public void create(ReplyDTO rDto);
	public void delete(ReplyDTO rDto);
	
}
