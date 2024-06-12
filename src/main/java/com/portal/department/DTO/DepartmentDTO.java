package com.portal.department.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class DepartmentDTO {

	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;

}
