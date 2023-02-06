package com.lpu.webjsp20231.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="employees")
public class Employee implements Comparable {
	
	public Employee() {
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

	@Column(name="first_name")
	String name;
	
	@Id
	@Column(name="employee_id")
	int empId;
	
	@Column(name="job_id")
	String jobId;
	
	
	@Transient
	double salary;
	
	public Employee( int empId) {
		super();
		this.empId = empId;
		this.name = "DefEmp" + empId;
	}
	
	public Employee(String name, int empId, double salary) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int compareTo(Object o) {
		Employee e = (Employee)o;
		return this.empId - e.getEmpId();
	}
	
	
	
	
	

}
