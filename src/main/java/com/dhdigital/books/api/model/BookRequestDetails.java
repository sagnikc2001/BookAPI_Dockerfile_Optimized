package com.dhdigital.books.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequestDetails {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

//	Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	Default Constructor

	public BookRequestDetails() {
		super();
	}

//	Parameterized Constructor

	public BookRequestDetails(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
//	toString

	@Override
	public String toString() {
		return "BookRequestDetaisls [id=" + id + ", name=" + name + "]";
	}

	
}
