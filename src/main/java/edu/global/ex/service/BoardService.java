package edu.global.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

@Service
public interface BoardService {
	public List<BoardVO> getList();

	public BoardVO read(int bid);

	public int modify(BoardVO board);

	public int delete(BoardVO board);

	public void register(BoardVO board);

	public void registerReply(BoardVO board);
	
	//paging
	public int getTotal();
	public List<BoardVO> getListWithPaging(Criteria cri);
}
