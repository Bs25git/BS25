package notice.model1.vo;

import java.sql.Date;

public class Comment {
	private int commentNo;
	private String userId;
	private String contents;
	private Date regDate;
	private int boardNum;
	
	
	public Comment() {}


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getBoardNum() {
		return boardNum;
	}


	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
}
