package member.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 전송값에 한그링 있을 경우 인코딩 처리s
		request.setCharacterEncoding("utf-8");
		// 2. View에서 보낸 전송값을 꺼내서 변수에 저장하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 3. 비즈니스 로직을 처리할 서비스 클래스 메소드로 값을 전달 및 결과 받기
		Member member = new MemberService().selectMember(userId, userPwd);
		
		// 4. 받은 결과에 따라 성공/실패 페이지 내보내기
		if (member != null) {
			// request 객체에 데이터를 저장하는 것이아니라
			// session이라는 객체에 데이터를 저장
			// session은 request와는 다르게 유저가 접속할 떄 생성되어 유지되는 객체임
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			//System.out.println(member.getMemberId() + ", " + member.getMemberPwd() + ", " + member.getMemberName());
			response.sendRedirect("/views/member/loginSuccess2.jsp");
		}else {
			response.sendRedirect("/views/member/memberError.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
