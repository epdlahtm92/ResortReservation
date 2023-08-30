package com.resort.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/logInSuccess")
	public String requestLogIn(HttpServletRequest request) {
		String backURL = request.getHeader("referer");
		return "redirect:" + backURL;
	}
	
	@GetMapping("/logOutSuccess")
	public String requestLogOut(HttpServletRequest request) {
		String backURL = request.getHeader("referer");
		return "redirect:" + backURL;
	}
}
