package cn.catering.action.supplier;

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

import cn.catering.pojo.Supplier;
import cn.catering.service.supplier.SupplierService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;


@Controller
@RequestMapping("/background")
public class SupplierAction {
	@Resource
	private SupplierService supplierService;
	/**
	 * 
	 * @Title: getSuppliner
	 * @Description: supplierName是从Suppliner.jsp页面传过的
	 * @author: Administrator
	 * @param model
	 * @param supplierName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = "/getSuppliner")
	@ResponseBody
	public Object getSuppliner(
			Model model,
			@RequestParam(value = "supplierName", required = false) String supplierName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
		System.err.println(1);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		/*try {
			supplierName=new  String(supplierName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
 			e1.printStackTrace();
		}*/
 		
 		int totalCount = 0; // 设置总数量为0
		try {
			// 根据供应商名称获取总数量
			totalCount = supplierService.getSupplierCount(supplierName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport pageSupport = new PageSupport();
 		pageSupport.setTotalCount(totalCount);  //设置总数量
		pageSupport.setPageSize(Constants.PAGESIZE_PC);       //设置页面容量
		pageSupport.setCurrentPageNo(pageIndex);            //设置页码
     		List<Supplier> supplierlist = null;
 		try {
  			supplierlist = supplierService.getSuppliner(supplierName,pageSupport);
   		} catch (Exception e) {
			e.printStackTrace();//pageIndex
		}
		return "["+JSONArray.fromObject(supplierlist)+","+JSONArray.fromObject(pageSupport.getTotalPageCount())+","+pageSupport.getCurrentPageNo()+"]";
 	}

	/**
	 * 
	 * @Title: getSupplierById
	 * @Description: 根据供应商编号获取供应商信息 supplierId是从Suppliner.jsp页面传过的
	 * @author: Administrator
	 * @return
	 */
	@RequestMapping(value = "/getSupplierById")
	public String getSupplierById(
			Model model,
			@RequestParam(value = "supplierId", required = false) Integer supplierId) {

 		Supplier supplier = null;
		try {
			supplier = supplierService.getSupplierById(supplierId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("supplier", supplier);
		return "suppliermodify";
	}

	/**
	 * 
	 * @Title: updateSupplierById
	 * @Description: 值是从suppliermodify.jsp页面传过来的
	 * @author: Administrator
	 * @param model
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/updateSupplierById")
	@ResponseBody
	public Object updateSupplierById(Supplier supplier) {
 		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = supplierService.updateSupplierById(supplier);
 			if (count > 0) {
				map.put("updateResult", "true");
 			} else {
				map.put("updateResult", "false");
			}
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: delSupplierById
	 * @Description: 根据供应商编号删除供应商信息 supplier.jsp
	 * @author: Administrator
	 * @param supplierId
	 * @return
	 */
	@RequestMapping(value = "/delSupplierById")
	@ResponseBody
	public Object delSupplierById(@RequestParam(value="supplierId") Integer supplierId) {
 		Map<String, String> map = new HashMap<String, String>();
 		System.err.println("进人");
 		try {
		if(supplierService.getBusinessById(supplierId)>0){
			map.put("delResult", "ok");
		}else{
			int count = supplierService.delSupplierById(supplierId);
			if (count > 0) {
				map.put("delResult", "true");
			} else {
				map.put("delResult", "flase");
			}
		}
 		} catch (Exception e) {
 			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: insertSupplier
	 * @Description: 添加供应商信息
	 * @author: Administrator
	 * @param supplier
	 * @return
	 */
	@RequestMapping(value = "/insertSupplier")
	@ResponseBody
	public Object insertSupplier(Supplier supplier) {
		Map<String, String> map = new HashMap<String, String>();
  		try {
		 	int count = supplierService.insertSupplier(supplier);
			if (count > 0) {
				map.put("insertSupplierResult", "true");
			} else {
				map.put("insertSupplierResult", "flase");
			} 
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return map;
	}
}
