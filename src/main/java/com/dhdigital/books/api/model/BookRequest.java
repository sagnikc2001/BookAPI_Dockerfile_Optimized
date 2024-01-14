package com.dhdigital.books.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequest {
	
	@JsonProperty("BookRequestDetails")
	protected BookRequestDetails bookRequestDetails;
	
//	Getters and Setters

	public BookRequestDetails getBookRequestDetails() {
		return bookRequestDetails;
	}

	public void setBookRequestDetails(BookRequestDetails bookRequestDetails) {
		this.bookRequestDetails = bookRequestDetails;
	}
	
	

}
