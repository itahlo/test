package org.fiveware.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/home")
	public String HelloWord() {
		return "/home";
	}
	
}
