package com.swz.mybatis.dao;


import org.apache.ibatis.annotations.Select;

import com.swz.mybatis.bean.Employee;


public interface EmployeeMapperAnnotation {
	
	@Select("select * from tbl_employee where id=#{id}")
	public Employee getEmpById(Integer id);
}
