package com.hcl.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBook() {
		
		List<Book> bookList=(List)bookRepository.findAll();
		System.out.println("Getting data from DB "+bookList);
		return bookList;
	}
	
	@Cacheable(cacheNames = "books",key = "#id")
	public Book getBookById(int id) {
		
		Book book= bookRepository.findById(id)
					.orElseThrow(()->{
							log.info("book not found with id {}",id);
							return new ResourceAccessException("book not found with id"+id);
					});
		System.out.println("successfully fetched book from DB "+book);
		log.info("successfully fetched book {} with id {}",book,id);
		return book;
	}
	
	public Book addBook(Book book) {
		Book book2 = bookRepository.save(book);
		System.out.println("Artificially Saving data to DB "+book2);
		return book2;
	}

	@CacheEvict(cacheNames = "books",key = "#id")
	public String deleteBook(int id) {
		
		Optional<Book> book = bookRepository.findById(id);
		System.out.println("Artificially Deleting data to DB "+book);
		 bookRepository.delete(book.get());
		
		 return "book deleted succesfully";
	}

	
	@CachePut(cacheNames = "books",key = "#id")
	public Book updateBook(Book book, int id) {
		
		return bookRepository.save(book);
	}
}
