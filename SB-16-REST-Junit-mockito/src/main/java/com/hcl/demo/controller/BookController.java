package com.hcl.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.dto.BookDTO;
import com.hcl.demo.entity.Book;
import com.hcl.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("")
	public ResponseEntity<List<BookDTO>> getBooks() {
		
		List<BookDTO> bookListDTO=bookService.getAllBooks();
		if(bookListDTO.size()==0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookListDTO));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getBookById(@PathVariable int id) {
		
		Optional<Book> book=bookService.getBookById(id);
		if(book.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(book);
		}else {
			return new ResponseEntity<>("Book with given id is not found!!!",HttpStatus.NOT_FOUND);
		}
	
	}
	
	@PostMapping("")
	public ResponseEntity<BookDTO> addNewBook(@RequestBody  BookDTO bookDto) {
		try {
			BookDTO dto =  bookService.addBook(bookDto);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		}catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("bookId")  int id) {
		try {
			bookService.deleteBookById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
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
