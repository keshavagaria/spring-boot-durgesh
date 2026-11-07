package com.hcl.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Author {

	@Autowired
	@Lazy                   // just a hack not actual solution
	private Book book;
}
