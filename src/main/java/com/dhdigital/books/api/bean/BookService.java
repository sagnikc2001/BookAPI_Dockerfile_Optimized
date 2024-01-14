package com.dhdigital.books.api.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.apache.camel.Message;

import com.dhdigital.books.api.model.AuthorBooks;
import com.dhdigital.books.api.model.AuthorDetails;
import com.dhdigital.books.api.model.BookBuy;
import com.dhdigital.books.api.model.BookRequest;
import com.dhdigital.books.api.model.BookRequestDetails;
import com.dhdigital.books.api.model.BookResponse;
import com.dhdigital.books.api.model.BookResponseDetails;
import com.dhdigital.books.api.model.backend.AuthorBooksBackend;
import com.dhdigital.books.api.model.backend.AuthorDetailsBackend;
import com.dhdigital.books.api.model.backend.BookBuyBackend;
import com.dhdigital.books.api.model.backend.BookRequestBackend;
import com.dhdigital.books.api.model.backend.BookRequestDetailsBackend;
import com.dhdigital.books.api.model.backend.BookResponseBackend;
import com.dhdigital.books.api.model.backend.BookResponseDetailsBackend;

@Component
public class BookService {
	
	public void setBookRequestBackend(Exchange exchange) throws Exception{
		
		Message oMessage = exchange.getIn(); //Getting Body of Route
		
		BookRequest bookRequest = oMessage.getBody(BookRequest.class); // Getting BookRequest body from Route Body
		
		BookRequestDetails bookRequestDetails = new BookRequestDetails(); // Creating new object for BookRequestDetails
		
		bookRequestDetails = bookRequest.getBookRequestDetails(); // Setting content of newly created BookRequestDetails objects equal to BookRequestDetails we got from Body
		
		BookRequestDetailsBackend bookRequestDetailsBackend = new BookRequestDetailsBackend(); // Creating new object of BookRequestDetailsBackend class
		
		BookRequestBackend bookRequestBackend = new BookRequestBackend(); // Creating new object of BookRequestBackend class
	
//		Setting values from bookRequestDetails frontend object to bookRequestDetailsBackend backend object
		
		bookRequestDetailsBackend.setId(bookRequestDetails.getId());
		bookRequestDetailsBackend.setName(bookRequestDetails.getName());
		
		bookRequestBackend.setBookRequestDetailsBackend(bookRequestDetailsBackend); // Setting bookRequestDetailsBackend backend object to bookRequestBackend backend object
		
		oMessage.setBody(bookRequestBackend); // Setting bookRequestBackend backend object to route body for sending to Backend endpoint
		
	}
	
	public void getBookResponseBackend(Exchange exchange) throws Exception{
		
		Message oMessage = exchange.getIn(); //Getting Body of Route
		
		BookResponseBackend bookResponseBackend = oMessage.getBody(BookResponseBackend.class); // Getting BookResponseBackend body from Route Body
		
		BookResponseDetailsBackend bookResponseDetailsBackend = new BookResponseDetailsBackend(); // Creating new object of BookRequestBackend backend class
		
		bookResponseDetailsBackend = bookResponseBackend.getBookResponseDetailsBackend(); // Setting content of newly created bookResponseDetailsBackend objects equal to getBookResponseDetailsBackend we got from Body
		
		BookResponseDetails bookResponseDetails = new BookResponseDetails(); // Creating new object of BookResponseDetails class
		
		BookResponse bookResponse = new BookResponse(); // Creating new object of BookResponse class
		
//		Setting values from bookResponseDetailsBackend backend object to bookResponseDetails frontend object
		
		bookResponseDetails.setAuthorName(bookResponseDetailsBackend.getAuthorName());
		bookResponseDetails.setGenre(bookResponseDetailsBackend.getBookGenre());
		bookResponseDetails.setLanguage(bookResponseDetailsBackend.getBookLanguage());
		bookResponseDetails.setName(bookResponseDetailsBackend.getBookName());
		bookResponseDetails.setPages(bookResponseDetailsBackend.getBookPages());
		bookResponseDetails.setPrice(bookResponseDetailsBackend.getBookPrice());
		bookResponseDetails.setPublisher(bookResponseDetailsBackend.getPublisherName());
		
		BookBuyBackend bookBuyBackend = new BookBuyBackend(); // Creating new object of BookBuyBackend backend class
		bookBuyBackend = bookResponseDetailsBackend.getBookBuyBackend(); // Setting newly created object bookBuyBackend equal to the getBookBuyBackend from bookResponseDetailsBackend
		
		BookBuy bookBuy = new BookBuy(); // Creating new object of BookBuy frontend class
		
//		Setting values from bookBuyBackend backend object to bookBuy frontend object
		
		bookBuy.setAmazonBuyLink(bookBuyBackend.getAmazonBuyLink());
		bookBuy.setFlipkartBuyLink(bookBuyBackend.getFlipkartBuyLink());
		
		bookResponseDetails.setBookBuy(bookBuy); // Setting bookBuy frontend object to bookResponseDetails frontend object
		
		bookResponse.setBookResponseDetails(bookResponseDetails); // Setting bookResponseDetails frontend object to bookResponse frontend object
		
		AuthorDetailsBackend authorDetailsBackend = new AuthorDetailsBackend(); // Creating new object of AuthorDetailsBackend backend class
		
		authorDetailsBackend = bookResponseBackend.getAuthorDetailsBackend(); // Setting newly created object authorDetailsBackend equal to the getAuthorDetailsBackend from bookResponseBackend
		
		AuthorDetails authorDetails = new AuthorDetails(); // Creating new object of AuthorDetails frontend class

//		Setting values from authorDetailsBackend backend object to authorDetails frontend object
		
		authorDetails.setCountry(authorDetailsBackend.getCountry());
		authorDetails.setName(authorDetailsBackend.getName());
		authorDetails.setNumberOfBooks(authorDetailsBackend.getNumberOfBooks());
		authorDetails.setYearBorn(authorDetailsBackend.getYearBorn());
		
		List<AuthorBooksBackend> authorBooksBackend = new ArrayList<>(); // Creating new list object of AuthorBooksBackend backend class
		
		authorBooksBackend = authorDetailsBackend.getAuthorBooksBackend(); // Setting newly created object authorBooksBackend equal to the getAuthorBooksBackend from authorDetailsBackend
		
		List<AuthorBooks> authorBooks = new ArrayList<>(); // Creating new object of AuthorBooks frontend class
		
		 // Map each AuthorBooksBackend to AuthorBooks
		for(AuthorBooksBackend backendBook : authorBooksBackend)
		{
			 AuthorBooks authorBook = new AuthorBooks(); // Single entity of authorBook to be added to authorBooks
			 
			 authorBook.setBookName(backendBook.getBookName());
	         authorBook.setPublisher(backendBook.getPublisherName());
	         authorBook.setGenre(backendBook.getBookGenre());
	         authorBook.setLanguage(backendBook.getBookLanguage());
	         authorBook.setPages(backendBook.getBookPages());
	         authorBooks.add(authorBook);
		}
		
		// Set the mapped authorBooks list in the authorDetails
        authorDetails.setAuthorBooks(authorBooks);
		
		bookResponse.setAuthorDetails(authorDetails);
		
		oMessage.setBody(bookResponse); // Setting bookResponse in body of route 
	}

	
}
