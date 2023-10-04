package edu.global.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class RestBoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public List<BoardVO> list() {
		log.info("list()..");
		return boardService.getList();
	}

	@GetMapping("/list_view")
	public ModelAndView list_view() {

		log.info("ModelAndView board() ..");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board/rest_list");

		return mv;
	}

	@DeleteMapping("/{bid}")
	public int boards_delete(BoardVO boardVO) {
		
		log.info("boards_delete() ..");

		int rn = boardService.delete(boardVO);

		return rn;
	}
	
	//@RequestBody = JSON을 Java객체로 넣어주는 Anotation
	@PostMapping("/")
	public String boards_write(@RequestBody BoardVO boardVO) {
		
		log.info("boards_write() .." + boardVO);

		boardService.register(boardVO);
		
		return "SUCCESS";
	}	
	
}
