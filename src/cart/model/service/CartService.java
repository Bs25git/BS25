package cart.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import cart.model.dao.CartDAO;
import cart.model.vo.Cart;
import common.JDBCTemplate;
import shop.model.vo.Shop;

public class CartService {
	private JDBCTemplate factory;
	
	public CartService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public ArrayList<Cart> selectBasketList(String userId) {
		ArrayList<Cart> pList = null;
		try {
			Connection conn = factory.createConnection();
			pList = new CartDAO().selectBasketList(conn, userId);
			JDBCTemplate.close(conn);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	public int insertCart(Cart cart) {
		int result = 0;
		try {
			Connection conn = factory.createConnection();
			result = new CartDAO().insertCart(conn, cart);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return result; 
	}
	public int deleteCart(String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new CartDAO().deleteCart(conn, userId);
		
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
	
		return result;
		
	}
}
