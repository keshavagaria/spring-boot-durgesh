package com.hcl.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.hcl.demo.entity.Book;

@Component
public class BookService {

	private static List<Book> bookList=new ArrayList<>();
	
	static {
		bookList.add(new Book(101, "Java Complete Reference Guide", "ABC"));
		bookList.add(new Book(102, "Java Black Book", "DEF"));
		bookList.add(new Book(103, "Head First To Java", "XYZ"));
	}
	
	public List<Book> getAllBook() {
		
		return bookList;
	}
	
	public Book getBookById(int id) {
		Book book=null;
		try {
		book=bookList.stream().filter(e->e.getId()==id).findFirst().get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public void addBook(Book book) {
		
		bookList.add(book);
	}

	public void deleteBookById(int id) {
		
		bookList=bookList.stream().filter(e->e.getId()!=id)
				.collect(Collectors.toList());
		
	}

	

	public void updateBook(Book book, int id) {
		
		bookList= bookList.stream().map(e->
		{
			if(e.getId()==id) {
				e.setAuthor(book.getAuthor());
				e.setTitle(book.getTitle());
			}
			return e;
		}).collect(Collectors.toList());
		
	}
}
