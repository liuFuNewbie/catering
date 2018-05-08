package cn.catering.service.major;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Major;

public interface MajorService {
	/**
	 * 
	 * @Title: getMajorList
	 * @Description: 获取专业信息列表
	 * @author: Administrator
	 * @return
	 */
    public List<Major> getMajorList()throws SQLException;
}
