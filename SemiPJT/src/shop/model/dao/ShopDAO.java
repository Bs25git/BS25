package shop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import shop.model.vo.Shop;

public class ShopDAO {
	
	// 상품 상세페이지 가져오는 쿼리문
	public Shop selectShop(Connection conn, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Shop shop = null;
		
		String query = "SELECT * FROM PRODUCT WHERE PRODUCT_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				shop = new Shop();
				shop.setProductNo(rset.getInt("PRODUCT_NO"));
				shop.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				shop.setProductName(rset.getString("PRODUCT_NAME"));
				shop.setQuantity(rset.getInt("QUANTITY"));
				shop.setPrice(rset.getInt("PRICE"));
				shop.setDiscount(rset.getInt("DISCOUNT"));
				shop.setProductOption(rset.getString("PRODUCT_OPTION"));
				shop.setImg(rset.getString("IMG"));
				shop.setInfoImg1(rset.getString("INFO_IMG1"));
				shop.setInfoImg2(rset.getString("INFO_IMG2"));
				shop.setInfoImg3(rset.getString("INFO_IMG3"));
				shop.setRegDate(rset.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return shop;
	}
	
	// 리스트 가져오는 쿼리문
	public ArrayList<Shop> allList(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allList = new Shop();
				allList.setProductNo(rset.getInt("PRODUCT_NO"));
				allList.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allList.setProductName(rset.getString("PRODUCT_NAME"));
				allList.setQuantity(rset.getInt("QUANTITY"));
				allList.setPrice(rset.getInt("PRICE"));
				allList.setDiscount(rset.getInt("DISCOUNT"));
				allList.setProductOption(rset.getString("PRODUCT_OPTION"));
				allList.setImg(rset.getString("IMG"));
				allList.setInfoImg1(rset.getString("INFO_IMG1"));
				allList.setInfoImg2(rset.getString("INFO_IMG2"));
				allList.setInfoImg3(rset.getString("INFO_IMG3"));
				allList.setRegDate(rset.getDate("REGDATE"));
				nList.add(allList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodList(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodList = new Shop();
				foodList.setProductNo(rset.getInt("PRODUCT_NO"));
				foodList.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodList.setProductName(rset.getString("PRODUCT_NAME"));
				foodList.setQuantity(rset.getInt("QUANTITY"));
				foodList.setPrice(rset.getInt("PRICE"));
				foodList.setDiscount(rset.getInt("DISCOUNT"));
				foodList.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodList.setImg(rset.getString("IMG"));
				foodList.setInfoImg1(rset.getString("INFO_IMG1"));
				foodList.setInfoImg2(rset.getString("INFO_IMG2"));
				foodList.setInfoImg3(rset.getString("INFO_IMG3"));
				foodList.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
		
	}
	
	public ArrayList<Shop> clothesList(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesList = new Shop();
				clothesList.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesList.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesList.setProductName(rset.getString("PRODUCT_NAME"));
				clothesList.setQuantity(rset.getInt("QUANTITY"));
				clothesList.setPrice(rset.getInt("PRICE"));
				clothesList.setDiscount(rset.getInt("DISCOUNT"));
				clothesList.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesList.setImg(rset.getString("IMG"));
				clothesList.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesList.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesList.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesList.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
		
	}
	
	public ArrayList<Shop> toyList(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyList = new Shop();
				toyList.setProductNo(rset.getInt("PRODUCT_NO"));
				toyList.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyList.setProductName(rset.getString("PRODUCT_NAME"));
				toyList.setQuantity(rset.getInt("QUANTITY"));
				toyList.setPrice(rset.getInt("PRICE"));
				toyList.setDiscount(rset.getInt("DISCOUNT"));
				toyList.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyList.setImg(rset.getString("IMG"));
				toyList.setInfoImg1(rset.getString("INFO_IMG1"));
				toyList.setInfoImg2(rset.getString("INFO_IMG2"));
				toyList.setInfoImg3(rset.getString("INFO_IMG3"));
				toyList.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
		
	}
	
	// 최신순으로 가져오는 쿼리문
	public ArrayList<Shop> allNew(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allNew = new Shop();
				allNew.setProductNo(rset.getInt("PRODUCT_NO"));
				allNew.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allNew.setProductName(rset.getString("PRODUCT_NAME"));
				allNew.setQuantity(rset.getInt("QUANTITY"));
				allNew.setPrice(rset.getInt("PRICE"));
				allNew.setDiscount(rset.getInt("DISCOUNT"));
				allNew.setProductOption(rset.getString("PRODUCT_OPTION"));
				allNew.setImg(rset.getString("IMG"));
				allNew.setInfoImg1(rset.getString("INFO_IMG1"));
				allNew.setInfoImg2(rset.getString("INFO_IMG2"));
				allNew.setInfoImg3(rset.getString("INFO_IMG3"));
				allNew.setRegDate(rset.getDate("REGDATE"));
				nList.add(allNew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodNew(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodNew = new Shop();
				foodNew.setProductNo(rset.getInt("PRODUCT_NO"));
				foodNew.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodNew.setProductName(rset.getString("PRODUCT_NAME"));
				foodNew.setQuantity(rset.getInt("QUANTITY"));
				foodNew.setPrice(rset.getInt("PRICE"));
				foodNew.setDiscount(rset.getInt("DISCOUNT"));
				foodNew.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodNew.setImg(rset.getString("IMG"));
				foodNew.setInfoImg1(rset.getString("INFO_IMG1"));
				foodNew.setInfoImg2(rset.getString("INFO_IMG2"));
				foodNew.setInfoImg3(rset.getString("INFO_IMG3"));
				foodNew.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodNew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesNew(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesNew = new Shop();
				clothesNew.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesNew.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesNew.setProductName(rset.getString("PRODUCT_NAME"));
				clothesNew.setQuantity(rset.getInt("QUANTITY"));
				clothesNew.setPrice(rset.getInt("PRICE"));
				clothesNew.setDiscount(rset.getInt("DISCOUNT"));
				clothesNew.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesNew.setImg(rset.getString("IMG"));
				clothesNew.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesNew.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesNew.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesNew.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesNew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toyNew(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3) P) WHERE NUM BETWEEN ? AND ?";
				
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyNew = new Shop();
				toyNew.setProductNo(rset.getInt("PRODUCT_NO"));
				toyNew.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyNew.setProductName(rset.getString("PRODUCT_NAME"));
				toyNew.setQuantity(rset.getInt("QUANTITY"));
				toyNew.setPrice(rset.getInt("PRICE"));
				toyNew.setDiscount(rset.getInt("DISCOUNT"));
				toyNew.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyNew.setImg(rset.getString("IMG"));
				toyNew.setInfoImg1(rset.getString("INFO_IMG1"));
				toyNew.setInfoImg2(rset.getString("INFO_IMG2"));
				toyNew.setInfoImg3(rset.getString("INFO_IMG3"));
				toyNew.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyNew);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 낮은가격순으로 가져오는 쿼리문
	public ArrayList<Shop> allMin(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allMin = new Shop();
				allMin.setProductNo(rset.getInt("PRODUCT_NO"));
				allMin.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allMin.setProductName(rset.getString("PRODUCT_NAME"));
				allMin.setQuantity(rset.getInt("QUANTITY"));
				allMin.setPrice(rset.getInt("PRICE"));
				allMin.setDiscount(rset.getInt("DISCOUNT"));
				allMin.setProductOption(rset.getString("PRODUCT_OPTION"));
				allMin.setImg(rset.getString("IMG"));
				allMin.setInfoImg1(rset.getString("INFO_IMG1"));
				allMin.setInfoImg2(rset.getString("INFO_IMG2"));
				allMin.setInfoImg3(rset.getString("INFO_IMG3"));
				allMin.setRegDate(rset.getDate("REGDATE"));
				nList.add(allMin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodMin(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodMin = new Shop();
				foodMin.setProductNo(rset.getInt("PRODUCT_NO"));
				foodMin.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodMin.setProductName(rset.getString("PRODUCT_NAME"));
				foodMin.setQuantity(rset.getInt("QUANTITY"));
				foodMin.setPrice(rset.getInt("PRICE"));
				foodMin.setDiscount(rset.getInt("DISCOUNT"));
				foodMin.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodMin.setImg(rset.getString("IMG"));
				foodMin.setInfoImg1(rset.getString("INFO_IMG1"));
				foodMin.setInfoImg2(rset.getString("INFO_IMG2"));
				foodMin.setInfoImg3(rset.getString("INFO_IMG3"));
				foodMin.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodMin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesMin(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesMin = new Shop();
				clothesMin.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesMin.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesMin.setProductName(rset.getString("PRODUCT_NAME"));
				clothesMin.setQuantity(rset.getInt("QUANTITY"));
				clothesMin.setPrice(rset.getInt("PRICE"));
				clothesMin.setDiscount(rset.getInt("DISCOUNT"));
				clothesMin.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesMin.setImg(rset.getString("IMG"));
				clothesMin.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesMin.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesMin.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesMin.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesMin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toyMin(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyMin = new Shop();
				toyMin.setProductNo(rset.getInt("PRODUCT_NO"));
				toyMin.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyMin.setProductName(rset.getString("PRODUCT_NAME"));
				toyMin.setQuantity(rset.getInt("QUANTITY"));
				toyMin.setPrice(rset.getInt("PRICE"));
				toyMin.setDiscount(rset.getInt("DISCOUNT"));
				toyMin.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyMin.setImg(rset.getString("IMG"));
				toyMin.setInfoImg1(rset.getString("INFO_IMG1"));
				toyMin.setInfoImg2(rset.getString("INFO_IMG2"));
				toyMin.setInfoImg3(rset.getString("INFO_IMG3"));
				toyMin.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyMin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 높은가격순으로 가져오는 쿼리문
	public ArrayList<Shop> allMax(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allMax = new Shop();
				allMax.setProductNo(rset.getInt("PRODUCT_NO"));
				allMax.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allMax.setProductName(rset.getString("PRODUCT_NAME"));
				allMax.setQuantity(rset.getInt("QUANTITY"));
				allMax.setPrice(rset.getInt("PRICE"));
				allMax.setDiscount(rset.getInt("DISCOUNT"));
				allMax.setProductOption(rset.getString("PRODUCT_OPTION"));
				allMax.setImg(rset.getString("IMG"));
				allMax.setInfoImg1(rset.getString("INFO_IMG1"));
				allMax.setInfoImg2(rset.getString("INFO_IMG2"));
				allMax.setInfoImg3(rset.getString("INFO_IMG3"));
				allMax.setRegDate(rset.getDate("REGDATE"));
				nList.add(allMax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodMax(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodMax = new Shop();
				foodMax.setProductNo(rset.getInt("PRODUCT_NO"));
				foodMax.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodMax.setProductName(rset.getString("PRODUCT_NAME"));
				foodMax.setQuantity(rset.getInt("QUANTITY"));
				foodMax.setPrice(rset.getInt("PRICE"));
				foodMax.setDiscount(rset.getInt("DISCOUNT"));
				foodMax.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodMax.setImg(rset.getString("IMG"));
				foodMax.setInfoImg1(rset.getString("INFO_IMG1"));
				foodMax.setInfoImg2(rset.getString("INFO_IMG2"));
				foodMax.setInfoImg3(rset.getString("INFO_IMG3"));
				foodMax.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodMax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesMax(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesMax = new Shop();
				clothesMax.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesMax.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesMax.setProductName(rset.getString("PRODUCT_NAME"));
				clothesMax.setQuantity(rset.getInt("QUANTITY"));
				clothesMax.setPrice(rset.getInt("PRICE"));
				clothesMax.setDiscount(rset.getInt("DISCOUNT"));
				clothesMax.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesMax.setImg(rset.getString("IMG"));
				clothesMax.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesMax.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesMax.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesMax.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesMax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toyMax(Connection conn, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Shop> nList = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3) P) WHERE NUM BETWEEN ? AND ?";
		
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyMax = new Shop();
				toyMax.setProductNo(rset.getInt("PRODUCT_NO"));
				toyMax.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyMax.setProductName(rset.getString("PRODUCT_NAME"));
				toyMax.setQuantity(rset.getInt("QUANTITY"));
				toyMax.setPrice(rset.getInt("PRICE"));
				toyMax.setDiscount(rset.getInt("DISCOUNT"));
				toyMax.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyMax.setImg(rset.getString("IMG"));
				toyMax.setInfoImg1(rset.getString("INFO_IMG1"));
				toyMax.setInfoImg2(rset.getString("INFO_IMG2"));
				toyMax.setInfoImg3(rset.getString("INFO_IMG3"));
				toyMax.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyMax);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 리스트 가져오는 쿼리문 (검색어 처리)
	public ArrayList<Shop> allSearchList(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allListSearch = new Shop();
				allListSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				allListSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allListSearch.setProductName(rset.getString("PRODUCT_NAME"));
				allListSearch.setQuantity(rset.getInt("QUANTITY"));
				allListSearch.setPrice(rset.getInt("PRICE"));
				allListSearch.setDiscount(rset.getInt("DISCOUNT"));
				allListSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				allListSearch.setImg(rset.getString("IMG"));
				allListSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				allListSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				allListSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				allListSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(allListSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodSearchList(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodListSearch = new Shop();
				foodListSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				foodListSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodListSearch.setProductName(rset.getString("PRODUCT_NAME"));
				foodListSearch.setQuantity(rset.getInt("QUANTITY"));
				foodListSearch.setPrice(rset.getInt("PRICE"));
				foodListSearch.setDiscount(rset.getInt("DISCOUNT"));
				foodListSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodListSearch.setImg(rset.getString("IMG"));
				foodListSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				foodListSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				foodListSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				foodListSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodListSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesSearchList(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesListSearch = new Shop();
				clothesListSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesListSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesListSearch.setProductName(rset.getString("PRODUCT_NAME"));
				clothesListSearch.setQuantity(rset.getInt("QUANTITY"));
				clothesListSearch.setPrice(rset.getInt("PRICE"));
				clothesListSearch.setDiscount(rset.getInt("DISCOUNT"));
				clothesListSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesListSearch.setImg(rset.getString("IMG"));
				clothesListSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesListSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesListSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesListSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesListSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toySearchList(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyListSearch = new Shop();
				toyListSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				toyListSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyListSearch.setProductName(rset.getString("PRODUCT_NAME"));
				toyListSearch.setQuantity(rset.getInt("QUANTITY"));
				toyListSearch.setPrice(rset.getInt("PRICE"));
				toyListSearch.setDiscount(rset.getInt("DISCOUNT"));
				toyListSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyListSearch.setImg(rset.getString("IMG"));
				toyListSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				toyListSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				toyListSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				toyListSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyListSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 최신순 쿼리문 처리 (검색어 기능)
	public ArrayList<Shop> allSearchNew(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allNewSearch = new Shop();
				allNewSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				allNewSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allNewSearch.setProductName(rset.getString("PRODUCT_NAME"));
				allNewSearch.setQuantity(rset.getInt("QUANTITY"));
				allNewSearch.setPrice(rset.getInt("PRICE"));
				allNewSearch.setDiscount(rset.getInt("DISCOUNT"));
				allNewSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				allNewSearch.setImg(rset.getString("IMG"));
				allNewSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				allNewSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				allNewSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				allNewSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(allNewSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodSearchNew(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodNewSearch = new Shop();
				foodNewSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				foodNewSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodNewSearch.setProductName(rset.getString("PRODUCT_NAME"));
				foodNewSearch.setQuantity(rset.getInt("QUANTITY"));
				foodNewSearch.setPrice(rset.getInt("PRICE"));
				foodNewSearch.setDiscount(rset.getInt("DISCOUNT"));
				foodNewSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodNewSearch.setImg(rset.getString("IMG"));
				foodNewSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				foodNewSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				foodNewSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				foodNewSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodNewSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesSearchNew(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesNewSearch = new Shop();
				clothesNewSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesNewSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesNewSearch.setProductName(rset.getString("PRODUCT_NAME"));
				clothesNewSearch.setQuantity(rset.getInt("QUANTITY"));
				clothesNewSearch.setPrice(rset.getInt("PRICE"));
				clothesNewSearch.setDiscount(rset.getInt("DISCOUNT"));
				clothesNewSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesNewSearch.setImg(rset.getString("IMG"));
				clothesNewSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesNewSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesNewSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesNewSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesNewSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toySearchNew(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3 AND PRODUCT_NAME LIKE ?) P)WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyNewSearch = new Shop();
				toyNewSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				toyNewSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyNewSearch.setProductName(rset.getString("PRODUCT_NAME"));
				toyNewSearch.setQuantity(rset.getInt("QUANTITY"));
				toyNewSearch.setPrice(rset.getInt("PRICE"));
				toyNewSearch.setDiscount(rset.getInt("DISCOUNT"));
				toyNewSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyNewSearch.setImg(rset.getString("IMG"));
				toyNewSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				toyNewSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				toyNewSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				toyNewSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyNewSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 낮은가격 쿼리문 (검색어 기능)
	public ArrayList<Shop> allSearchMin(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allMinSearch = new Shop();
				allMinSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				allMinSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allMinSearch.setProductName(rset.getString("PRODUCT_NAME"));
				allMinSearch.setQuantity(rset.getInt("QUANTITY"));
				allMinSearch.setPrice(rset.getInt("PRICE"));
				allMinSearch.setDiscount(rset.getInt("DISCOUNT"));
				allMinSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				allMinSearch.setImg(rset.getString("IMG"));
				allMinSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				allMinSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				allMinSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				allMinSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(allMinSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodSearchMin(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodMinSearch = new Shop();
				foodMinSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				foodMinSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodMinSearch.setProductName(rset.getString("PRODUCT_NAME"));
				foodMinSearch.setQuantity(rset.getInt("QUANTITY"));
				foodMinSearch.setPrice(rset.getInt("PRICE"));
				foodMinSearch.setDiscount(rset.getInt("DISCOUNT"));
				foodMinSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodMinSearch.setImg(rset.getString("IMG"));
				foodMinSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				foodMinSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				foodMinSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				foodMinSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodMinSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesSearchMin(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesMinSearch = new Shop();
				clothesMinSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesMinSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesMinSearch.setProductName(rset.getString("PRODUCT_NAME"));
				clothesMinSearch.setQuantity(rset.getInt("QUANTITY"));
				clothesMinSearch.setPrice(rset.getInt("PRICE"));
				clothesMinSearch.setDiscount(rset.getInt("DISCOUNT"));
				clothesMinSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesMinSearch.setImg(rset.getString("IMG"));
				clothesMinSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesMinSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesMinSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesMinSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesMinSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toySearchMin(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyMinSearch = new Shop();
				toyMinSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				toyMinSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyMinSearch.setProductName(rset.getString("PRODUCT_NAME"));
				toyMinSearch.setQuantity(rset.getInt("QUANTITY"));
				toyMinSearch.setPrice(rset.getInt("PRICE"));
				toyMinSearch.setDiscount(rset.getInt("DISCOUNT"));
				toyMinSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyMinSearch.setImg(rset.getString("IMG"));
				toyMinSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				toyMinSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				toyMinSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				toyMinSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyMinSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 높은가격 쿼리문 (검색어 기능)
	public ArrayList<Shop> allSearchMax(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop allMaxSearch = new Shop();
				allMaxSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				allMaxSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				allMaxSearch.setProductName(rset.getString("PRODUCT_NAME"));
				allMaxSearch.setQuantity(rset.getInt("QUANTITY"));
				allMaxSearch.setPrice(rset.getInt("PRICE"));
				allMaxSearch.setDiscount(rset.getInt("DISCOUNT"));
				allMaxSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				allMaxSearch.setImg(rset.getString("IMG"));
				allMaxSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				allMaxSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				allMaxSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				allMaxSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(allMaxSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> foodSearchMax(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop foodMaxSearch = new Shop();
				foodMaxSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				foodMaxSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				foodMaxSearch.setProductName(rset.getString("PRODUCT_NAME"));
				foodMaxSearch.setQuantity(rset.getInt("QUANTITY"));
				foodMaxSearch.setPrice(rset.getInt("PRICE"));
				foodMaxSearch.setDiscount(rset.getInt("DISCOUNT"));
				foodMaxSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				foodMaxSearch.setImg(rset.getString("IMG"));
				foodMaxSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				foodMaxSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				foodMaxSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				foodMaxSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(foodMaxSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> clothesSearchMax(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 2 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop clothesMaxSearch = new Shop();
				clothesMaxSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				clothesMaxSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				clothesMaxSearch.setProductName(rset.getString("PRODUCT_NAME"));
				clothesMaxSearch.setQuantity(rset.getInt("QUANTITY"));
				clothesMaxSearch.setPrice(rset.getInt("PRICE"));
				clothesMaxSearch.setDiscount(rset.getInt("DISCOUNT"));
				clothesMaxSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				clothesMaxSearch.setImg(rset.getString("IMG"));
				clothesMaxSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				clothesMaxSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				clothesMaxSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				clothesMaxSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(clothesMaxSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	public ArrayList<Shop> toySearchMax(Connection conn, String search, int currentPage, int recordCountPerPage){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY DISCOUNT DESC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 3 AND PRODUCT_NAME LIKE ?) P )WHERE NUM BETWEEN ? AND ?";
		ArrayList<Shop> nList = null;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			nList = new ArrayList<Shop>();
			while(rset.next()) {
				Shop toyMaxSearch = new Shop();
				toyMaxSearch.setProductNo(rset.getInt("PRODUCT_NO"));
				toyMaxSearch.setCategoryCode(rset.getInt("CATEGORY_CODE"));
				toyMaxSearch.setProductName(rset.getString("PRODUCT_NAME"));
				toyMaxSearch.setQuantity(rset.getInt("QUANTITY"));
				toyMaxSearch.setPrice(rset.getInt("PRICE"));
				toyMaxSearch.setDiscount(rset.getInt("DISCOUNT"));
				toyMaxSearch.setProductOption(rset.getString("PRODUCT_OPTION"));
				toyMaxSearch.setImg(rset.getString("IMG"));
				toyMaxSearch.setInfoImg1(rset.getString("INFO_IMG1"));
				toyMaxSearch.setInfoImg2(rset.getString("INFO_IMG2"));
				toyMaxSearch.setInfoImg3(rset.getString("INFO_IMG3"));
				toyMaxSearch.setRegDate(rset.getDate("REGDATE"));
				nList.add(toyMaxSearch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return nList;
	}
	
	// 옵션 선택 쿼리문
	public ArrayList<Shop> foodOption(Connection conn, int currentPage, int recordCountPerPage, String searchKeyword){
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<Shop> nList = null;

	      String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY PRODUCT_NO ASC) AS NUM, P.* FROM (SELECT PRODUCT.* FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_OPTION LIKE ? ) P )WHERE NUM BETWEEN ? AND ?";

	      int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
	      int end = currentPage*recordCountPerPage;

	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, searchKeyword);
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);
	         rset = pstmt.executeQuery();
	         nList = new ArrayList<Shop>();
	         while(rset.next()) {
	            Shop foodOption = new Shop();
	            foodOption.setProductNo(rset.getInt("PRODUCT_NO"));
	            foodOption.setCategoryCode(rset.getInt("CATEGORY_CODE"));
	            foodOption.setProductName(rset.getString("PRODUCT_NAME"));
	            foodOption.setQuantity(rset.getInt("QUANTITY"));
	            foodOption.setPrice(rset.getInt("PRICE"));
	            foodOption.setDiscount(rset.getInt("DISCOUNT"));
	            foodOption.setProductOption(rset.getString("PRODUCT_OPTION"));
	            foodOption.setImg(rset.getString("IMG"));
	            foodOption.setInfoImg1(rset.getString("INFO_IMG1"));
	            foodOption.setInfoImg2(rset.getString("INFO_IMG2"));
	            foodOption.setInfoImg3(rset.getString("INFO_IMG3"));
	            foodOption.setRegDate(rset.getDate("REGDATE"));
	            nList.add(foodOption);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }
	      return nList;

	   }
	
	// 리스트 페이징처리
	public String getAllPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = allTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/all?category=list&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/all?category=list&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>" + i + "</button>" + "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/all?category=list&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getFoodPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = foodTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/food?category=list&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/food?category=list&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>" + i +"</button>" +"</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/food?category=list&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getClothesPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = clothesTotalCount(conn);
		
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/clothes?category=list&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/clothes?category=list&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/clothes?category=list&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getToyPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = toyTotalCount(conn);
		
		int pageTotalCount = 0;
		
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/toy?category=list&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/toy?category=list&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/toy?category=list&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	// 최신순 페이징처리
	public String getAllNewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = allTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/all?category=new&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/all?category=new&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/all?category=new&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getFoodNewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = foodTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/food?category=new&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/food?category=new&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/food?category=new&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getClothesNewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = clothesTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/clothes?category=new&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/clothes?category=new&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/clothes?category=new&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getToyNewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = toyTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/toy?category=new&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/toy?category=new&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/toy?category=new&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	// 낮은가격 페이징 처리
	public String getAllMinPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = allTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/all?category=min&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/all?category=min&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/all?category=min&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getFoodMinPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = foodTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/food?category=min&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/food?category=min&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/food?category=min&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getClothesMinPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = clothesTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/clothes?category=min&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/clothes?category=min&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/clothes?category=min&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getToyMinPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = toyTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/toy?category=min&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/toy?category=min&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/toy?category=min&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	// 높은가격 페이징 처리
	public String getAllMaxPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = allTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/all?category=max&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/all?category=max&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/all?category=max&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getFoodMaxPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = foodTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/food?category=max&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/food?category=max&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/food?category=max&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getClothesMaxPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = clothesTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/clothes?category=max&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/clothes?category=max&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/clothes?category=max&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	public String getToyMaxPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = foodTotalCount(conn);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/toy?category=max&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " +"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+ "</b></a>");
			}else {
				sb.append("<a href='/toy?category=max&currentPage="+i+"'> " +"<button style='color: white; background-color: black'>"+ i +"</button>"+ "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/toy?category=max&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	// 리스트 페이징 처리 (검색어 처리)
	public String getAllSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = allSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/allSearch?search="+search+"&category=all&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/allSearch?search="+search+"&category=all&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/allSearch?search="+search+"&category=all&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getFoodSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = foodSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/foodSearch?search="+search+"&category=all&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/foodSearch?search="+search+"&category=all&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/foodSearch?search="+search+"&category=all&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getClothesSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = clothesSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=all&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/clothesSearch?search="+search+"&category=all&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=all&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getToySearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = toySearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/toySearch?search="+search+"&category=all&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/toySearch?search="+search+"&category=all&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/toySearch?search="+search+"&category=all&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	// 최신순 페이징 처리 (검색어 기능)
	public String getAllNewSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = allSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/allSearch?search="+search+"&category=new&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/allSearch?search="+search+"&category=new&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/allSearch?search="+search+"&category=new&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getFoodNewSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = foodSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/foodSearch?search="+search+"&category=new&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/foodSearch?search="+search+"&category=new&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/foodSearch?search="+search+"&category=new&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getClothesNewSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = clothesSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=new&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/clothesSearch?search="+search+"&category=new&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=new&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getToyNewSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = toySearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/toySearch?search="+search+"&category=new&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/toySearch?search="+search+"&category=new&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/toySearch?search="+search+"&category=new&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	// 낮은가격 페이징 처리 (검색어 기능)
	public String getAllMinSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = allSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/allSearch?search="+search+"&category=min&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/allSearch?search="+search+"&category=min&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/allSearch?search="+search+"&category=min&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getFoodMinSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = foodSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/foodSearch?search="+search+"&category=min&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/foodSearch?search="+search+"&category=min&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/foodSearch?search="+search+"&category=min&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getClothesMinSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = clothesSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=min&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/clothesSearch?search="+search+"&category=min&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=min&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getToyMinSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = toySearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/toySearch?search="+search+"&category=min&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/toySearch?search="+search+"&category=min&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/toySearch?search="+search+"&category=min&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	// 높은가격 페이징 처리 (검색어 기능)
	public String getAllMaxSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = allSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/allSearch?search="+search+"&category=max&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/allSearch?search="+search+"&category=max&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/allSearch?search="+search+"&category=max&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}

	public String getFoodMaxSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = foodSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/foodSearch?search="+search+"&category=max&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/foodSearch?search="+search+"&category=max&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/foodSearch?search="+search+"&category=max&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getClothesMaxSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = clothesSearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=max&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/clothesSearch?search="+search+"&category=max&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/clothesSearch?search="+search+"&category=max&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	public String getToyMaxSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String search) {
		int recordTotalCount = toySearchTotalCount(conn, search);
		int pageTotalCount = 0;
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb  = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/toySearch?search="+search+"&category=max&currentPage="+(startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> "+"<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>"+"</b></a>");
			}else {
				sb.append("<a href='/toySearch?search="+search+"&category=max&currentPage="+i+"'> "+"<button style='color: white; background-color: black'>"+ i +"</button>"+"</a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/toySearch?search="+search+"&category=max&currentPage="+(endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}
		return sb.toString();
	}
	
	// 옵션 페이징 처리
	public String getFoodOptionPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage, String searchKeyword) {
		int recordTotalCount = foodOptionTotalCount(conn, searchKeyword);

		int pageTotalCount = 0;

		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();

		if(needPrev) {
			sb.append("<a href='/food/option?age="+searchKeyword+"&currentPage=" + (startNavi-1)+"'> <button style='color: white; background-color: black'>이전</button> </a>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<b> " + "<button style='color: black; background-color: white; border: 1px solid black'>"+ i +"</button>" + "</b></a>");
			}else {
				sb.append("<a href='/food/option?age="+searchKeyword+"&currentPage="+i+"'> " + "<button style='color: white; background-color: black'>"+ i +"</button>" + "</a>");
			}
		}

		if(needNext) {
			sb.append("<a href='/food/option?age=2&currentPage=" + (endNavi+1)+"'> <button style='color: white; background-color: black'>다음</button> </a>");
		}

		return sb.toString();
	}
	
	// 카테고리별 전체 게시글의 갯수 쿼리문
	public int allTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int foodTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 1";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int clothesTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 2";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int toyTotalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 3";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	// 카테고리별 전체 게시글의 갯수 쿼리문 (검색어 처리)
	public int allSearchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 게시글의 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE PRODUCT_NAME LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝.
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int foodSearchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 게시글의 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_NAME LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝.
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int clothesSearchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 게시글의 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 2 AND PRODUCT_NAME LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝.
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int toySearchTotalCount(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		// 게시글의 총 갯수를 알아오는 쿼리
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 3 AND PRODUCT_NAME LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				// 쿼리한 결과 값이 하나의 컬럼에 number값이므로 1줄로 끝.
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	// 옵션 전체 게시글
	public int foodOptionTotalCount(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCT WHERE CATEGORY_CODE = 1 AND PRODUCT_OPTION LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
}
