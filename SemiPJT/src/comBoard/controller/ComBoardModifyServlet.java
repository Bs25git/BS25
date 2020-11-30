package comBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comBoard.model.service.ComBoardService;


/**
 * Servlet implementation class NoticeModifyServlet
 */
@WebServlet("/comboard/modify")
public class ComBoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComBoardModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String comSubject = request.getParameter("comSubject");
		String comContents = request.getParameter("comContents");
		int comNoticeNo = Integer.parseInt(request.getParameter("comNoticeNo"));
		int result = new ComBoardService().modifyComBoard(comSubject, comContents, comNoticeNo);
		if ( result > 0 ) { 
			response.sendRedirect("/comboard/select?comNoticeNo="+comNoticeNo);
		}else { 
			request.getRequestDispatcher("/WEB-INF/views/comboard/comboardError.html").forward(request, response);
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