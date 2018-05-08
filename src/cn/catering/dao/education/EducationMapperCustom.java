package cn.catering.dao.education;

import java.util.List;

import cn.catering.pojo.Education;

public interface EducationMapperCustom {
	/**
	 * 
	 * @Title: getEducationList
	 * @Description: 获取学历信息列表
	 * @author: Administrator
	 * @return
	 */
   public List<Education> getEducationList();
}