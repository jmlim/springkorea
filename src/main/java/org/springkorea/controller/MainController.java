package org.springkorea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {
	@RequestMapping("/main")
	public String mainPage() {
		return "main/main";
	}
}
