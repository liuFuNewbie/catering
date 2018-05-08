package cn.catering.dao.market;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Employee;
import cn.catering.pojo.Market;
import cn.catering.pojo.Menu;

public interface MarketMapperCustom {
	
	/**
	 * 根据名称统计总数
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getMarketCount(@Param("menuName")String menuName)throws Exception;
	
	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * @Title: getComboList
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Market> getMarketList(@Param("menuName") String menuName,@Param("currentPageNo")  Integer currentPageNo,@Param("pageSize") Integer pageSize) throws Exception;
	
	/**
	 * 根据Id查询数据（点击修改进行传值）
	 * @Title: getMarkeByIdList
	 * @Description:
	 * @author: Administrator
	 * @param marketId
	 * @return
	 * @throws Exception
	 */
	public List<Market> getMarkeByIdList(@Param("marketId")Integer marketId)throws Exception;
	
	/**
	 * 新增
	 * @Title: addMarket
	 * @Description:
	 * @author: Administrator
	 * @param market
	 * @return
	 * @throws Exception
	 */
	public int addMarket(Market market)throws Exception;
	
	/**
	 * 修改
	 * @Title: updateMarket
	 * @Description:
	 * @author: Administrator
	 * @param market
	 * @return
	 * @throws Exception
	 */
	public int updateMarket(Market market)throws Exception;
	
	/**
	 * 删除
	 * @Title: delMarket
	 * @Description:
	 * @author: Administrator
	 * @param marketId
	 * @return
	 * @throws Exception
	 */
	public boolean delMarket(@Param("marketId")Integer marketId)throws Exception;
	
	/**
	 * 获取全部菜名
	 * @Title: listMenus
	 * @Description:
	 * @author: Administrator
	 * @return
	 * @throws Exception
	 */
	public List<Menu> listMenus()throws Exception;
	
	/**
	 * 获取全部员工姓名
	 * @Title: listMenus
	 * @Description:
	 * @author: Administrator
	 * @return
	 * @throws Exception
	 */
	public List<Employee> listEmployees()throws Exception;
	
	/**
	 * 获取会员名称
	 * @Title: listByMemberName
	 * @Description:
	 * @author: Administrator
	 * @return
	 * @throws Exception
	 */
	public List<Market> listByMemberName()throws Exception;
	
	/**
	 * @Title: selectEmpByIdInfo
	 * @Description:  根据员工Id查询是否存在该员工是否有销售信息
	 * @author: Arouse
	 * @param empId
	 * @return
	 */
	public int selectEmpByIdInfo(@Param("empId") Integer empId);

}
