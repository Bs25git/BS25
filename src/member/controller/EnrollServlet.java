package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public EnrollServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1. 인코딩 처리
      request.setCharacterEncoding("utf-8");
      // 2. View에서 보낸 값 변수에 저장
      Member member = new Member();
      // 데이터를 매개변수로 하나씩 하나씩 넘겨도 되지만
      // 멤버 객체에 담아서 한꺼번에 보내도록 함.
      member.setUserId(request.getParameter("userId"));
      member.setUserPwd(request.getParameter("userPwd"));
      member.setName(request.getParameter("name"));
      member.setPhone(request.getParameter("phone"));
      member.setEmail(request.getParameter("email"));
      member.setZipcode(request.getParameter("zipcode"));
      member.setAddress(request.getParameter("address"));
      
      
      // 날짜가 없는 이유는 DB에서 sysdate로 처리함.
      // 3. 비즈니스 로직 처리 ( DB에 회원정보 저장 )
      int result = new MemberService().insertMember(member);
      
      if ( result > 0 ) { // 성공
         response.sendRedirect("/index.jsp");
      } else { // 실패
         response.sendRedirect("/views/member/memberError.html");
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}