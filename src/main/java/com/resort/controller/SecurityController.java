package com.resort.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.resort.security.CustomUserDetails;
import com.resort.security.CustomUserDetailsService;

@Controller
public class SecurityController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	// Create
		@GetMapping("/newRegistration")
		public String requestNewRegistration(@ModelAttribute("newRegistration") CustomUserDetails customUserDetails) {
			return "security/newRegistration";
		}
		
		@PostMapping("/newRegistration")
		public String submitNewRegistration(@ModelAttribute("newRegistration") CustomUserDetails customUserDetails) {
			customUserDetailsService.createOneUser(customUserDetails);
			return "security/submitRegistration";
		}
		
	// Read
		@GetMapping("/logInSuccess")
		public String requestLogIn(HttpServletRequest request, Model model) {
			String backURL = request.getHeader("referer");
			if (backURL.contains("newRegistration")) {
				return "redirect:/";
			}
			return "redirect:" + backURL;
		}
		
		@GetMapping("/logInFailed")
		public String requestLogInFailed(HttpServletRequest request, RedirectAttributes redirectAttributes) {
			String backURL = request.getHeader("referer");
			redirectAttributes.addFlashAttribute("logInError", "true");
			return "redirect:" + backURL;
		}
		
		@GetMapping("/logOutSuccess")
		public String requestLogOut(HttpServletRequest request) {
			String backURL = request.getHeader("referer");
			return "redirect:" + backURL;
		}
	
	
}
