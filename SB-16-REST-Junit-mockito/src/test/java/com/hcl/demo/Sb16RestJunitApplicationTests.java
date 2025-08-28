package com.hcl.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;
import com.hcl.demo.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Sb16RestJunitApplicationTests {
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;

	@Test
	public void getBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream.of(
				new Book(1,"Java","James Gosling"),
				new Book(2,"C++","Dennies Ritchie")).collect(Collectors.toList()));
		
		assertEquals(2, bookService.getAllBook().size());
	}

	@Test
	public void getBookByAuthorTest() {
		String author = "Vishal Singh";
		
		when(bookRepository.findBookByAuthor(author)).thenReturn(
			Stream.of(new Book(2,"Java","James Gosling")).collect(Collectors.toList()));
		assertEquals(1,bookService.getBookByAuthor(author).size());
	}
	
	@Test
	public void saveBookTest() {
		Book book=new Book(3, "Let Us C", "Yashwant Kanetkar");
		when(bookRepository.save(book)).thenReturn(book);
		
		assertEquals(book, bookService.addBook(book));
	}
	
	@Test
	public void deleteBookByIdtest() {
		Book book=new Book(3, "Let Us C", "Yashwant Kanetkar");
		int id = 3;
		bookService.deleteBookById(id);
		verify(bookRepository,times(1)).deleteById(id);
	}
}
