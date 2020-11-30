package freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;
import freeBoard.model.vo.FreeBoard;


// /notice/writeform 	=> noticeList.jsp
// /notice/write 	=> noticeWrite.html
// /notice/select 	=> noticeList.jsp
// /notice/list 	=> index.jsp
// /notice/delete	=> noticeContent.jsp
// /notice/modifyform => notice.Content.jsp
// /notice/modify	=> noticeModify.jsp

/**
 * Servlet implementation class NoticeModifyFormServlet
 */
@WebServlet("/freeboard/modifyform")
public class FreeBoardModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardModifyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 페이지에서 넘겨준 noticeNo를 가지고 다시한번 DB에서 데이터를 가져옴
		int freeNoticeNo = Integer.parseInt(request.getParameter("freeNoticeNo"));
		FreeBoard freeboard = new FreeBoardService().selectFreeBoard(freeNoticeNo);
		if (freeboard != null ) {
			request.setAttribute("freeboard", freeboard);
			request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardModify.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardError.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
