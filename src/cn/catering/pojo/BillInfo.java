package cn.catering.pojo;

import java.sql.Date;

/**
 * 自定义账单明细实体类
 * @ClassName:  BillInfo   
 * @Description:
 * @author: Administrator
 * @date:   2018年4月1日 下午11:12:32
 */
public class BillInfo {
	
	private Integer marketId;   //销售编号
	private double totalMoney;   //消费金额
	private Date dataTime;     //结算日期
	private String describe;  // 备注
	private Integer memberId;   //会员编号
	private String memberName;  //用户姓名 
	private Integer account;      //会员编号
	private Integer comboId;    //套餐编号
	private String comboName;   //套餐类型名称
	private Integer menuId;     //菜编号
	private Integer discount;   //优惠状态
	private Integer payId;  //支付类型编号
	private String payName;  //支付类型
	private Integer empId;    //员工编号
	private String empName;     //收款人
	private Integer navId;    //前台类别Id
	private double saleMoney;     //优惠金额
	private double factMoney;    //实际收款金额
	private Integer materialId;   //原料编号
	
	public Integer getMarketId() {
		return marketId;
	}
	public void setMarketId(Integer marketId) {
		this.marketId = marketId;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Date getDataTime() {
		return dataTime;
	}
	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public Integer getComboId() {
		return comboId;
	}
	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getPayId() {
		return payId;
	}
	public void setPayId(Integer payId) {
		this.payId = payId;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(double saleMoney) {
		this.saleMoney = saleMoney;
	}
	public double getFactMoney() {
		return factMoney;
	}
	public void setFactMoney(double factMoney) {
		this.factMoney = factMoney;
	}
	public Integer getNavId() {
		return navId;
	}
	public void setNavId(Integer navId) {
		this.navId = navId;
	}
	public Integer getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

}
