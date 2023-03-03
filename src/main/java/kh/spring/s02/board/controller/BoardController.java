package kh.spring.s02.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.board.model.service.BoardService;
import kh.spring.s02.board.model.vo.BoardVo;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	private final static int BOARD_LIMIT = 5;
	private final static int PAGE_LIMIT = 3;
	
	@GetMapping("/list")
	public ModelAndView viewListBoard(ModelAndView mv) {
		// TODO : 검색 단어는 제목, 내용, 작성자에 포함되어 있으면 찾기
		// null 또는 ""은 검색하지 않음
//		String searchWord = "";
		String searchWord = null;
//		String searchWord = "bb";
		int currentPage = 1;
		int totalCnt = service.selectOneCount(searchWord);
		int totalPage = (totalCnt % BOARD_LIMIT == 0) ? (totalCnt / BOARD_LIMIT) : (totalCnt / BOARD_LIMIT) + 1;
		int startPage = (currentPage % PAGE_LIMIT == 0) ? ((currentPage / PAGE_LIMIT) - 1) * PAGE_LIMIT + 1
														: (currentPage / PAGE_LIMIT) * PAGE_LIMIT + 1;
		int endPage = startPage + PAGE_LIMIT - 1 > totalPage ? totalPage : startPage + PAGE_LIMIT - 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("total", totalPage);
		map.put("current", currentPage);
		map.put("start", startPage);
		map.put("end", endPage);
		
		
		mv.addObject("list", service.selectList(currentPage, BOARD_LIMIT, searchWord));
		mv.addObject("paging", map);
		mv.setViewName("board/list");
		
		return mv;
	}
	
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@GetMapping("/insert")
	public ModelAndView viewInsertBoard(ModelAndView mv) {
		// jsp로 보낼 자료가 있으면 ModelAndView로 아니면 String 추천
		// void로 지정시 어노테이션에 지정한 url과 동일한 값을 가진 jsp로 이동
		
		mv.setViewName("board/insert");

		return mv;
	}
	
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	@PostMapping("/insert")
	@GetMapping("/inserttest")
	public ModelAndView doInsertBoard(ModelAndView mv, BoardVo vo) {
		vo.setBoardContent("111");
		vo.setBoardTitle("111");
		vo.setBoardWriter("user11");
		
		int result = service.insert(vo);
		return mv;
	}

	@GetMapping("/update")
	public void viewUpdateBoard() {
	}
	
//	@PostMapping("/update")
	@GetMapping("/updatetest")
	public void updateBoard() {
		int boardNum = 1;
		String title = "수정제목";
		String content = "수정내용";
		String boardOriginalFilename = "";	// "" -> 파일없음
		String boardRenameFilename = "";	// "" -> 파일없음
		
		BoardVo vo = new BoardVo();
		vo.setBoardTitle(title);
		vo.setBoardContent(content);
		vo.setBoardOriginalFilename(boardOriginalFilename);
		vo.setBoardRenameFilename(boardRenameFilename);
		
		int result = service.update(vo);
		
	}
	
	@GetMapping("/delete")
	public void viewDeleteBoard() {
		int boardNum = 10;
		int result = service.delete(boardNum);
	}
	
	@GetMapping("/read")
	public void viewReadBoard() {
		int boardNum = 1;
		String writer = "user22";
		BoardVo result = service.selectOne(boardNum, writer);
	}
	
	// 답글 작성
	@GetMapping("/insertReply")
	public ModelAndView viewInsertReply(ModelAndView mv, int boardNum) {
		// 몇 번글의 답글인가?
		return mv;
	}
	
//	@PostMapping("/insertReply")
	@GetMapping("/insertReplytest")
	public ModelAndView insertReply(ModelAndView mv, BoardVo vo) {
		int boardNum = 4;
		vo.setBoardNum(boardNum);
		vo.setBoardContent("4444답글");
		vo.setBoardTitle("4444답글");
		vo.setBoardWriter("user11");
		
		service.insert(vo);
		return mv;
	}
	
	
	
	/*
	 * do와 post를 한 번에 다 처리하는 방식
	 * @RequestMapping(value = "/test")
	 * @RequestMapping("/test")
	 * public ModelAndView test(ModelAndView mv) {
	 * 		mv.setViewName("redirect:/boardinsert");
	 * 		return mv;
	 * }
	 */
}
