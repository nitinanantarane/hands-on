package com.nitin.quickstart.springboot.jpa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {

	@RequestMapping("/")
	public String home() {
		return "Hello Guest :)";
	}
}
