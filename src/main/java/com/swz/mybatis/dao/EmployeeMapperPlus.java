package com.swz.mybatis.dao;

import com.swz.mybatis.bean.Employee;

import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-26 15:22
 */
public interface EmployeeMapperPlus {
    Employee getEmpById(Integer id);

    Employee getEmpAndDept(Integer id);

    Employee getEmpByStep(Integer id);

    List<Employee> getEmpByDeptId(Integer deptId);
}
