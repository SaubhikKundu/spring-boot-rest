package com.saubhik.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saubhik.beans.Department;
import com.saubhik.dao.MyCrudRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private MyCrudRepository myCrudRepository;
	
	@Autowired
	public DepartmentServiceImpl(MyCrudRepository myCrudRepository) {
		this.myCrudRepository = myCrudRepository;
	}
	
	@Override
	public List<Department> listAll() {
		List<Department> departments = new ArrayList<>();
		myCrudRepository.findAll().forEach(departments::add);
        return departments;
	}

	@Override
	public Department getById(String deptNo) {
		Optional<Department> optional = myCrudRepository.findById(deptNo);
		if(optional.isPresent()) return optional.get();
		else return null;
	}

	@Override
	public Department update(Department department) {
		myCrudRepository.save(department);
		return department;
	}

	@Override
	public void delete(String deptNo) {
		myCrudRepository.deleteById(deptNo);
	}

}
