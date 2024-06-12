package com.portal.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.department.DTO.DepartmentDTO;
import com.portal.department.entity.Department;
import com.portal.department.repository.DepartmentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public DepartmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<DepartmentDTO> getAllDepartments() {
		List<Department> departmentList = departmentRepository.findAll();
		List<DepartmentDTO> departmentDTOList = departmentList.stream()
				.map(department -> new DepartmentDTO(department.getDepartmentId(), department.getDepartmentName(),
						department.getDepartmentAddress(), department.getDepartmentCode()))
				.toList();
		return departmentDTOList;
	}

	public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
		Department department = new Department();
		department.setDepartmentId(departmentDTO.getDepartmentId());
		department.setDepartmentName(departmentDTO.getDepartmentName());
		department.setDepartmentCode(departmentDTO.getDepartmentCode());
		department.setDepartmentAddress(departmentDTO.getDepartmentAddress());

		Department savedDepartment = departmentRepository.save(department);

		DepartmentDTO savedDepartmentDTO = new DepartmentDTO(savedDepartment.getDepartmentId(),
				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentAddress(),
				savedDepartment.getDepartmentCode());
		return savedDepartmentDTO;
	}

	public DepartmentDTO getDepartmentById(Long departmentId) {
		if (departmentId == null) {
			throw new IllegalArgumentException("Department id cannot be null");
		} else {
			if (!departmentRepository.existsById(departmentId)) {
				throw new IllegalArgumentException("Department with id " + departmentId + " does not exist");
			} else {
				Department department = departmentRepository.findById(departmentId).get();
				DepartmentDTO departmentDTO = new DepartmentDTO(department.getDepartmentId(),
						department.getDepartmentName(), department.getDepartmentAddress(),
						department.getDepartmentCode());
				return departmentDTO;
			}
		}

	}

	public List<DepartmentDTO> getDepartmentByName(String departmentName) {
		List<DepartmentDTO> departmentDTOList = null;
		if (departmentName == null || departmentName.isEmpty()) {
			throw new IllegalArgumentException("Department name cannot be null or empty");
		} else {
			List<Department> departmentList = departmentRepository.findByDepartmentName(departmentName);
			departmentDTOList = departmentList.stream()
					.map(department -> new DepartmentDTO(department.getDepartmentId(), department.getDepartmentName(),
							department.getDepartmentAddress(), department.getDepartmentCode()))
					.toList();
		}
		return departmentDTOList;
	}

	public List<DepartmentDTO> getDepartmentByCode(String departmentCode) {
		if (departmentCode == null || departmentCode.isEmpty()) {
			throw new IllegalArgumentException("Department code cannot be null or empty");
		} else {
			List<Department> departmentList = departmentRepository.findByDepartmentCode(departmentCode);
			List<DepartmentDTO> departmentDTOList = departmentList.stream()
					.map(department -> new DepartmentDTO(department.getDepartmentId(), department.getDepartmentName(),
							department.getDepartmentAddress(), department.getDepartmentCode()))
					.toList();
			return departmentDTOList;
		}
	}
}
