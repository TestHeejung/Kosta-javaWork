package app.mvc.service;

import java.util.List;

import app.mvc.dao.BoardDAO;
import app.mvc.dao.BoardDAOImpl;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardServiceImpl implements BoardService {
	private static BoardService instance = new BoardServiceImpl();
	
	private BoardDAO boardDAO = BoardDAOImpl.getInstance();
	
	private BoardServiceImpl() {}
	public static BoardService getInstance() {
		return instance;
	}

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		List<BoardDTO> boardList = boardDAO.boardSelectAll();
		if(boardList.size()==0)
			throw new SearchWrongException("게시물에 레코드가 없습니다.^^");
		
		return boardList;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list == null || list.isEmpty()) 
			throw new SearchWrongException(keyWord+"단어를 포함한 레코드의 정보 없습니다.");
		
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if(boardDTO==null)throw new SearchWrongException(boardNo+"해당하는 정보가 없습니다.");
		return boardDTO;
	}

	
	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result==0)throw new DMLException("등록되지않았습니다.^^");

	}
	

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardUpdate(boardDTO);
		if(result==0)throw new DMLException("수정되지 않았습니다.");

	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		int result = boardDAO.boardDelete(boardNo);
		if(result==0)throw new DMLException("삭제되지 않았습니다.");

	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws DMLException  {
	    int result = boardDAO.replyInsert(replyDTO);
		if(result==0)throw new DMLException("댓글 등록에 실패하였습니다.");
	}

	
	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		BoardDTO boardDTO = boardDAO.replySelectByParentNo(boardNo);
		
		if(boardDTO==null)
			throw new SearchWrongException(boardNo+"에 해당하는 부모글 정보가 없습니다.");
		
	    if(boardDTO.getRepliesList().size()==0)
	    	throw new SearchWrongException(boardNo+"에 해당하는 댓글정보가 없습니다.");
		
		return boardDTO;
	}

}




