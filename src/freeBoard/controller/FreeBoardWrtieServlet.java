package freeBoard.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freeBoard.model.service.FreeBoardService;
import member.model.vo.Member;

///notice/writeform 	=> noticeList.jsp
///notice/write 	=> noticeWrite.html
///notice/select 	=> noticeList.jsp
///notice/list 	=> index.jsp
///notice/delete	=> noticeContent.jsp
///notice/modifyform => notice.Content.jsp
///notice/modify	=> noticeModify.jsp
/**
 * Servlet implementation class NoticeWrtieServlet
 */
@WebServlet("/freeboard/write")
public class FreeBoardWrtieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardWrtieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		// 2. 웹 페이지에서 보내온 값 변수 저장
		String freeSubject = request.getParameter("freeSubject");
		String freeContents = request.getParameter("freeContents");
		
		HttpSession session = request.getSession();
		if ( session != null && ( session.getAttribute("member") != null )) {
			String freeUserId = ((Member)session.getAttribute("member")).getUserId();
			// 저장할 데이터가 준비된 후 비즈니스 로직 처리
			int result = new FreeBoardService().insertFreeBoard(freeSubject, freeContents, freeUserId);
			// response.sendRedirect메소드로는 WEB-INF안에 있는 페이지로 이동이 되지 않으므로
			// RequestDispatcher의 forward() 메소드로 페이지 이동
			// RequestDispatcher view = request.getRequestDispatcher("경로");
			if ( result > 0 ) {
				// 작성한 경로가 보이게 된다.
				response.sendRedirect("/freeboard/list");
			}else {
				// insert가 되지 않았을 때 출력하는 오류 메시지
				// 실제 파일이 존재하는 경로가 보이지 않음! 페이지만 이동.. 
				// RequestDispatcher는 데이터를 가지고 이동시킴. 이동할 때 url 변경이 되지 않음.
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardError.html");
				view.forward(request, response);
			}			
		}else {
			// 로그인을 하지 않았을 때 출력하는 오류 메시지
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardFailed.html");
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
