package cn.catering.action.combo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.catering.pojo.Combo;
import cn.catering.service.combo.ComboService;
import cn.catering.tools.PageSupport;


@Controller
@RequestMapping("/combos")
public class ComboAction {

	/**
	 * 查询数据并分页
	 */
	@Resource
	private ComboService comboService;

	@RequestMapping("getCombolist")
	public String getProviderList(
			Model model,
			@RequestParam(value = "ComboName", required = false) String queryComboName,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex) {

		int pageSize = 4;
		int totalCount = 0;
		int totalPageCount = 0;
		String comboName = null;
		List<Combo> list = null;

		if (queryComboName != null) {
			comboName = queryComboName;
		}
		if (pageIndex == null) {
			pageIndex = 1;
		}
		// 获取记录行数
		try {
			totalCount = comboService.getComboCount(comboName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageSupport support = new PageSupport();
		support.setPageSize(pageSize);
		support.setCurrentPageNo(pageIndex);
		support.setTotalCount(totalCount);
		totalPageCount = support.getTotalPageCount();
		// 控制首页和尾页
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > totalPageCount) {
			pageIndex = totalPageCount;
		}
		try {
			list = comboService.getComboList(comboName, pageIndex, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("queryComboName", comboName);
		model.addAttribute("currentPageNo", pageIndex);
		model.addAttribute("totalCout", totalCount);
		model.addAttribute("totalPageCout", totalPageCount);
		model.addAttribute("ComboList", list);

		return "/background/setmealtype";
	}


	@RequestMapping(value = "/getdelcombo")
	public String delcombo(@RequestParam(value = "comboId", required = false)Integer comboId) {
		try {
			boolean bl = comboService.delCombo(comboId);
			if (bl == false) 
				return "/background/addsetmealtype";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/combos/getCombolist.action";
	}

	@RequestMapping(value = "/getUpdatecombo", method = RequestMethod.GET)
	public String updateCombo(Model model,
		@RequestParam(value = "comboId", required = false) Integer id) {
		try {
			List<Combo> mealtypebyId = comboService.getComboByid(id);

			model.addAttribute("mealtypebyId", mealtypebyId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/background/updsetmealtype";
	}

	@RequestMapping(value = "/Updatecombo", method = RequestMethod.POST)
	public String updateCombo(
		Model model,
			Combo combo,
			@RequestParam(value = "ComboName", required = false) String queryComboName,
			@RequestParam(value = "comboId", required = false) Integer id) {
		try {
			combo.setComboId(id);
			combo.setComboName(queryComboName);
			boolean bl = comboService.updateCombo(combo);
			if (bl == false) {
				return "/background/updsetmealtype";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/combos/getCombolist.action";

	}
	
	@RequestMapping(value = "/getaddcombo")
	public String addCombo(
			@RequestParam(value = "ComboName", required = false) String queryComboName) {
		Combo combo = new Combo();
		combo.setComboName(queryComboName);
		try {
			boolean bl = comboService.addCombo(combo);
			if (bl == false) 
				return "/background/addsetmealtype";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/combos/getCombolist.action";
	}
}
