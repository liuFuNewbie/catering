package cn.catering.service.employeetype.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.employeetype.EmployeeTypeMapperCustom;
import cn.catering.pojo.EmployeeType;
import cn.catering.service.employeetype.EmployeeTypeService;
@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {
@Resource
private EmployeeTypeMapperCustom employeeTypeMapperCustom;
	@Override
	public List<EmployeeType> getEmployeeTypeList() throws SQLException {
 		return employeeTypeMapperCustom.getEmployeeTypeList();
	}

}
