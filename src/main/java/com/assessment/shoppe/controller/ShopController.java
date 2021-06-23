package com.assessment.shoppe.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShopController {

	@RequestMapping("/shop")
	public String welcome(HttpServletRequest req) {
		
		return "Welcome to points shopping servce!";
	}
}

