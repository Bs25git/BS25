package freeBoard.model.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import QnAboard.model.dao.QnABoardDAO;
import common.JDBCTemplate;
import freeBoard.model.dao.FreeBoardDAO;
import freeBoard.model.vo.FreeBoard;
import freeBoard.model.vo.PageData;

public class FreeBoardService {

	private JDBCTemplate factory;

	public FreeBoardService() {
		factory = JDBCTemplate.getConnection();		
	}

	public FreeBoard selectFreeBoard(int freeNoticeNo) {
		FreeBoard freeboard = null;
		Connection conn = null;
		FreeBoardDAO freeDAO = new FreeBoardDAO();
		try {
			conn = factory.createConnection();
			freeboard = new FreeBoardDAO().selectFreeBoard(conn, freeNoticeNo);
			
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return freeboard;
	}
	
	
	
	public PageData selectList(int currentPage) {
		ArrayList<FreeBoard> freeBoardList = null;
		Connection conn = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		PageData pd = new PageData();
		try {
			conn = factory.createConnection();
			pd.setPageList(new FreeBoardDAO().selectList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new FreeBoardDAO().getPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public PageData freeBoardSearchList(String search, int currentPage){
		Connection conn = null;
		PageData pd = new PageData();
		int recordCountPerPage = 5;
		int naviCountPerPage = 5;
		try {
			conn = factory.createConnection();
			pd.setPageList(new FreeBoardDAO().freeBoardSearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new FreeBoardDAO().getSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}

	public int insertFreeBoard(String freeSubject, String freeContents, String freeUserId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new FreeBoardDAO().insertFreeBoard(conn, freeSubject, freeContents, freeUserId);
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

	public int deleteFreeBoard(int freeNoticeNo) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new FreeBoardDAO().deleteFreeBoard(conn, freeNoticeNo);
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



	public int modifyFreeBoard(String freeSubject, String freeContents, int freeNoticeNo) {
		int result = 0;
		Connection conn = null;

		try {
			conn = factory.createConnection();
			result = new FreeBoardDAO().modifyFreeBoard(conn, freeSubject, freeContents, freeNoticeNo);			
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
	public int updateReadCount(int freeReadCount) {
		int result=0;
		Connection conn = null;
		
		try {
			conn =factory.createConnection();
			result = new FreeBoardDAO().updateReadCount(conn,freeReadCount);
			
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
