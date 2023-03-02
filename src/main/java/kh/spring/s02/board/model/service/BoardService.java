package kh.spring.s02.board.model.service;

import java.util.List;

import kh.spring.s02.board.model.vo.BoardVo;

public interface BoardService {
	public int insert(BoardVo vo);
//	public int updateForReply(int boardNum);
	public int update(BoardVo vo);
	public int delete(int boardNum /* BoardVo vo 또는 PK 또는 List<PK> */);
	public BoardVo selectOne(int boardNum, String writer /* PK */);
//	public int updateReadCount(int boardNum);
	public int selectOneCount();
	public List<BoardVo> selectList();	// 전체읽기
	public List<BoardVo> selectList(int currentPage, int limit);	// paging 처리
}