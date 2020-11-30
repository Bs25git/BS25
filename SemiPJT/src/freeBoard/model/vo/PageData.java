package freeBoard.model.vo;

import java.util.ArrayList;

public class PageData {
	
	private ArrayList<FreeBoard> pageList;
	private String pageNavi;
	
	public PageData() {}
	
	
	public ArrayList<FreeBoard> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<FreeBoard> pageList) {
		this.pageList = pageList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
		
}
