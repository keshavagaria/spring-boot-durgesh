package com.hcl.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hcl.demo.dao.UserRepository;
import com.hcl.demo.entity.UserDetails;

@SpringBootApplication
public class Sb2SpringDataJpaApplication {

	public static void main(String[] args) {
	
		ApplicationContext context=	  SpringApplication.run(Sb2SpringDataJpaApplication.class, args);
		UserRepository repository=  context.getBean(UserRepository.class);
		
//		UserDetails user1=new UserDetails();
//		user1.setName("Vishal");
//		user1.setStatus("Programmer");
//		user1.setCity("Delhi");
//		
//		UserDetails user2=new UserDetails();
//		user2.setName("Rahul");
//		user2.setStatus("Sweeper");
//		user2.setCity("UP");
		
		//CREATE
		//UserDetails user1=repository.save(details);
		//System.out.println(user1);
		
//		List<UserDetails> details=Arrays.asList(user1,user2);
//		Iterable<UserDetails> result=  repository.saveAll(details);
//		
//		result.forEach(e->System.out.println(e));
		
		
		//RETRIEVE
//		 Optional<UserDetails> optional= repository.findById(2);
//		 Iterable<UserDetails> iterable=  repository.findAll();
//		 
//		 System.out.println(optional.get());
//		 iterable.forEach(p->System.out.println(p));
		
		
		//UPDATE
//		 Optional<UserDetails> userOptional= repository.findById(2);
//		 
//		 UserDetails getUser=userOptional.get();
//		 
//		 getUser.setName("Rahul Singh");
//		 
//		 UserDetails updatedUser=  repository.save(getUser);
//		 System.out.println(updatedUser);
		 
		 
		 //DELETE
		 
		    //repository.deleteById(2);
		   // repository.deleteAll();
		
		
			//Custom Finder Methods or Derived Query Methods
//			List<UserDetails> users=repository.findByName("Vishal");
//			users.forEach(e->System.out.println(e));
//			
//			List<UserDetails> users2=repository.findByNameAndCity("Vishal","delhi");
//			users2.forEach(e->System.out.println(e));
//			
			
			//JPQL
//			List<UserDetails> users3= repository.getAllUsers();
//			users3.forEach(e->System.out.println(e));
//			
//			List<UserDetails> users4=repository.getUserByName("vishal");
//			users4.forEach(e->System.out.println(e));
			

//			List<UserDetails> users5=repository.getUserByNameAndCity("vishal", "delhi");
//			users5.forEach(e->System.out.println(e));
//			
			
			//Native SQL Query
			List<UserDetails> users6= repository.getUsers();
      		users6.forEach(e->System.out.println(e));
			
			
	}

}
