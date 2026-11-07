package com.hcl.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.demo.dto.BookDTO;
import com.hcl.demo.entity.Book;
import com.hcl.demo.service.BookService;

@WebMvcTest(controllers = BookController.class)
public class BookControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	
	@Test
	void test_createBook_whenValidBookProvided_returnsCreatedBook() throws Exception{
		
		// Arrange
		
		Book book = new Book();
		book.setId(777);
		book.setTitle("Titanic");
		book.setAuthor("James Cameron");
		
		BookDTO bookDTO =  new ModelMapper().map(book, BookDTO.class);
		
		RequestBuilder requestBuilder =  MockMvcRequestBuilders.post("/books")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(bookDTO));
		
		Mockito.when(bookService.addBook(Mockito.any(BookDTO.class))).thenReturn(bookDTO);
		
		// Act
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String responseBodyAsString = mvcResult.getResponse().getContentAsString();
		BookDTO createdBookDTO =  new ObjectMapper().readValue(responseBodyAsString, BookDTO.class);
		
		// Assert
		Assertions.assertEquals(bookDTO.getId(), createdBookDTO.getId());
		Assertions.assertEquals(bookDTO.getTitle(), createdBookDTO.getTitle());
		Assertions.assertEquals(bookDTO.getAuthor(), createdBookDTO.getAuthor());
		Assertions.assertFalse(createdBookDTO.getId() == 0,"book id should  not be empty");
		
		
	}
}
