package com.resort.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecurityController {

	@GetMapping("/logInSuccess")
	public String requestLogIn(HttpServletRequest request, Model model) {
		String backURL = request.getHeader("referer");
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
