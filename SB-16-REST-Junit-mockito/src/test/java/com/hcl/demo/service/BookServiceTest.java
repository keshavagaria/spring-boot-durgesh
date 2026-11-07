//package com.hcl.demo.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.assertj.core.util.Arrays;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.PermissionDeniedDataAccessException;
//
//import com.hcl.demo.dao.BookRepository;
//import com.hcl.demo.entity.Book;
//
//@SpringBootTest
//public class BookServiceTest {
//
//	@InjectMocks
//	BookService bookService;
//		
//	@Mock
//	BookRepository bookRepository;
//	
//	@Test
//	public void getBookAllBooks() {
//		
//		when(bookRepository.findAll()).thenReturn(createMultipleBooksStub());
//		List<Book> books = bookService.getAllBooks();	
//		assertEquals(4,books.size());
//	}
//	
//	@Test
//	public void getBookById() {
//		
//		when(bookRepository.findById(1)).thenReturn(createBookStub());
//		Optional<Book> testedBook = bookService.getBookById(1);
//		assertEquals(testedBook.get().getTitle(), "The Java Black Book");
//	}
//	
//	@Test
//	public void getBookByAuthorTest() {
//		
//		String author="Chetan Bhagat";
//		when(bookRepository.findBookByAuthor(author)).thenReturn(createMultipleBooksStub2(author));
//		List<Book> books = bookService.getBookByAuthor(author);
//		assertEquals(2, books.size());
//		
//	}
//	
//	@Test
//	public void addBookTest() {
//		
//		Book book = new Book();
//		book.setId(555);
//		book.setAuthor("Vishu");
//		book.setTitle("Game of Thrones");
//		
//		Optional<Book> book2 =  createBookStub();
//		
//		when(bookRepository.save(book2.get())).thenReturn(book2.get());
//		Book savedBook = bookService.addBook(book2.get());
//		assertEquals(book2.get().getId(), savedBook.getId());
//		
//	}
//	
//	@Test
//	public void getBookByIdWithException() {
//		
//		when(bookRepository.findById(1)).thenReturn(createBookStubWithException());
//		PermissionDeniedDataAccessException ex = assertThrows(PermissionDeniedDataAccessException.class,() -> bookService.getBookById(1));
//		assertEquals(ex.getMessage(), "Dont Access Book with this Name");
//	}
//	
//	public  Optional<Book>  createBookStub() {
//		Book book = Book.builder().id(1).author("James GOsling").title("The Java Black Book").build();
//		return Optional.of(book);	
//	}
//	
//	public  Optional<Book>  createBookStubWithException() {
//		Book book = Book.builder().id(2).title("LET US C").build();
//		return Optional.of(book);
//		
//	}
//	
//	public  List<Book>  createMultipleBooksStub() {
//		
//		List<Book> books = new ArrayList<>();
//		books.add(new Book(101, "JK Rowling", "harry Potter"));
//		books.add(new Book(102, "Chetan Bhagat", "Half Girlfriend"));
//		books.add(new Book(103, "Puolo Coelho", "The Alchemist"));
//		books.add(new Book(104, "Chetan Bhagat", "Five Point Someone"));
//		return books;	
//	}
//	
//	public  List<Book>  createMultipleBooksStub2(String author) {
//		
//		List<Book> books = new ArrayList<>();
//		books.add(new Book(101, "JK Rowling", "harry Potter"));
//		books.add(new Book(102, "Chetan Bhagat", "Half Girlfriend"));
//		books.add(new Book(103, "Puolo Coelho", "The Alchemist"));
//		books.add(new Book(104, "Chetan Bhagat", "Five Point Someone"));
//		
//		List<Book> books2 = books.stream().filter(e -> author.equals(e.getAuthor())).collect(Collectors.toList());
//		return books2;	
//	}
//}
//
//
//
//
//
//
