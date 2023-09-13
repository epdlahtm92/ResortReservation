package com.resort.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.resort.security.CustomUserDetails;
import com.resort.security.CustomUserDetailsService;

@Controller
public class SecurityController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	// Create (registration)
	@GetMapping("/newRegistration")
	public String requestNewRegistration(@ModelAttribute("newRegistration") CustomUserDetails customUserDetails) {
		return "security/newRegistration";
	}

	@PostMapping("/newRegistration")
	public String submitNewRegistration(@ModelAttribute("newRegistration") CustomUserDetails customUserDetails, RedirectAttributes redirectAttributes) {
		if (!customUserDetails.getPassword().equals(customUserDetails.getConfirmPassword())) {
			customUserDetails.setPassword("");
			customUserDetails.setConfirmPassword("");
			redirectAttributes.addFlashAttribute("passwordAlert", "true");
			redirectAttributes.addFlashAttribute("newRegistration", customUserDetails);
			return "redirect:/newRegistration";
		} else {
			customUserDetailsService.createOneUser(customUserDetails);
			return "security/submitRegistration";
		}	
	}

	// Read 
		// (logIn & logOut)
//			@PostMapping("/preLogIn")
//			public String requestPreLogIn(HttpServletRequest request) {
//				String remeberId = request.getParameter("remeberId");
//				return "redirect:/login";
//			}
//		
			@GetMapping("/logInSuccess")
			public String requestLogIn(HttpServletResponse response, HttpServletRequest request, Model model, Principal principal) {
				String backURL = request.getHeader("referer");
//				String logInCookie = request.getParameter("logInCookie");
//				if (logInCookie.equals("true")) {
//					Cookie cookieForLogIn = new Cookie("logInCookie", "true");
//					Cookie cookieForLogInId = new Cookie("logInIdCookie", request.getParameter("username"));
//					Cookie cookieForLogInPassword = new Cookie("logInPasswordCookie", request.getParameter("password"));
//					
//					cookieForLogIn.setMaxAge(60*60*24);
//					cookieForLogIn.setPath("/");
//					cookieForLogInId.setMaxAge(60*60*24);
//					cookieForLogInId.setPath("/");
//					cookieForLogInPassword.setMaxAge(60*60*24);
//					cookieForLogInPassword.setPath("/");
//					
//					response.addCookie(cookieForLogIn);
//					response.addCookie(cookieForLogInId);
//					response.addCookie(cookieForLogInPassword);
//				}
				
				if (backURL.contains("newRegistration")) {
					return "redirect:/";
				}
				return "redirect:" + backURL;
			}
		
			@GetMapping("/logInFailed")
			public String requestLogInFailed(HttpServletRequest request, RedirectAttributes redirectAttributes) {
				String backURL = request.getHeader("referer");
				redirectAttributes.addFlashAttribute("logInError", "true");
				if (backURL.contains("newRegistration")) {
					return "redirect:/";
				}
				return "redirect:" + backURL;
			}
		
			@GetMapping("/logOutSuccess")
			public String requestLogOut(HttpServletRequest request) {
				String backURL = request.getHeader("referer");
				if (backURL.contains("admin") || backURL.contains("manager") || backURL.contains("member")) {
					return "redirect:/";
				}
				return "redirect:" + backURL;
			}
			
		// (userInfo)
			@GetMapping("/admin/allUserInfo")
			public String requsteAllUserInfo(Model model) {
				List<CustomUserDetails> userList = customUserDetailsService.readAllUser();
				model.addAttribute("userList", userList);
				return "security/allUserInfo";
			}
			
			@GetMapping("/member/oneUserInfo")
			public String requestOneUserInfo(@RequestParam("username") String username, Model model) {
				UserDetails userInfo = customUserDetailsService.loadUserByUsername(username);
				model.addAttribute("userInfo", userInfo);
				return "security/oneUserInfo";
			}
	
	// Update
			@GetMapping("/member/updateOneUser")
			public String requestUpdateOneUser(@RequestParam("username") String username, Model model) {
				UserDetails updateOneUser = customUserDetailsService.loadUserByUsername(username);
				model.addAttribute("updateOneUser", updateOneUser);
				return "security/updateOneUser";
			}
			
			@PostMapping("/member/updateOneUser")
			public String submitUpdateOneUser(@ModelAttribute("updateOneUser") CustomUserDetails customUserDetails, RedirectAttributes redirectAttributes) {
				customUserDetailsService.updateOneUser(customUserDetails);
				String username = customUserDetails.getUsername();
				return "redirect:/member/oneUserInfo?username=" + username;
			}
	
	// Delete
			@PostMapping("/member/deleteOneUser")
			public String requestDeleteOneUser(HttpServletRequest request) {
				String username = request.getParameter("username");
				customUserDetailsService.deleteOneUser(username);
				
				if (request.getParameter("isAdmin").equals("true")) {
					return "redirect:/admin/allUserInfo";
				}
				request.getSession().invalidate();
				return "redirect:/logOutSuccess";
			}

}
