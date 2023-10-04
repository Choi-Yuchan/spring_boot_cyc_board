package edu.global.ex.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardVOTest {

	@Test
	void testBoardVO() {
		BoardVO board = new BoardVO();
		board.setBid(10);
		
		assertEquals(10, board.getBid());
		
		System.out.println(board.getBid());
	}

}
