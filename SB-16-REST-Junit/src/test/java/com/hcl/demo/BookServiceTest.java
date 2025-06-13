package com.hcl.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;
import com.hcl.demo.service.BookService;

@SpringBootTest
public class BookServiceTest {

	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepository bookRepository;
	
	@Test
	public void getBookById() {
		
		when(bookRepository.findById(1)).thenReturn(createBookStub());
		
		Book testedBook = bookService.getBookById(1);
		
		assertEquals(testedBook.getTitle(), "The Java Black Book");
	}
	
	public  Optional<Book>  createBookStub() {
		Book book = Book.builder().id(1).title("The Java Black Book").build();
		
		return Optional.of(book);
		
	}
}
