package comBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comBoard.model.service.ComBoardService;
import comBoard.model.vo.ComBoard;
import comBoard.model.vo.ComPageData;


/**
 * Servlet implementation class NoticeSearchServlet
 */
@WebServlet("/comboard/search")
public class ComBoardSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComBoardSearchServlet() {
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
      ComPageData comPageData = new ComBoardService().comBoardSearchList(search, currentPage);
      ArrayList<ComBoard> cList = comPageData.getComPageList();
      if(!cList.isEmpty()) { 
         request.setAttribute("cList", cList);
         request.setAttribute("comPageNavi", comPageData.getComPageNavi());
         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/comboard/comboardSearch.jsp");
         view.forward(request, response);
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