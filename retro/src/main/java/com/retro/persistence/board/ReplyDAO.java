package com.retro.persistence.board;

import java.util.List;

import com.retro.domain.board.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> list(int bno);
	public void create(ReplyDTO rDto);
	public void delete(ReplyDTO rDto);
	
}
