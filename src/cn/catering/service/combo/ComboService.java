package cn.catering.service.combo;

import java.util.List;

import cn.catering.pojo.Combo;

public interface ComboService {

	/**
	 * 根据名称统计总数
	 * 
	 * @Title: getComboCount
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @return
	 * @throws Exception
	 */
	public int getComboCount(String comboName) throws Exception;

	/**
	 * 根据名称,当前页号，每页尺寸获取分页数据
	 * 
	 * @Title: getComboList
	 * @Description:
	 * @author: Administrator
	 * @param comboName
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Combo> getComboList(String comboName, Integer currentPageNo,
			Integer pageSize) throws Exception;

	/**
	 * 新增套餐类型
	 * 
	 * @Title: addCombo
	 * @Description:
	 * @author: Administrator
	 * @param combo
	 * @return
	 * @throws Exception
	 */
	public boolean addCombo(Combo combo) throws Exception;

	/**
	 * 修改套餐类型
	 * 
	 * @Title: updateCombo
	 * @Description:
	 * @author: Administrator
	 * @param combo
	 * @return
	 * @throws Exception
	 */
	public boolean updateCombo(Combo combo) throws Exception;

	/**
	 * 删除套餐类型
	 * 
	 * @Title: delCombo
	 * @Description:
	 * @author: Administrator
	 * @param ComboId
	 * @return
	 * @throws Exception
	 */
	public boolean delCombo(Integer ComboId) throws Exception;

	/**
	 * 根据Id查询类型名称
	 * 
	 * @Title: getComboByid
	 * @Description:
	 * @author: Administrator
	 * @param comboId
	 * @return
	 * @throws Exception
	 */
	public List<Combo> getComboByid(Integer comboId) throws Exception;

	/**
	 * 查询全部套餐类型
	 * 
	 * @Title: listCombos
	 * @Description:
	 * @author: Administrator
	 * @return
	 * @throws Exception
	 */
	public List<Combo> selectlistCombos() throws Exception;

}
