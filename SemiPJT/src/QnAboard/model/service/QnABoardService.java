package QnAboard.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import QnAboard.model.dao.QnABoardDAO;
import QnAboard.model.vo.Comment;
import QnAboard.model.vo.QnABoard;
import QnAboard.model.vo.PageData;
import common.JDBCTemplate;

public class QnABoardService {
	
	private JDBCTemplate factory;
	
	public QnABoardService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public QnABoard selectNotice(int noticeNo) {
		QnABoard notice = null;
		Connection conn = null;
		QnABoardDAO noticeDAO = new QnABoardDAO();
		try {
			conn = factory.createConnection();
			notice = noticeDAO.selectNotice(conn, noticeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return notice;
		
	}
	public PageData selectList(int currentPage){
		
		ArrayList<QnABoard> noticeList = null;
		Connection conn = null;
		PageData pd = new PageData();
		int recordPerPage = 10;
		int naviCountPerPage= 5;
		
		try {
			 conn = factory.createConnection();
			 
			 // setPageList() 메소드는 10개의 게시물을 저장
			 pd.setPageList(new QnABoardDAO().selectList(conn, currentPage, recordPerPage));
			 // setPageNavi() 메소드는 a링ㅋ으 10개를 저장
			 pd.setPageNavi(new QnABoardDAO().getPageNavi(conn, currentPage,  recordPerPage ,naviCountPerPage));
			//noticeList = new NoticeDAO().selectList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	public PageData noticeSearchList(String search, int currentPage){
			Connection conn = null;
			PageData pd = new PageData();
			int recordCountPerPage = 12;
			int naviCountPerPage = 5;
			
			try {
				conn = factory.createConnection();
				pd.setPageList(new QnABoardDAO().noticeSearchList(conn, search, currentPage, recordCountPerPage));
				pd.setPageNavi(new QnABoardDAO().getSearchPageNavi(conn, currentPage, recordCountPerPage, search, naviCountPerPage));
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			finally {
			JDBCTemplate.close(conn);	
			}
			return pd;
	}
	
	public int insertNotice(String subject, String content, String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnABoardDAO().insertNotice(conn, subject, content, userId);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		// 서비스 클래스에서 하는 역할로 commit/rollback
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}
	public int deleteNotice(int noticeNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new QnABoardDAO().deleteNotice(conn, noticeNo);
			
			if (result > 0) {
				JDBCTemplate.commit(conn);
			}else{
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return result;
	}
	public int modifyNotice(String subject, String content, int noticeNo) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			result = new QnABoardDAO().modifyNotice(conn, subject, content, noticeNo);
			
			if(result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int updateReadCount(int readcount) {
		int result=0;
		Connection conn = null;
		
		try {
			conn =factory.createConnection();
			result = new QnABoardDAO().updateReadCount(conn,readcount);
			
			if(result >0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public Comment commentRe(int commentNo) {
			Comment comment = null;
			Connection conn = null;
			QnABoardDAO noticeDAO = new QnABoardDAO();
			
			try {
				conn=factory.createConnection();
				comment = noticeDAO.commentRe(conn, commentNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(conn);
			}
			return comment;
	}
	public int insertReply(String memberId, String contents, int noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnABoardDAO().insertReply(conn, memberId, contents, noticeNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	
}

