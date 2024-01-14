package com.dhdigital.books.api;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.UseAdviceWith;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dhdigital.books.api.model.BookRequest;
import com.dhdigital.books.api.model.BookResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

@CamelSpringBootTest
@SpringBootApplication
@WebAppConfiguration
@UseAdviceWith
@PropertySource("classpath:application-test.properties")
@ComponentScan("com.dhdigital.books.api.*")
public class BooksRouteBuilderTest{
	
	@Autowired
	CamelContext camelContext;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ProducerTemplate producerTemplate;

	@Autowired
	ApplicationContext applicationContext;

	// @EndpointInject("mock://"+"{{booksDB.host}}"+"/Books") // mock://https://94dd0060-f5fc-4bc9-a3fd-6202e3289f5d.mock.pstmn.io/Books
	@EndpointInject("mock://https://94dd0060-f5fc-4bc9-a3fd-6202e3289f5d.mock.pstmn.io/Books")
	private MockEndpoint bookDetailsEndpoint;
	
	@Test
	public void book_route_Test() throws Exception{
		
		String bookDetailsRequest = Resources.toString(Resources.getResource("mock/frontend/BookDetails/BookDetailsRequest.json")
				, Charsets.UTF_8);
		
		
		String bookDetailsResponse = Resources.toString(Resources.getResource("mock/backend/BookDetails/BookDetailsResponse.json")
				, Charsets.UTF_8);
		
		
		AdviceWith.adviceWith(camelContext, "bookDetails", routeBuilder -> {
			routeBuilder.replaceFromWith("direct:invoke-book-details");
		});
		
		camelContext.start();
		
		bookDetailsEndpoint.expectedMessageCount(1);
		bookDetailsEndpoint.whenAnyExchangeReceived(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.getMessage().setBody(bookDetailsResponse);
			}
		});
		
		BookRequest oBookRequest = objectMapper.readValue(bookDetailsRequest, BookRequest.class);
		
		BookResponse oBookResponse = producerTemplate.requestBody("direct:invoke-book-details", oBookRequest, BookResponse.class);
		
		System.out.println("Response:"+ oBookResponse.getBookResponseDetails().toString());
		
		Assertions.assertTrue(null != oBookResponse.getBookResponseDetails().getName());
	}
}
