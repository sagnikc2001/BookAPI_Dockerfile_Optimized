package com.dhdigital.books.api.model.backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD) // specify the access type for fields when marshalling (converting an object to
										// XML) or unmarshalling (converting XML to an object) in the context of XML
										// binding.
@XmlRootElement(name = "Book") // Setting the XML root element to book -- <book>....</book>
public class BookResponseDetailsBackend {

	@XmlElement(name = "BookName") // For naming XML Element same as variable -- <bookName>....</bookName>
	private String bookName;

	@XmlElement(name = "AuthorName")
	private String authorName;

	@XmlElement(name = "PublisherName")
	private String publisherName;

	@XmlElement(name = "BookPrice")
	private int bookPrice;

	@XmlElement(name = "BookGenre")
	private String bookGenre;

	@XmlElement(name = "BookLanguage")
	private String bookLanguage;

	@XmlElement(name = "BookPages")
	private int bookPages;

	@XmlElement(name = "Link")
	private BookBuyBackend bookBuyBackend;

//	Getters and Setters

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
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

	public BookBuyBackend getBookBuyBackend() {
		return bookBuyBackend;
	}

	public void setBookBuyBackend(BookBuyBackend bookBuyBackend) {
		this.bookBuyBackend = bookBuyBackend;
	}

//	Default Constructor

	public BookResponseDetailsBackend() {
		super();
	}
	
//	Parameterized Constructor

	public BookResponseDetailsBackend(String bookName, String authorName, String publisherName, int bookPrice,
			String bookGenre, String bookLanguage, int bookPages, BookBuyBackend bookBuyBackend) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.bookPrice = bookPrice;
		this.bookGenre = bookGenre;
		this.bookLanguage = bookLanguage;
		this.bookPages = bookPages;
		this.bookBuyBackend = bookBuyBackend;
	}
	
//	toString

	@Override
	public String toString() {
		return "BookResponseDetailsBackend [bookName=" + bookName + ", authorName=" + authorName + ", publisherName="
				+ publisherName + ", bookPrice=" + bookPrice + ", bookGenre=" + bookGenre + ", bookLanguage="
				+ bookLanguage + ", bookPages=" + bookPages + ", bookBuyBackend=" + bookBuyBackend + "]";
	}
}
