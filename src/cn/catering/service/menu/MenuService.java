package cn.catering.service.menu;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Menu;
import cn.catering.tools.PageSupport;

public interface MenuService {
	/**
	 * @Title: getCount
	 * @Description:按前台的导航条数据编号或菜名获取菜谱数据条数
	 * @author: MDS
	 * @param navId
	 *            前台的导航条数据编号
	 * @param menuName
	 *            菜单名称
	 * @return 返回总行数
	 */
	public int getCount(Integer navId,String menuName) throws SQLException;

	/**
	 * @Title: selectMenusByPage
	 * @Description: 按前台的导航条数据编号或者按菜单名称进行分页获取菜谱数据
	 * @author: MDS
	 * @param navId
	 *            前台的导航条数据编号
	 * @param pageSupport
	 *            分页对象
	 * @param menuName
	 *            菜单名称
	 * @return 返回菜谱数据对象集合
	 */
	public List<Menu> selectMenusByPage(Integer navId, PageSupport pageSupport,
			String menuName) throws SQLException;
	/**
	 * @Title: selectAll
	 * @Description: 获取所有的菜谱数据
	 * @author: MDS
	 * @return 返回菜谱数据对象集合
	 */
	public List<Menu> selectAll() throws SQLException;
	/**
	 * 
	 * @Title: getMenuCount
	 * @Description:根据菜谱编号、菜谱名称和创建人获取菜谱数据的行数
	 * @author: Sun
	 * @param menuId
	 *            菜谱编号
	 * @param menuName
	 *            菜谱名称
	 * @param userName
	 *            创建人
	 * @return int类型
	 * @throws SQLException
	 */
	public int getMenuCount(Integer menuId, String menuName, String userName)
			throws SQLException;

	/**
	 * 
	 * @Title: getMenuList
	 * @Description:根据条件获取所有的菜谱
	 * @author: Sun
	 * @param menuId
	 *            菜谱编号
	 * @param menuName
	 *            菜谱名称
	 * @param pageSupport
	 *            分页对象
	 * @return 菜谱对象集合
	 */
	public List<Menu> getMenuList(Integer menuId, String menuName,
			String userName, PageSupport pageSupport) throws SQLException;
	
	/**
	 * 
	 * @Title: insertMenu 添加菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menu 菜谱对象
	 * @return int类型
	 * @throws SQLException
	 */
	public int insertMenu(Menu menu) throws SQLException;
	
	/**
	 * 
	 * @Title: getMenuById 根据菜谱编号获取菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menuId 菜谱编号
	 * @return
	 * @throws SQLException
	 */
	public Menu getMenuById(Integer menuId) throws SQLException;
	
	/**
	 * 
	 * @Title: updateMenuById 根据菜谱编号修改菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menu 菜谱对象
	 * @return int类型
	 * @throws SQLException
	 */
	public int updateMenuById(Menu menu) throws SQLException;
	
	/**
	 * 
	 * @Title: deleteMenuById 根据菜谱编号删除菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menuId 菜谱编号
	 * @return
	 * @throws SQLException
	 */
	public int deleteMenuById(Integer menuId) throws SQLException;
	
}
