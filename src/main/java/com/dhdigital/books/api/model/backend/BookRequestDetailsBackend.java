package com.dhdigital.books.api.model.backend;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD) // specify the access type for fields when marshalling (converting an object to XML) or unmarshalling (converting XML to an object) in the context of XML binding.
@XmlRootElement(name = "Book") // Setting the XML root element to book -- <book>....</book>
public class BookRequestDetailsBackend {

	@XmlElement(name = "Id") // For naming XML Element same as variable -- <Id>....</Id>
	private int id;

	@XmlElement(name = "BookName")
	private String bookName;

//	Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return bookName;
	}

	public void setName(String name) {
		this.bookName = name;
	}

//	Default Constructor

	public BookRequestDetailsBackend() {
		super();
	}

//	Parameterized Constructor

	public BookRequestDetailsBackend(int id, String name) {
		super();
		this.id = id;
		this.bookName = name;
	}

//	toString

	@Override
	public String toString() {
		return "BookRequestDetails [id=" + id + ", bookName=" + bookName + "]";
	}

}
