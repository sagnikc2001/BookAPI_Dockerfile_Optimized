package com.dhdigital.books.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class BookBuy {

	@JsonProperty("amazon")
	private String amazonBuyLink;

	@JsonProperty("flipkart")
	private String flipkartBuyLink;

//	Getters and Setters

	public String getAmazonBuyLink() {
		return amazonBuyLink;
	}

	public void setAmazonBuyLink(String amazonBuyLink) {
		this.amazonBuyLink = amazonBuyLink;
	}

	public String getFlipkartBuyLink() {
		return flipkartBuyLink;
	}

	public void setFlipkartBuyLink(String flipkartBuyLink) {
		this.flipkartBuyLink = flipkartBuyLink;
	}

//	Default Constructor

	public BookBuy() {
		super();
	}
	
//	Parameterized Constructor

	public BookBuy(String amazonBuyLink, String flipkartBuyLink) {
		super();
		this.amazonBuyLink = amazonBuyLink;
		this.flipkartBuyLink = flipkartBuyLink;
	}
	
//	toString

	@Override
	public String toString() {
		return "BookBuy [amazonBuyLink=" + amazonBuyLink + ", flipkartBuyLink=" + flipkartBuyLink + "]";
	}
	
}
