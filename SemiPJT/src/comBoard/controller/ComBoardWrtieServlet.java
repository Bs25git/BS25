package comBoard.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comBoard.model.service.ComBoardService;
import member.model.vo.Member;


/**
 * Servlet implementation class NoticeWrtieServlet
 */
@WebServlet("/comboard/write")
public class ComBoardWrtieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComBoardWrtieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		// 2. 웹 페이지에서 보내온 값 변수 저장
		String comSubject = request.getParameter("comSubject");
		String comContents = request.getParameter("comContents");
		
		HttpSession session = request.getSession();
		if ( session != null && ( session.getAttribute("member") != null )) {
			String comUserId = ((Member)session.getAttribute("member")).getUserId();
			int result = new ComBoardService().insertComBoard(comSubject, comContents, comUserId);
			if ( result > 0 ) {
				response.sendRedirect("/comboard/list");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/comboard/comboardError.html");
				view.forward(request, response);
			}			
		}else {
			// 로그인을 하지 않았을 때 출력하는 오류 메시지
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/comboard/comboardFailed.html");
			view.forward(request, response);
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
