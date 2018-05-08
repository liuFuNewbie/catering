package cn.catering.action.material;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Material;
import cn.catering.pojo.MaterialExtension;
import cn.catering.pojo.Navigation;
import cn.catering.pojo.PayType;
import cn.catering.pojo.User;
import cn.catering.service.material.MaterialService;
import cn.catering.service.navigation.NavigationService;
import cn.catering.service.paytype.PayTypeService;
import cn.catering.service.user.UserService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping(value = "/material")
public class MaterialAction {
	@Autowired
	private MaterialService materialService;
	@Autowired
	private UserService userService;
	@Autowired
	private PayTypeService payTypeService;
	@Autowired
	private NavigationService navigationService;

	/**
	 * 
	 * @Title: getMaterial
	 * @Description: materialinfo.jsp index.jsp
	 * @author: Administrator
	 * @param model
	 * @param type
	 * @param postName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = "/getMaterial")
	@ResponseBody
	public Object getMaterial(
			Model model,
			@RequestParam(value = "type", required = false) Integer type,
			@RequestParam(value = "postName", required = false) String postName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {
		 List<MaterialExtension> list=null;  // 声明List集合记录总数量
  		if (pageIndex == null) {
			pageIndex = 1;
		}
 		try {
			// 根据供应商名称获取总数量
			list = materialService.getMaterialCount(postName, type);
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport pageSupport = new PageSupport();
		 for (int i =1; i <= list.size(); i++) {
				pageSupport.setTotalCount(i); // 设置总数量
			}
 		pageSupport.setPageSize(Constants.PAGESIZE_PC); // 设置页面容量
		pageSupport.setCurrentPageNo(pageIndex); // 设置页码
		List<MaterialExtension> materiallist = null;
		try {
			materiallist = materialService.getMaterial(postName, type,pageSupport);
  		} catch (Exception e) {
			e.printStackTrace();
		}
		return "["+JSONArray.fromObject(materiallist)+","+pageSupport.getTotalPageCount()+","+pageIndex+"]";
 	}

	/**
	 * 
	 * @Title: getMaterialById
	 * @Description: 根据编号获取原料信息
	 * @author: Administrator
	 * @param model
	 * @param Materiald
	 * @return
	 */
	@RequestMapping("/getMaterialById")
 	public String getMaterialById(
			Model model,
			@RequestParam(value = "materialId", required = false) Integer materialId) {
 		try {
			List<PayType> getPayTypeList = payTypeService.getPayTypeList();
			List<Navigation> getNavigationList = navigationService .getNavigationList();
			MaterialExtension material = materialService .getMaterialById(materialId);
 			model.addAttribute("getPayTypeList", getPayTypeList);
			model.addAttribute("getNavigationList", getNavigationList);
			model.addAttribute("material", material);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/updmaterialinfo";
	}

	/**
	 * 
	 * @Title: updateMaterialById
	 * @Description: 根据编号修改 值是从updmaterialinfo.jsp 页面传过来
	 * @author: Administrator
	 * @param materialExtension
	 * @return
	 */
	@RequestMapping("/updateMaterialById")
	@ResponseBody
	public Object updateMaterialById(MaterialExtension materialExtension) {
 		Map<String, String> map = new HashMap<String, String>();
		User user=null;
		try {
			user = userService.getUserByUserName(materialExtension
					.getUserName());
		} catch (SQLException e1) {
 			e1.printStackTrace();
		}
		materialExtension.setUserId(user.getUserId());
		try {
			int count = materialService.updateMaterialById(materialExtension);
			if (count > 0) {
				map.put("updateMaterialResult", "true");
			} else {
				map.put("updateMaterialResult", "flase");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: getMaterialInfo
	 * @Description: 获取下拉框信息
	 * @author: Administrator
	 * @param model
	 * @return
	 */
	@RequestMapping("/getMaterialInfo")
	@ResponseBody
	public Object getMaterialInfo(Model model) {
		List<PayType> getPayTypeList=null;
		List<Navigation> getNavigationList=null;
		List<User> getUserList=null;
		try {
			  getPayTypeList = payTypeService.getPayTypeList();
			  getNavigationList = navigationService
					.getNavigationList();
			 getUserList = userService.getUserList();
 		} catch (Exception e) {
			e.printStackTrace();
		}
		return "["+JSONArray.fromObject(getPayTypeList)+","+JSONArray.fromObject(getNavigationList)+","+JSONArray.fromObject(getUserList)+"]";
	}

	/**
	 * 
	 * @Title: insetMaterial
	 * @Description: 添加购买原料信息
	 * @author: Administrator
	 * @param material
	 * @return
	 */
	@RequestMapping("/insetMaterial")
	@ResponseBody
	public Object insetMaterial(Material material) {
		material.setDateTime(new Date());
		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = materialService.insertMaterial(material);
			if (count > 0) {
				map.put("insertMaterialResult", "true");
			} else {
				map.put("insertMaterialResult", "false");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: deleteMaterialById
	 * @Description: 根据原料购买记录编号删除信息
	 * @author: Administrator
	 * @param materialId
	 * @return
	 */
	@RequestMapping("/deleteMaterialById")
	@ResponseBody
	public Object deleteMaterialById(
			@RequestParam(value = "materialId") Integer materialId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int count = materialService.deleteMaterialById(materialId);
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

	@RequestMapping(value = "/getMaterialCountById/{payId}")
	@ResponseBody
	public String getMaterialCountById(
			@PathVariable(value = "payId") Integer payId) {
		int res = 0;
		try {
			res = materialService.getMaterialCountById(payId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (res > 0)
			return "false";
		else
			return "true";
	}
}
