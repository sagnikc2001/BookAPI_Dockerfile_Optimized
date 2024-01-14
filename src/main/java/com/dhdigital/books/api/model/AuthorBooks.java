package com.dhdigital.books.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorBooks {

	@JsonProperty("bookName")
	private String bookName;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("genre")
	private String genre;

	@JsonProperty("language")
	private String language;

	@JsonProperty("pages")
	private int pages;

//	Getters and Setters

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

//	Default Constructor

	public AuthorBooks() {
		super();
	}
	
//	Parameterized Constructor

	public AuthorBooks(String bookName, String publisher, String genre, String language, int pages) {
		super();
		this.bookName = bookName;
		this.publisher = publisher;
		this.genre = genre;
		this.language = language;
		this.pages = pages;
	}
	
//	toString

	@Override
	public String toString() {
		return "AuthorBooks [bookName=" + bookName + ", publisher=" + publisher + ", genre=" + genre + ", language="
				+ language + ", pages=" + pages + "]";
	}
	

}
