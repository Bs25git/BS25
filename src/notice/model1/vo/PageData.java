package notice.model1.vo;

import java.util.ArrayList;

public class PageData {
	// 기존 notice 클래스로는 NoticeDAO에서 만든 pageNavigation String을 저장할 수 없음
	// 그래서 PageNavigetion용 클래스를 하나 만들어서 String과 list데이터를 저장하도록함
	// 멤버변수
	
	private ArrayList<Notice> pageList;
	private String pageNavi;
	
	public PageData() {}

	public ArrayList<Notice> getPageList() {
		return pageList;
	}

	public void setPageList(ArrayList<Notice> pageList) {
		this.pageList = pageList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
}
