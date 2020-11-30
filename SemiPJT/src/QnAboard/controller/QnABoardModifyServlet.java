package QnAboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QnAboard.model.service.QnABoardService;

@WebServlet("/notice/modify")
public class QnABoardModifyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public QnABoardModifyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      //2. View 넘어온 데이터 변수 저장
      //getParameter() 메소드의 매개값은 form 태그안에 input태그 name속성에
      //지정한 값으로 /notice/modify의 경우 subject,content,noticeNo가 있다
      String subject = request.getParameter("subject");
      String content = request.getParameter("content");
      int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
      int result = new QnABoardService().modifyNotice(subject,content,noticeNo);
      if(result > 0) { //공지사항 상세 페이지 이동
         //상세페이지를 보여주는 URL은? > notice/select
         //상세페이지를 보여주기 위해 필요한 쿼리스트링은? > noticeNo=?
         response.sendRedirect("/notice/select?noticeNo="+noticeNo);
         
      }else { //공지사항 서비스 요청 오류
            //WEB-INF 폴더 안에 있는 소스들은 직접 접근이 불가능하여
            //RequestDispatcher객체의 forward()메소드를 이용하여 이동시킴
         request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html").forward(request, response);
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}