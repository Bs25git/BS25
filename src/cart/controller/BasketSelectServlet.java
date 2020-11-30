package cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.model.service.CartService;
import cart.model.vo.Cart;
import member.model.vo.Member;

/**
 * Servlet implementation class BasketSelectServlet
 */
@WebServlet("/cart/select")
public class BasketSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String userId = ((Member)session.getAttribute("member")).getUserId(); 
		ArrayList<Cart> pList = new CartService().selectBasketList(userId); 
		
		if(!pList.isEmpty()) {
			request.setAttribute("pList", pList);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/shop/basket.jsp");
			view.forward(request, response);
			System.out.println(pList);
		} else {
			response.sendRedirect("");
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
