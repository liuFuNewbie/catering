package cn.catering.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Combo;
import cn.catering.pojo.Employee;
import cn.catering.pojo.EmployeeType;
import cn.catering.tools.PageSupport;

/**
 * 
 * @ClassName:  NavigationMapperCustom   
 * @Description:员工费用接口
 * @author: Sun
 * @date:   2018年3月28日 下午1:58:26
 */
public interface EmployeeMapperCustom {

	
	/**
	 * 根据名称统计总数
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getEmployeeCount(@Param("employeeName")String employeeName);
	
	/**
	 * 根据Id查询类型名称
	 * @Title: getComboByid
	 * @Description:
	 * @author: Administrator
	 * @param comboId
	 * @return
	 * @throws Exception
	 */
	public List<Employee> getEmployeeByid(@Param("empId")Integer empId);

	/**
	 * @Title: getEmployeeCount
	 * @Description: 查询后台员工奖励金数据总数
	 * @author: Arouse
	 * @param employee
	 * @return
	 */
	public int getEmployeeCount(@Param("employee") Employee employee);
	
	/**
	 * @Title: getEmployeeList
	 * @Description:  后台员工奖励金查询与分页
	 * @author: Arouse
	 * @param employeeName  员工姓名
	 * @param employeeTypeList  员工职位类型集合
	 * @param pose  奖金发放状态
	 * @param pageSupport 分页对象
	 * @return
	 */
	public List<Employee> getEmployeeList(
			@Param("employeeName") String employeeName,
			@Param("employeeTypeList") List<EmployeeType> employeeTypeList,
			@Param("pose") Integer pose,
			@Param("PageSupport") PageSupport pageSupport);
	
	//*********************************
	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @Title: getEmployeeList
	 * @Description:
	 * @author: zjb
	 * @param employeeName
	 * @param pageSupport
	 * @return
	 */
	public List<Employee> getProviderList(@Param("empName") String employeeName,@Param("pageSupport") PageSupport pageSupport);
	
	public int getEmployeeCounts(@Param("empName")String EmployeeName);
	/**
	 * 
	 * @Title: getEmployee
	 * @Description: 获取员工编号和姓名
	 * @author: Administrator
	 * @return
	 */
	public  List<Employee> getEmployee();
	/**
	 * 
	 * @Title: getEmployeeByOrempNameList
	 * @Description:  获取员工信息列表  根据员工姓名获取列表信息 【条件可有可无】
	 * @author: Administrator
	 * @param empName
	 * @param pageSupport
	 * @return
	 */
	 public List<Employee>getEmployeeByOrempNameList(@Param(value="empName")String empName,@Param(value="pageSupport")PageSupport pageSupport );
		/**
		 * 
		 * @Title: getEmployeeByOrempNameList
		 * @Description:  获取员工信息列表  根据员工姓名获取列表数量 【条件可有可无】
		 * @author: Administrator
		 * @param empName
		 * @param pageSupport
		 * @return
		 */
	 public int getEmployeeByOrempNameCount(@Param(value="empName")String empName);
	 /**
	  * 
	  * @Title: getEmployeeByidentityCard
	  * @Description:  根据身份证号获取员工数量
	  * @author: Administrator
	  * @param identificationCard
	  * @return
	  */
	 public int getEmployeeByidentityCard(@Param(value="identificationCard")String identificationCard);
	 /**
	  * 
	  * @Title: insertEmployee
	  * @Description:  添加员工信息
	  * @author: Administrator
	  * @param employee
	  * @return
	  */
	 public int insertEmployee(@Param(value="employee")Employee employee);
	 /**
	  * 
	  * @Title: getEmployeeById
	  * @Description: 根据员工编号获取员工信息
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public Employee getEmployeeById(@Param(value="empId")Integer empId);
	 /**
	  * 
	  * @Title: updateEmployeeById
	  * @Description:  根据员工编号修改员工信息
	  * @author: Administrator
	  * @param employee
	  * @return
	  */
	 public int updateEmployeeById(@Param(value="record")Employee employee);
	 /**
	  * 
	  * @Title: getEmployyeByIdCount
	  * @Description:根据员工编号获取员工数量
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public int getEmployyeByIdCount(@Param(value="empId")Integer empId);
	 /**
	  * 
	  * @Title: delEmployeeById
	  * @Description:根据员工编号删除员工信息
	  * @author: Administrator
	  * @param empId
	  * @return
	  */
	 public int delEmployeeById(@Param(value="empId")Integer empId);
	 /**
		 * 根据名称统计总数
		 * @Title: getComboCount
		 * @Description:
		 * @author: Administrator
		 * @param comboName
		 * @return
		 * @throws Exception
		 */
		public int getComboCount(@Param("employeeName")String employeeName);
		
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
		public List<Employee> getComboList(@Param("employeeName") String employeeName,@Param("currentPageNo")  Integer currentPageNo,@Param("pageSize") Integer pageSize);
		
		/**
		 * 根据Id查询类型名称
		 * @Title: getComboByid
		 * @Description:
		 * @author: Administrator
		 * @param comboId
		 * @return
		 * @throws Exception
		 */
		public List<Combo> getComboByid(@Param("empId")Integer empId);

		/**
		 * @Title: getEmployeeCount
		 * @Description: 查询后台员工奖励金数据总数
		 * @author: Arouse
		 * @param employee
		 * @return
		 */
		public int getEmployeeCount(
				@Param("empName") String empName,
				@Param("employeeTypeName") String employeeTypeName,
				@Param("pose") Integer pose);
		
		/**
		 * @Title: getEmployeeList
		 * @Description:  后台员工奖励金查询与分页
		 * @author: Arouse
		 * @param employeeName  员工姓名
		 * @param employeeTypeList  员工职位类型集合
		 * @param pose  奖金发放状态
		 * @param pageSupport 分页对象
		 * @return
		 */
		public List<Employee> getEmployeeList(
				@Param("empName") String empName,
				@Param("employeeTypeName") String employeeTypeName,
				@Param("pose") Integer pose,
				@Param("pageSupport") PageSupport pageSupport);
		public List<Employee> getMemberLists(@Param("employeeName") String employeeName,@Param("pageSupport") PageSupport pageSupport);
	
	
}
