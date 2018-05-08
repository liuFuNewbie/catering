package cn.catering.action.employee;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Education;
import cn.catering.pojo.Employee;
import cn.catering.pojo.EmployeeType;
import cn.catering.pojo.Major;
import cn.catering.service.education.EducationService;
import cn.catering.service.employee.EmployeeService;
import cn.catering.service.employeetype.EmployeeTypeService;
import cn.catering.service.major.MajorService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;

 

@Controller
@RequestMapping("/employee")
public class EmployeeAction {
	@Autowired
	private EmployeeService employeeService;
 
	@Autowired
	private EducationService educationService;
	@Autowired
	private EmployeeTypeService employeeTypeService;
	@Autowired
	private MajorService majorService;
	/**
	 * 查询数据并分页
	 * @Title: getProviderList
	 * @Description:
	 * @author: zjb
	 * @param model
	 * @param queryemlName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("/getEmployeelist")
	public String getProviderList(Model model,@RequestParam(value="empName",required=false)String queryemlName,
			@RequestParam(value="pageIndex",required=false)Integer currentPageNo){ 
		PageSupport pageSupport = new PageSupport();
		//设置页的大小
		pageSupport.setPageSize(2);
		//设置当前行数
		if(currentPageNo == null){
			currentPageNo = 1;
		}
		pageSupport.setCurrentPageNo(currentPageNo);
		try {
			//获取总行数，并且设置
			pageSupport.setTotalCount(employeeService.getEmployeeCounts(queryemlName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > pageSupport.getTotalPageCount()) {
			currentPageNo = pageSupport.getTotalPageCount();
		}
		List<Employee> list = null;
		try {
			list = employeeService.getProviderList(queryemlName, pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("queryemlName", queryemlName);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCout", pageSupport.getTotalCount());
		model.addAttribute("totalPageCout", pageSupport.getTotalPageCount());
		model.addAttribute("list", list);
		
		return "/background/employeecost";
	}
	/**
	 * @Title: getEmployeeList
	 * @Description: 后台员工奖励金信息
	 * @author: Arouse
	 * @param employeeName
	 * @param employeeTypeList
	 * @param pose
	 * @param pageSupport
	 * @return
	 */
    @RequestMapping("/getemployeelist")
	public @ResponseBody Object getEmployeeList(@RequestParam(value="empName",required=false)String empName,
			@RequestParam(value="employeeTypeName",required=false) String employeeTypeName,
			@RequestParam(value="pose",required=false) Integer pose,
			@RequestParam(value="currentPageNo",required=false) Integer currentPageNo){
    	List<Employee> list = null;
    	PageSupport pageSupport = new PageSupport();
    	try {
    		int totalCount = employeeService.getEmployeeCount(empName, employeeTypeName, pose); //查询记录总记录数
    		if(currentPageNo != null){
    		    pageSupport.setCurrentPageNo(currentPageNo); //当前页
    		}else{
    			pageSupport.setCurrentPageNo(1); //当前页
    		}
    		pageSupport.setPageSize(2); //页大小
    		pageSupport.setTotalCount(totalCount);  //总行数
			list = employeeService.getEmployeeList(empName, employeeTypeName, pose, pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return "[" + JSONArray.fromObject(list) + ","
					+ pageSupport.getTotalPageCount() + "," + pageSupport.getCurrentPageNo() + "]"; 	
	}
	
    /**
     * @Title: deleteEmpById
     * @Description: 根据员工id删除奖励信息
     * @author: Arouse
     * @param empId
     * @return
     */
    @RequestMapping("/deleteempbyid")
    @ResponseBody
	public String deleteEmpById(@RequestParam(value="empId") Integer empId){
    	try {
			int emp = employeeService.deleteEmpById(empId);
			if(emp > 0)
				return "true";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "false";
	}
    
    /**
	 * 查询数据分页
	 */


	@RequestMapping("/getEmployeeByOrempNameList")
	@ResponseBody
	public Object getEmployeeByOrempNameList(
			Model model,
			@RequestParam(value = "empName", required = false) String empName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
		int totalPageCount = 0;
		if (pageIndex == null) {
			pageIndex = 1;
		}
		// 获取记录行数
		try {
			totalPageCount = employeeService
					.getEmployeeByOrempNameCount(empName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport pageSupport = new PageSupport();
		pageSupport.setPageSize(Constants.PAGESIZE);
		pageSupport.setCurrentPageNo(pageIndex);
		pageSupport.setTotalCount(totalPageCount);
		List<Employee> list = null;
		try {
			list = employeeService.getEmployeeByOrempNameList(empName,
					pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "[" +  JSONArray.fromObject(list) + ','
				+ pageSupport.getTotalPageCount() + ',' + pageIndex + "]";
	}
    
	/**
	 * 
	 * @Title: getComboBoxList
	 * @Description: 获取下拉框信息
	 * @author: Administrator
	 * @return
	 */
	@RequestMapping(value = "/getComboBoxList")
	@ResponseBody
	public Object getComboBoxList() {
		List<EmployeeType> getmployeeTypeList = null;
		List<Education> getEducationList = null;
		List<Major> getMajorList = null;
		try {
			getmployeeTypeList = employeeTypeService.getEmployeeTypeList();
			getEducationList = educationService.getEducationList();
			getMajorList = majorService.getMajorList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "[" + JSONArray.fromObject(getmployeeTypeList) + ","
				+ JSONArray.fromObject(getEducationList) + ","
				+ JSONArray.fromObject(getMajorList) + "]";
	}
	 
	/**
	 * 
	 * @Title: getEmployeeByidentityCard
	 * @Description: 根据用户身份证号验证该用户是否存在
	 * @author: Administrator
	 * @param model
	 * @param identificationCard
	 * @return
	 */
	@RequestMapping(value = "/getEmployeeByidentityCard")
	@ResponseBody
	public Object getEmployeeByidentityCard(
			Model model,
			@RequestParam(value = "identificationCard", required = false) String identificationCard) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = employeeService
					.getEmployeeByidentityCard(identificationCard);
			if (count > 0) {
				map.put("exist", "ok");
			} else {
				map.put("exist", "no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	

	/**
	 * 
	 * @Title: insertEmployee
	 * @Description:添加用户信息
	 * @author: Administrator
	 * @param model
	 * @param Employee
	 * @param birthday
	 * @return
	 */
	@RequestMapping(value = "/insertEmployee")
	@ResponseBody
	public Object insertEmployee(Model model, Employee employee,
			@RequestParam(value = "birth", required = false) String birth) {
		Map<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
		java.util.Date date = null;
		try {
			date = sdf.parse(birth);
			employee.setBirthdate(date);
			date = new Date();
			employee.setCreateDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			int count = employeeService.insertEmployee(employee);
			if (count > 0) {
				map.put("addemployee", "ok");
			} else {
				map.put("addemployee", "no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	};
	/**
	 * 
	 * @Title: getEmployeeById
	 * @Description:根据员工编号获取员工信息
	 * @author: Administrator
	 * @param model
	 * @param birth
	 * @return
	 */
	@RequestMapping("/getEmployeeById")
	public String getEmployeeById(Model model,
			@RequestParam(value = "empId", required = false) Integer empId) {
		List<EmployeeType> getmployeeTypeList = null;
		List<Education> getEducationList = null;
		List<Major> getMajorList = null;
		Employee employee = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		try {
			employee = employeeService.getEmployeeById(empId);
 			String dateString = sdf.format(employee.getBirthdate());
			getmployeeTypeList = employeeTypeService.getEmployeeTypeList();
			getEducationList = educationService.getEducationList();
			getMajorList = majorService.getMajorList();
			model.addAttribute("dateString", dateString);
			model.addAttribute("employee", employee);
			model.addAttribute("getmployeeTypeList", getmployeeTypeList);
			model.addAttribute("getEducationList", getEducationList);
			model.addAttribute("getMajorList", getMajorList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/updateemployeebasicinfo";
	}
	
	@RequestMapping(value = "/updateEmployeeById")
	@ResponseBody
	public Object updateEmployeeById(Model model, Employee employee,
			@RequestParam(value = "birth", required = false) String birth) {
		Map<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
		java.util.Date date = null;
		try {
			date = sdf.parse(birth);
			employee.setBirthdate(date);
			date = new Date();
			employee.setCreateDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			int count = employeeService.updateEmployeeById(employee);
			if (count > 0) {
				map.put("upemployee", "ok");
			} else {
				map.put("upemployee", "no");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/delEmployeeById")
	@ResponseBody
	public Object delEmployeeById(Model model,
			@RequestParam(value = "empId", required = false) Integer empId) {
		System.out.println("进入："+empId);
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (employeeService.getEmployyeByIdCount(empId) > 0) {
				map.put("delResult", "ok");
			} else {
				int count = employeeService.delEmployeeById(empId);
				if (count > 0) {
					map.put("delResult", "true");
				} else {
					map.put("delResult", "false");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}
}
