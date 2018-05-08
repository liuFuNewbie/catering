package cn.catering.action.billinfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.catering.pojo.BillInfo;
import cn.catering.pojo.Combo;
import cn.catering.pojo.Employee;
import cn.catering.service.billinfo.BillInfoService;
import cn.catering.service.combo.ComboService;
import cn.catering.service.market.MarketService;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping("/billAction")
public class BillInfoAction {
	
	/**
	 * 查询数据并分页
	 */
	@Resource
	private BillInfoService billInfoService;
	//声明套餐类型对象
	@Resource
	private ComboService comboService;
	//声明员工对象
	@Resource
	private MarketService marketService;
	
	@RequestMapping("getBillInfolist")
	public String getProviderList(Model model,@RequestParam(value="memberName",required=false)String queryMemberName,
			@RequestParam(value="pageIndex",required=false)Integer pageIndex){
		
		int pageSize=3;
		int currentPageNo=1;
		int totalCount=0;
		int totalPageCount=0;
		String memberName=null;
		List<BillInfo> list=null;
		
		if(queryMemberName != null){
			memberName=queryMemberName;
		}
		if(pageIndex != null){
			currentPageNo=pageIndex;
		}
		//获取记录行数
		try {
			totalCount=billInfoService.getBillInfotCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport support=new PageSupport();
		support.setPageSize(pageSize);
		support.setCurrentPageNo(currentPageNo);
		support.setTotalCount(totalCount);
		totalPageCount = support.getTotalPageCount();
		//控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		try {
			list=billInfoService.getBillInfotList(memberName, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("queryMemberName", memberName);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCout",totalCount);
		model.addAttribute("totalPageCout", totalPageCount);
		model.addAttribute("BillInfoList", list);

		return "/background/billinfo";
	}
	
	//点击修改按钮时进行传值
	@RequestMapping(value="/getBillInfoBylist")
	public String getMarkeByIdList(Model model,@RequestParam(value="marketId",required=false) Integer id){
		try {
			List<BillInfo> list=billInfoService.getBillInfoByIdList(id);
			List<Employee> listEmployees=marketService.listEmployees();
			List<Combo> listCombos=comboService.selectlistCombos();
			
			model.addAttribute("listEmployees", listEmployees);
			model.addAttribute("listCombos", listCombos);
			model.addAttribute("marketBylist", list);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "/background/updbillinfo";
	}
	
	//账单明细页面修改
	@RequestMapping(value = "/getUpdateBillInfo")
	public String updBillInfo(
			@RequestParam(value="memberName",required=false)String memberName,
			@RequestParam(value="memberId",required=false)Integer memberId,
			@RequestParam(value="totalMoney",required=false)double totalMoney,
			@RequestParam(value="describe",required=false)String describe,
			@RequestParam(value="marketId",required=false)Integer marketId,
			@RequestParam(value="discount",required=false)Integer discount,
			@RequestParam(value="ComboType",required=false)Integer ComboType,
			@RequestParam(value="menuId",required=false)Integer menuId,
			@RequestParam(value="payType",required=false)Integer payType,
			@RequestParam(value="materialId",required=false)Integer materialId,
			@RequestParam(value="employee",required=false)Integer employee,
			BillInfo bInfo){
		bInfo.setMemberName(memberName);
		bInfo.setMemberId(memberId);
		bInfo.setTotalMoney(totalMoney);
		bInfo.setDescribe(describe);
		bInfo.setMarketId(marketId);
		bInfo.setDiscount(discount);
		bInfo.setComboId(ComboType);
		bInfo.setMenuId(menuId);
		bInfo.setPayId(payType);
		bInfo.setEmpId(employee);
		bInfo.setMaterialId(materialId);
		
		try {
			boolean bill=billInfoService.updateBillInfo(bInfo);
			if(bill == false)
				return "/background/updbillinfo";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/billAction/getBillInfolist.action";
	}
	
	//删除
	@RequestMapping(value = "/getdeleteBillInfo")
	public String delBillInfo(@RequestParam(value="marketId",required=false)Integer BillId){
		try {
			billInfoService.delBillInfo(BillId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/billAction/getBillInfolist.action";
	}

}
