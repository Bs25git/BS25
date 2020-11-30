package QnAboard.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import QnAboard.model.vo.Comment;
import QnAboard.model.vo.QnABoard;
import common.JDBCTemplate;

public class QnABoardDAO {
	
	private int naviCountPerPage;
	public QnABoard selectNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		QnABoard notice = null;
		String query="SELECT * FROM QNAboard WHERE QNANOTICENO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				notice = new QnABoard();
				notice.setNoticeNo(rset.getInt("QNANOTICENO"));
				notice.setSubject(rset.getString("QNASUBJECT"));
				notice.setContents(rset.getString("QNACONTENTS"));
				notice.setUserId(rset.getString("QNAUSERID"));
				notice.setRegDate(rset.getDate("QNAREGDATE"));
				notice.setReadcount(rset.getInt("QNAREADCOUNT"));
				
			}
		}catch(SQLException e) {
			
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	public ArrayList<QnABoard> selectList(Connection conn,int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnABoard> nList = null;
		// ROW_NUMBER() 함수는 순번을 매기는 함수이다. NOTICENO 컬럼을 기준으로 내림차순 정렬을 해서 NUM이라는 컬럼에 
	       // 1부터 112 까지 순번을 매기며 , 내가 보여주고 싶은 게시물의 갯수만큼 SELECT 하여 가져올 수 있게 됨 
	      // 즉, 1페이지에서는 1번부터 10번까지, 2페이지는 11번 부터 20번까지의 게시물을 보여줄 수 있게 됨 
	      // WHERE 조건절에서 NUM BETWEEN 뒤에 위치홀더의 값은 현재 페이지의 값에 따라가 바꿔주도록 설정함 
	      // 다시 말해, 1페이지이면 1, 10의 값이, 2페이지면 11, 20의 값이 들어가도록 수식으로 만들어줘야함 
		String query = "SELECT * FROM (SELECT QNAboard.*, ROW_NUMBER() OVER(ORDER BY QNANOTICENO DESC) AS NUM FROM QNAboard) WHERE NUM BETWEEN ? AND ?";
		
		// 현재페이지 : 1, 한페이지 당 보여줄 게시물의 갯수 : 10
		// start : 1, end : 10
		// start = 1* 10 - (10 - 1) = 1
		// end : 1 * 10 = 10
		// 현재 페이지 : 2, 한 페이지 당 보여줄 게시물의 갯수 : 10
		// start  11 , end : 20
		// start = 2 * 10 - ( 10 - 1 ) = 11 , end = 2 * 10 =20
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1); 
		int end = currentPage*recordCountPerPage;
		try {
			//stmt = conn.createStatement();
			//rset = stmt.executeQuery(query);
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<QnABoard>();
			
			while(rset.next()) {
				// 여기에서 사용하는 noticeOne 객체는 List에 데이터를 저장하기 위해
				QnABoard noticeOne = new QnABoard();
				noticeOne.setNoticeNo(rset.getInt("QNANOTICENO"));
				noticeOne.setSubject(rset.getNString("QNASUBJECT"));
				noticeOne.setContents(rset.getNString("QNACONTENTS"));
				noticeOne.setUserId(rset.getNString("QNAUSERID"));
				noticeOne.setRegDate(rset.getDate("QNAREGDATE"));
				noticeOne.setReadcount(rset.getInt("QNAREADCOUNT"));
				nList.add(noticeOne);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return nList;
		
	}
	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		
		// 전체 게시글의 갯수
		int recordTotalCount = totalCount(conn);
		
		// 전체 페이지의 갯수
		// 전체 게시물의 갯수가 11개이고 10개씩 보여준다고 하면
		// 전체 페이지의 갯수는 112/10 = 11 + 1 => 12
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage >0) {
			pageTotalCount = recordTotalCount / recordCountPerPage+1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지 코드
		// 현재페이지값이 최소값보다 작거나 최대값도 클 때
		// 정상값으로 셋팅해주는 코드
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// naviCountPerPage라는 변수는 현재 페이지에서 보여줄 navi의 수
		// 현재 페이지에서 보여줄 navi 수가 10개
		// 현재 페이지가 1이라고 하면
		// 1 2 3 4 5 6 7 8 9 10 next(O)
		// 1 2 3 4 5 next (X)
		// startNavi =  ((1-1) /10)*10 + 1 = 11
		
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		// 오류 방지 코드
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		// prev, next를 준비하기 위해 필요한 변수
		boolean needPrev = true;
		boolean needNext = true;
		// 변수의 값이 true가 되면 버튼을 클릭할 수 있는 것이고
		// 첫번째 페이지에서는 이전버튼, 마지막 페이지에서는 다음버튼이
		// 클릭이 안되도록 false값을 대입해줌
		if(startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}
		
		// Navition 태그를 String으로 만듬
		// String을 연결하여 긴 String으로 만들어주는 클래스
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href = '/notice/list?currentPage=" + (startNavi - 1) + "'> ◀</a>");
		}
		// 1~10까지의 숫자를for문을 이용해서 생성하고 만들어주는 부분
		for (int i =startNavi; i <= endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a href='/notice/list?currentPage" + i + "'> <b> " + i + "</b></a>");
			}else {
				sb.append("<a href='/notice/list?currentPage=" + i +"'>" + i + "</a>");
			}
		}
		// 다음 버튼을 누를 수 있을 때 다음버튼을 생성하는 부분
		if(needNext) {
			sb.append("<a href='/notice/list?currentPage=" + (endNavi+1) + "'> ▶ </a>");
			
		}
		// 태그를 StringBuilder의 append()메소드를 이용해서 붙인 후에
		// toString() 메소드를 이용하여 String으로 만들어서 리턴
		return sb.toString();
	}
	// 전체 게시글의 갯수는 사용자가 등록, 삭제할 때 마다 달라지게 되므로
	// DB에서 쿼리하여 그 갯수를 가져와야함 그래서 만든 메소드가 totalCount()메소드
	public int totalCount(Connection conn) {
		
	PreparedStatement pstmt = null;
	ResultSet rset= null;
	// 게시그르이 총 갯수를 알아오는 쿼리
	String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNAboard";	
	int recordTotalCount = 0;
	
	try {
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝
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
	public ArrayList<QnABoard> noticeSearchList(Connection conn, String search, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ArrayList<QnABoard> nList = null;
		ResultSet rset = null;
		// 특정 단어가 포함된 게시물을 검색할 수 있는 쿼리문
		String query ="SELECT * FROM (SELECT QNAboard.*, ROW_NUMBER() OVER(ORDER BY QNANOTICENO DESC) AS NUM FROM QNAboard WHERE QNASUBJECT LIKE ?) WHERE NUM BETWEEN ? AND ?";  
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset=pstmt.executeQuery();
			// 검색결과가 1개가 아닐 수 있기 때문에 while문 사용
			nList = new ArrayList<QnABoard>();
			while(rset.next()) {
				QnABoard notice = new QnABoard();
				notice.setNoticeNo(rset.getInt("QNANOTICENO"));
				notice.setContents(rset.getNString("QNACONTENTS"));
				notice.setSubject(rset.getNString("QNASUBJECT"));
				notice.setUserId(rset.getNString("QNAUSERID"));
				notice.setRegDate(rset.getDate("QNAREGDATE"));
				
				nList.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return nList;
	}
	public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, String search,int naviCountPerPage) {
		
		int recordTotalCount = searchTotalCount(conn,search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			
		
	}else {
		pageTotalCount = recordTotalCount / recordCountPerPage;
	}
		//오류방지용 코드
		if(currentPage < 1) {
			currentPage = 1;
	}else if(currentPage > pageTotalCount){
		currentPage = pageTotalCount;
	}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage +1;
		int endNavi = startNavi + naviCountPerPage -1 ;
		
		// 오류 방지용 코드
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;
		}if (endNavi == 1) {
			needNext = false;
		}
		// a태그를 만드는 코드
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/notice/search?search=" + search + "&currentPage=" + (startNavi -1)+"'> ◀ </a>");
		}
		for (int i= startNavi; i <= endNavi; i++) {
			if ( i == currentPage) {
				sb.append("<a href='/notice/search?search=" + search + "&currentPage=" + i + "'><b>" + i + "</b></a>");

			}else {
				sb.append("<a href='/notice/search?search=" + search + "&currentPage=" + i + "'>" + i + "</a>");
				
			}
		}
		if(needNext) {
			sb.append("<a href='/notice/search?search=" + search + "&currentPage=" + (endNavi + 1)+"'> ▶ </a>");

		}
		return sb.toString();
	}
	// 기존의 totalCount 메소드를 쓸 수 없는 이뉴는 totalCount()메소드는
	// 전체 게시물의 갯수를 가져오기 ㄸ문에 내가 원하는 검색한 결과값에 다한
	// 객수를 가져오지 못한다. 다라서 searchTotalCount() 메소드를 다시 만듬
	public int searchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		// 게시그르이 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNAboard WHERE QNASUBJECT LIKE ?";	
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1,  "%" + search + "%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝
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
	
	
	public int insertNotice(Connection conn, String subject, String content, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO QnAboard VALUES(SEQ_NOTICE.NEXTVAL,?,?,?,SYSDATE,default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, subject);
			pstmt.setNString(2, content);
			pstmt.setNString(3, userId);
			
			
			
			result= pstmt.executeUpdate();
			// 쿼리문 실행하고 실행한 결과값을 받음
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="DELETE FROM QNABOARD WHERE QNANOTICENO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
	
	}
	public int modifyNotice(Connection conn, String subject, String content, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE QnAboard SET QnASUBJECT =?, QnACONTENTS=? WHERE QnANOTICENO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setNString(2, content);
			pstmt.setInt(3, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int updateReadCount(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE QnAboard SET QnAreadcount = QnAreadcount+1 WHERE QnANOTICENO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public Comment commentRe(Connection conn, int commentNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Comment comment = null;
		String query = "SELECT * FROM commentBoard WHERE BOARDNUM=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, commentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				comment = new Comment();
				comment.setCommentNo(rset.getInt("CommentNo"));
				comment.setUserId(rset.getString("CommentuserId"));
				comment.setContents(rset.getNString("Commentcontents"));
				comment.setRegDate(rset.getDate("Commentregdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return comment;
	}
	public int insertReply(Connection conn, String memberId, String contents, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="INSERT INTO COMMENTBOARD VALUES(SEQ_COMMENT.NEXTVAL,?,?,SYSDATE,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, memberId);
			pstmt.setNString(2, contents);
			pstmt.setInt(3, noticeNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
}
