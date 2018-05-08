package cn.catering.dao.navigation;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Navigation;

/**
 * 
 * @ClassName:  NavigationMapperCustom   
 * @Description:商品类别接口
 * @author: Sun
 * @date:   2018年3月28日 下午1:58:26
 */
public interface NavigationMapperCustom {
	/**
	 * 
	 * @Title: getNavigationList
	 * @Description: 获取商品所有类别信息（信息包括商品编号和商品名称）
	 * @author: Sun
	 * @return 商品类别的对象集合
	 */
	List<Navigation> getNavigationList() throws SQLException;
	
	/**
	 * 
	 * @Title: getNavigationCountByName
	 * @Description:根据添加输入的商品名称与数据库的商品名称是否唯一
	 * @author: Sun
	 * @param nvaName 商品名称
	 * @return 返回商品行数作为判断条件
	 * @throws Exception
	 */
	int getNavigationCountByName(@Param("navName") String navName) throws SQLException;
	
	/**
	 * 
	 * @Title: getNavigationById
	 * @Description:根据商品类别编号获取商品类别信息
	 * @author: Sun
	 * @param navId 商品类别编号
	 * @return 商品类别编号
	 * @throws SQLException
	 */
	Navigation getNavigationById(@Param("navId") Integer navId) throws SQLException;
	
}
