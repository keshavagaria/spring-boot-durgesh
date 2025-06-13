package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBook() {
		
		List<Book> bookList=(List)bookRepository.findAll();
		return bookList;
	}
	
	public Book getBookById(int id) {
		
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}
	
	public void addBook(Book book) {
		
		bookRepository.save(book);
	}

	public void deleteBookById(int id) {
		
		bookRepository.deleteById(id);
		
	}

	

	public void updateBook(Book book, int id) {
		
		bookRepository.save(book);
	}
}
