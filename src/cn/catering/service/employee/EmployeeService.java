package cn.catering.service.employee;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Employee;
import cn.catering.pojo.EmployeeType;
import cn.catering.tools.PageSupport;

public interface EmployeeService {
	
	
	/**
	 * 新增套餐类型
	 * @Title: addCombo
	 * @Description:
	 * @author: Administrator
	 * @param combo
	 * @return
	 * @throws Exception
	 */
	public boolean addEmployee(Employee employee)throws SQLException;
	
	/**
	 * 修改套餐类型
	 * @Title: updateCombo
	 * @Description:
	 * @author: Administrator
	 * @param combo
	 * @return
	 * @throws Exception
	 */
	public boolean updateEmployee(Employee employee)throws SQLException;
	
	/**
	 * 删除套餐类型
	 * @Title: delCombo
	 * @Description:
	 * @author: Administrator
	 * @param ComboId
	 * @return
	 * @throws Exception
	 */
	public boolean delEmployee(Integer EmplId)throws SQLException;
	
	/**
	 * 根据Id查询类型名称
	 * @Title: getComboByid
	 * @Description:
	 * @author: Administrator
	 * @param comboId
	 * @return
	 * @throws Exception
	 */
	public List<Employee> getComboByid(Integer emplId)throws SQLException;

	/**
	 * @Title: getEmployeeCount
	 * @Description: 查询后台员工奖励数据总记录数
	 * @author: Arouse
	 * @param employee
	 * @return
	 */
	public int getEmployeeCount(Employee employee) throws SQLException;
	
	/**
	 * @Title: getEmployeeList
	 * @Description:后台员工奖励金查询与分页
	 * @author: Arouse
	 * @param employeeName
	 * @param employeeTypeList
	 * @param pose
	 * @param pageSupport
	 * @return
	 */
	public List<Employee> getEmployeeList(String employeeName,
			List<EmployeeType> employeeTypeList, Integer pose,
			PageSupport pageSupport) throws SQLException;
	/**
	 * 根据名称统计总数
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getEmployeeCount(String EmployeeName)throws SQLException;
	
	
	/**
	 * @Title: deleteEmpById
	 * @Description: 根据员工id删除奖励金信息
	 * @author: Arouse
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	public int deleteEmpById(Integer empId) throws SQLException;
	
	//*************
	/**
	 * 查询全部数据
	 * @Title: getEmployeeList
	 * @Description:
	 * @author: zjb
	 * @param employeeName
	 * @param pageSupport
	 * @return
	 * @throws SQLException
	 */
	public List<Employee> getProviderList(String employeeName,PageSupport pageSupport) throws SQLException;
	/**
	 * 总数
	 * @Title: getEmployeeCounts
	 * @Description:
	 * @author: zjb
	 * @param EmployeeName
	 * @return
	 * @throws SQLException
	 */
	public int getEmployeeCounts(String EmployeeName)throws SQLException;
	/**
	 * 
	 * @Title: getEmployee
	 * @Description: 获取员工编号和姓名
	 * @author: Administrator
	 * @return
	 */
	public  List<Employee> getEmployee()throws SQLException;
	/**
	 * 
	 * @Title: getEmployeeByOrempNameList
	 * @Description:  获取员工信息列表  根据员工姓名获取列表信息 【条件可有可无】
	 * @author: Administrator
	 * @param empName
	 * @param pageSupport
	 * @return
	 */
	 public List<Employee>getEmployeeByOrempNameList(String empName,PageSupport pageSupport )throws SQLException;

		/**
		 * 
		 * @Title: getEmployeeByOrempNameList
		 * @Description:  获取员工信息列表  根据员工姓名获取列表数量 【条件可有可无】
		 * @author: Administrator
		 * @param empName
		 * @param pageSupport
		 * @return
		 */
	 public int getEmployeeByOrempNameCount(String empName)throws SQLException;
	 /**
	  * 
	  * @Title: getEmployeeByidentityCard
	  * @Description:  根据身份证号获取员工数量
	  * @author: Administrator
	  * @param identificationCard
	  * @return
	  */
	 public int getEmployeeByidentityCard(String identificationCard)throws SQLException;
	 /**
	  * 
	  * @Title: insertEmployee
	  * @Description:  添加员工信息
	  * @author: Administrator
	  * @param employee
	  * @return
	  */
	 public int insertEmployee( Employee employee)throws SQLException;
	 /**
	  * 
	  * @Title: getEmployeeById
	  * @Description: 根据员工编号获取员工信息
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public Employee getEmployeeById(Integer empId)throws SQLException;
	 /**
	  * 
	  * @Title: updateEmployeeById
	  * @Description:  根据员工编号修改员工信息
	  * @author: Administrator
	  * @param employee
	  * @return
	  */
	 public int updateEmployeeById(Employee employee)throws SQLException;
	 /**
	  * 
	  * @Title: getEmployyeByIdCount
	  * @Description:根据员工编号获取员工数量
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public int getEmployyeByIdCount(Integer empId)throws SQLException;
	 /**
	  * 
	  * @Title: delEmployeeById
	  * @Description:根据员工编号删除员工信息
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public int delEmployeeById(Integer empId)throws SQLException;
		
		/**
		 * 根据名称,当前页号，每页尺寸获取分页数据
		 * @Title: getComboList
		 * @Description:
		 * @author: Administrator
		 * @param comboName
		 * @param currentPageNo
		 * @param pageSize
		 * @return
		 * @throws Exception
		 */
		public List<Employee> getEmployeeList(String emplName,Integer PageSupport,int pageSupport) throws SQLException;
		
		
		/**
		 * @Title: getEmployeeCount
		 * @Description: 查询后台员工奖励数据总记录数
		 * @author: Arouse
		 * @param employee
		 * @return
		 */
		public int getEmployeeCount(String empName,String employeeTypeName,Integer pose) throws SQLException;
		
		/**
		 * @Title: getEmployeeList
		 * @Description:后台员工奖励金查询与分页
		 * @author: Arouse
		 * @param employeeName
		 * @param employeeTypeList
		 * @param pose
		 * @param pageSupport
		 * @return
		 */
		public List<Employee> getEmployeeList(String empName,
				String employeeTypeName, Integer pose, PageSupport pageSupport)
				throws SQLException;
		
}
