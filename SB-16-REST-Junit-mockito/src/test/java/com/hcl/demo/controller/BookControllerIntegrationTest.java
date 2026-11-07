//package com.hcl.demo.controller;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.hcl.demo.dao.BookRepository;
//import com.hcl.demo.entity.Book;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//public class BookControllerIntegrationTest {
//
//	@Autowired
//	TestRestTemplate testRestTemplate;
//	
//	@Autowired
//	private BookRepository bookRepository;
//	
//	@BeforeEach
//    void cleanDb() {
//		bookRepository.deleteAll();
//    }
//	
//	@Test
//    void addNewBook() {
//		
//		//given
//		Book book = new Book(123, "ALchemist","Paolo Coelho");
//		
//		// when
//		ResponseEntity<Book> response = testRestTemplate
//										.postForEntity("/books", book, Book.class);
//
//		
//		//then
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
//	}
//	
//	 @Test
//	 void testGetBookById() {
//	        Book saved = bookRepository.save(new Book(222, "Java Black Book",
//	        										"James Gosling"));
//
//	        ResponseEntity<Book> response = testRestTemplate
//	        							.getForEntity("/books/" + saved.getId(), Book.class);
//
//	        assertEquals(HttpStatus.OK, response.getStatusCode());
//	        assertEquals("Java Black Book", response.getBody().getTitle());
//	    }
//}
