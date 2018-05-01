package com.saubhik.services;

import java.util.List;
import java.util.Optional;

import com.saubhik.beans.Department;

public interface DepartmentService {

	public List<Department> listAll();
	public Department getById(String deptNo);
	public Department update(Department department);
	public void delete(String deptNo);
}
