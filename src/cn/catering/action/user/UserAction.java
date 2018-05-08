package cn.catering.action.user;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.ibatis.annotations.Param;
import org.mybatis.caches.redis.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import redis.clients.jedis.Jedis;
import cn.catering.cache.RedisCache;
import cn.catering.pojo.Role;
import cn.catering.pojo.User;
import cn.catering.service.role.RoleSerive;
import cn.catering.service.user.UserService;
import cn.catering.tools.Constants;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping("/userAction")
public class UserAction {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleSerive roleSerive;

	/**
	 * 
	 * @Title: getUserListByWrongUserName
	 * @Description: 获取用户列表信息 条件可有可无
	 * @author: Administrator
	 * @param model
	 * @param userName
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(value = "/getUserListByWrongUserName")
	@ResponseBody
	public Object getUserListByWrongUserName(Model model,
			@Param(value = "userName") String userName,
			@Param(value = "pageIndex") Integer pageIndex) {
		int totalPageCount = 0; // 记录总行数
		if (pageIndex == null) {
			pageIndex = 1;
		}
		try {
			// 根据用户名称获取总行数
			totalPageCount = userService
					.getUserListByWrongUserNameCount(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PageSupport pageSupport = new PageSupport();

		pageSupport.setTotalCount(totalPageCount); // 设置总行数
		pageSupport.setPageSize(Constants.PAGESIZE); // 设置页大小
		pageSupport.setCurrentPageNo(pageIndex); // 设置页码
		List<User> getUserList = null;
		try {
			getUserList = userService.getUserListByWrongUserName(userName,
					pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "[" + JSONArray.fromObject(getUserList) + ","
				+ pageSupport.getTotalPageCount() + "," + pageIndex + "]";
	}

	@RequestMapping(value = "/getRoleList")
	@ResponseBody
	public Object getRoleList(Model model) {
		List<Role> getRoleList = null;
		try {
			getRoleList = roleSerive.getRoleList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "[" + JSONArray.fromObject(getRoleList) + "]";
	}

	/**
	 * 
	 * @Title: insertUser
	 * @Description: 添加用户信息
	 * @author: Administrator
	 * @param model
	 * @param user
	 * @return ,HttpServletResponse response
	 */

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(
			User user,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "portraits", required = false) MultipartFile portraits,
			@RequestParam(value = "birth", required = false) String birth)
			throws ServletException, IOException {
		int count = 0;
		String imgPath = request.getSession().getServletContext()
				.getRealPath(File.separator + "img" + File.separator);
		if (!portraits.isEmpty()) {
			// 获取上传文件名
			String imgName = portraits.getOriginalFilename();
			// 获取文件扩展名
			String extendName = FilenameUtils.getExtension(imgName);
			// 创建新文件名
			String newFileName = System.currentTimeMillis()
					+ RandomUtils.nextInt(10000) + "." + extendName;
			System.out.println("新文件名：" + newFileName);
			// 目标文件
			FileUtils.copyInputStreamToFile(portraits.getInputStream(),
					new File(imgPath, newFileName));
			user.setHeadPortraits("img/" + newFileName);
			SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
			java.util.Date date = null;
			try {
				date = sdf.parse(birth);
				user.setBirthdate(date);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			try {
				count = userService.insertUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (count > 0) {
			return "/background/usermanage";
		} else {
			return "/background/usermanage";
		}
	}

	/**
	 * 
	 * @Title: getUserById
	 * @Description:根据用户编号获取用户信息
	 * @author: Administrator
	 * @param model
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserById")
	public String getUserById(Model model,
			@RequestParam(value = "userId", required = false) Integer userId) {
		User user = null;
		List<Role> getRoleList = null;
		try {
			user = userService.getUserById(userId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(user.getBirthdate());
			getRoleList = roleSerive.getRoleList();
			model.addAttribute("user", user);
			model.addAttribute("dateString", dateString);
			model.addAttribute("getRoleList", getRoleList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/background/updateusermanage";
	}

	/**
	 * 
	 * @Title: updateUserById
	 * @Description: 根据用户编号修改用户信息
	 * @author: Administrator
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
	public String updateUserById(
			User user,
			HttpSession session,
			HttpServletRequest request,
			@RequestParam(value = "portraits", required = false) MultipartFile portraits,
			@RequestParam(value = "birth", required = false) String birth)
			throws ServletException, IOException {
		int count = 0;
		String imgPath = request.getSession().getServletContext()
				.getRealPath(File.separator + "img" + File.separator);
		if (!portraits.isEmpty()) {
		}
		// 获取上传文件名
		String imgName = portraits.getOriginalFilename();
		// 获取文件扩展名
		String extendName = FilenameUtils.getExtension(imgName);
		// 创建新文件名
		String newFileName = System.currentTimeMillis()
				+ RandomUtils.nextInt(10000) + "." + extendName;
		System.out.println("新文件名：" + newFileName);
		// 目标文件
		FileUtils.copyInputStreamToFile(portraits.getInputStream(), new File(
				imgPath, newFileName));
		user.setHeadPortraits("img/" + newFileName);
		SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
		java.util.Date date = null;
		try {
			date = sdf.parse(birth);
			user.setBirthdate(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			count = userService.updateUserById(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (count > 0) {
			return "/background/usermanage";
		} else {
			return "/background/usermanage";
		}

	}

	@RequestMapping(value = "/delUserById")
	@ResponseBody
	public Object delUserById(
			@RequestParam(value = "userId", required = false) Integer userId) {
		Map<String, String> map = new HashMap<String, String>();
		int count = 0;
		try {
			if (userService.getUserCountById(userId) > 0) {
				map.put("delUserResult", "ok");
			} else {
				count = userService.delUserById(userId);
				if (count > 0) {

					map.put("delUserResult", "true");
				} else {
					map.put("delUserResult", "false");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getUserHeadPortraits")
	public String getUserHeadPortraits(Model model,
			@RequestParam(value = "userCode", required = false) String userName) {
		try {
			List<User> HeadPortraits = userService
					.getSelectUserheadPortraits(userName);
			model.addAttribute("userHeadPortraits", HeadPortraits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/background/index";
	}

	// 修改用户头像页面跳转
	@RequestMapping(value = "/getHeadPortraits")
	public String getHeadPortraits(Model model,
			@RequestParam(value = "userName", required = false) String userName) {
		try {
			userName = new String(userName.getBytes("iso-8859-1"), "UTF-8");
			List<User> HeadPortraits = userService
					.getSelectUserheadPortraits(userName);
			model.addAttribute("userHeadPortraits", HeadPortraits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/background/upduserHeadPortraits";
	}

	// 修改用户头像
	@Resource
	ServletContext application;

	@RequestMapping(value = "/udpheadPortraits", method = RequestMethod.POST)
	public String udpUserheadPortraits(Model model, HttpServletRequest request,
			@RequestParam(value = "file1", required = false) MultipartFile file) {
		User user = (User) request.getSession().getAttribute("userSession");
		String imgPath = request.getSession().getServletContext()
				.getRealPath(File.separator + "img" + File.separator);
		if (!file.isEmpty()) {
			try {
				// 获取上传文件名
				String imgName = file.getOriginalFilename();
				// 获取文件扩展名
				String extendName = FilenameUtils.getExtension(imgName);
				// 创建新文件名
				String newFileName = System.currentTimeMillis()
						+ RandomUtils.nextInt(10000) + "." + extendName;
				System.out.println("新文件名：" + newFileName);
				// 目标文件
				FileUtils.copyInputStreamToFile(file.getInputStream(),
						new File(imgPath, newFileName));
				user.setHeadPortraits("img/" + newFileName);
				int count = userService.updateheadPortraits(user);
				if (count > 0) {
					// 获取redis操作对象
					Jedis resource = RedisCache.getJedisPool().getResource();
					resource.set(user.getUserName().getBytes(),
							SerializeUtil.serialize(user));
					resource.expire(user.getUserName().getBytes(), 1800);
					// 释放资源
					if (resource != null) {
						resource.close();
					}
					model.addAttribute("num", "1");
				} else {
					model.addAttribute("num", "0");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "/background/upduserHeadPortraits";
	}

	/**
	 * 验证登录
	 * 
	 * @Title: getUser
	 * @Description:
	 * @author: MDS
	 * @param userName
	 *            用户名
	 * @param userPwd
	 *            密码
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(
			HttpServletResponse response,
			HttpSession session,
			@RequestParam(value = "userCode", required = false) String userName,
			@RequestParam(value = "userPassword", required = false) String userPwd) {
		User user = null;
		try {
			user = userService.getUser(userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			session.setAttribute("userSession", "loginFailed");
			return "redirect:/background/login.jsp";
		} else {
			Cookie cookie = null;
			try {
				cookie = new Cookie("userName", URLEncoder.encode(userName,
						"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			cookie.setMaxAge(1800);
			cookie.setPath("/");
			response.addCookie(cookie);
			// 获取redis操作对象
			Jedis resource = RedisCache.getJedisPool().getResource();
			resource.set(userName.getBytes(), SerializeUtil.serialize(user));
			resource.expire(userName.getBytes(), 1800);
			session.setAttribute("userSession", user);
			// 释放资源
			if (resource != null) {
				resource.close();
			}
			return "redirect:/dataPilotAction/getAllDataPilots.action";
		}
	}

	/**
	 * 
	 * @Title: redisLogin
	 * @Description:使用redis登录
	 * @author: MDS
	 * @param Session
	 * @return
	 */
	@RequestMapping("/redisLogin")
	public String redisLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// 获取redis操作对象
		Jedis resource = RedisCache.getJedisPool().getResource();
		User user = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if ("userName".equals(cookies[i].getName())) {
					String value = null;
					try {
						value = URLDecoder.decode(cookies[i].getValue(),
								"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					// 判断hash中是否存在这个键
					if (resource.exists(value.getBytes())) {
						// 获取数据
						user = (User) SerializeUtil.unserialize(resource
								.get(value.getBytes()));
						resource.expire(value.getBytes(), 1800);
						cookies[i].setPath("/");
						cookies[i].setMaxAge(1800);
						response.addCookie(cookies[i]);
					}
					break;
				}
			}
		}
		if (resource != null) {
			resource.close();
		}
		if (user == null) {
			session.setAttribute("userSession", "redisEmpty");
			return "redirect:/background/login.jsp";
		} else {
			session.setAttribute("userSession", user);
			return "redirect:/dataPilotAction/getAllDataPilots.action";
		}
	}

	/**
	 * 
	 * @Title: quitLogin
	 * @Description:退出登录
	 * @author: MDS
	 * @param session
	 * @return
	 */
	@RequestMapping("/quitLogin")
	public String quitLogin(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// 获取redis操作对象
		Jedis resource = RedisCache.getJedisPool().getResource();
		resource.del(((User) session.getAttribute("userSession")).getUserName()
				.getBytes());
		Cookie cookie = new Cookie("userName", null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		// 释放资源
		if (resource != null) {
			resource.close();
		}
		session.setAttribute("userSession", "redisEmpty");
		return "redirect:/background/error.jsp";
	}
	
	public Object identifyingCodeImgGenerate(){
		return null;
	}
}
