package com.lpu.webjsp20231.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lpu.webjsp20231.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByJobId(String jobId);
    
    @Query("select e From Employee e where e.name like %:namePat%")
    List<Employee> findByNameLike(@Param("namePat") String namePat);
}
