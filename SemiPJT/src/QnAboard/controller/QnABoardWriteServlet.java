package QnAboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import QnAboard.model.service.QnABoardService;
import member.model.vo.Member;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/notice/write")
public class QnABoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnABoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param readcount 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		// 2. 웹 페이지에서 보내온 값 변수 지정
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
	
		
		//int readcount = Integer.parseInt(request.getParameter("readcount"));
		HttpSession session = request.getSession();
		if (session != null && (session.getAttribute("member")!=null)) {
			String userId = ((Member)session.getAttribute("member")).getUserId();
			// 저정할 데이터가 준비가 된 후 비즈니스 로직 처리
			int result = new QnABoardService().insertNotice(subject, content, userId);
			// response.sendRedirect 메소드로는 WEB-INF안에 있는 페이지로 이동이 되지 않으므로
			// requestDistpatcher의 forward()메소드로 이동.
			
			//RequestDispatcher view = request.getRequestDispatcher("경로");
			 			if (result > 0 ) {
				response.sendRedirect("/notice/list");
			}else {
				// insert가 되지 않아을때 출력하는 오류 메시지
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html");
				view.forward(request, response);
				
			}
		}else {
			// 로그인을 하지 않았을 때 출력하는 오류 메세지
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/serviceFailed.html");
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
