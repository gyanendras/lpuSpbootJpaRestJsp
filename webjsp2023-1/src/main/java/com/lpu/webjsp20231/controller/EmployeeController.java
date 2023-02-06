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
	
	@GetMapping("/emp/{id}/{name}")
	@ResponseBody
	Employee getEmployee(@PathVariable Integer id,@PathVariable String name) {
		 //Integer intId = Integer.parseInt(id);
		return new Employee(name,id.intValue(),120000);
		
	}

}
