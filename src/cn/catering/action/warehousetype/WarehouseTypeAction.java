package cn.catering.action.warehousetype;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.catering.pojo.Purchase;
import cn.catering.pojo.WarehouseType;
import cn.catering.service.warehousetype.WarehouseTypeService;


/**
 * @ClassName:  WarehouseTypeAction   
 * @Description:  后台仓库类型数据操作类
 * @author: Arouse
 * @date:   2018年3月28日 下午1:33:27
 */
@Controller
@RequestMapping(value = "/warehouseTypeAction")
public class WarehouseTypeAction {
	
	/**
	 * 后台仓库类型数据接口对象
	 */
	@Autowired
	private WarehouseTypeService warehouseTypeService;
    
	/**
	 * @Title: getAllWarehouseType
	 * @Description:  设置后台仓库类型数据
	 * @author: Arouse
	 * @param model
	 * @return  返回waretype.jsp页面
	 */
	@RequestMapping(value = "/getAllWarehouseType")
	public String getAllWarehouseType(Model model,@RequestParam(value = "warehouseId", required = false) Integer warehouseId,
			@RequestParam(value = "warehouseName", required = false) String warehouseName){
		try {
			model.addAttribute("warehouseTypeList", warehouseTypeService.getAllWarehouseType(warehouseId, warehouseName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/waretype";
	}
	
	/**
	 * @Title: getWarehouseByIdOrName
	 * @Description: 根据条件查询
	 * @author: Arouse
	 * @param warehouseId
	 * @param warehouseName
	 * @return
	 */
	@RequestMapping("/getwarhousebyidorname")
	@ResponseBody
	public String getWarehouseByIdOrName(@RequestParam(value = "warehouseId", required = false) Integer warehouseId,
			@RequestParam(value = "warehouseName", required = false) String warehouseName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			String wareStr = new String(warehouseName.getBytes("ISO-8859-1"),"UTF-8");
			List<WarehouseType> list = warehouseTypeService.getAllWarehouseType(warehouseId, wareStr);
			resultMap.put("list", list);
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSONArray.toJSONString(resultMap);
	}
	
	
    /**
     * @Title: getWaretypeAdd
     * @Description:  跳转到后台仓库类型新增页面
     * @author: Arouse
     * @param warehouseType
     * @return
     */
	@RequestMapping(value = "/getWaretypeadd", method = RequestMethod.GET)
	public String getWaretypeAdd(@ModelAttribute("warehouseType") WarehouseType warehouseType) {
		return "/background/waretypeadd";
	}
	
	/**
	 * @Title: insertWaretSave
	 * @Description:  新增仓库类型保存
	 * @author: Arouse
	 * @param warehouseType
	 * @return
	 */
	@RequestMapping(value = "/insertWaretSave",method = RequestMethod.POST)
	public String insertWaretSave(WarehouseType warehouseType){
		try {
			boolean flay = warehouseTypeService.insertWarehouseType(warehouseType);
			if(flay){
				return "redirect:/warehouseTypeAction/getAllWarehouseType.action";
			}else{
				return "/background/waretypeadd";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/waretypeadd";
	}
	
       /**
        * @Title: selectByWarehouseName
        * @Description: 根据名称查询名称是否存在
        * @author: Arouse
        * @param warehouseName
        * @return
        */
		@RequestMapping(value = "/waretypeExist",method = RequestMethod.GET)
		@ResponseBody
		public String selectByWarehouseName(
				@RequestParam(value = "warehouseName") String warehouseName) {
				try {
				 String wareStr = new String(warehouseName.getBytes("ISO-8859-1"),"UTF-8");//处理中文乱码
				 int ware = warehouseTypeService.selectByWarehouseName(wareStr);
					if (ware > 0) {
						return "false";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			return "true";
		}
		
		/**
		 * @Title: deleteByWarehouseId
		 * @Description: 根据仓库id删除数据
		 * @author: Arouse
		 * @param warehouseId
		 * @return
		 */
		@RequestMapping(value="/delware/{warehouseId}",method=RequestMethod.GET)
		@ResponseBody
		public String deleteByWarehouseId(@PathVariable("warehouseId") Integer warehouseId){
			try {
				boolean flay = warehouseTypeService.deleteWarehouse(warehouseId);
				if(flay)
					return "true";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "false";
		}
		
		/**
		 * @Title: getUpdateWare
		 * @Description: 跳转到仓库类型修改页面
		 * @author: Arouse
		 * @param id
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/getupdateware", method = RequestMethod.GET)
		public String getUpdateWare(Model model,@RequestParam(value="warehouseId") Integer warehouseId,@RequestParam(value="warehouseName") String warehouseName) {
			try {
				String wareStr = new String(warehouseName.getBytes("ISO-8859-1"),"UTF-8");
				WarehouseType ware = new WarehouseType();
				ware.setWarehouseId(warehouseId);
				ware.setWarehouseName(wareStr);
				model.addAttribute("ware",ware);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}//处理中文乱码
			return "/background/waretypemodify";
		}
		
		/**
		 * @Title: updataWaretSave
		 * @Description:  修改仓库名称
		 * @author: Arouse
		 * @param warehouseType
		 * @return
		 */
		@RequestMapping(value="/updataWaretsave",method = RequestMethod.POST)
		public String updataWaretSave(WarehouseType warehouseType){
			try {
			  boolean upd = warehouseTypeService.updataWarehouse(warehouseType);
			  if(upd)
				  return "redirect:/warehouseTypeAction/getAllWarehouseType.action";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "/background/waretypemodify";
		}
}

