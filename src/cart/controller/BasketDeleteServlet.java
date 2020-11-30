package cart.controller;

import java.io.IOException;
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
 * Servlet implementation class BasketDeleteServlet
 */
@WebServlet("/cart/delete")
public class BasketDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketDeleteServlet() {
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
	      //int productNo = Integer.parseInt(request.getParameter("productNo"));
	            
	      int result = new CartService().deleteCart(userId);
	      if(result > 0) {
	         request.getRequestDispatcher("/WEB-INF/views/shop/basket.jsp").forward(request, response);
	      } else {
	         response.sendRedirect("/index.jsp");
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
