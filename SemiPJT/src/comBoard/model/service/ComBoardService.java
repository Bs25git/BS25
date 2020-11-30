package comBoard.model.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import comBoard.model.dao.ComBoardDAO;
import comBoard.model.vo.ComBoard;
import comBoard.model.vo.ComPageData;
import common.JDBCTemplate;


public class ComBoardService {

	private JDBCTemplate factory;

	public ComBoardService() {
		factory = JDBCTemplate.getConnection();		
	}

	public ComBoard selectComBoard(int comNoticeNo) {
		ComBoard comboard = null;
		Connection conn = null;
		ComBoardDAO comDAO = new ComBoardDAO();
		try {
			conn = factory.createConnection();
			comboard = new ComBoardDAO().selectComBoard(conn, comNoticeNo);
			
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return comboard;
	}
	
	
	
	public ComPageData selectList(int currentPage) {
		ArrayList<ComBoard> comBoardList = null;
		Connection conn = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		ComPageData cpd = new ComPageData();
		try {
			conn = factory.createConnection();
			cpd.setComPageList(new ComBoardDAO().selectList(conn, currentPage, recordCountPerPage));	
			cpd.setComPageNavi(new ComBoardDAO().getComPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return cpd;
	}

	public ComPageData comBoardSearchList(String search, int currentPage){
		Connection conn = null;
		ComPageData cpd = new ComPageData();
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			cpd.setComPageList(new ComBoardDAO().comBoardSearchList(conn, search, currentPage, recordCountPerPage));
			cpd.setComPageNavi(new ComBoardDAO().getSearchComPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return cpd;
	}

	public int insertComBoard(String comSubject, String comContents, String comUserId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new ComBoardDAO().insertComBoard(conn, comSubject, comContents, comUserId);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if ( result > 0 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int deleteComBoard(int comNoticeNo) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new ComBoardDAO().deleteComBoard(conn, comNoticeNo);
			if ( result > 0 ) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(conn);
		}
		return result;
	}



	public int modifyComBoard(String comSubject, String comContents, int comNoticeNo) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new ComBoardDAO().modifyComBoard(conn, comSubject, comContents, comNoticeNo);
					
			if ( result > 0 ) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int updateReadCount(int comReadcount) {
		int result=0;
		Connection conn = null;
		
		try {
			conn =factory.createConnection();
			result = new ComBoardDAO().updateReadCount(conn,comReadcount);
			
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
}
