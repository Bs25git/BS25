package shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import shop.model.service.ShopService;
import shop.model.vo.Shop;

/**
 * Servlet implementation class ShopSelectServlet
 */
@WebServlet("/select/Shop")
public class ShopSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//String userId = ((Member)session.getAttribute("member")).getUserId();
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		Shop shop = new ShopService().selectShop(productNo);
		
		
		
		
		if(shop != null) {
			request.setAttribute("shop", shop);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/selectShop.jsp");
			view.forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/shop/shopError.jsp");
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
