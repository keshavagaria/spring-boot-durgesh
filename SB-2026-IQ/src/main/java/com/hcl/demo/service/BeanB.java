package com.hcl.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

	@Autowired
	@Lazy
	private BeanA beanA;
}
