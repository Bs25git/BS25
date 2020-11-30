package member.model.vo;

import java.sql.Date;

public class Member {
	private String UserId;
	private String UserPwd;
	private String UserPwdCheck;
	private String Name; 
	private String Phone;
	private String Email;
	private String Address;
	private String Zipcode;
	private Date EnrollDate;
	private String adminYN;
	

	public Member() {}
	
	public String getAdminYN() {
		return adminYN;
	}

	public void setAdminYN(String adminYN) {
		this.adminYN = adminYN;
	}

	public Date getEnrollDate() {
		return EnrollDate;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public void setEnrollDate(Date enrollDate) {
		EnrollDate = enrollDate;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPwd() {
		return UserPwd;
	}

	public void setUserPwd(String userPwd) {
		UserPwd = userPwd;
	}

	public String getUserPwdCheck() {
		return UserPwdCheck;
	}

	public void setUserPwdCheck(String userPwdCheck) {
		UserPwdCheck = userPwdCheck;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}


}
