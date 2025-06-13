package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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
	
	public Optional<Book> getBookById(int id) {
		
		return bookRepository.findById(id);
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
