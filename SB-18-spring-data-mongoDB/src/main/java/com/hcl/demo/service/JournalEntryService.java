package com.hcl.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.demo.entity.JournalEntry;
import com.hcl.demo.entity.User;
import com.hcl.demo.repository.JournalEntryRepo;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepo journalEntryRepo;
	
	@Autowired
	private UserService  userService; 

	public List<JournalEntry> getAllENtries() {

		return journalEntryRepo.findAll();

	}

	public void saveEntry(JournalEntry journalEntry, String username) {
		
			User user = userService.findByUserName(username);
			journalEntry.setDate(LocalDateTime.now());
			JournalEntry journalEntry2 =  journalEntryRepo.save(journalEntry);
			user.getJournalEntries().add(journalEntry2);
			userService.saveUser(user);
	}

	public Optional<JournalEntry> getEntryById(ObjectId myId) {

		return journalEntryRepo.findById(myId);
	}

	public void deleteEntryById(ObjectId myId, String username) {
		
		User user = userService.findByUserName(username);
		user.getJournalEntries().removeIf(x -> x.getId().equals(myId));
		userService.saveUser(user);
		journalEntryRepo.deleteById(myId);

	}

}
