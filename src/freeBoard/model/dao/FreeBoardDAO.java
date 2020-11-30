package freeBoard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import common.JDBCTemplate;
import freeBoard.model.vo.FreeBoard;

public class FreeBoardDAO {

	public FreeBoard selectFreeBoard(Connection conn, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FreeBoard freeboard =null;
		String query = "SELECT * FROM FREEBOARD WHERE FREENOTICENO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNoticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				freeboard = new FreeBoard();
				freeboard.setFreeNoticeNo(rset.getInt("FREENOTICENO"));
				freeboard.setFreeSubject(rset.getString("FREESUBJECT"));
				freeboard.setFreeContents(rset.getString("FREECONTENTS"));
				freeboard.setFreeUserId(rset.getString("FREEUSERID"));
				freeboard.setFreeRegDate(rset.getDate("FREEREGDATE"));
				freeboard.setFreeReadCount(rset.getInt("FREEREADCOUNT"));
			}
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return freeboard;
	}


	public ArrayList<FreeBoard> selectList(Connection conn,  int currentPage, int recordCountPerPage ) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeBoard> fList = null;
	
		String query = "SELECT * FROM (SELECT FREEBOARD.*, ROW_NUMBER() OVER(ORDER BY FREENOTICENO DESC) AS NUM FROM FREEBOARD) WHERE NUM BETWEEN ? AND ?";

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			fList = new ArrayList<FreeBoard>();
			while(rset.next()) {
				FreeBoard freeBoardOne= new FreeBoard();
				freeBoardOne.setFreeNoticeNo(rset.getInt("FREENOTICENO"));
				freeBoardOne.setFreeSubject(rset.getString("FREESUBJECT"));
				freeBoardOne.setFreeContents(rset.getString("FREECONTENTS"));
				freeBoardOne.setFreeUserId(rset.getString("FREEUSERID"));
				freeBoardOne.setFreeRegDate(rset.getDate("FREEREGDATE"));
				freeBoardOne.setFreeReadCount(rset.getInt("FREEREADCOUNT"));
				fList.add(freeBoardOne);
			}			
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fList;
	}

	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalCount(conn);
		int pageTotalCount = 0;
		if ( recordTotalCount % recordCountPerPage > 0 ) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if ( currentPage < 1 ) {
			currentPage = 1;
		}else if ( currentPage > pageTotalCount ) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi==1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
	
		if (needPrev) {
			sb.append("<a href='/freeboard/list?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			if ( i == currentPage ) {
				sb.append("<a href='/freeboard/list?currentPage="+ i + "'><b> " + i + " </b></a>");
			}else {
				sb.append("<a href='/freeboard/list?currentPage="+ i + "'> " + i + " </a>");
			}			
		}
		if (needNext) {
			sb.append("<a href='/freeboard/list?currentPage="+ (endNavi+1) + "'> > </a>");
		}
		return sb.toString();
	}	

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM FREEBOARD";
		int recordTotalCount = 0;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		}catch ( SQLException e ) {
			e.printStackTrace();

		}finally {
			JDBCTemplate.close(rset);;
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}


	public ArrayList<FreeBoard> freeBoardSearchList(Connection conn, String search, int currentPage, int recordCountPerPage) {
	      PreparedStatement pstmt = null;
	      ArrayList<FreeBoard> fList = null;
	      ResultSet rset = null;
	
	      String query ="SELECT * FROM (SELECT FREEBOARD.*, ROW_NUMBER() OVER(ORDER BY FREENOTICENO DESC) AS NUM FROM FREEBOARD WHERE FREEUSERID LIKE ?) WHERE NUM BETWEEN ? AND ?";  
	      int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
	      int end = currentPage * recordCountPerPage;
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, "%" + search + "%");
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);
	         rset=pstmt.executeQuery();
	         fList = new ArrayList<FreeBoard>();
	         while(rset.next()) {
	            FreeBoard freeBoard = new FreeBoard();
	            freeBoard.setFreeNoticeNo(rset.getInt("FREENOTICENO"));
	            freeBoard.setFreeContents(rset.getString("FREECONTENTS"));
	            freeBoard.setFreeSubject(rset.getString("FREESUBJECT"));
	            freeBoard.setFreeUserId(rset.getString("FREEUSERID"));
	            freeBoard.setFreeRegDate(rset.getDate("FREEREGDATE"));
				

	            fList.add(freeBoard);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	         JDBCTemplate.close(rset);
	      }
	      return fList;
	   }
	
	 public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
	      int recordTotalCount = searchTotalCount(conn, search);
	      int pageTotalCount = 0;
	      if(recordTotalCount % recordCountPerPage > 0) {
	         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
	      }else {
	         pageTotalCount = recordTotalCount / recordCountPerPage;
	      }
	      if(currentPage < 1) {
	         currentPage = 1;
	      }else if(currentPage > pageTotalCount) {
	         currentPage = pageTotalCount;
	      }
	      int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
	      int endNavi = startNavi + naviCountPerPage - 1;
	      if(endNavi > pageTotalCount) {
	         endNavi = pageTotalCount;
	      }
	      boolean needPrev = true;
	      boolean needNext = true;
	      if(startNavi == 1) {
	         needPrev = false;
	      }
	      if(endNavi == pageTotalCount) {
	         needNext = false;
	      }
	      StringBuilder sb  = new StringBuilder();
	      if(needPrev) {
	         sb.append("<a href='/freeboard/search?search="+search+"&currentPage="+(startNavi-1)+"'> < </a>");
	      }
	      for(int i=startNavi; i<=endNavi; i++) {
	         if(i == currentPage) {
	            sb.append("<a href='/freeboard/search?search="+search+"&currentPage="+i+"'><b>"+i+"</b></a>");
	         }else {
	            sb.append("<a href='/freeboard/search?search="+search+"&currentPage="+i+"'>"+i+"</a>");
	         }
	      }
	      if(needNext) {
	         sb.append("<a href='/freeboard/search?search="+search+"&currentPage="+(endNavi+1)+"'> > </a>");
	      }
	      return sb.toString();
	   }

	 public int searchTotalCount(Connection conn, String search) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "SELECT COUNT(*) AS TOTALCOUNT FROM FREEBOARD WHERE SUBJECT LIKE ?";
	      int recordTotalCount = 0;
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, "%"+search+"%");
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            recordTotalCount = rset.getInt("TOTALCOUNT");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      return recordTotalCount;
	   }

	public int insertFreeBoard(Connection conn, String freeSubject, String freeContents, String freeUserId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO FREEBOARD VALUES(SEQ_FREEBOARD.NEXTVAL,?,?,?,SYSDATE,DEFAULT)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, freeSubject);
			pstmt.setString(2, freeContents);
			pstmt.setString(3, freeUserId);
			
			
			result = pstmt.executeUpdate();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteFreeBoard(Connection conn, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM FREEBOARD WHERE FREENOTICENO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNoticeNo);
			result = pstmt.executeUpdate();
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int modifyFreeBoard(Connection conn, String freeSubject, String freeContents, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE FREEBOARD SET FREESUBJECT=?, FREECONTENTS=? WHERE FREENOTICENO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  freeSubject);
			pstmt.setString(2,  freeContents);
			pstmt.setInt(3,  freeNoticeNo);
			result = pstmt.executeUpdate();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}
	public int updateReadCount(Connection conn, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE FREEboard SET FREEreadcount = FREEreadcount+1 WHERE FREENOTICENO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, freeNoticeNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}