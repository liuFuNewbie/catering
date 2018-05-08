package cn.catering.action.paytype;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.PayType;
import cn.catering.service.paytype.PayTypeService;

/**
 * 
 * @ClassName:  PayTypeAction   
 * @Description:支付类型控制器类
 * @author: Sun
 * @date:   2018年3月31日 下午6:08:37
 */
@Controller
@RequestMapping(value="/paytype")
public class PayTypeAction {
	@Resource
	private PayTypeService payTypeService;
	
	/**
	 * 
	 * @Title: getPayTypeList
	 * @Description:获取所有支付类型
	 * @author: Sun
	 * @param model
	 * @return 支付类型对象集合
	 */
	@RequestMapping(value="/getPayTypeList")
	public String getPayTypeList(Model model){
		List<PayType> payTypeList = null;
		try {
			payTypeList = payTypeService.getPayTypeList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("payTypeList",payTypeList);
		return "/background/payoffmode";
	}
	
	/**
	 * 
	 * @Title: insertPayType
	 * @Description: 添加支付类别
	 * @author: Sun
	 * @param payType 支付对象
	 * @return int类型
	 */
	@RequestMapping(value="/insertPayType")
	public String insertPayType(PayType payType){
		int res = 0;
		try {
			res = payTypeService.insertPayType(payType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0){
			return "redirect:/paytype/getPayTypeList.action";
		}else{
			return "/background/addpayoffmode";
		}
	}
	
	/**
	 * 
	 * @Title: getPayTypeCountByName
	 * @Description:根据添加输入的支付类别名称与数据库的支付类别名称是否唯一
	 * @author: Sun
	 * @param payName 支付类别名称
	 * @return String类型
	 */
	@RequestMapping(value="/getPayTypeCountByName")
	@ResponseBody
 	public String getPayTypeCountByName(@RequestParam(value="payName") String payName){
		int res = 0;
		try {
			res = payTypeService.getPayTypeCountByName(payName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0){
			return "false";
		}else{
			return "true";
		}
	}
	
	/**
	 * 
	 * @Title: delPayTypeById
	 * @Description:根据支付类别编号删除支付类别信息
	 * @author: Sun
	 * @param payId 支付类别编号
	 * @return String类型
	 */
	@RequestMapping(value="/delPayTypeById/{payId}",method=RequestMethod.GET)
	@ResponseBody
	public String delPayTypeById(@PathVariable(value="payId") Integer payId){
		int res = 0;
		try {
			res = payTypeService.delPayTypeById(payId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0){
			return "true";
		}else{
			return "false";
		}
	}
	
	/**
	 * 
	 * @Title: getNavigation
	 * @Description:获取要修改的支付类别信息
	 * @author: Sun
	 * @param model
	 * @param payId 支付类别编号
	 * @param payName 支付类别名称
	 * @return
	 */
	@RequestMapping(value = "/getPayType")
	public String getPayType(Model model,@RequestParam(value="id") Integer payId,@RequestParam(value="name") String payName){
		Integer id = payId;
		String name = null;
		try {
			name = new String(payName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PayType payType = new PayType();
		payType.setPayId(id);
		payType.setPayName(name);
		model.addAttribute("payType",payType);
		return  "/background/updpayoffmode";
	}
	
	/**
	 * 
	 * @Title: updatePayTypeById
	 * @Description: 根据支付类别编号修改支付类别信息
	 * @author: Sun
	 * @param payType 支付类别编号
	 * @return
	 */
	@RequestMapping(value="/updatePayTypeById")
	public String updatePayTypeById(PayType payType){
		int res = 0;
		try {
			res = payTypeService.updatePayTypeById(payType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0){
			return "redirect:/paytype/getPayTypeList.action";
		}else{
			return "/background/addpayoffmode";
		}
	}

}
