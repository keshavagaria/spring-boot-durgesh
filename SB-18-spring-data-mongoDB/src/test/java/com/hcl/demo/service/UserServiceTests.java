package com.hcl.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@ParameterizedTest
	@ValueSource(strings = {
		"vishu",
		"aman",
		"vishal",
		"rahul"
	})
	public void testfindByUserName(String name) {
		
		assertEquals(4, 2+2);
		assertNotNull(userRepository.findByUsername(name));
		
	}

	
	
	//@Disabled
	@ParameterizedTest
	@CsvSource({
		"1,1,2",
		"10,12,22",
		"2,3,9"
	})
	public void test(int a, int b, int expected) {
		assertEquals(expected, a+b);
		
	}

}
