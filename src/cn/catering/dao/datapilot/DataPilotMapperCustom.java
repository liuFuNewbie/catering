package cn.catering.dao.datapilot;

import java.util.List;

import cn.catering.pojo.DataPilotCustom;
/**
 * @ClassName:  DataPilotMapperCustom   
 * @Description:后台导航条数据接口
 * @author: MDS
 * @date:   2018年3月27日 下午10:09:27
 */
public interface DataPilotMapperCustom {
	/**
	 * @Title: getAllDataPilots
	 * @Description:获取后台导航条数据
	 * @author: MDS
	 * @return 返回后台导航条数据集合;
	 */
	public List<DataPilotCustom> getAllDataPilots();
}
