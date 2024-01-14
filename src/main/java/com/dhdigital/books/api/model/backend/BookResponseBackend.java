package com.dhdigital.books.api.model.backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD) // specify the access type for fields when marshalling (converting an object to XML) or unmarshalling (converting XML to an object) in the context of XML binding.
@XmlType(propOrder = {
		"bookResponseDetailsBackend",
		"authorDetailsBackend"
	})
@XmlRootElement(name = "BookResponse") // Setting the XML root element to BookResponse -- <BookResponse>....</BookResponse>
public class BookResponseBackend {
	
	@XmlElement(name="Book")
	protected BookResponseDetailsBackend bookResponseDetailsBackend;
	
	@XmlElement(name="Author")
	protected AuthorDetailsBackend authorDetailsBackend;
	
//	Getters and Setters

	public BookResponseDetailsBackend getBookResponseDetailsBackend() {
		return bookResponseDetailsBackend;
	}

	public void setBookResponseDetailsBackend(BookResponseDetailsBackend bookResponseDetailsBackend) {
		this.bookResponseDetailsBackend = bookResponseDetailsBackend;
	}

	public AuthorDetailsBackend getAuthorDetailsBackend() {
		return authorDetailsBackend;
	}

	public void setAuthorDetailsBackend(AuthorDetailsBackend authorDetailsBackend) {
		this.authorDetailsBackend = authorDetailsBackend;
	}	
}
