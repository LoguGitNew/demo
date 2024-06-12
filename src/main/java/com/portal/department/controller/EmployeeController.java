package com.portal.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.portal.department.DTO.DepartmentDTO;
import com.portal.department.service.DepartmentService;

@RestController
public class EmployeeController {
	@Autowired
	DepartmentService departmentService;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("api/departments/{department-id}")
	public DepartmentDTO getDepartment(@PathVariable("department-id") Long departmentId) {		
		return departmentService.getDepartmentById(departmentId);
	}
	

}
