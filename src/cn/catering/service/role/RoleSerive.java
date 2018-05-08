package cn.catering.service.role;

import java.sql.SQLException;
import java.util.List;

import cn.catering.pojo.Role;

public interface RoleSerive {
	 public   List<Role> getRoleList()throws SQLException;
}
