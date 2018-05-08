package cn.catering.action.purchase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.catering.action.BaseAction;
import cn.catering.pojo.Purchase;
import cn.catering.pojo.WarehouseType;
import cn.catering.service.purchase.PurchaseService;

@Controller
@RequestMapping(value="/purchaseAction")
public class PurchaseAction extends BaseAction {
    
	/**
	 * 后台采购订单接口
	 */
	@Resource
    private PurchaseService purchaseService;
	
	/**
	 * @Title: getAllPurchase
	 * @Description:  查询所有采购信息
	 * @author: Arouse
	 * @param model
	 * @param shoppingName
	 * @return
	 */
	@RequestMapping(value="/getAllPurchase")
	@ResponseBody
	public String getAllPurchase(@RequestParam(value = "shoppingName", required = false) String shoppingName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			List<Purchase> list = purchaseService.getAllPurchase(shoppingName);
			resultMap.put("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	/**
	 * @Title: getPurchaseAdd
	 * @Description:  跳转到采购新增页面
	 * @author: Arouse
	 * @param Purchase
	 * @return
	 */
	@RequestMapping(value = "/getPurchaseAdd", method = RequestMethod.GET)
	public String getPurchaseAdd(@ModelAttribute("Purchase") WarehouseType Purchase) {
		return "/background/purchaseadd";
	}
	
	/**
	 * @Title: insertPurSave
	 * @Description: 新增采购信息
	 * @author: Arouse
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/insertPurSave")
	public String insertPurSave(Purchase purchase){
		try {
			purchase.setCreateDate(new Date());
			boolean bo = purchaseService.insertPurchase(purchase);
			if(bo)
				return "/background/purchase";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/purchaseadd";
	}
	
	/**
	 * @Title: deleteBypurchaseId
	 * @Description:  删除采购订单
	 * @author: Arouse
	 * @param purchaseId
	 * @return
	 */
	@RequestMapping(value="/delpurId/{purchaseId}",method=RequestMethod.GET)
	@ResponseBody
	public String deleteBypurchaseId(@PathVariable("purchaseId") Integer purchaseId){
		try {
			boolean flay = purchaseService.deletePurchase(purchaseId);
			if(flay)
				return "true";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "false";
	}
	
	/**
	 * @Title: getUpdatePur
	 * @Description:  跳转采购订单修改页面
	 * @author: Arouse
	 * @param model
	 * @param purchaseId
	 * @return
	 */
	@RequestMapping(value = "/getupdatepur", method = RequestMethod.GET)
	public String getUpdatePur(Model model,@RequestParam(value="purchaseId") Integer purchaseId) {
		try {
			Purchase purchase = purchaseService.getPurchaseByIdInfo(purchaseId);
			model.addAttribute(purchase);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/purchasemodify";
	}
	
	/**
	 * @Title: updataWaretSave
	 * @Description:   修改采购订单
	 * @author: Arouse
	 * @param purchase
	 * @return
	 */
	@RequestMapping(value="/updataPursave",method = RequestMethod.POST)
	public String updataWaretSave(Purchase purchase){
		try {
		  boolean upd = purchaseService.updataPurchase(purchase);
		  if(upd)
			  return "/background/purchase";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/purchasemodify";
	}
	
}
