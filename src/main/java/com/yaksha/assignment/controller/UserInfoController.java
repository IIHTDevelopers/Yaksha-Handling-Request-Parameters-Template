package com.yaksha.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserInfoController {

	// Handle request with query parameters
	@GetMapping("/user/info")
	public String getUserInfo(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age,
			@RequestHeader(name = "User-Agent") String userAgent, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("userAgent", userAgent);
		return "user-info";
	}
}
