package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;
import com.hcl.demo.exceptions.BusinessException;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		
		List<Book> bookList=(List)bookRepository.findAll();
		System.out.println(bookList);
		return bookList;
	}
	
	public List<Book> getBookByAuthor(String author) {
	
		List<Book> books =  bookRepository.findBookByAuthor(author);
		System.out.println(books);
		return books;
	}
	
	public Book addBook(Book book) {
		
		Book savedBook = bookRepository.save(book);
		System.out.println(savedBook);
		return savedBook;
	}

	public void deleteBookById(int id) {
		
		bookRepository.deleteById(id);
		
	}

	

	public void updateBook(Book book, int id) {
		
		bookRepository.save(book);
	}

	public Optional<Book> getBookById(int id) {
		
	Optional<Book> book = bookRepository.findById(id);
	try {
		
		if(book.get().getTitle().equalsIgnoreCase("LET US C")) {
			//BusinessException be = new BusinessException("403","Not Allowed to  access this Employee");
			throw new PermissionDeniedDataAccessException("Dont Access Book with this Name1", null);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}	
		return book;
	}
}
