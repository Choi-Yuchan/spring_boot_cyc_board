package edu.global.ex.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class RestBoardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testBoardsWrite() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBcontent("lol");
		vo.setBname("hi");
		vo.setBtitle("Title");
		
		String jsonStr = new ObjectMapper().writeValueAsString(vo);
		
		log.info(jsonStr);
		
	      mockMvc.perform(post("/boards/")
	              .contentType(MediaType.APPLICATION_JSON)
	              .content(jsonStr))
	           .andExpect(status().is(200))
	           .andDo(MockMvcResultHandlers.print());
	}

}
