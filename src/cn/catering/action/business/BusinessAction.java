package cn.catering.action.business;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Business;
import cn.catering.pojo.BusinessExtension;
import cn.catering.pojo.Employee;
import cn.catering.pojo.Supplier;
import cn.catering.service.business.businessService;
import cn.catering.service.employee.EmployeeService;
import cn.catering.service.supplier.SupplierService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping(value = "/background")
public class BusinessAction {
	@Resource
	private businessService businessservice;
	@Resource
	private SupplierService supplierService;
	@Resource
	private EmployeeService employeeservice;
 	/**
	 * 
	 * @Title: getBusinessExtension
	 * @Description: 获取业务信息
	 * @author: Administrator
	 * @param model
	 * @param supplierName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping("/getBusinessExtension")
	@ResponseBody
	public Object getBusinessExtension(
			Model model,
			@RequestParam(value = "supplierName", required = false) String supplierName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
 		if (pageIndex == null) {
			pageIndex = 1;
		}
 		int totalCount = 0; // 设置总数量为0
		// 根据供应商名称获取总数量
		try {
			totalCount = businessservice.getBusinessExtensionCount(supplierName);
 		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport pageSupport = new PageSupport();
		pageSupport.setTotalCount(totalCount); // 设置总数量
		pageSupport.setPageSize(Constants.PAGESIZE_PC); // 设置页面容量
		pageSupport.setCurrentPageNo(pageIndex); // 设置页码
		List<BusinessExtension> BusinessList = null;
		try {
			BusinessList = businessservice.getBusinessExtension(supplierName,
					pageSupport);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "["+JSONArray.fromObject(BusinessList)+","+pageSupport.getTotalPageCount()+","+pageIndex+"]";
	}

	
	/**
	 * 
	 * @Title: getgetBusinessById
	 * @Description: 根据业务编号获取业务信息
	 * @author: Administrator
	 * @param model
	 * @param businessById
	 * @return
	 */
	@RequestMapping("/getBusinessById")
	public String getBusinessById(
			Model model,
			@RequestParam(value = "businessById", required = false) Integer businessById) {
 		try {
			List<Supplier> supplierList = supplierService.getSupplinerList();
			List<Employee> employeeList = employeeservice.getEmployee();
			Business business = businessservice.getBusinessById(businessById);
			System.err.println(businessById+"\t"+business.getEmpId()+"\t"+business.getAccountPaid());
			model.addAttribute("supplierList", supplierList);
			model.addAttribute("employeeList", employeeList);
			model.addAttribute("business", business);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "accountingmodify";
	}

	/**
	 * 
	 * @Title: getBusinessinfoList
	 * @Description: 绑定下拉框中的数据
	 * @author: Administrator
	 * @param model
	 * @return
	 */
	@RequestMapping("/getBusinessinfoList")
	@ResponseBody
	public Object getBusinessinfoList(Model model) {
		List<Supplier> supplierList=null;
		List<Employee> employeeList=null;
		try {
			supplierList = supplierService.getSupplinerList();
			employeeList = employeeservice.getEmployee();
 		} catch (Exception e) {
			e.printStackTrace();
		}
		return "["+JSONArray.fromObject(supplierList)+","+JSONArray.fromObject(employeeList)+"]";
	}

	/**
	 * 
	 * @Title: insertBusiness
	 * @Description:添加业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	@RequestMapping("/insertBusiness")
	@ResponseBody
	public Object insertBusiness(Business business) {
		Map<String, String> map = new HashMap<String, String>();
		business.setCreateDate(new Date());
		try {
			int count = businessservice.insertBusiness(business);
			if (count > 0) {
				map.put("addbusinessResult", "true");
			} else {
				map.put("addbusinessResult", "flase");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: updateBusinessById
	 * @Description: 根据业务编号修改业务信息
	 * @author: Administrator
	 * @param business
	 * @return
	 */
	@RequestMapping("/updateBusinessById")
	@ResponseBody
	public Object updateBusinessById(Business business) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = businessservice.updateBusinessById(business);
			if (count > 0) {
				map.put("updatebusinessResult", "true");
			} else {
				map.put("updatebusinessResult", "flase");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/**
	 * 
	 * @Title: delectBusinessById
	 * @Description:根据业务编号删除业务信息
	 * @author: Administrator
	 * @param model
	 * @param businessById
	 * @return
	 */
	@RequestMapping("/delectBusinessById")
	@ResponseBody
	public Object delectBusinessById(
			Model model,
			@RequestParam(value = "businessId", required = false) Integer businessId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = businessservice.delectBusinessById(businessId);
			if (count > 0) {
				map.put("delResult", "true");
			} else {
				map.put("delResult", "flase");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
