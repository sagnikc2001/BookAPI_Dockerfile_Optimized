package com.dhdigital.books.api.model.backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD) // specify the access type for fields when marshalling (converting an object to XML) or unmarshalling (converting XML to an object) in the context of XML binding.
@XmlRootElement(name = "BookRequest") // Setting the XML root element to BookRequest -- <BookRequest>....</BookRequest>
public class BookRequestBackend {
	
	@XmlElement(name="BookRequestDetails")
	protected BookRequestDetailsBackend bookRequestDetailsBackend;
	
//	Getters and Setters

	public BookRequestDetailsBackend getBookRequestDetailsBackend() {
		return bookRequestDetailsBackend;
	}

	public void setBookRequestDetailsBackend(BookRequestDetailsBackend bookRequestDetailsBackend) {
		this.bookRequestDetailsBackend = bookRequestDetailsBackend;
	}

}
