package edu.global.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		log.info("getList()..");

		return boardMapper.getList();
	}

	@Override
	public BoardVO read(int bid) {
		log.info("read()..");

		return boardMapper.read(bid);
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify()..");

		return boardMapper.update(board);
	}

	@Override
	public int delete(BoardVO board) {
		log.info("delete()..");
		return boardMapper.delete(board);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register()..");

		boardMapper.insert(board);
	}

	@Transactional
	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply()..");
		
		boardMapper.updateShape(board);
		boardMapper.insertReply(board);
	}

	@Override
	public int getTotal() {
		log.info("getTotal()..");
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		log.info("getListWithPaging()..");
		return boardMapper.getListWithPaging(cri);
	}

}
