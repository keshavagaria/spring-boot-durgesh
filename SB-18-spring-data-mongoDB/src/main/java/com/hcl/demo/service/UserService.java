package com.hcl.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.User;
import com.hcl.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	   @Autowired
	   private UserRepository userRepository;
	   
	   /*
	    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	    public boolean saveNewUser(User user) {
	        try {
	            user.setPassword(passwordEncoder.encode(user.getPassword()));
	            user.setRoles(Arrays.asList("USER"));
	            userRepository.save(user);
	            return true;
	        } catch (Exception e) {
	            log.error("hahahhahhahahahah");
	            log.warn("hahahhahhahahahah");
	            log.info("hahahhahhahahahah");
	            log.debug("hahahhahhahahahah");
	            log.trace("hahahhahhahahahah");
	            return false;
	        }
	    }

	    public void saveAdmin(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        user.setRoles(Arrays.asList("USER", "ADMIN"));
	        userRepository.save(user);
	    }
	*/
	   
	 public User saveUser(User user) {
	        return userRepository.save(user);
	    }

	    public List<User> getAll() {
	        return userRepository.findAll();
	    }

	    public Optional<User> findById(ObjectId id) {
	        return userRepository.findById(id);
	    }

	    public void deleteById(ObjectId id) {
	        userRepository.deleteById(id);
	    }

	    public User findByUserName(String userName) {
	        return userRepository.findByUsername(userName);
	    }
}
