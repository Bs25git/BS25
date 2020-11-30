package freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;


/**
 * Servlet implementation class NoticeModifyServlet
 */
@WebServlet("/freeboard/modify")
public class FreeBoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. View 넘어온 데이터 변수 저장
		// getParameter() 메소드의 매개값은 form태그 안에 input태그의 name속성에
		// 지정한 값으로 /notice/modify의 경우 subject, content, noticeNo가 있다.
		String freeSubject = request.getParameter("freeSubject");
		String freeContents = request.getParameter("freeContents");
		int freeNoticeNo = Integer.parseInt(request.getParameter("freeNoticeNo"));
		// 서비스 클래스 메소드를 호출하여 매개변수값을 넘겨줌
		int result = new FreeBoardService().modifyFreeBoard(freeSubject, freeContents, freeNoticeNo);
		if ( result > 0 ) { // 성공
			// 공지사항 상세 페이지 이동
			// 상세페이지를 보여주는 URL은?
			// 상세페이지를 보여주기 위해 필요한 쿼리스트링은?
			response.sendRedirect("/freeboard/select?freeNoticeNo="+freeNoticeNo);
		}else { // 실패
			// 공지사항 서비스 요청 오류 페이지
			// WEB-INF 폴더 안에 있는 소스들은 접근이 불가능(보안상의 이유)하여 
			// RequestDispatcher 객체의 forward()메소드를 이용하여 이동시킨다.
			request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardError.html").forward(request, response);
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
