package QnAboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnAboard.model.service.QnABoardService;
import QnAboard.model.vo.QnABoard;
import QnAboard.model.vo.PageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/list")
public class QnABoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnABoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//  SELECT * FROM  NOTICE;
		// 쿼리는 위와 같기 때문에 매개값이 필요없음
		int currentPage= 0;
		if(request.getParameter("currentPage") == null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
		}
		PageData pageData = new QnABoardService().selectList(currentPage);
		ArrayList<QnABoard> nList = pageData.getPageList();
		
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
			view.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
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
