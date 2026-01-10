package com.hcl.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.demo.entity.JournalEntry;
import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;
import com.hcl.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class Sb18SpringDataMongoDbApplicationTests {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	

	//@Disabled
	@ParameterizedTest
	@ValueSource(strings = {
			"vishu",
			"aman",
			"vishal",
			"rahul"
		})
	public void findByUserNameTest(String name) {
	
		List<JournalEntry> journalEntries = new ArrayList<>();
		journalEntries.add(new JournalEntry(new ObjectId(),"Night","Blck Coffee",LocalDateTime.now()));
		journalEntries.add(new JournalEntry(new ObjectId(),"Morning","The Kapil Gym",LocalDateTime.now()));
		
		when(userRepository.findByUsername(name)).thenReturn(new User(new ObjectId(),"vishu", "vishu123", journalEntries));
		User user =  userService.findByUserName(name);
		System.out.println(user);
		assertNotNull(userService.findByUserName(name));
	}

	 @Test
	 public void getAllUsersTest() {
		 
		 List<JournalEntry> journalEntries = new ArrayList<>();
		 journalEntries.add(new JournalEntry(new ObjectId(),"Night","Blck Coffee",LocalDateTime.now()));
		 journalEntries.add(new JournalEntry(new ObjectId(),"Morning","The Kapil Gym",LocalDateTime.now()));
		 
		 List<JournalEntry> journalEntries2 = new ArrayList<>();
		 journalEntries2.add(new JournalEntry(new ObjectId(),"During Dark Night","Black Coffeeee",LocalDateTime.now()));
		 journalEntries2.add(new JournalEntry(new ObjectId(),"Weekend","MOVIE",LocalDateTime.now()));
		 
		 User user1 = new User(new ObjectId(),"vishu", "vishu123", journalEntries);
		 User user2 = new User(new ObjectId(),"vishal", "vishal@123", journalEntries2);
		
		 List<User> users = new ArrayList<>();
		 users.add(user1);
		 users.add(user2);
		
		
		 when(userRepository.findAll()).thenReturn(users);
		 
		 
		 System.out.println(userService.getAll());
		 
		 assertEquals(2,userService.getAll().size());
		 
		 
		 
	 }
	 
		@Test
		public void createUSerTest() {
			
			 List<JournalEntry> journalEntries = new ArrayList<>();
			 journalEntries.add(new JournalEntry(new ObjectId(),"Night","Blck Coffee",LocalDateTime.now()));
			 journalEntries.add(new JournalEntry(new ObjectId(),"Morning","The Kapil Gym",LocalDateTime.now()));
			 
			 User user = new User(new ObjectId(),"vishu", "vishu123", journalEntries);
			
			when(userRepository.save(user)).thenReturn(user);
			System.out.println("User Created: "+userService.saveUser(user));
			assertNotNull(userService.saveUser(user));
		}
}
