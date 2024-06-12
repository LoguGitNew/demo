package com.portal.department.service;

import java.util.List;

import com.portal.department.DTO.DepartmentDTO;

public interface DepartmentService {

	List<DepartmentDTO> getAllDepartments();

	DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
	
	DepartmentDTO getDepartmentById(Long departmentId);
	
	List<DepartmentDTO> getDepartmentByName(String departmentName);
	
	List<DepartmentDTO> getDepartmentByCode(String departmentCode);

}
