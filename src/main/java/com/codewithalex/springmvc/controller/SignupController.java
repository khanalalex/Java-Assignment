package com.codewithalex.springmvc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codewithalex.springmvc.model.User;
import com.codewithalex.springmvc.repository.UserRepository;



@Controller
public class SignupController {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/signup")
	public String showSignup() {
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user, Model model) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepo.save(user);
		
		return "login";
		
		
		
		
	}
	
	

}
