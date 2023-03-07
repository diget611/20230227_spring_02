package kh.spring.s02.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.s02.board.model.dao.BoardDao;
import kh.spring.s02.board.model.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao; 
	
	@Override
	public int insert(BoardVo vo) {
		if(vo.getBoardNum() != 0) {
			dao.updateForReply(vo.getBoardNum());
		}
		return dao.insert(vo);			
	}

	@Override
	public int update(BoardVo vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(int boardNum) {
		return dao.delete(boardNum);
	}

	@Override
	public BoardVo selectOne(int boardNum, String writer) {
//		작성자가 읽으면 조회수 증가가 안 되도록
		BoardVo result = dao.selectOne(boardNum);
		if(result != null && !result.getBoardWriter().equals(writer)) {
			dao.updateReadCount(boardNum);
		} 
		return result;
		
//		if(dao.updateReadCount(boardNum) > 0) {
//			return dao.selectOne(boardNum);			
//		} else {
//			return null;
//		}
	}

	@Override
	public int selectOneCount() {
		return dao.selectOneCount();
	}
	
	@Override
	public int selectOneCount(String searchWord) {
		return dao.selectOneCount(searchWord);
	}

	@Override
	public List<BoardVo> selectList() {
		return dao.selectList();
	}

	@Override
	public List<BoardVo> selectList(int currentPage, int limit) {
		return dao.selectList(currentPage, limit);
	}

	@Override
	public List<BoardVo> selectList(int currentPage, int boardLimit, String searchWord) {
		return dao.selectList(currentPage, boardLimit, searchWord);
	}

}
