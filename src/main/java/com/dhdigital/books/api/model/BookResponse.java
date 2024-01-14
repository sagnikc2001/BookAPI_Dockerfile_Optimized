package com.dhdigital.books.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "BookResponseDetails", "AuthorDetails" })
public class BookResponse {
	
	@JsonProperty("BookResponseDetails")
	protected BookResponseDetails bookResponseDetails;
	
	@JsonProperty("AuthorDetails")
	protected AuthorDetails authorDetails;
	
//	Getters and Setters

	public BookResponseDetails getBookResponseDetails() {
		return bookResponseDetails;
	}

	public void setBookResponseDetails(BookResponseDetails bookResponseDetails) {
		this.bookResponseDetails = bookResponseDetails;
	}

	public AuthorDetails getAuthorDetails() {
		return authorDetails;
	}

	public void setAuthorDetails(AuthorDetails authorDetails) {
		this.authorDetails = authorDetails;
	}

}
