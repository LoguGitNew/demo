package com.portal.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.department.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findByDepartmentName(String departmentName);

	List<Department> findByDepartmentCode(String departmentCode);

}
