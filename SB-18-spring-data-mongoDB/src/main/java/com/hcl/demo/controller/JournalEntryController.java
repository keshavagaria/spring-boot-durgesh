package com.hcl.demo.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.demo.entity.JournalEntry;
import com.hcl.demo.entity.User;
import com.hcl.demo.service.JournalEntryService;
import com.hcl.demo.service.UserService;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

	@Autowired
	private JournalEntryService journalEntryService;
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/{username}")
	public ResponseEntity<List<JournalEntry>> getAllEntriesOfUser(@PathVariable String username){
		User user = userService.findByUserName(username);
		List<JournalEntry> userEntries =  user.getJournalEntries();
		if(!userEntries.isEmpty() && userEntries!=null) {
			
			return new ResponseEntity<>(userEntries,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@GetMapping("/id/{myId}")
	public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId){
		Optional<JournalEntry> journalEntry = journalEntryService.getEntryById(myId);
		if(journalEntry.isPresent()) {
			
			return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/add/{username}")
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry entry,
													@PathVariable String username) {
		try {
		
			journalEntryService.saveEntry(entry, username);
			return new ResponseEntity<>(entry,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/id/{username}/{myId}")
	public ResponseEntity<JournalEntry> deleteEntryById(@PathVariable ObjectId myId,@PathVariable String username) {
		journalEntryService.deleteEntryById(myId,username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/id/{myId}")
	public ResponseEntity<JournalEntry> updateEntryById(@PathVariable ObjectId myId,
									@RequestBody JournalEntry newEntry) {
		JournalEntry oldEntry = journalEntryService.getEntryById(myId).orElse(null);
		if(oldEntry != null) {
			oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")
								? newEntry.getTitle() : oldEntry.getTitle());
			oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")
					? newEntry.getContent() : oldEntry.getContent());
			
			//wjournalEntryService.saveEntry(oldEntry);
			return new ResponseEntity<>(oldEntry,HttpStatus.OK);
		}
		
		return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
