package app.mvc.service;

import java.util.List;

import app.mvc.dao.BoardDAO;
import app.mvc.dao.BoardDAOImpl;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
/**
 * @author 
 * */
public class BoardServiceImpl implements BoardService {
	private static BoardService instance = new BoardServiceImpl();
	private BoardDAO boardDao = BoardDAOImpl.getInstance();
			
	private BoardServiceImpl() {}
    public static BoardService getInstance() {
		return instance;
	}
    
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		List<BoardDTO> list = boardDao.boardSelectAll();
		
		if(list.isEmpty())
			throw new SearchWrongException("검색된 레코드가 없습니다.");
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		int result = boardDao.boardInsert(boardDTO);
		if(result==0)
			throw new DMLException("등록되지않았습니다.");

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		

	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		
		return null;
	}

}











