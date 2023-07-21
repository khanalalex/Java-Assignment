package com.codewithalex.springmvc.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewithalex.springmvc.model.User;
import com.codewithalex.springmvc.repository.UserRepository;
import com.codewithalex.springmvc.utils.VerifyRecaptcha;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;

	
	@GetMapping({"/","/login"})
	public String showLogin() {
		
		
		return "login";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, Model model,@RequestParam("g-recaptcha-response") String reCode) throws IOException {
		
		if(VerifyRecaptcha.verify(reCode)) {
			
	
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

		User usr =userRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		
		
		if(usr!=null) {
			
			model.addAttribute("uname",user.getUsername());

			return "home";
		
			}
		else {
			model.addAttribute("message","user not found");
			return "login";
			
		}
	}

		model.addAttribute("message", "you are not human !!!");
		return"login";
		
		
	
	
	
	}

}
