package com.lpu.webjsp20231.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lpu.webjsp20231.domain.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/greet")
	@ResponseBody
	String hello() {
		
		return "<h1>Hello World!- It works</h1>";
	}
	
	@GetMapping("/emp/{id}")
	Employee getEmployee(@PathVariable int id) {
		return new Employee(id);
		
	}

}
