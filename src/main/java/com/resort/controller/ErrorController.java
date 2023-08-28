package com.resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/error404")
	public String requestError404() {
		return "error404";
	}
}
