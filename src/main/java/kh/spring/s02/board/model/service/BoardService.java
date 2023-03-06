package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVo;

// Service 역할 - Transaction 기능. Dao의 여러 메소드를 하나의 기능으로 묶어서 처리
public interface BoardService {
	public int insert(BoardVo vo);
//	public int updateForReply(int boardNum);
	public int update(BoardVo vo);
	public int delete(int boardNum /* BoardVo vo 또는 PK 또는 List<PK> */);
	public BoardVo selectOne(int boardNum, String writer /* PK */);
//	public int updateReadCount(int boardNum);
	public int selectOneCount();
	public int selectOneCount(String searchWord);
	public List<BoardVo> selectList();	// 전체읽기
	public List<BoardVo> selectList(int currentPage, int limit);	// paging 처리
	public List<BoardVo> selectList(int currentPage, int boardLimit, String searchWord);
}
