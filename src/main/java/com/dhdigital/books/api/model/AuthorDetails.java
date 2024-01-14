package com.dhdigital.books.api.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorDetails {

	@JsonProperty("name")
	private String name;

	@JsonProperty("yearBorn")
	private int yearBorn;

	@JsonProperty("numberOfBooks")
	private int numberOfBooks;

	@JsonProperty("country")
	private String country;

	@JsonProperty("moreBooks")
	protected List<AuthorBooks> authorBooks;

//	Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public int getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(int numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<AuthorBooks> getAuthorBooks() {
		return authorBooks;
	}

	public void setAuthorBooks(List<AuthorBooks> authorBooks) {
		this.authorBooks = authorBooks;
	}

//	Default Constructor

	public AuthorDetails() {
		super();
	}
	
//	Parameterized Constructor

	public AuthorDetails(String name, int yearBorn, int numberOfBooks, String country, List<AuthorBooks> authorBooks) {
		super();
		this.name = name;
		this.yearBorn = yearBorn;
		this.numberOfBooks = numberOfBooks;
		this.country = country;
		this.authorBooks = authorBooks;
	}
	

//	toString

	@Override
	public String toString() {
		return "AuthorDetails [name=" + name + ", yearBorn=" + yearBorn + ", numberOfBooks=" + numberOfBooks
				+ ", country=" + country + ", authorBooks=" + authorBooks + "]";
	}
}
