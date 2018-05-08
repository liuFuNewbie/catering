package cn.catering.service.menu.impl;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.catering.dao.menu.MenuMapper;
import cn.catering.dao.menu.MenuMapperCustom;
import cn.catering.pojo.Menu;
import cn.catering.service.menu.MenuService;
import cn.catering.tools.PageSupport;

/**
 * @ClassName: MenuServiceImpl
 * @Description:菜谱数据接口实现类
 * @author: MDS
 * @date: 2018年3月29日 上午12:59:37
 */
@Service
public class MenuServiceImpl implements MenuService {
	/**
	 * 菜谱数据对象
	 */
	@Autowired
	private MenuMapperCustom menuMapperCustom;
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public int getCount(Integer navId,String menuName) throws SQLException {
		return menuMapperCustom.getCount(navId,menuName);
	}

	@Override
	public List<Menu> selectMenusByPage(Integer navId, PageSupport pageSupport,
			String menuName) throws SQLException {
		return menuMapperCustom.selectMenusByPage(navId, pageSupport, menuName);
	}

	@Override
	public List<Menu> selectAll() throws SQLException{
		return menuMapperCustom.selectAll();
	}
	@Override
	public List<Menu> getMenuList(Integer menuId, String menuName,String userName,
			PageSupport pageSupport) throws SQLException {
		return menuMapperCustom.getMenuList(menuId, menuName,userName, pageSupport);
	}

	@Override
	public int getMenuCount(Integer menuId, String menuName, String userName)
			throws SQLException {
		return menuMapperCustom.getMenuCount(menuId, menuName, userName);
	}

	@Override
	public int insertMenu(Menu menu) throws SQLException {
		return menuMapper.insertSelective(menu);
	}

	@Override
	public Menu getMenuById(Integer menuId) throws SQLException {
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public int updateMenuById(Menu menu) throws SQLException {
		return menuMapper.updateByPrimaryKeySelective(menu);
	}

	@Override
	public int deleteMenuById(Integer menuId) throws SQLException {
		return menuMapper.deleteByPrimaryKey(menuId);
	}
}
