package imgboard.model.vo;

import java.util.ArrayList;

public class PageData {
	// 기존 notice 클래스로는 NoticeDAO에서 만든 pageNavigation String을 저장할 수 없음
	// 그래서 PageNavigetion용 클래스를 하나 만들어서 String과 list데이터를 저장하도록함
	// 멤버변수
	
	private ArrayList<ImgBoard> pageList;
	private String pageNavi;
	
	public PageData() {}

	public ArrayList<ImgBoard> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<ImgBoard> pageList) {
		this.pageList = pageList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
