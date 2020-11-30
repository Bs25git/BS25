package shop.model.vo;

import java.util.ArrayList;

public class PageData {
	
	private ArrayList<Shop> pageList;
	private String pageNavi;
	private int totalCount;
	
	public PageData() {}

	public ArrayList<Shop> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<Shop> pageList) {
		this.pageList = pageList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
