package com.dhdigital.books.api.model.backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD) // specify the access type for fields when marshalling (converting an object to
										// XML) or unmarshalling (converting XML to an object) in the context of XML
										// binding.
@XmlRootElement(name = "Book") // Setting the XML root element to book -- <book>....</book>
public class AuthorBooksBackend {

	@XmlElement(name = "BookName") // For naming XML Element same as variable -- <BookName>....</BookName>
	private String bookName;

	@XmlElement(name = "PublisherName")
	private String publisherName;

	@XmlElement(name = "BookGenre")
	private String bookGenre;

	@XmlElement(name = "BookLanguage")
	private String bookLanguage;

	@XmlElement(name = "BookPages")
	private int bookPages;

//	Getters and Setters

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

//	Default Constructor

	public AuthorBooksBackend() {
		super();
	}
	
//	Parameterized Constructor

	public AuthorBooksBackend(String bookName, String publisherName, String bookGenre, String bookLanguage,
			int bookPages) {
		super();
		this.bookName = bookName;
		this.publisherName = publisherName;
		this.bookGenre = bookGenre;
		this.bookLanguage = bookLanguage;
		this.bookPages = bookPages;
	}
	
//	toString

	@Override
	public String toString() {
		return "AuthorBooksBackend [bookName=" + bookName + ", publisherName=" + publisherName + ", bookGenre="
				+ bookGenre + ", bookLanguage=" + bookLanguage + ", bookPages=" + bookPages + "]";
	}
	
}
