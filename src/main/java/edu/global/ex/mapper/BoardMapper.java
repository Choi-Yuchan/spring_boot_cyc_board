package edu.global.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.global.ex.page.Criteria;
import edu.global.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> getList();
	public BoardVO read(int bid);
	public int update(BoardVO board);
	public int delete(BoardVO board);
	public void insert(BoardVO board);
	public void updateShape(BoardVO board);
	public void insertReply(BoardVO board);
	
	//paging
	public int getTotalCount();
	public List<BoardVO> getListWithPaging(Criteria cri);
}
