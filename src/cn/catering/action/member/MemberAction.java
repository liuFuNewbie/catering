package cn.catering.action.member;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.catering.pojo.Member;
import cn.catering.service.member.MemberService;
import cn.catering.tools.PageSupport;

@Controller
@RequestMapping("/member")
public class MemberAction{ 
	/**
	 * 查询数据并分页
	 */
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/getMemberlist")
	public String getProviderList(
			Model model,
			@RequestParam(value="MemberName",required=false)String queryComboName,
			@RequestParam(value="pageIndex",required=false)Integer currentPageNo){
		PageSupport pageSupport = new PageSupport();
		//设置页的大小
		pageSupport.setPageSize(5);
		//设置当前行数
		if(currentPageNo == null){
			currentPageNo = 1;
		}
		
		pageSupport.setCurrentPageNo(currentPageNo);
		try {
			//获取总行数，并且设置
			pageSupport.setTotalCount(memberService.getMemberCount(queryComboName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > pageSupport.getTotalPageCount()) {
			currentPageNo = pageSupport.getTotalPageCount();
		}
		List<Member> list = null;
		try {
			list = memberService.getMemberList(queryComboName, pageSupport);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("queryComboName", queryComboName);
		model.addAttribute("currentPageNo", currentPageNo);
		model.addAttribute("totalCout", pageSupport.getTotalCount());
		model.addAttribute("totalPageCout", pageSupport.getTotalPageCount());
		model.addAttribute("list", list);
		return "/background/memberlist";
	}
	/**
	 * 根据会员编号删除会员信息
	 * @Title: delMemberById
	 * @Description:根据会员编号删除会员信息
	 * @author: zhang
	 * @param payId 
	 * @return String类型
	 */
	@RequestMapping(value = "/delmember")
	@ResponseBody
	public String delmermber(@RequestParam(value="memberId",required=false)int membrtId) {
		try {
			int cost=memberService.delmember(membrtId);
			if(cost > 0)
				return "true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
	}
	/**
	 * 获取会员信息再进行修改
	 */
	@RequestMapping(value = "/getUpdatemember", method = RequestMethod.GET)
	public String updateMember(Model model,Member member,
		@RequestParam(value = "memberId", required = false) Integer id) {
		try {
			 member=memberService.getMemberByid(id);
			 model.addAttribute("member", member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/background/updatemember";
	}
	@RequestMapping(value = "/Updatemember", method = RequestMethod.POST)
	public String updateMember(
		Model model,
			Member member,
			@RequestParam(value = "memberName", required = false) String MemberName,
			@RequestParam(value = "memberId", required = false) Integer id,
			@RequestParam(value = "account", required = false) Integer account,
			@RequestParam(value = "phone", required = false) Long phone,
			@RequestParam(value = "balance", required = false) BigDecimal balance
			) {
		try {
			member.setMemberId(id);
			member.setMemberName(MemberName);
			member.setAccount(account);
			member.setPhone(phone);
			member.setBalance(balance);
			boolean bl = memberService.updateMember(member);
			if (bl != true) {
				return "/background/updatemember";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/getMemberlist.action";
	}	/**
	 * 修改会员信息
	 * @Title: updateMember
	 * @Description:
	 * @author: zjb
	 * @param model
	 * @param member
	 * @param myBirthdate
	 * @param memberId
	 * @return
	 */
	@RequestMapping(value="/updatemember",method = RequestMethod.POST)
	public String updateMember(Model model,Member member,@RequestParam(value="myBirthdate",required=false)String myBirthdate,
			@RequestParam(value = "memberId", required = false) Integer memberId) {
			
		try {
			if(myBirthdate !=""){
				member.setBirthdate(java.sql.Date.valueOf(myBirthdate));
			}
			member.setMemberId(memberId);
			boolean bl = memberService.updateMember(member);
			if (bl != true) {
				model.addAttribute("member", member);
				return "/background/updatemember";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/getMemberlist.action";
	}
	/**
	 * 会员添加
	 * @Title: addMmeber
	 * @Description:
	 * @author: zjb
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/getaddmember")
	public String insert(Member member,@RequestParam(value="myBirthdate",required=false)String myBirthdate) {
		try {
			if(myBirthdate !=""){
				member.setBirthdate(java.sql.Date.valueOf(myBirthdate));
			}
			boolean bl = memberService.addMember(member);
			if (bl == false) 
				return "/background/addmember";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/getMemberlist.action";
	}
	
	/**
	 * @Title: selectIsAccount
	 * @Description: 会员号验证是否存在
	 * @author: MDS
	 * @param account
	 * @return 如果存在返回会员编号
	 */
	@RequestMapping("/{account}/selectIsAccount")
	public @ResponseBody Integer selectIsAccount(@PathVariable Long account){
		try {
			return memberService.selectIsAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
