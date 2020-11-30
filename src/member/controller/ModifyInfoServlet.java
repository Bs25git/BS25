package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class ModifyInfoServlet
 */
@WebServlet("/member/update")
public class ModifyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 HttpSession session = request.getSession();
		 String userId = ((Member)session.getAttribute("member")).getUserId();
		
		Member member = new Member(); 
		
		  member.setUserId(userId);
	      member.setUserPwd(request.getParameter("userPwd"));
	      member.setEmail(request.getParameter("email"));
	      member.setName(request.getParameter("name"));
	      member.setAddress(request.getParameter("address"));
	      member.setZipcode(request.getParameter("zipcode"));
	      member.setPhone(request.getParameter("phone"));
	      
	      int result = new MemberService().updateMember(member);
	      if ( result > 0 ) { // 성공
	          session.invalidate();
	          response.sendRedirect("/index.jsp");
	          
	       } else { // 실패
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
