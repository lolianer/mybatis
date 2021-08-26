package com.swz.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.swz.mybatis.bean.Department;
import com.swz.mybatis.dao.DepartmentMapper;
import com.swz.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.swz.mybatis.bean.Employee;
import com.swz.mybatis.dao.EmployeeMapper;

public class MyBatisTest {
	
	public SqlSessionFactory getSqlSessionfactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	/**
	 * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.获取sqlSession实例，能直接执行已经映射的sql语句
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Employee employee = openSession.selectOne("com.swz.mybatis.employeeMapper.selectEmp", 1);
			
			System.out.println(employee);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}
	
	
	@Test
	public void test2() throws IOException {
		//1.获取sqlSessionFactory对象
		SqlSessionFactory sqlSessionfactory = getSqlSessionfactory();
		
		//2.获取sqlSession对象
		SqlSession openSession = sqlSessionfactory.openSession();
		
		Employee employee;
		try {
			//3.获取接口的实现对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			employee = mapper.getEmployeeById(1);
			System.out.println(mapper.getClass());
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionfactory = getSqlSessionfactory();
		SqlSession openSession = sqlSessionfactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
//			Employee employee = new Employee(null, "jerry", "jerry@qq.com", "1");
//			mapper.addEmp(employee);
//			System.out.println(employee.getId());
			
//			Employee employee = new Employee(1, "jerry", "jerry@qq.com", "0");
//			mapper.updateEmp(employee);
			
//			mapper.deleteEmp(2);
			openSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test04() throws IOException{
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionfactory();
		//1、获取到的SqlSession不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//			Employee employee = mapper.getEmployeeById(1);
//			Employee employee = mapper.getEmployee(1, "jerry");
			
			
//			Map<String, Object> map = new HashMap<>();
//			map.put("id", 3);
//			map.put("lastName", "jerry");
//			map.put("tableName", "tb1_employee");
//			Employee employee = mapper.getEmployeeByMap(map);
			
//			System.out.println(employee);
			
			/*List<Employee> like = mapper.getEmpsByLastNameLike("%e%");
			for (Employee employee : like) {
				System.out.println(employee);
			}*/
			
			/*Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
			System.out.println(map);*/

			Map<Integer, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%r%");
			System.out.println(map);
			
		}finally{
			openSession.close();
		}
	}

	@Test
	public void test05() throws IOException {
		SqlSessionFactory sqlSessionfactory = getSqlSessionfactory();
		SqlSession sqlSession = sqlSessionfactory.openSession();
		try {
			EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
			/*Employee employee = mapper.getEmpById(1);
			System.out.println(employee);*/

			/*Employee empAndDept = mapper.getEmpAndDept(1);
			System.out.println(empAndDept);
			System.out.println(empAndDept.getDept());*/

			Employee employee = mapper.getEmpByStep(3);
			System.out.println(employee);
//			System.out.println(employee.getDept());



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void test06() throws IOException {
		SqlSessionFactory sqlSessionfactory = getSqlSessionfactory();
		SqlSession sqlSession = sqlSessionfactory.openSession();
		try {
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//			Department department = mapper.getDeptByIdPlus(1);

			Department department = mapper.getDeptByIdStep(1);
			System.out.println(department.getId());
			System.out.println(department.getEmps());
		} finally {
			sqlSession.close();
		}
	}

}
