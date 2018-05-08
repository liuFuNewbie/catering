package cn.catering.service.material;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Material;
import cn.catering.pojo.MaterialExtension;
import cn.catering.pojo.WarehouseType;
import cn.catering.tools.PageSupport;
 

public interface MaterialService {
	/**
	 * 
	 * @Title: getMaterial
	 * @Description:  第一个参数pageSupport代表是根据商品编号、创建人、菜名获取原料信息列表【参数可有可无】 第二个参数pageSupport使用分页
	 * @author: Administrator
	 * @param material
	 * @param pageSupport
	 * @return
	 */
  public List<MaterialExtension> getMaterial(String postName,Integer type,PageSupport pageSupport)throws SQLException;
  /**
   * 
   * @Title: getMaterialCount
   * @Description:   根据商品编号、创建人、菜名获取原料信息数量
   * @author: Administrator
   * @return
   */
  public  List<MaterialExtension> getMaterialCount(String postName,Integer typeId)throws SQLException;
  /**
   * 
   * @Title: getMaterialById
   * @Description:  根据原料购买记录编号获取信息列表
   * @author: Administrator
   * @param Materiald
   * @return
   */
  public MaterialExtension getMaterialById(Integer Materiald)throws SQLException;
  /**
   * 
   * @Title: updateMaterialById
   * @Description:  根据编号修改原料信息列表信息
   * @author: Administrator
   * @param material
   * @return  
   */
  public int updateMaterialById(MaterialExtension material)throws SQLException;
  /**
   * 
   * @Title: insertMaterial
   * @Description:  添加原料信息列表信息
   * @author: Administrator
   * @param material
   * @return
   */
  public int insertMaterial(Material material)throws SQLException;
  /**
   * 
   * @Title: deleteMaterialById
   * @Description:  根据编号删除原料信息
   * @author: Administrator
   * @param material
   * @return
   */
  public int deleteMaterialById(Integer material)throws SQLException; 
  /**
   * 
   * @Title: getMaterialCountById
   * @Description:根据支付类别Id获取原料信息行数
   * @author: Sun
   * @param payId 支付类别Id
   * @return int类型
   * @throws SQLException
   */
  public int getMaterialCountById(Integer payId) throws Exception;
}
