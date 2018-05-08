package cn.catering.action.datapilot;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;

import cn.catering.service.datapilot.DataPilotService;

/**
 * 
 * @ClassName: DataPilotAction
 * @Description:后台导航条数据操作类
 * @author: MDS
 * @date: 2018年3月27日 下午10:37:43
 */
@Controller
@RequestMapping("/dataPilotAction")
public class DataPilotAction {
	/**
	 * 后台导航条数据接口对象
	 */
	@Autowired
	private DataPilotService dataPilotService;

	@RequestMapping("/getAllDataPilots")
	public String getAllDataPilots(Model model) {
		try {
			model.addAttribute("dataPilotList",
					JSONArray.toJSON(dataPilotService.getAllDataPilots()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/index";
	}
}
