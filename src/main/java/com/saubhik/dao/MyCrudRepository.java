package com.saubhik.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saubhik.beans.Department;

@Repository
public interface MyCrudRepository extends CrudRepository<Department, String> {

}
