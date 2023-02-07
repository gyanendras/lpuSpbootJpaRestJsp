package com.lpu.webjsp20231;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.lpu.webjsp20231.domain.Employee;

@Configuration
public class config {
	@Bean // dependecy injection by type and name
	Employee getEmployee(){
		return new Employee("Garima2",123,200000);
	}

	@Bean
	public ViewResolver viewResolver() {
	  InternalResourceViewResolver resolver =
	      new InternalResourceViewResolver();
	  resolver.setPrefix("/WEB-INF/views/");
	  resolver.setSuffix(".jsp");
	  resolver.setViewClass(JstlView.class);
	  return resolver;
	}
	
}
