package cn.catering.service.employeetype;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.EmployeeType;

public interface EmployeeTypeService {
	/**
	 * 
	 * @Title: getEmployeeTypeList
	 * @Description:获取员工类型信息列表
	 * @author: Administrator
	 * @return
	 */
    public List<EmployeeType> getEmployeeTypeList()throws SQLException;
}
