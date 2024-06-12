package com.portal.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.department.DTO.DepartmentDTO;
import com.portal.department.service.DepartmentService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/department")
@NoArgsConstructor
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/allDepartments")
	public List<DepartmentDTO> fetchAllDepartments() {
		return departmentService.getAllDepartments();
	}
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
		DepartmentDTO department = departmentService.saveDepartment(departmentDTO);
		return new ResponseEntity<>(department, HttpStatus.CREATED);
	}
	
	@GetMapping("/getDepartmentById/{departmentId}")
	public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
		try {
			if (departmentId == null) {
				throw new IllegalArgumentException("Department id cannot be null");
			} else {
				DepartmentDTO department = departmentService.getDepartmentById(departmentId);
				return new ResponseEntity<>(department, HttpStatus.OK);
			}
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getDepartmentByName/{departmentName}")
	public ResponseEntity<List<DepartmentDTO>> getDepartmentByName(@PathVariable String departmentName) {
		try {
			List<DepartmentDTO> departmentList = departmentService.getDepartmentByName(departmentName);
			return new ResponseEntity<>(departmentList, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/getDepartmentByCode/{departmentCode}")
	public ResponseEntity<List<DepartmentDTO>> getDepartmentByCode(@PathVariable String departmentCode) {
		try {
			List<DepartmentDTO> departmentList = departmentService.getDepartmentByCode(departmentCode);
			return new ResponseEntity<>(departmentList, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
