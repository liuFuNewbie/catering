package cn.catering.dao.employeetype;

import java.util.List;

import cn.catering.pojo.EmployeeType;

public interface EmployeeTypeMapperCustom {
	/**
	 * 
	 * @Title: getEmployeeTypeList
	 * @Description:获取员工类型信息列表
	 * @author: Administrator
	 * @return
	 */
    public List<EmployeeType> getEmployeeTypeList();
}