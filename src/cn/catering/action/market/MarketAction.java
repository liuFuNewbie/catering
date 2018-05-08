package cn.catering.action.market;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Employee;
import cn.catering.pojo.Market;
import cn.catering.pojo.Menu;
import cn.catering.service.market.MarketService;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping("/markets")
public class MarketAction {

	/**
	 * 查询数据并分页
	 */
	@Resource
	private MarketService marketService;

	@RequestMapping("getmarketlist")
	public String getProviderList(
			Model model,
			@RequestParam(value = "marketName", required = false) String queryMarketName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {

		int pageSize = 3;
		int currentPageNo = 1;
		int totalCount = 0;
		int totalPageCount = 0;
		String marketName = null;
		List<Market> list = null;

		if (queryMarketName != null) {
			marketName = queryMarketName;
		}
		if (pageIndex != null) {
			currentPageNo = pageIndex;
		}
		// 获取记录行数
		try {
			totalCount = marketService.getMarketCount(marketName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport support = new PageSupport();
		support.setPageSize(pageSize);
		support.setCurrentPageNo(currentPageNo);
		support.setTotalCount(totalCount);
		totalPageCount = support.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		try {
			list = marketService.getMarketList(marketName, currentPageNo,
					pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("queryMarketName", marketName);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCout", totalCount);
		model.addAttribute("totalPageCout", totalPageCount);
		model.addAttribute("MarketList", list);

		return "/background/market";
	}

	// 点击修改按钮时进行传值
	@RequestMapping(value = "/getmarketBylist")
	public String getMarkeByIdList(Model model,
			@RequestParam(value = "marketId", required = false) Integer id) {
		try {
			List<Market> list = marketService.getMarkeByIdList(id);
			List<Menu> listMenu = marketService.listMenus();
			List<Employee> listEmpolyee = marketService.listEmployees();
			model.addAttribute("listEmployee", listEmpolyee);
			model.addAttribute("listMenu", listMenu);
			model.addAttribute("marketBylist", list);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return "/background/updmarket";
	}

	// 销售查询页面修改
	@RequestMapping(value = "/getUpdateMarket")
	public String updMarket(
			@RequestParam(value = "selectMenu", required = false) Integer menuId,
			@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "tableNo", required = false) Integer tableNo,
			@RequestParam(value = "unitPrice", required = false) double unitPrice,
			@RequestParam(value = "cost", required = false) double cost,
			@RequestParam(value = "selectEmployee", required = false) Integer empId,
			@RequestParam(value = "marketId", required = false) Integer marketId) {
		Market market = new Market();
		market.setNumber(number);
		market.setMarketId(marketId);
		market.setMenuId(menuId);
		market.setTableNo(tableNo);
		market.setUnitPrice(unitPrice);
		market.setTotalMoney(new java.math.BigDecimal(number * unitPrice));
		market.setCost(cost);
		market.setEmpId(empId);
		try {
			int count = marketService.updateMarket(market);
			if (count < 0)
				return "/background/getUpdateMarket";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/markets/getmarketlist.action";
	}

	// 根据用户编号删除用户信息
	@RequestMapping(value = "/getdelMarketId")
	public String getdelcombo(
			@RequestParam(value = "marketId", required = false) Integer marketId) {

		try {
			marketService.delMarket(marketId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/markets/getmarketlist.action";
	}

	// 新增页面跳转
	@RequestMapping(value = "/getByAddMarket")
	public String getByMarket(Model model) {
		try {
			List<Menu> listMenu = marketService.listMenus();
			List<Employee> listEmpolyee = marketService.listEmployees();
			List<Market> listMemberName = marketService.listByMemberName();
			model.addAttribute("listMemberName", listMemberName);
			model.addAttribute("listEmployee", listEmpolyee);
			model.addAttribute("listMenu", listMenu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/background/addmarket";
	}

	// 销售查询页面新增
	@RequestMapping(value = "/getAddMarket")
	public String getSelectMarket(
			@RequestParam(value = "selectMenu", required = false) Integer menuId,
			@RequestParam(value = "number", required = false) Integer number,
			@RequestParam(value = "tableNo", required = false) Integer tableNo,
			@RequestParam(value = "unitPrice", required = false) double unitPrice,
			@RequestParam(value = "cost", required = false) double cost,
			@RequestParam(value = "selectEmployee", required = false) Integer empId,
			@RequestParam(value = "describe", required = false) String describe,
			@RequestParam(value = "memberNameType", required = false) Integer memberNameType) {
		Market market = new Market();
		market.setNumber(number);
		market.setProfitLoss(new java.math.BigDecimal((unitPrice - cost)
				* number));
		market.setTotalMoney(new java.math.BigDecimal(number * unitPrice));
		market.setTableNo(tableNo);
		market.setDescribe(describe);
		market.setMenuId(menuId);
		market.setEmpId(empId);
		market.setMemberId(memberNameType);

		try {
			boolean bool = marketService.addMarket(market);
			if (bool == false)
				return "/background/getAddMarket";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/markets/getmarketlist.action";
	}

	// 查询该销售记录是否存在该员工信息
	@RequestMapping("/existempidinfo")
	@ResponseBody
	public String selectExistEmpByIdInfo(
			@RequestParam(value = "empId") Integer empId) {
		try {
			int count = marketService.selectEmpByIdInfo(empId);
			if (count > 0)
				return "true";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "false";
	}
}
