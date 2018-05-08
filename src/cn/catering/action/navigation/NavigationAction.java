package cn.catering.action.navigation;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Combo;
import cn.catering.pojo.Navigation;
import cn.catering.service.combo.ComboService;
import cn.catering.service.navigation.NavigationService;

/**
 * 
 * @ClassName:  NavigationAction   
 * @Description:商品类别控制器类
 * @author: Sun
 * @date:   2018年3月28日 下午2:07:20
 */

@Controller
@RequestMapping(value="/navigation")
public class NavigationAction {
	@Autowired
	private NavigationService navigationService;
	@Resource
	private ComboService comboService;
	
	/**
	 * 
	 * @Title: getNavigationList
	 * @Description:获取商品所有类别信息（信息包括商品编号和商品名称）
	 * @author: Sun
	 * @param model 
	 * @return 返回jsp页面的url
	 */
	@RequestMapping(value="/getNavigationList")
	public String getNavigationList(Model model){
		List<Navigation> navigationList = null;
		try {
			navigationList = navigationService.getNavigationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("navigationList",navigationList);
		return "/background/shoppingtype";
	}
	
	/**
	 * 
	 * @Title: addNavigation
	 * @Description:添加商品类别信息（信息包括商品名称）
	 * @author: Sun
	 * @param navigation
	 * @return 返回jsp页面的url
	 */
	@RequestMapping(value="/addNavigation")
	public String addNavigation(Navigation navigation){
		navigation.setGrade(1);
		navigation.setParent(0);
		int res = 0;
		try {
			res = navigationService.insertNavigation(navigation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(res > 0){
			return "redirect:/navigation/getNavigationList.action";
		}else{
			return "/background/addshoppingtype";
		}
	}
	/**
	 * 
	 * @Title: getNavigationByName
	 * @Description:根据添加输入的商品名称与数据库的商品名称是否唯一
	 * @author: Sun
	 * @param navName 商品名称
	 * @return 返回商品名称作为判断条件
	 */
	@RequestMapping(value="/getNavigationCountByName")
	@ResponseBody
 	public String getNavigationCountByName(@RequestParam(value="navName") String navName){
		int res = 0;
		System.out.println(navName);
		try {
			res = navigationService.getNavigationCountByName(navName);
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
	 * @Title: updateNavigationById
	 * @Description: 根据商品类别Id修改商品类别信息
	 * @author: Sun
	 * @param navigation 商品类别对象
	 * @return 返回jsp页面的url
	 */
	@RequestMapping(value="/updateNavigationById")
	public String updateNavigationById(Navigation navigation){
		int res = 0;
		try {
			res = navigationService.updateNavigationById(navigation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0){
			return "redirect:/navigation/getNavigationList.action";
		}else{
			return "/background/addshoppingtype";
		}
	}
	
	/**
	 * 
	 * @Title: delNavigation
	 * @Description:根据商品类别编号删除商品类别
	 * @author: Sun
	 * @param navId 商品类别编号
	 * @return 返回Object类型
	 */
	@RequestMapping(value="/delNavigationById/{navId}",method=RequestMethod.GET)
	@ResponseBody
	public Object delNavigation(@PathVariable(value="navId") String navId){
		Map<String,String> map = new HashMap<String,String>();
		int nid = Integer.parseInt(navId);
		boolean res = false;
		try {
			res = navigationService.delNavigationById(nid);
			if(res){
				map.put("delResult", "true");
			}else{
				map.put("delResult", "false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/getNavigation")
	public String getNavigation(Model model,@RequestParam(value="id") Integer navId,@RequestParam(value="name") String navName){
		Integer id = navId;
		String name = null;
		try {
			name = new String(navName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Navigation navigation = new Navigation();
		navigation.setNavId(id);
		navigation.setNavName(name);
		model.addAttribute("navigation",navigation);
		return  "/background/updshoppingtype";
	}
	
	@RequestMapping(value = "/{isMobile}/selectByExample", method = RequestMethod.GET)
	public String selectByExample(Model model, @PathVariable String isMobile) {
		try {
			if("APP".equals(isMobile)){
				model.addAttribute("navList",JSONArray.fromObject(navigationService.getNavigationList()));
				return "forward:/menuAction/selectAll.action";
			}else{
				model.addAttribute("navList",navigationService.getNavigationList());
				return "/PC/menu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getComNavList")
	public String getComboList(Model model){
		List<Combo> comboList = null;
		List<Navigation> navigationList = null;
		try {
			comboList = comboService.selectlistCombos();
			navigationList = navigationService.getNavigationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("comboList",comboList);
		model.addAttribute("navigationList",navigationList);
		return "/background/addshoppinginfo";
	}
	
}
