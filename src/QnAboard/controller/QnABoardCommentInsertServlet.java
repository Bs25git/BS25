package QnAboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnAboard.model.service.QnABoardService;

/**
 * Servlet implementation class NoticeCommentInsertServlet
 */
@WebServlet("/notice/commentinsert")
public class QnABoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnABoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		// insert Reply
		String userId = request.getParameter("userId");
		String contents = request.getParameter("contents");
		int result = new QnABoardService().insertReply(userId, contents, noticeNo);
		if (result > 0) {
			response.sendRedirect("/notice/select?noticeNo="+noticeNo);
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
