package com.hcl.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.demo.dao.UserRepository;
import com.hcl.demo.entities.User;
import com.hcl.demo.helper.Message;

@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepo;
	
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title","Home-Smart Contact Manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About-Smart Contact Manager");
		return "about";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","SignUp -Smart Contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult results,
								@RequestParam(value = "agreement",defaultValue = "false")
								Boolean agreement,Model model,
								HttpSession session) {
		
	try {
		
		if(results.hasErrors()) {
			System.out.println("ERROR "+results.toString());
			model.addAttribute("user", user);
			return "signup";
		}
		
		if(!agreement) {
			System.out.println("You have not agreed terms and conditions");
			throw new Exception("You have not agreed terms and conditions");
		}
		
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setImageUrl("default.png");
		
		System.out.println("Agreement "+agreement);
		System.out.println(user);
		User result=userRepo.save(user);
		System.out.println("Save User is "+result);
		model.addAttribute("user", new User());
		session.setAttribute("message", new Message("Successfully Registered",
				"alert-success"));
		return "signup";
		
	}catch (Exception e) {
		e.printStackTrace();
		model.addAttribute("user", user);
		session.setAttribute("message", new Message("Something Went Wrong!!!"+e.getMessage(),
							"alert-danger"));
		return "signup";
	}
		
	}

}
