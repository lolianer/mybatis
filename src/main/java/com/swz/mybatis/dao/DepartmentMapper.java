package com.swz.mybatis.dao;

import com.swz.mybatis.bean.Department;

/**
 * @author shen_wzhong
 * @create 2021-08-26 16:21
 */
public interface DepartmentMapper {
    Department getDeptById(Integer id);

    Department getDeptByIdPlus(Integer id);

    Department getDeptByIdStep(Integer id);
}
