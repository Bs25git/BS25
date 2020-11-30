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
 * Servlet implementation class NoticeSearch
 */
@WebServlet("/notice/search")
public class QnABoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnABoardSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int currentPage = 0;
		if (request.getParameter("currentPage")==null) {
			currentPage =1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		String search = request.getParameter("search");
		PageData pageData = new QnABoardService().noticeSearchList(search, currentPage);
		ArrayList<QnABoard> nList = pageData.getPageList();
		if(!nList.isEmpty()) {
			// 성공
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeSearch.jsp");
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
