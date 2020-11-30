package freeBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;


/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/freeboard/delete")
public class FreeBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int freeNoticeNo = Integer.parseInt(request.getParameter("freeNoticeNo"));
		int result = new FreeBoardService().deleteFreeBoard(freeNoticeNo);
		if ( result > 0 ) {
			// 공지사항 리스트 페이지 출력
			response.sendRedirect("/freeboard/list");
		}else {
			//공지사항 서비스 요청 실패 페이지 출력
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
