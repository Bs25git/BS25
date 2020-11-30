package comBoard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import comBoard.model.vo.ComBoard;
import common.JDBCTemplate;


public class ComBoardDAO {

	public ComBoard selectComBoard(Connection conn, int comNoticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ComBoard comboard =null;
		String query = "SELECT * FROM COMBOARD WHERE COMNOTICENO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, comNoticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				comboard = new ComBoard();
				comboard.setComNoticeNo(rset.getInt("COMNOTICENO"));
				comboard.setComSubject(rset.getString("COMSUBJECT"));
				comboard.setComContents(rset.getString("COMCONTENTS"));
				comboard.setComUserId(rset.getString("COMUSERID"));
				comboard.setComRegDate(rset.getDate("COMREGDATE"));
				comboard.setComReadcount(rset.getInt("COMREADCOUNT"));
			}
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return comboard;
	}


	public ArrayList<ComBoard> selectList(Connection conn,  int currentPage, int recordCountPerPage ) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ComBoard> cList = null;
		
		String query = "SELECT * FROM (SELECT COMBOARD.*, ROW_NUMBER() OVER(ORDER BY COMNOTICENO DESC) AS NUM FROM COMBOARD) WHERE NUM BETWEEN ? AND ?";


		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			cList = new ArrayList<ComBoard>();
			while(rset.next()) {
				
				ComBoard comboardOne= new ComBoard();
				comboardOne.setComNoticeNo(rset.getInt("COMNOTICENO"));
				comboardOne.setComSubject(rset.getString("COMSUBJECT"));
				comboardOne.setComContents(rset.getString("COMCONTENTS"));
				comboardOne.setComUserId(rset.getString("COMUSERID"));
				comboardOne.setComRegDate(rset.getDate("COMREGDATE"));
				comboardOne.setComReadcount(rset.getInt("COMREADCOUNT"));
				cList.add(comboardOne);
			}			
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return cList;
	}

	public String getComPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {

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
			sb.append("<a href='/comboard/list?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		
		for (int i = startNavi; i <= endNavi; i++) {
			if ( i == currentPage ) {
				sb.append("<a href='/comboard/list?currentPage="+ i + "'><b> " + i + " </b></a>");
			}else {
				sb.append("<a href='/comboard/list?currentPage="+ i + "'> " + i + " </a>");
			}			
		}
		if (needNext) {
			sb.append("<a href='/comboard/list?currentPage="+ (endNavi+1) + "'> > </a>");
		}
		return sb.toString();
	}	

	
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM COMBOARD";
		int recordTotalCount = 0;

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과값이 하나의 칼럼에 number값이므로 1줄로 끝.
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


	public ArrayList<ComBoard> comBoardSearchList(Connection conn, String search, int currentPage, int recordCountPerPage) {
	      PreparedStatement pstmt = null;
	      ArrayList<ComBoard> cList = null;
	      ResultSet rset = null;
	      String query ="SELECT * FROM (SELECT COMBOARD.*, ROW_NUMBER() OVER(ORDER BY COMNOTICENO DESC) AS NUM FROM COMBOARD WHERE COMUSERID LIKE ?) WHERE NUM BETWEEN ? AND ?";  
	      int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
	      int end = currentPage * recordCountPerPage;
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, "%" + search + "%");
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);
	         rset=pstmt.executeQuery();
	         // 검색결과가 1개가 아닐 수 있기 때문에 while문 사용
	         cList = new ArrayList<ComBoard>();
	         while(rset.next()) {
	            ComBoard comboard = new ComBoard();
				comboard.setComNoticeNo(rset.getInt("COMNOTICENO"));
				comboard.setComSubject(rset.getString("COMSUBJECT"));
				comboard.setComContents(rset.getString("COMCONTENTS"));
				comboard.setComUserId(rset.getString("COMUSERID"));
				comboard.setComRegDate(rset.getDate("COMREGDATE"));
				

	            cList.add(comboard);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	         JDBCTemplate.close(rset);
	      }
	      return cList;
	   }
	
	 public String getSearchComPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
	      int recordTotalCount = searchTotalCount(conn, search);
	      int pageTotalCount = 0;
	      if(recordTotalCount % recordCountPerPage > 0) {
	         pageTotalCount = recordTotalCount / recordCountPerPage + 1;
	      }else {
	         pageTotalCount = recordTotalCount / recordCountPerPage;
	      }
	      // 오류방지용 코드
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
	         sb.append("<a href='/comboard/search?search="+search+"&currentPage="+(startNavi-1)+"'> < </a>");
	      }
	      for(int i=startNavi; i<=endNavi; i++) {
	         if(i == currentPage) {
	            sb.append("<a href='/comboard/search?search="+search+"&currentPage="+i+"'><b>"+i+"</b></a>");
	         }else {
	            sb.append("<a href='/comboard/search?search="+search+"&currentPage="+i+"'>"+i+"</a>");
	         }
	      }
	      if(needNext) {
	         sb.append("<a href='/comboard/search?search="+search+"&currentPage="+(endNavi+1)+"'> > </a>");
	      }
	      return sb.toString();
	   }

	 public int searchTotalCount(Connection conn, String search) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	    
	      String query = "SELECT COUNT(*) AS TOTALCOUNT FROM COMBOARD WHERE SUBJECT LIKE ?";
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

	public int insertComBoard(Connection conn, String comSubject, String comContents, String comUserId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO COMBOARD VALUES(SEQ_COMBOARD.NEXTVAL,?,?,?,SYSDATE,default)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, comSubject);
			pstmt.setString(2, comContents);
			pstmt.setString(3, comUserId);
			
			
			result = pstmt.executeUpdate();
			
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteComBoard(Connection conn, int comNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM COMBOARD WHERE COMNOTICENO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, comNoticeNo);
			result = pstmt.executeUpdate();
		}catch ( SQLException e ){
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int modifyComBoard(Connection conn, String comSubject, String comContents, int comNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE COMBOARD SET COMSUBJECT=?, COMCONTENTS=? WHERE COMNOTICENO=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  comSubject);
			pstmt.setString(2,  comContents);
			pstmt.setInt(3,  comNoticeNo);
			result = pstmt.executeUpdate();
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);	
		}
		return result;
	}
	public int updateReadCount(Connection conn, int comNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE COMboard SET COMreadcount = COMreadcount+1 WHERE COMNOTICENO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, comNoticeNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}