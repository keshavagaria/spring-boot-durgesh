package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Service;

import com.hcl.demo.dao.BookRepository;
import com.hcl.demo.dto.BookDTO;
import com.hcl.demo.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<BookDTO> getAllBooks() {
		
		List<Book> bookList=(List)bookRepository.findAll();
		List<BookDTO> bookDTOs = new ArrayList<>();
		for(Book book : bookList) {
			BookDTO bookDTO = this.modelMapper.map(book, BookDTO.class);
			bookDTOs.add(bookDTO);
		}
		System.out.println(bookList);
		return bookDTOs;
	}
	
	public List<Book> getBookByAuthor(String author) {
	
		List<Book> books =  bookRepository.findBookByAuthor(author);
		System.out.println(books);
		return books;
	}
	
	public BookDTO addBook(BookDTO bookDto) {
		
		Book book = new ModelMapper().map(bookDto, Book.class);
		Book savedBook = bookRepository.save(book);
		System.out.println(savedBook);
		return new ModelMapper().map(savedBook, BookDTO.class);
		
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
