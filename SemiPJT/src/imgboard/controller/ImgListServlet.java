package imgboard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imgboard.model.service.ImgBoardService;
import imgboard.model.vo.ImgBoard;
import member.model.vo.Member;

/**
 * Servlet implementation class ImgListServlet
 */
@WebServlet("/img/list")
public class ImgListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("member")).getUserId();
		ArrayList<ImgBoard> iList = new ImgBoardService().selectImgList(userId); 
		if(!iList.isEmpty()) {
			request.setAttribute("iList", iList);
		}
		request.getRequestDispatcher("/WEB-INF/views/imgboard/imgList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
