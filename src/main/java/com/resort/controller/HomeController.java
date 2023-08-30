package com.resort.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletResponse response, HttpServletRequest request, Model model) {
		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd_HH:mm:ss")); 
		List<String> cookieNames = new ArrayList<String>();
		Cookie[] getCookie = request.getCookies();
		if (request.getCookies() != null) {
			for (Cookie c : getCookie) {
				cookieNames.add(c.getName());
			}
			if (cookieNames.contains("connectionLog")) {
				for (Cookie c : getCookie) {
					if(c.getName().equals("connectionLog")) {
						model.addAttribute("connectionLog", "이전 방문 일시 : " + c.getValue());
						c.setValue(today);
					}
				}
			} else {
				model.addAttribute("connectionLog", "최초 방문 입니다!");
				Cookie c = new Cookie("connectionLog" ,today);
				c.setMaxAge(60*60*24);
				c.setPath("/");
				response.addCookie(c);
			}
			
		} else {		
		
			model.addAttribute("connectionLog", "최초 방문 입니다!");
			Cookie c = new Cookie("connectionLog" ,today);
			c.setMaxAge(60*60*24);
			c.setPath("/");
			response.addCookie(c);
		}
		return "resort/resortHome";
	}
	
}
