package comBoard.model.vo;

import java.util.ArrayList;

public class ComPageData {
	

	private ArrayList<ComBoard> comPageList;
	private String comPageNavi;
	
	public ComPageData() {}
	
	
	public ArrayList<ComBoard> getComPageList() {
		return comPageList;
	}

	public void setComPageList(ArrayList<ComBoard> comPageList) {
		this.comPageList = comPageList;
	}

	public String getComPageNavi() {
		return comPageNavi;
	}

	public void setComPageNavi(String comPageNavi) {
		this.comPageNavi = comPageNavi;
	}
		
}
