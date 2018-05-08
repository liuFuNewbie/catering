package cn.catering.action.menu;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.catering.alipay.AlipayConfig;
import cn.catering.pojo.Combo;
import cn.catering.pojo.Menu;
import cn.catering.pojo.Navigation;
import cn.catering.pojo.User;
import cn.catering.service.combo.ComboService;
import cn.catering.service.menu.MenuService;
import cn.catering.service.navigation.NavigationService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * @ClassName: MenuAction
 * @Description:菜谱数据操作类
 * @author: MDS
 * @date: 2018年3月29日 上午1:02:55
 */
@Controller
@RequestMapping("/menuAction")
public class MenuAction {
	/**
	 * 菜谱数据对象
	 */
	@Autowired
	private MenuService menuService;
	@Autowired
	private ComboService comboService;
	@Autowired
	private NavigationService navigationService;

	/**
	 * @Title: selectMenusByPage
	 * @Description:分页操作
	 * @author: MDS
	 * @param model
	 *            模型对象
	 * @return 路径
	 */
	@RequestMapping(value = "/{navId}/{currentPageNo}/{menuName}/selectMenusByPage", method = RequestMethod.GET)
	public @ResponseBody Object selectMenusByPage(@PathVariable Integer navId,
			@PathVariable Integer currentPageNo, @PathVariable String menuName) {
		try {
			menuName = new String(menuName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		// 总行数
		int totalCount = 0;
		try {
			// 获取总行数
			totalCount = menuService.getCount(navId, menuName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 获取分页对象并且赋值属性
		PageSupport pageSupport = new PageSupport();
		pageSupport.setTotalCount(totalCount);
		pageSupport.setPageSize(Constants.PAGESIZE_PC);
		pageSupport.setCurrentPageNo(currentPageNo);
		// 创建对象
		List<Menu> list = null;
		try {
			list = menuService.selectMenusByPage(navId, pageSupport, menuName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "[" + JSONArray.fromObject(list) + ","
				+ pageSupport.getTotalPageCount() + "," + currentPageNo + "]";
	}

	/**
	 * @Title: selectAll
	 * @Description: 获取所有的菜谱数据
	 * @author: MDS
	 * @return 返回菜谱数据对象集合
	 */
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		try {
			model.addAttribute("menuList",
					JSONArray.fromObject(menuService.selectAll()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/APP/menu";
	}

	/**
	 * 
	 * @Title: getMenuCountByNavId
	 * @Description:根据商品类别编号获取商品信息行数
	 * @author: Sun
	 * @param navId
	 *            商品类别编号
	 * @return 返回Object类型
	 */
	@RequestMapping(value = "/getMenuCountByNavId/{navId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getMenuCountByNavId(
			@PathVariable(value = "navId") Integer navId) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if (menuService.getCount(navId, null) > 0) {
				map.put("selResult", "true");
			} else {
				map.put("selResult", "false");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @Title: getMenuList
	 * @Description: 根据菜谱编号、菜谱名称和创建人获取菜谱数据进行分页
	 * @author: Sun
	 * @param menuId
	 *            菜谱编号
	 * @param menuName
	 *            菜谱名称
	 * @param userName
	 *            创建人
	 * @param currentPageNo
	 *            当前页数
	 * @return
	 */
	@RequestMapping(value = "/getMenuListAjax", method = RequestMethod.GET)
	@ResponseBody
	public Object getMenuListAjax(
			Model model,
			@RequestParam(value = "menuId", required = false) Integer menuId,
			@RequestParam(value = "menuName", required = false) String menuName,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "currentPageNo", required = false) Integer currentPageNo) {
		try {
			if (menuName != null) {
				menuName = new String(menuName.getBytes("ISO-8859-1"), "UTF-8");
			}
			if (userName != null) {
				userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 总行数
		int totalCount = 0;
		try {
			// 获取总行数
			totalCount = menuService.getMenuCount(menuId, menuName, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 获取分页对象并且赋值属性
		PageSupport pageSupport = new PageSupport();
		pageSupport.setTotalCount(totalCount);
		pageSupport.setPageSize(9);
		if (currentPageNo != null) {
			pageSupport.setCurrentPageNo(currentPageNo);
		} else {
			pageSupport.setCurrentPageNo(1);
		}
		currentPageNo = pageSupport.getCurrentPageNo();
		// 创建对象
		List<Menu> menuList = null;
		try {
			menuList = menuService.getMenuList(menuId, menuName, userName,
					pageSupport);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalPageCount", pageSupport.getTotalPageCount());
		return "[" + JSONArray.fromObject(menuList) + ","
				+ pageSupport.getTotalPageCount() + "," + currentPageNo + "]";
	}

	/**
	 * 
	 * @Title: insertMenu 添加菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menu
	 *            菜谱对象
	 * @param request
	 * @param attachs
	 * @return
	 */
	@RequestMapping(value = "/insertMenu", method = RequestMethod.POST)
	public String insertMenu(
			Menu menu,HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		imgUpload(menu, request, attachs);
		int res = 0;
		menu.setUserId(((User)session.getAttribute("userSession")).getUserId());
		menu.setDateTime(new Date());
		try {
			res = menuService.insertMenu(menu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res > 0) {
			return "/background/shoppinginfo";
		} else {
			return "/background/addshoppinginfo";
		}
	}

	/**
	 * 
	 * @Title: imgUpload 上传文件
	 * @Description:
	 * @author: Sun
	 * @param menu
	 *            菜谱对象
	 * @param request
	 *            请求对象
	 * @param attachs
	 *            MultipartFile数组
	 */
	public void imgUpload(Menu menu, HttpServletRequest request,
			MultipartFile[] attachs) {
		String imgPathOne = null;
		String imgPathTwo = null;
		String imgPathThree = null;
		String imgPath = request.getSession().getServletContext()
				.getRealPath(File.separator + "img" + File.separator);
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile file = attachs[i];
			if (!file.isEmpty()) {
				// 获取上传文件名
				String imgName = file.getOriginalFilename();
				// 获取文件扩展名
				String extendName = FilenameUtils.getExtension(imgName);
				// 创建新文件名
				String newFileName = System.currentTimeMillis()
						+ RandomUtils.nextInt(10000) + "." + extendName;
				// 目标文件
				try {
					FileUtils.copyInputStreamToFile(file.getInputStream(),
							new File(imgPath, newFileName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 设置每个图片的路径
				if (i == 0) {
					imgPathOne = "img/" + newFileName;
				} else if (i == 1) {
					imgPathTwo = "img/" + newFileName;
				} else if (i == 2) {
					imgPathThree = "img/" + newFileName;
				}
			}
		}
		// 添加数据到menu对象中
		menu.setImgPathOne(imgPathOne);
		menu.setImgPathTwo(imgPathTwo);
		menu.setImgPathThree(imgPathThree);
	}

	/**
	 * 
	 * @Title: getMenuById 根据菜谱编号获取菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param model
	 *            菜谱编号
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "/getMenuById")
	public String getMenuById(Model model,
			@RequestParam(value = "menuId") Integer menuId) {
		Menu menu = null;
		List<Combo> comboList = null;
		List<Navigation> navigationList = null;
		try {
			menu = menuService.getMenuById(menuId);
			comboList = comboService.selectlistCombos();
			navigationList = navigationService.getNavigationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imgPathOne = null;
		String imgPathTwo = null;
		String imgPathThree = null;
		int num = menu.getImgPathOne().lastIndexOf("/") + 1;
		if (menu.getImgPathOne() != null) {
			imgPathOne = menu.getImgPathOne();
			imgPathOne = imgPathOne.substring(num, imgPathOne.length());
		}
		if (menu.getImgPathTwo() != null) {
			imgPathTwo = menu.getImgPathTwo();
			imgPathTwo = imgPathTwo.substring(num, imgPathTwo.length());
		}
		if (menu.getImgPathThree() != null) {
			imgPathThree = menu.getImgPathThree();
			imgPathThree = imgPathThree.substring(num, imgPathThree.length());
		}
		menu.setImgPathOne(imgPathOne);
		menu.setImgPathTwo(imgPathTwo);
		menu.setImgPathThree(imgPathThree);
		model.addAttribute("menu", menu);
		model.addAttribute("comboList", comboList);
		model.addAttribute("navigationList", navigationList);
		return "/background/updshoppinginfo";
	}

	/**
	 * 
	 * @Title: updateMenuById 根据菜谱编号修改菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param model
	 *            菜谱编号
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/updateMenuById")
	public String updateMenuById(Model model, Menu menu,
			HttpServletRequest request) {
		int res = 0;
		menu.setUserId(((User)request.getSession().getAttribute("userSession")).getUserId());
		menu.setImgPathOne("img/"+menu.getImgPathOne());
		String imgPathTwo = menu.getImgPathTwo();
		String imgPathThree = menu.getImgPathThree();
		if (imgPathTwo == "未选择任何文件（可选项）") {
			menu.setImgPathTwo("");
		}else{
			menu.setImgPathTwo("img/"+menu.getImgPathTwo());
		}
		if (imgPathThree == "未选择任何文件（可选项）") {
			menu.setImgPathThree("");
		}else{
			menu.setImgPathThree("img/"+menu.getImgPathThree());
		}
		try {
			res = menuService.updateMenuById(menu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res > 0) {
			return "redirect:/background/shoppinginfo.jsp";
		} else {
			return "/background/updshoppinginfo";
		}
	}

	/**
	 * 
	 * @Title: deleteMenuById 根据菜谱编号删除菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menuId
	 * @return
	 */
	@RequestMapping(value = "/deleteMenuById/{menuId}", method = RequestMethod.GET)
	@ResponseBody
	public String deleteMenuById(@PathVariable(value = "menuId") Integer menuId) {
		int res = 0;
		try {
			res = menuService.deleteMenuById(menuId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 
	 * @Title: payment
	 * @Description:获取支付名称数组，支付金额
	 * @author: MDS
	 * @param model
	 * @param menuNames
	 *            支付名称数组
	 * @param money
	 *            支付金额
	 * @return
	 */
	@RequestMapping("/payment")
	public String payment(Model model, String[] menuNames, String payMoney) {
		model.addAttribute("menuNames", Arrays.toString(menuNames));
		model.addAttribute("payMoney", payMoney);
		return "/alipay";
	}

	/**
	 * 
	 * @Title: alipay
	 * @Description:支付方法
	 * @author: MDS
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/alipay")
	public String alipay(HttpServletRequest request) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json",
				AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);
		// 设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

		// 商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = request.getParameter("WIDout_trade_no");
		// 付款金额，必填
		String total_amount = request.getParameter("WIDtotal_amount");
		// 订单名称，必填
		String subject = request.getParameter("WIDsubject");
		// 商品描述，可空
		String body = request.getParameter("WIDbody");

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no
				+ "\"," + "\"total_amount\":\"" + total_amount + "\","
				+ "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body
				+ "\"," + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

		// 请求
		String result = null;
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		request.setAttribute("result", result);
		return "/alipay.trade.page.pay";
	}
}
