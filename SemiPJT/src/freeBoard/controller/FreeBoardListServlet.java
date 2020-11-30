package freeBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;
import freeBoard.model.vo.FreeBoard;
import freeBoard.model.vo.PageData;


///notice/writeform 	=> noticeList.jsp
///notice/write 	=> noticeWrite.html
///notice/select 	=> noticeList.jsp
///notice/list 	=> index.jsp
///notice/delete	=> noticeContent.jsp
///notice/modifyform => notice.Content.jsp
///notice/modify	=> noticeModify.jsp
/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/freeboard/list")
public class FreeBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// SELECT * FROM NOTICE;
		// 쿼리는 위와 같기 때문에 매개값이 필요없음
		//ArrayList<Notice> nList = new NoticeService().selectList();
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageData pageData = new FreeBoardService().selectList(currentPage);
		ArrayList<FreeBoard> fList = pageData.getPageList();
		
		if(!fList.isEmpty()) {
			request.setAttribute("fList", fList);
			request.setAttribute("pageNavi",  pageData.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardList.jsp");
			view.forward(request, response);
		}else {
			// 서비스 요청이 실패했을 때 
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
