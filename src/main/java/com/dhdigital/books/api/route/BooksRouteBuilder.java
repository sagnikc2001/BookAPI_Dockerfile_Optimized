package com.dhdigital.books.api.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.apache.camel.component.jackson.JacksonDataFormat;

import com.dhdigital.books.api.model.BookRequest;
import com.dhdigital.books.api.model.BookResponse;
import com.dhdigital.books.api.model.backend.BookRequestBackend;
import com.dhdigital.books.api.model.backend.BookResponseBackend;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BooksRouteBuilder extends RouteBuilder{
	

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		 .bindingMode(RestBindingMode.auto);
		
		rest("/v1")
		
//		http://localhost:8080/v1/Book
		
		.post("/Book")
		 .type(BookRequest.class)
		 .outType(BookResponse.class)
		 .produces("application/json")
		 .consumes("application/json")
		 .to("direct:invoke-book-details");
		
		
		
		from("direct:invoke-book-details").routeId("bookDetails")
	    .to("bean:bookService?method=setBookRequestBackend") //Converting from JSON frontend POJO to XML Backend POJO
	    .marshal().jacksonXml(BookRequestBackend.class) // Marshalling to XML of type BookRequestBackend class
//	    .to("direct:invoke-send-to-backend") // Direct endpoint to send to the backend
	    .setHeader(Exchange.CONTENT_TYPE, constant("application/xml")) // Setting header of type xml for sending request to Backend endpoint
	    .to("{{booksDB.host}}"+"/Books?bridgeEndpoint=true") // https://94dd0060-f5fc-4bc9-a3fd-6202e3289f5d.mock.pstmn.io/Books?bridgeEndpoint=true
	    .unmarshal().jacksonXml(BookResponseBackend.class) // Unmarshalling XML response from backend endpoint to BookResponseBackend class
	    .to("bean:bookService?method=getBookResponseBackend") // Converting from XML backend POJO to JSON frontend POJO
	    .setHeader("Content-Type", constant("application/json")); // Setting the header of type JSON as JSON format is expected while declaration -- .produces("application/json")
		
	}
	
	
	
	

}
