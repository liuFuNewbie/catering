package cn.catering.dao.menu;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Menu;
import cn.catering.tools.PageSupport;

/**
 * @ClassName: MenuMapperCustom
 * @Description:菜谱数据接口
 * @author: MDS
 * @date: 2018年3月29日 上午12:04:00
 */
public interface MenuMapperCustom {
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
	public int getCount(@Param("navId") Integer navId,@Param("menuName")String menuName);

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
	public List<Menu> selectMenusByPage(@Param("navId") Integer navId,
			@Param("pageSupport") PageSupport pageSupport,@Param("menuName")String menuName);
	/**
	 * @Title: selectAll
	 * @Description: 获取所有的菜谱数据
	 * @author: MDS
	 * @return 返回菜谱数据对象集合
	 */
	public List<Menu> selectAll();
	
	/**
	 * 
	 * @Title: getMenuCount
	 * @Description:根据菜谱编号、菜谱名称和创建人获取菜谱数据的行数
	 * @author: Sun
	 * @param menuId 菜谱编号
	 * @param menuName 菜谱名称
	 * @param userName 创建人
	 * @return int类型
	 * @throws SQLException
	 */
	public int getMenuCount(@Param("menuId") Integer menuId,@Param("menuName") String menuName,
			@Param("userName") String userName); 
	
	/**
	 * 
	 * @Title: getMenuList
	 * @Description:根据条件获取所有的菜谱
	 * @author: Sun
	 * @param menuId 菜谱编号
	 * @param menuName 菜谱名称
	 * @param pageSupport 分页对象
	 * @return 菜谱对象集合
	 */
	public List<Menu> getMenuList(@Param("menuId") Integer menuId,@Param("menuName") String menuName,
			@Param("userName") String userName,@Param("pageSupport") PageSupport pageSupport);
	
	/**
	 * 
	 * @Title: updateMenuById 根据菜谱编号修改菜谱信息
	 * @Description:
	 * @author: Sun
	 * @param menu 菜谱对象
	 * @return
	 */
	public int updateMenuById(Menu menu);
}
