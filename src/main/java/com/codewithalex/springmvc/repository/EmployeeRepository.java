package com.codewithalex.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithalex.springmvc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
