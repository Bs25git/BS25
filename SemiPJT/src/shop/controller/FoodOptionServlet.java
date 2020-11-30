package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.model.service.ShopService;
import shop.model.vo.PageData;
import shop.model.vo.Shop;

/**
 * Servlet implementation class FoodOption1Servlet
 */
@WebServlet("/food/option")
public class FoodOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodOptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
	      
	     if(request.getParameter("currentPage") == null) {
	    	 currentPage = 1;
	     }else {
	         currentPage = Integer.parseInt(request.getParameter("currentPage"));
	     }
	     String searchKeyword = request.getParameter("age");
	     PageData pageData = new ShopService().foodOption(currentPage, searchKeyword);
	     ArrayList<Shop> nList = pageData.getPageList();
	     if(!nList.isEmpty()) {
	    	 request.setAttribute("age", searchKeyword);
	         request.setAttribute("nList", nList);
	         request.setAttribute("pageNavi", pageData.getPageNavi());
	         request.setAttribute("totalCount", pageData.getTotalCount());
	         RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/foodOption.jsp");
	         view.forward(request, response);
	     }else {
	         request.getRequestDispatcher("/WEB-INF/views/shop/shopError.html").forward(request, response);
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
