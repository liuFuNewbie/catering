package cn.catering.service.navigation;


import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Navigation;

/**
 * 
 * @ClassName:  NavigationService   
 * @Description:商品类别业务处理接口
 * @author: Sun
 * @date:   2018年3月28日 下午2:03:07
 */
public interface NavigationService {
	/**
	 * 
	 * @Title: getNavigationList
	 * @Description:获取商品所有类别信息（信息包括商品编号和商品名称）
	 * @author: Sun
	 * @return 返回商品类别的对象集合
	 */
	List<Navigation> getNavigationList() throws SQLException;
	
	/**
	 * 
	 * @Title: addNavigation
	 * @Description:添加商品类别信息（信息包括商品名称）
	 * @author: Sun
	 * @param navigation 商品类别对象
	 * @return 返回int类型作为是否添加成功的判断条件
	 * @throws Exception
	 */
	int insertNavigation(Navigation navigation) throws SQLException;
	
	/**
	 * 
	 * @Title: getNavigationCountByName
	 * @Description:根据添加输入的商品名称与数据库的商品名称是否唯一
	 * @author: Sun
	 * @param navName 商品类别名称
	 * @return 返回商品行数作为判断条件
	 * @throws Exception
	 */
	int getNavigationCountByName(String navName) throws SQLException;
	
	/**
	 * 
	 * @Title: delNavigation
	 * @Description:根据商品类别编号删除商品类别信息
	 * @author: Sun
	 * @param navId 商品类别编号
	 * @return 返回boolean类型作为判断条件
	 * @throws Exception
	 */
	boolean delNavigationById(Integer navId) throws SQLException;
	
	/**
	 * 
	 * @Title: updateNavigationById
	 * @Description:根据商品类别编号修改商品类别信息
	 * @author: Sun
	 * @param navigation 商品类别对象
	 * @return int类型
	 * @throws SQLException
	 */
	int updateNavigationById(Navigation navigation) throws SQLException;
	
}