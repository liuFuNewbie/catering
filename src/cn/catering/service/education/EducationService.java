package cn.catering.service.education;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Education;

public interface EducationService {
	/**
	 * 
	 * @Title: getEducationList
	 * @Description: 获取学历信息列表
	 * @author: Administrator
	 * @return
	 */
   public List<Education> getEducationList()throws SQLException;
}
