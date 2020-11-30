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
 * Servlet implementation class AllListServlet
 */
@WebServlet("/all")
public class AllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 0;
		PageData pageData = new PageData();
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		String category = request.getParameter("category");
		if(category.equals("new")) {
			pageData = new ShopService().allNew(currentPage);
		}else if(category.equals("min")) {
			pageData = new ShopService().allMin(currentPage);
		}else if(category.equals("max")) {
			pageData = new ShopService().allMax(currentPage);
		}else {
			pageData = new ShopService().allList(currentPage);
		}
		
		ArrayList<Shop> nList = pageData.getPageList(); 
		if(!nList.isEmpty()) {
			request.setAttribute("nList", nList);
			request.setAttribute("pageNavi", pageData.getPageNavi());
			request.setAttribute("totalCount", pageData.getTotalCount());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/allList.jsp");
			view.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/shop/shopError.jsp").forward(request, response);
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
