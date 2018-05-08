package cn.catering.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.User;
import cn.catering.tools.PageSupport;

public interface UserMapperCustom {
	/**
	 * 
	 * @Title: getUserList
	 * @Description:  获取用户列表
	 * @author: Administrator
	 * @return
	 */
    public List<User> getUserList();
  
    /**
     * 
     * @Title: getUserByUserName
     * @Description:  根据用户名获取用户编号
     * @author: Administrator
     * @param userName
     * @return
     */
    public User getUserByUserName(@Param("userName")String userName);
    /**
     * 
     * @Title: getUserListByWronguserName
     * @Description:  获取用户列表  条件可有可无
     * @author: Administrator
     * @param userName
     * @return
     */
    public List<User> getUserListByWrongUserName(@Param(value="userName")String userName,@Param("pageSupport")PageSupport pageSupport);
    /**
     * 
     * @Title: getUserListByWronguserNameCount
     * @Description:  获取用户列表数量  条件可有可无
     * @author: Administrator
     * @param userName
     * @return
     */
    public int getUserListByWrongUserNameCount(@Param(value="userName")String userName);
    /**
     * 
     * @Title: insertUser
     * @Description:  添加用户信息
     * @author: Administrator
     * @param user
     * @return
     */
    public int insertUser(@Param(value="user")User user);
    /**
     * 
     * @Title: getUserById
     * @Description:根据用户编号获取用户信息
     * @author: Administrator
     * @param userId
     * @return
     */
    public User getUserById(@Param(value="userId")Integer userId);
    /**
     * 
     * @Title: updateUserById
     * @Description:根据用户编号修改用户信息
     * @author: Administrator
     * @param user
     * @return
     */
    public int updateUserById(@Param(value="user")User user);
    /**
     * 
     * @Title: getUserCountById
     * @Description:根据用户编号获取用户数量
     * @author: Administrator
     * @param userId
     * @return
     */
    public int getUserCountById(@Param(value="userId")Integer userId);
    /**
     * 
     * @Title: delUserById
     * @Description:  根据用户编号删除用户信息
     * @author: Administrator
     * @param userId
     * @return
     */
    public int delUserById(@Param(value="userId")Integer userId);
    /**
	 * 根据用户名称查找用户头像(有用)
	 * @Title: getSelectUserName
	 * @Description:
	 * @author: Administrator
	 * @param UserName
	 * @return
	 * @throws Exception
	 */
	public List<User> getSelectUserheadPortraits(String userName);
	
	/**
	 * 修改用户头像
	 * @Title: updateheadPortraits
	 * @Description:
	 * @author: Administrator
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateheadPortraits(User user);
	/**
	 * 获取登录对象
	 * @Title: getUser
	 * @Description:
	 * @author: MDS
	 * @param userName
	 * @return 登录名称
	 */
	public User getUser(@Param(value="userName")String userName);
}