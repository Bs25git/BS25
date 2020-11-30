package comBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comBoard.model.service.ComBoardService;
import comBoard.model.vo.ComBoard;


@WebServlet("/comboard/modifyform")
public class ComBoardModifyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComBoardModifyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int comNoticeNo = Integer.parseInt(request.getParameter("comNoticeNo"));
		ComBoard comboard = new ComBoardService().selectComBoard(comNoticeNo);
		if (comboard != null ) {
			request.setAttribute("comboard", comboard);
			request.getRequestDispatcher("/WEB-INF/views/comboard/comboardModify.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/comboard/comboardError.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


