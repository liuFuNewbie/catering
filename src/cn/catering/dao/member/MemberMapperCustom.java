package cn.catering.dao.member;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.catering.pojo.Member;
import cn.catering.tools.PageSupport;

public interface MemberMapperCustom {


		/**
		 * 统计总数
		 * @Title: getMemberCount
		 * @Description:
		 * @author: zjb
		 * @param MemberName
		 * @return
		 */
		public int getMemberCount(@Param("memberName")String MemberName);
		
		/**
		 * 根据名称,当前页号，每页尺寸获取分页数据
		 * @Title: getComboList
		 * @Description:
		 * @author: Administrator
		 * @param comboName
		 * @param currentPageNo
		 * @param pageSize
		 * @return
		 * @throws Exception
		 */
		public List<Member> getMemberList(@Param("memberName") String memberName,@Param("pageSupport") PageSupport pageSupport);
		/**
		 * 
		 * @Title: getMemberCoByName
		 * @Description:
		 * @author: zjb
		 * @param memberName
		 * @return
		 * @throws SQLException
		 */
		boolean getMemberCoByName(@Param("memberName") String memberName) throws SQLException;/**
		 * 修改
		 * @Title: updateMember
		 * @Description:
		 * @author: zjb
		 * @param member
		 * @return
		 * @throws SQLException
		 */
		public boolean updateMember(Member member)throws SQLException;
		
		/**
		 * 按ID查询
		 * @Title: getMemberByid
		 * @Description:
		 * @author: zjb
		 * @param memberId
		 * @return
		 * @throws SQLException
		 */
		public Member getMemberByid(@Param("memberId")Integer memberId)throws SQLException;
		/**
		 * 添加信息
		 * @Title: addMember
		 * @Description:
		 * @author: zjb
		 * @param member
		 * @return
		 * @throws SQLException
		 */
		public int addMember(Member member) throws SQLException;
		/**
		 * @Title: selectIsAccount
		 * @Description:验证会员号是否存在并且返回会员编号
		 * @author: MDS
		 * @param account 会员号
		 * @return 返回会员编号
		 */
		public Integer selectIsAccount(@Param("account")long account);
}
