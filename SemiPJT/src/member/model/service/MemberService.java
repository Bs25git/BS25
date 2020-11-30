package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {

	private JDBCTemplate factory;

	public MemberService() {
		factory = JDBCTemplate.getConnection();
	}
	public ArrayList<Member> selectMemberList(){
		ArrayList<Member> list = null;
		try {
			Connection conn = factory.createConnection();
			list = new MemberDAO().selectMemberList(conn);
			JDBCTemplate.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Member selectMember(String userId) {
		//DB 연결을 DAO에서 하는 것이 아니라 Service에서 하도록 함
		// selectMember 메소드 내에서 사용할 수 있는 변수 선언
		Member member = null;
		try {
			Connection conn = factory.createConnection();
			member = new MemberDAO().selectOne(conn, userId);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	public Member selectMember(String userId, String userPwd) {
		Member member = null;
		try {
			Connection conn = factory.createConnection();
			member = new MemberDAO().selectOne(conn, userId, userPwd);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {// TODO: handle exception
			e.printStackTrace();
		}
		return member;
	}
	// View에서 보내준 9개의 데이터를 각각의 매개변수로 보내도되자만 member객체에 담아 한꺼번에 보냄
	public int insertMember(Member member) {
		int result = 0;
		try {
			Connection conn = factory.createConnection();
			result = new MemberDAO().insertMember(conn, member);
			JDBCTemplate.close(conn);
			// 리턴타입 int과 리턴값은 자료형이 값아야함

		}catch (SQLException e) {// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	// 정보를 수정하기 위한 메소드
	// 6개의 매개변수를 받는 대신 한개의 객체에 모든 정보를 저장하여 데이터를 넘겨받음
	public int updateMember(Member member) {
		int result = 0;
		try {
			Connection conn = factory.createConnection();
			// result는 executeUpdate() 메소드의 리턴값이 int이기떄문에
			// int형 변수가 됨
			result = new MemberDAO().updateMember(conn, member);
			if(result > 0) {
				JDBCTemplate.commit(conn);
				
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMember(String userId) {
		int result =0;
		try {
			Connection conn = factory.createConnection();
			result = new MemberDAO().deleteMember(conn, userId);
			JDBCTemplate.close(conn);
		} catch (SQLException e) {

		}
		return result;

	}
}