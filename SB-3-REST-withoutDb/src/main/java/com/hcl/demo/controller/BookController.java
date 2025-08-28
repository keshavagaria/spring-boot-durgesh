package com.hcl.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.Book;
import com.hcl.demo.service.BookService;

@RestController
public class BookController {

	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	/*
	@GetMapping("/books")
	public List<Book> getBooks() {
		
//		Book book=new Book();
//		book.setId(101);
//		book.setAuthor("Vishal");
//		book.setTitle("Java Complete Reference Guide...");
		return bookService.getAllBook();
	}
	
	@GetMapping("/books/{id}")
	public Book getBooks(@PathVariable int id) {
		

		return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addNewBook(@RequestBody  Book book) {
		
		bookService.addBook(book);
		return book;
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBookById(@PathVariable("bookId")  int id) {
		
		bookService.deleteBookById(id);
		
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateTheBook(@RequestBody Book book,
						   @PathVariable("bookId")  int id) {
		
		bookService.updateBook(book,id);
		
		return book;
	}
	*/
	
	//*****************************WITH RESPONSEENTITY*************************************
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		
		List<Book> bookList=bookService.getAllBook();
		logger.info("Fetching All Books {}",bookList);
		
		if(bookList.size()==0) {
			logger.error("Books Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookList));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBooks(@PathVariable int id) {
		
		Book book=bookService.getBookById(id);
		logger.info("Fetching  Book by id {}",book);
		
		if(book==null) {
			logger.error("Book Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addNewBook(@RequestBody  Book book) {
		try {
			bookService.addBook(book);
			logger.info("Saving  Book to Collection {}",book);
			return ResponseEntity.of(Optional.of(book));
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to save book detail",book);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bookId")  int id) {
		try {
			bookService.deleteBookById(id);
			logger.info("Deleting  Book by id {}",id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to delete book detail",id);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateTheBook(@RequestBody Book book,
							  @PathVariable("bookId")  int id) {
		try {
			bookService.updateBook(book,id);
			return ResponseEntity.ok().body(book);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
