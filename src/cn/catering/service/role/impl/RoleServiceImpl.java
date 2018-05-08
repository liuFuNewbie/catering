package cn.catering.service.role.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.catering.dao.role.RoleMapperCustom;
import cn.catering.pojo.Role;
import cn.catering.service.role.RoleSerive;
@Service
public class RoleServiceImpl implements RoleSerive {
@Resource
	 private RoleMapperCustom roleMapperCustom;
/**
 * 获取角色列表信息
 */
	public List<Role> getRoleList()throws SQLException {
 		return roleMapperCustom.getRoleList();
	}

}
