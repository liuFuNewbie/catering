package cn.catering.action.elsecost;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.ElseCost;
import cn.catering.pojo.Employee;
import cn.catering.service.elsecost.ElsecostService;
import cn.catering.service.market.MarketService;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping("/else")
public class ElsecostAction {
	/**
	 * 查询数据并分页
	 */
	@Autowired
	private ElsecostService elsecostService;
	@Autowired
	private MarketService marketService;
	@RequestMapping("/getelsecostlist")
	public String getElsecostList(Model model,@RequestParam(value="costName",required=false)String querycostName,
			@RequestParam(value="pageIndex",required=false)Integer currentPageNo){
		PageSupport pageSupport = new PageSupport();
		//设置页的大小
		pageSupport.setPageSize(4);
		//设置当前行数
		if(currentPageNo == null){
			currentPageNo = 1;
		}
		pageSupport.setCurrentPageNo(currentPageNo);
		try {
			//获取总行数，并且设置
			pageSupport.setTotalCount(elsecostService.getElsecostCount(querycostName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > pageSupport.getTotalPageCount()) {
			currentPageNo = pageSupport.getTotalPageCount();
		}
		List<ElseCost> list = null;
		try {
			list = elsecostService.getElsecostList(querycostName, pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("querycostName", querycostName);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCout", pageSupport.getTotalCount());
		model.addAttribute("totalPageCout", pageSupport.getTotalPageCount());
		model.addAttribute("list", list);
		
		return "/background/elsecost";
	}
	/**
	 * 获取信息再进行修改  根据ID查询
	 */
	@RequestMapping(value = "/getupdateElsecost", method = RequestMethod.GET)
	public String getupdateElsecost(Model model,ElseCost elseCost,
			@RequestParam(value = "costId", required = false) Integer costId) {
			try {
				elseCost=elsecostService.getElseCostByid(costId);
				List<Employee> listEmpolyee=marketService.listEmployees();
				model.addAttribute("listEmployee", listEmpolyee);
				 model.addAttribute("elsecost", elseCost);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "/background/updateelsecost";
		}
	/**
	 * 修改
	 * @param model
	 * @param member
	 * @param MemberName
	 * @param id
	 * @param account
	 * @param phone
	 * @param balance
	 * @return
	 */
	@RequestMapping(value = "/updateElsecost", method = RequestMethod.POST)
	public String updateElsecost(Model model,ElseCost elseCost,@RequestParam(value="myBirthdate",required=false)String myBirthdate,
			@RequestParam(value = "costId", required = false) Integer costId) {
		try {
			if(myBirthdate !=""){
				elseCost.setCreateDate(java.sql.Date.valueOf(myBirthdate));
			}
			elseCost.setCostId(costId);
			boolean bl = elsecostService.updateElseCost(elseCost);
			if (bl != true) {
				model.addAttribute("elsecost", elseCost);
				return "/background/updateelsecost";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/else/getelsecostlist.action";
	}
	
	/**
	 * 2018-4-25
	 * 根据id删除费用信息
	 */
		@RequestMapping("/deleteelsecostid")
	    @ResponseBody
		public String deleteEmpById(@RequestParam(value="costId") Integer costId){
	    	try {
				int cost = elsecostService.delElseCostId(costId);
				if(cost > 0)
					return "true";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "false";
		}
		/**
		 * 新增页面跳转
		 */
		@RequestMapping("/getselelsecost")
		public String getAddelsecost(Model model){
			try {
				List<Employee> listEmployees = marketService.listEmployees();
				model.addAttribute("listEmployees", listEmployees);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "/background/addelsecost";
		}
		/**
		 * 添加
		 * @param cName
		 * @param money
		 * @param payeType
		 * @param uName
		 * @param elseCost
		 * @return
		 */
		@RequestMapping("/insertelsecost")
		public String addelsecost(@RequestParam(value="cName") String cName,
				@RequestParam(value="money") BigDecimal money,
				@RequestParam(value="payeType") Integer payeType,
				@RequestParam(value="uName") Integer uName,ElseCost elseCost){
			
			try {
				elseCost.setCostName(new String(cName.getBytes("iso-8859-1"),"UTF-8"));
				elseCost.setMoney(money);
				elseCost.setCostTypeId(payeType);
				elseCost.setEmpId(uName);
			    elsecostService.addElseCost(elseCost);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/else/getelsecostlist.action";
		}
}
