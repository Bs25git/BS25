package freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeWriteFormServlet
 */
@WebServlet("/freeboard/writeform")
public class FreeBoardWriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardWriteFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// WebContent 바로 밑에 소스코드를 두면 서버내 경로만 알면 쉽게 접근이 가능했음
		// 소스코드들이 바로 보이는 것을 막기 위해 WEB-INF폴더 밑에 소스코드들을 두어
		// 바로 접근이 못하도록 막음.
		request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardWrite.html").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
