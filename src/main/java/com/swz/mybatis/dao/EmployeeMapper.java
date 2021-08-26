package com.swz.mybatis.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.swz.mybatis.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    //
    @MapKey("id")
    Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);

    //返回一条记录的map；key就是列名，值就是对应的值
    Map<String, Object>  getEmpByIdReturnMap(Integer id);

    List<Employee> getEmpsByLastNameLike(String lastName);

    Employee getEmployee( Integer id,  String lastName);

    Employee getEmployeeByMap(Map<String, Object> map);

    Employee getEmployeeById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmp(Integer id);

}
