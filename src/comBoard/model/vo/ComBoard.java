package comBoard.model.vo;

import java.sql.Date;

public class ComBoard {

	private int comNoticeNo;
	private String comSubject;
	private String comContents;
	private String comUserId;
	private Date comRegDate;	
	private int comReadcount;

	
	public ComBoard() {}


	public int getComNoticeNo() {
		return comNoticeNo;
	}


	public void setComNoticeNo(int comNoticeNo) {
		this.comNoticeNo = comNoticeNo;
	}


	public String getComSubject() {
		return comSubject;
	}


	public void setComSubject(String comSubject) {
		this.comSubject = comSubject;
	}


	public String getComContents() {
		return comContents;
	}


	public void setComContents(String comContents) {
		this.comContents = comContents;
	}


	public String getComUserId() {
		return comUserId;
	}


	public void setComUserId(String comUserId) {
		this.comUserId = comUserId;
	}


	public Date getComRegDate() {
		return comRegDate;
	}


	public void setComRegDate(Date comRegDate) {
		this.comRegDate = comRegDate;
	}


	public int getComReadcount() {
		return comReadcount;
	}


	public void setComReadcount(int comReadcount) {
		this.comReadcount = comReadcount;
	}




	
	
}

	