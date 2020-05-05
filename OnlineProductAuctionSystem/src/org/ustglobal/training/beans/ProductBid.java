package org.ustglobal.training.beans;

public class ProductBid {
	private String name;

	private String emailId;

	private String phoneNumber;

	private String postalAddress;

	private String productCode;

	private float bidderPrice;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProductBid() {
		
	}

	public ProductBid(String name, String emailId, String phoneNumber, String postalAddress, String productCode,
			float bidderPrice) {
		this.name = name;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.postalAddress = postalAddress;
		this.productCode = productCode;
		this.bidderPrice = bidderPrice;
	}

	public float getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(float bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
}
