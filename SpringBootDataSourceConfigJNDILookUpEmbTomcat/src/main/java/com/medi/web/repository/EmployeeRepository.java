package com.medi.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medi.web.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
