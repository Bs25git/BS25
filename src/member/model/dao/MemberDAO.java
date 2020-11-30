package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDAO {
	
	// DB에 접속하여 데이터를 꺼내오는 클래스
	
	public ArrayList<Member> selectMemberList(Connection conn){
		ArrayList<Member> list = null;
		Statement stmt=null;
		ResultSet rset =null;
		String query = "SELECT * FROM MEMBER";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Member>();
			// 이전에는 한개의 데이터를 가져오기 때문에 if문을 사용했다면
			// selectMemberList는 여러개의 데이터를 가져오기때문에 while문을 사용하며
			// 데이터가 없을 때까지 실행함
			while(rset.next()) {
				Member member = new Member();
				
				member.setUserId(rset.getNString("MEMBER_ID"));
				member.setUserPwd(rset.getNString("MEMBER_PW"));
				member.setEmail(rset.getNString("EMAIL"));
				member.setName(rset.getNString("MEMBER_NAME"));
				member.setAddress(rset.getNString("ADDRESS"));
				member.setZipcode(rset.getString("ZIPCODE"));
				member.setPhone(rset.getNString("PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));	
				// DB에서 가져온 값을 member에 저장한 후에
				// 최종적으로 저장할 list에 추가해줌
				list.add(member);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public Member selectOne(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID=?";
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			// 위치홀더에 값 셋팅
			pstmt.setString(1, userId);
			// 쿼리문 실행 및 결과 받기
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 걀과값이 존재하는지 확인 있으면 밑에 코드 실행
				member = new Member();
				// rset.getString은 MEMBER_ID 컬럼에 해당하는 값을 가져옴(리턴)
				// 그 값을 member 객체의 멤버변수인 memberId에 setMemberId메소드를 이용하여
				// 저장하고 있음 나머지 값들도 마찬가지
				member.setUserId(rset.getNString("MEMBER_ID"));
				member.setUserPwd(rset.getNString("MEMBER_PW"));
				member.setEmail(rset.getNString("EMAIL"));
				member.setName(rset.getNString("MEMBER_NAME"));
				member.setAddress(rset.getNString("ADDRESS"));
				member.setZipcode(rset.getString("ZIPCODE"));
				member.setPhone(rset.getNString("PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));	
			}
	} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return member;
	}
	public Member selectOne(Connection conn, String userId, String userPwd) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MEMBER WHERE MEMBER_ID = '" + userId +  "'AND MEMBER_PW = '" + userPwd +  "'";
		Member member = null;
		try {
	
			// statement 생성
			stmt = conn.createStatement();
			// 쿼리문 실행 및 결과 가져오기
			rset = stmt.executeQuery(query);
			// 결과값이 있다면
			if(rset.next()) {
				member = new Member();
				member.setUserId(rset.getNString("MEMBER_ID"));
				member.setUserPwd(rset.getNString("MEMBER_PW"));
				member.setEmail(rset.getNString("EMAIL"));
				member.setName(rset.getNString("MEMBER_NAME"));
				member.setAddress(rset.getNString("ADDRESS"));
				member.setZipcode(rset.getString("ZIPCODE"));
				member.setPhone(rset.getNString("PHONE"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		
		return member;
	}
	
	
	public int insertMember(Connection conn, Member member) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,sysdate)";
		
		try {
			// prepareStatement 생성시 query문이 들어감
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, member.getUserId());
			pstmt.setNString(2, member.getUserPwd());
			pstmt.setNString(3, member.getEmail());
			pstmt.setNString(4, member.getName());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getZipcode());
			pstmt.setString(7, member.getPhone());
		
			
			// pstmt로 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET MEMBER_PW=?, EMAIL=?, MEMBER_NAME=?, ADDRESS=?, ZIPCODE=?, PHONE =? WHERE MEMBER_ID =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setNString(1, member.getUserPwd());
			pstmt.setNString(2, member.getEmail());
			pstmt.setString(3,  member.getName());
			pstmt.setNString(4, member.getAddress());
			pstmt.setString(5, member.getZipcode());
			pstmt.setNString(6, member.getPhone());
			pstmt.setNString(7, member.getUserId());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null; 
		String query = "DELETE FROM MEMBER WHERE MEMBER_ID =?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setNString(1, userId);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
