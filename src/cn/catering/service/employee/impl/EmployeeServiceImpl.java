package cn.catering.service.employee.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.employee.EmployeeMapper;
import cn.catering.dao.employee.EmployeeMapperCustom;
import cn.catering.pojo.Employee;
import cn.catering.pojo.EmployeeType;
import cn.catering.service.employee.EmployeeService;
import cn.catering.tools.PageSupport;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapperCustom employeeMapperCustom;
	@Resource
	private EmployeeMapper employeeMapper;
	/**
	 * 
	 * @Title: getEmployeeByOrempNameList
	 * @Description:  获取员工信息列表  根据员工姓名获取列表信息 【条件可有可无】
	 * @author: Administrator
	 * @param empName
	 * @param pageSupport
	 * @return
	 */
	@Override
 	public List<Employee> getEmployeeByOrempNameList(String empName,
			PageSupport pageSupport) throws SQLException {
		return 	employeeMapperCustom.getEmployeeByOrempNameList(empName, pageSupport);
 	}
	@Override
	public int getEmployeeByOrempNameCount(String empName)throws SQLException {
 		return employeeMapperCustom.getEmployeeByOrempNameCount(empName);
	}
	@Override
	public List<Employee> getEmployee()throws SQLException {
 		return employeeMapperCustom.getEmployee();
	}
	@Override
	public int getEmployeeByidentityCard(String identificationCard)
			throws SQLException {
 		return employeeMapperCustom.getEmployeeByidentityCard(identificationCard);
	}
	@Override
	public int insertEmployee(Employee employee) throws SQLException {
 		return employeeMapperCustom.insertEmployee(employee);
	}
	@Override
	public Employee getEmployeeById(Integer empId)throws SQLException {
		return employeeMapperCustom.getEmployeeById(empId);
	}
	@Override
	public int updateEmployeeById(Employee employee) throws SQLException {
 		return employeeMapperCustom.updateEmployeeById(employee);
	}
	@Override
	public int getEmployyeByIdCount(Integer empId) throws SQLException {
 		return employeeMapperCustom.getEmployyeByIdCount(empId);
	}
	@Override
	public int delEmployeeById(Integer empId) throws SQLException {
 		return employeeMapperCustom.delEmployeeById(empId);
	}
	
	@Override
	public int getEmployeeCount(String EmployeeName) throws SQLException {
		return employeeMapperCustom.getComboCount(EmployeeName);
	}
	@Override
	public boolean addEmployee(Employee employee) throws SQLException {
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws SQLException {
		return false;
	}

	@Override
	public boolean delEmployee(Integer EmplId) throws SQLException {
		return false;
	}

	@Override
	public List<Employee> getComboByid(Integer emplId) throws SQLException {
		return null;
	}

	@Override
	public int deleteEmpById(Integer empId) throws SQLException {
		return employeeMapper.deleteByPrimaryKey(empId);
	}

	@Override
	public int getEmployeeCount(String empName,String employeeTypeName, Integer pose) throws SQLException {
		return employeeMapperCustom.getEmployeeCount(empName, employeeTypeName, pose);
	}
	
	@Override
	public List<Employee> getEmployeeList(String empName,
			String employeeTypeName, Integer pose, PageSupport pageSupport)
			throws SQLException {
		return employeeMapperCustom.getEmployeeList(empName, employeeTypeName, pose, pageSupport);
	}

	@Override
	public List<Employee> getEmployeeList(String emplName,
			Integer PageSupport,int pageSupport) throws SQLException {
		return null;
	}
	@Override
	public int getEmployeeCount(Employee employee) throws SQLException {
		return employeeMapperCustom.getEmployeeCount(employee);
	}
	@Override
	public List<Employee> getEmployeeList(String employeeName,
			List<EmployeeType> employeeTypeList, Integer pose,
			PageSupport pageSupport) throws SQLException {
		return employeeMapperCustom.getEmployeeList(employeeName, employeeTypeList, pose, pageSupport);
	}
	@Override
	public List<Employee> getProviderList(String employeeName,
			PageSupport pageSupport) throws SQLException {
		return employeeMapperCustom.getProviderList(employeeName, pageSupport);
	}
	@Override
	public int getEmployeeCounts(String EmployeeName) throws SQLException {
		return employeeMapperCustom.getEmployeeCounts(EmployeeName);
	}
}