package com.hcl.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;
import com.hcl.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
	    private UserService userService;

	    @Autowired
	    private UserRepository userRepository;
	    
	    @GetMapping()
		public List<User> getAllUsers(){
			
			return userService.getAll();
			
		}
	    
	   
		
	
		@PostMapping()
		public User createUSer(@RequestBody User user) {
			
			return userService.saveUser(user);
		}
		
		@PutMapping("/id/{myId}")
		public String updateUser(@RequestBody User user) {
			User userInDB = userService.findByUserName(user.getUsername());
			if(userInDB !=null) {
				userInDB.setUsername(user.getUsername());
				userInDB.setPassword(user.getPassword());
				userService.saveUser(userInDB);
			}
			
			return "User Updated";
		}
	 
}
