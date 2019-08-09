package com.city.info.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello World";
	}
}
