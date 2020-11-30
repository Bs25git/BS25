package shop.model.vo;

import java.sql.Date;

public class Shop {
	private int productNo;
	private int categoryCode;
	private String productName;
	private int quantity;
	private int price;
	private int discount; 
	private String productOption;
	private String img;
	private String infoImg1;
	private String infoImg2;
	private String infoImg3;
	private Date regDate;
	
	public Shop() {}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getProductOption() {
		return productOption;
	}

	public void setProductOption(String productOption) {
		this.productOption = productOption;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getInfoImg1() {
		return infoImg1;
	}

	public void setInfoImg1(String infoImg1) {
		this.infoImg1 = infoImg1;
	}

	public String getInfoImg2() {
		return infoImg2;
	}

	public void setInfoImg2(String infoImg2) {
		this.infoImg2 = infoImg2;
	}

	public String getInfoImg3() {
		return infoImg3;
	}

	public void setInfoImg3(String infoImg3) {
		this.infoImg3 = infoImg3;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	

}
