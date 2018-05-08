package cn.catering.dao.combo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Combo;
import cn.catering.pojo.Market;

public interface ComboMapperCustom {
	
	/**
	 * 根据名称统计总数
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getComboCount(@Param("comboName")String comboName)throws Exception;
	
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
	public List<Combo> getComboList(@Param("comboName") String comboName,@Param("currentPageNo")  Integer currentPageNo,@Param("pageSize") Integer pageSize) throws Exception;
	
	/**
	 * 根据Id查询类型名称
	 * @Title: getComboByid
	 * @Description:
	 * @author: Administrator
	 * @param comboId
	 * @return
	 * @throws Exception
	 */
	public List<Combo> getComboByid(@Param("comboId")Integer comboId)throws Exception;
	
	/**
	 * 修改
	 * @Title: updateMarket
	 * @Description:
	 * @author: Administrator
	 * @param market
	 * @return
	 * @throws Exception
	 */
	public boolean updateMarket(Market market)throws Exception;
	
	/**
	 * 查询全部套餐类型
	 * @Title: listCombos
	 * @Description:
	 * @author: Administrator
	 * @return
	 * @throws Exception
	 */
	public List<Combo> selectlistCombos()throws Exception;

}
