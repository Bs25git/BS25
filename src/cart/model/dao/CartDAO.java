package cart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cart.model.vo.Cart;
import common.JDBCTemplate;


public class CartDAO {
   public ArrayList<Cart> selectBasketList(Connection conn, String userId){
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<Cart> pList = null;
      
      String query = "SELECT * FROM CART WHERE MEMBER_ID=?";
      try {
    	  pstmt = conn.prepareStatement(query);
    	  pstmt.setString(1, userId);
    	  rset = pstmt.executeQuery();
    	  pList = new ArrayList<Cart>();
    	  while(rset.next()) {
    		  Cart cart = new Cart(); 
    		  
    		  cart.setUserId(rset.getString("MEMBER_ID"));
    		  cart.setProductNo(rset.getInt("PRODUCT_NO"));
    		  cart.setProductName(rset.getString("PRODUCT_NAME"));
    		  cart.setQuantity(rset.getInt("QUANTITY"));
    		  cart.setPrice(rset.getInt("PRICE"));
    		  cart.setDiscount(rset.getInt("DISCOUNT"));
    		  cart.setImg(rset.getString("IMG"));
 
    		  pList.add(cart);
    		 
    	  }
      } catch (SQLException e) {
    	  e.printStackTrace();
      } finally {
    	  JDBCTemplate.close(pstmt);
    	  JDBCTemplate.close(rset); 	  
      }
  
      return pList;
   }
   
   public int insertCart(Connection conn,Cart cart) {
      PreparedStatement pstmt = null; 
      int result = 0;
      String query = "INSERT INTO CART VALUES(?,?,?,?,?,?,?)";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, cart.getUserId());
         pstmt.setInt(2, cart.getProductNo());
         pstmt.setString(3, cart.getProductName());
         pstmt.setInt(4, cart.getQuantity());
         pstmt.setInt(5, cart.getPrice());
         pstmt.setInt(6, cart.getDiscount());
         pstmt.setString(7, cart.getImg());
         result = pstmt.executeUpdate();
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         JDBCTemplate.close(pstmt);
      }
      
      return result; 
   }
   
   public int deleteCart(Connection conn, String userId) {
	   PreparedStatement pstmt = null;
	   int result = 0;
	   String query="DELETE FROM CART WHERE MEMBER_ID=?";
	   
	   try {
		   pstmt = conn.prepareStatement(query);
		   pstmt.setString(1, userId);
		   result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(pstmt);
	}
	   return result;
   }
   
   
}