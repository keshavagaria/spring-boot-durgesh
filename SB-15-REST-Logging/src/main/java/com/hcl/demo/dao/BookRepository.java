package com.hcl.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.demo.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

	List<Book> findBookByAuthor(String author);
}
