package freeBoard.model.vo;

import java.sql.Date;

public class FreeBoard {
	
	private int freeNoticeNo;
	private String freeSubject;
	private String freeContents;
	private String freeUserId;
	private Date freeRegDate;	
	private int freeReadCount;

	
	public FreeBoard() {}
	
	public int getFreeNoticeNo() {
		return freeNoticeNo;
	}
	public void setFreeNoticeNo(int freeNoticeNo) {
		this.freeNoticeNo = freeNoticeNo;
	}
	public String getFreeSubject() {
		return freeSubject;
	}
	public void setFreeSubject(String freeSubject) {
		this.freeSubject = freeSubject;
	}
	public String getFreeContents() {
		return freeContents;
	}
	public void setFreeContents(String freeContents) {
		this.freeContents = freeContents;
	}
	public String getFreeUserId() {
		return freeUserId;
	}
	public void setFreeUserId(String freeUserId) {
		this.freeUserId = freeUserId;
	}
	
	public Date getFreeRegDate() {
		return freeRegDate;
	}
	public void setFreeRegDate(Date freeRegDate) {
		this.freeRegDate = freeRegDate;
	}
	public int getFreeReadCount() {
		return freeReadCount;
	}
	public void setFreeReadCount(int freeReadCount) {
		this.freeReadCount = freeReadCount;
	}

}

	