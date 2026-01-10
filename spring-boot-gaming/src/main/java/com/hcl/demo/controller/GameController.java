package com.hcl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

	
	@GetMapping("/")
	public String home() {
	
		return "index";
	}
	
	@GetMapping("/guess-my-number")
	public String getGame1() {
	
		return "guess";
	}
	
	@GetMapping("/modal-window")
	public String getGame2() {
	
		return "modal";
	}
	
	@GetMapping("/pig-game")
	public String getGame3() {
	
		return "pig";
	}
}
