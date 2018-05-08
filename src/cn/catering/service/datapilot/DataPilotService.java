package cn.catering.service.datapilot;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.DataPilotCustom;
/**
 * @ClassName:  DataPilotService   
 * @Description:后台导航条数据接口
 * @author: MDS
 * @date:   2018年3月27日 下午9:20:11
 */
public interface DataPilotService {
	/**
	 * @Title: getAllDataPilots
	 * @Description:获取所有后台导航条数据信息
	 * @author: MDS
	 * @return 返回后台导航条数据信息集合
	 * @throws SQLException
	 */
	public List<DataPilotCustom> getAllDataPilots() throws SQLException;
}
