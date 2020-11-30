package comBoard.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnAboard.model.service.QnABoardService;
import QnAboard.model.vo.Comment;
import QnAboard.model.vo.QnABoard;
import comBoard.model.service.ComBoardService;
import comBoard.model.vo.ComBoard;


/**
 * Servlet implementation class NoticeSelectServlet
 */
@WebServlet("/comboard/select")
public class ComBoardSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComBoardSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie viewCookie=null;
		Cookie[] cookies=request.getCookies();

		System.out.println("cookie : "+cookies);
		
		// SELECT * FROM NOTICE WHERE NOTICENO=12;
		int comNoticeNo = Integer.parseInt(request.getParameter("comNoticeNo"));
		ComBoard comboard = new ComBoardService().selectComBoard(comNoticeNo);
		
		
		if(cookies !=null) {

			for (int i = 0; i < cookies.length; i++) {
				
                
                //만들어진 쿠키들을 확인하며, 만약 들어온 적 있다면 생성되었을 쿠키가 있는지 확인
				if(cookies[i].getName().equals("|"+comNoticeNo+"|")) {
					
				
                //찾은 쿠키를 변수에 저장
					viewCookie=cookies[i];
				}
			}
			
		}else {
			System.out.println("cookies 확인 로직 : 쿠키가 없습니다.");
		}


		//만들어진 쿠키가 없음을 확인
		if(viewCookie==null) {
        
          	System.out.println("viewCookie 확인 로직 : 쿠키 없당");
			
            try {
            
            	//이 페이지에 왔다는 증거용(?) 쿠키 생성
				Cookie newCookie=new Cookie("|"+comNoticeNo+"|","readCount");
				response.addCookie(newCookie);
                
                //쿠키가 없으니 증가 로직 진행
				new ComBoardService().updateReadCount(comNoticeNo);
                
			} catch (Exception e) {
				System.out.println("쿠키 넣을때 오류 나나? : "+e.getMessage());
				e.getStackTrace();

			}
		
        //만들어진 쿠키가 있으면 증가로직 진행하지 않음
		}else {
			System.out.println("viewCookie 확인 로직 : 쿠키 있당");
			String value=viewCookie.getValue();
			System.out.println("viewCookie 확인 로직 : 쿠키 value : "+value);
		}
		
		if (comboard != null ) {
			request.setAttribute("content", comboard);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/comboard/comboardContent.jsp");
			view.forward(request, response);
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
