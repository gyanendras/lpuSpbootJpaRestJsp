package com.lpu.webjsp20231.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lpu.webjsp20231.domain.Employee;
import com.lpu.webjsp20231.repo.EmployeeRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class EmployeeController {
	@Autowired
	Employee empInj ; // Field Injection, Setter, COnstructor
	
	@Autowired
	EmployeeRepository er;
	
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
	
	@GetMapping("/empdb/{id}")
	@ResponseBody
	Employee getEmployeeFromDB(@PathVariable Integer id) {
		 Optional<Employee> op = er.findById(id);
		   return op.get();
		
	}
	
	@GetMapping("/empdb/job/{jid}")
	@ResponseBody
	List <Employee> getEmpWithJIdFromDB(@PathVariable String jid) {
		 List<Employee> op = er.findByJobId(jid);
		   return op;
		
	}
	
	@GetMapping("/empdb/namepat/{pat}")
	@ResponseBody
	List <Employee> getEmpFromNamePat(@PathVariable String pat) {
		 List<Employee> op = er.findByNameLike(pat);
		   return op;
		
	}
	
	
	
	@GetMapping("/empinj")
	@ResponseBody
	Employee getInjectedEmp() {
		return empInj;
	}
	
	@GetMapping("/time")
	String getDate(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("emp", new Employee(100));
		return "date";
	}
	

	@GetMapping("/emplist/job/{jid}")
	String getEmpsOfAJob(HttpServletRequest req, HttpServletResponse res,@PathVariable String jid ) {
		List<Employee> op = er.findByJobId(jid);
		req.setAttribute("empList", op);
		return "employee";
	}
	
	@PostMapping("/new/emp/{empid}")
    Employee createEmp(@PathVariable Integer empid) {
		Employee emp = new Employee(empid);
		er.save(emp);
    	return emp;
    }
}
