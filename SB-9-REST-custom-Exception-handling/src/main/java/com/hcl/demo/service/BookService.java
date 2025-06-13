package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.entity.Book;
import com.hcl.demo.exception.BusinessException;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		List<Book> bookList=null;
		try {
			bookList=(List)bookRepository.findAll();
		}catch(Exception e) {
			throw new BusinessException("605","Something wrong in service layer while fetching list!!!"+e.getMessage() );
		}
			if(bookList.isEmpty()) {
				throw new BusinessException("604","List is all empty!!!");
			}
			return bookList;
		
	}
	
	public Optional<Book> getBookById(int id) {
		try {
			Optional<Book> book=bookRepository.findById(id);
			if(book.isEmpty()) {
				throw new BusinessException("606","Given Book id don't exist in DB!!!");
			}
		return book;
		}catch (NoSuchElementException e) {
			throw new BusinessException("607","No Such Element Present");
		}
	}
	
	public void addBook(Book book) {
		
			if(book.getAuthor().isEmpty() || book.getAuthor().length()==0) {
				throw new BusinessException("601","Book Author name is null. Please correct it");
			}
			try {
			bookRepository.save(book);
			
		}catch (IllegalArgumentException e) {
			throw new BusinessException("602","Book Object is null "+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603","Something wrong in service layer!!!"+e.getMessage() );
		}
	}

	public void deleteBookById(int id) {
		try {
			bookRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608","Book id is null!!!");
		}
		
	}

	

	public void updateBook(Book book, int id) {
		
		bookRepository.save(book);
	}
}
