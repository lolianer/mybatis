package com.swz.mybatis.dao;

import com.swz.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shen_wzhong
 * @create 2021-08-27 9:16
 */
public interface EmployeeMapperDynamicSQL {

    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);

    List<Employee> getEmpsByConditionChoose(Employee employee);

    void updateEmp(Employee employee);

    List<Employee> getEmpsByConditionForeach(List<Integer> ids);

    void addEmps(@Param("emps") List<Employee> emps);

    List<Employee> getEmpsTestInnerParameter(Employee employee);
}
