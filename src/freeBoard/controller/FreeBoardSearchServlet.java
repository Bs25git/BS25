package freeBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freeBoard.model.service.FreeBoardService;

import freeBoard.model.vo.FreeBoard;

import freeBoard.model.vo.PageData;

/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/freeboard/search")
public class FreeBoardSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
      request.setCharacterEncoding("utf-8");
      int currentPage = 0;
      if(request.getParameter("currentPage") == null) {
         currentPage = 1;
      }else {
         currentPage = Integer.parseInt(request.getParameter("currentPage"));
      }
      String search = request.getParameter("search");
      // 10개의 게시물, 10개의 a링크가 저장되어 있고
      PageData pageData = new FreeBoardService().freeBoardSearchList(search, currentPage);
      // getPageList() 메소드를 이용해서 10개의 게시물을 꺼내 nList에 저장함
      ArrayList<FreeBoard> fList = pageData.getPageList();
      if(!fList.isEmpty()) { // 성공
         request.setAttribute("fList", fList);
         // getPageNavi() 메소드를 이용하여 10개의 a태그를 request
         request.setAttribute("pageNavi", pageData.getPageNavi());
         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardSearch.jsp");
         view.forward(request, response);
      }else { // 실패
         // forward() 메소드를 호출해야 페이지가 이동한다.
         request.getRequestDispatcher("/WEB-INF/views/freeboard/freeboardError.html").forward(request, response);
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