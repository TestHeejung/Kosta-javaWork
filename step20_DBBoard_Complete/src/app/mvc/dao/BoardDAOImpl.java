package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAO instance = new BoardDAOImpl();
	/**
	 * 외부에서 객체생성 막음.
	 * */
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			//?가 있다면 ps.setXxx(); 
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("subject"), 
						rs.getString("writer"), rs.getString("content"),
						rs.getString("board_date"));
				
				list.add(dto);
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException("전체검색에 예외가 발생했습니다. 다시 조회해주세요.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}
	
	
	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		String sql= "select * from board where upper(subject) like upper(?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%"); // 
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
							
				//BoardDTO를 list에 추가한다.
				list.add(dto);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("제목에 해당하는 정보 조회에 문제 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
		
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		BoardDTO boardDTO=null;
		String sql= "select * from board where board_no = ? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);//
			
			rs = ps.executeQuery();//select * from board where board_no = 5 
			
			//컬럼의 정보를(컬럼개수,컬럼타입,컬럼이름) 가져온다
			ResultSetMetaData rsm = rs.getMetaData();
			int count = rsm.getColumnCount();
			for(int i=1; i <=count; i++) {
			   String columNam = rsm.getColumnName(i);
			   System.out.println(columNam);
		
			}
			
			if(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getString(4), rs.getString(5));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("글번호에 해당하는 정보를 검색하는데 문제가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return boardDTO;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into board ( subject, writer, content, board_date)"
				+ " values ( ?, ?, ?, now())";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			result = ps.executeUpdate();// db쪽으로 쿼리르 전송
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("등록하는데 오류가 발생하여 등록되지 않았습니다."); 
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException { //
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update board set content = ?,board_date=now() where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new DMLException("정보를 수정하는데 장애가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from board where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("먼저 삭제하려는 글의 댓글을 삭제 한후 삭제해주세요.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}



	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException { //댓글내용, 부모글번호
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into reply(reply_content,board_no ,reply_regdate) "
				+ "values( ?, ? , now())";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo()); //댓글 작성하려는 부모글의 글번호 
			
			result = ps.executeUpdate();
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("댓글 등록에 장애가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}


	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		BoardDTO boardDTO=null;
		String sql= "select * from board where board_no=? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getString(4), rs.getString(5));
				
				//댓글번호를 검색한다.
				List<ReplyDTO> replyList = this.replySelect(con, boardNo);
				boardDTO.setRepliesList(replyList);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("부모글 정보조회에 오류가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return boardDTO;
	}
	/**
	 * 부모글에 해당하는 댓글정보를 검색하는 메소드
	 * */
	private List<ReplyDTO> replySelect(Connection con, int boardNo)throws SQLException{
		 PreparedStatement ps =null;
		 ResultSet rs =null;
		 List<ReplyDTO> repliesList = new ArrayList<>();
		 String sql="select * from reply where board_no=?";
		 
		 
		 
		try {
		    ps = con.prepareStatement(sql);
		    ps.setInt(1, boardNo);
		    
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	ReplyDTO reply = 
		    		new ReplyDTO(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4));
		    	repliesList.add(reply);
		    }
		
		}finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return repliesList;
	}

}






