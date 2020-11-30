package shop.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import shop.model.dao.ShopDAO;
import shop.model.vo.PageData;
import shop.model.vo.Shop;

public class ShopService {
	
	private JDBCTemplate factory;
	
	public ShopService() {
		factory = JDBCTemplate.getConnection();
	}
	
	public Shop selectShop(int productNo) {
		Shop shop = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			shop = new ShopDAO().selectShop(conn, productNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return shop;
	}
	
	// 리스트 서비스
	public PageData allList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().allTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	
	public PageData foodList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().foodTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	
	public PageData clothesList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().clothesTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	
	public PageData toyList(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toyList(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().toyTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 최신순 서비스
	public PageData allNew(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allNew(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllNewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().allTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodNew(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodNew(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodNewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().foodTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesNew(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesNew(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesNewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().clothesTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData toyNew(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toyNew(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyNewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().toyTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	// 낮은가격 서비스
	public PageData allMin(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allMin(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllMinPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().allTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodMin(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodMin(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodMinPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().foodTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesMin(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesMin(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesMinPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().clothesTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toyMin(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toyMin(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyMinPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().toyTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 높은가격 서비스
	public PageData allMax(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allMax(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllMaxPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().allTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public PageData foodMax(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodMax(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodMaxPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().foodTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesMax(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesMax(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesMaxPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().clothesTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toyMax(int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toyMax(conn, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyMaxPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
			pd.setTotalCount(new ShopDAO().toyTotalCount(conn));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 검색 리스트 서비스
	public PageData allSearchList(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allSearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().allSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodSearchList(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodSearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().foodSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesSearchList(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesSearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().clothesSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toySearchList(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toySearchList(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToySearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().toySearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 최신순 서비스 (검색어 기능)
	public PageData allSearchNew(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allSearchNew(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllNewSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().allSearchTotalCount(conn, search));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodSearchNew(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodSearchNew(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodNewSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().foodSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesSearchNew(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesSearchNew(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesNewSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().clothesSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toySearchNew(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toySearchNew(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyNewSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().toySearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 낮은가격 서비스 (검색어 기능)
	public PageData allSearchMin(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allSearchMin(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllMinSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().allSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodSearchMin(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodSearchMin(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodMinSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().foodSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesSearchMin(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesSearchMin(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesMinSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().clothesSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toySearchMin(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toySearchMin(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyMinSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().toySearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	// 높은가격 서비스 (검색어 기능)
	public PageData allSearchMax(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().allSearchMax(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getAllMaxSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().allSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData foodSearchMax(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodSearchMax(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getFoodMaxSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().foodSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData clothesSearchMax(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().clothesSearchMax(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getClothesMaxSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().clothesSearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;	
	}
	
	public PageData toySearchMax(String search, int currentPage) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().toySearchMax(conn, search, currentPage, recordCountPerPage));
			pd.setPageNavi(new ShopDAO().getToyMaxSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
			pd.setTotalCount(new ShopDAO().toySearchTotalCount(conn, search));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	// 옵션 선택
	public PageData foodOption(int currentPage, String searchKeyword) {
		Connection conn = null;
		int recordCountPerPage = 8;
		int naviCountPerPage = 4;
		PageData pd = new PageData();
		
		try {
			conn = factory.createConnection();
			pd.setPageList(new ShopDAO().foodOption(conn, currentPage, recordCountPerPage, searchKeyword));
			pd.setPageNavi(new ShopDAO().getFoodOptionPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, searchKeyword));
			pd.setTotalCount(new ShopDAO().foodOptionTotalCount(conn, searchKeyword));
			JDBCTemplate.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
}
