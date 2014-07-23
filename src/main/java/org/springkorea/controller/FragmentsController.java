package org.springkorea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fragments")
public class FragmentsController {
	@RequestMapping("/bodyHeader")
	public String getBodyHeader() {
		return "fragments/bodyHeader";
	}

	@RequestMapping("/footer")
	public String getFooter() {
		return "fragments/footer";
	}

	@RequestMapping("/headTag")
	public String getHeadTag() {
		return "fragments/headTag";
	}
}
