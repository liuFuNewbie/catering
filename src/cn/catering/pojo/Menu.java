package cn.catering.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {
	private Integer menuId;

	private String menuName;

	private BigDecimal unitPrice;

	private BigDecimal cost;

	private String describe;

	private String imgPathOne;

	private String imgPathTwo;

	private String imgPathThree;

	private String unit;

	private Integer discount;

	private Date dateTime;

	private Integer navId;

	private Integer userId;

	private Integer comboId;

	private List<Market> list;

	private List<User> userList;

	private List<Navigation> navigationList;

	private List<Combo> comboList;

	private static final long serialVersionUID = 1L;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}

	public String getImgPathOne() {
		return imgPathOne;
	}

	public void setImgPathOne(String imgPathOne) {
		this.imgPathOne = imgPathOne == null ? null : imgPathOne.trim();
	}

	public String getImgPathTwo() {
		return imgPathTwo;
	}

	public void setImgPathTwo(String imgPathTwo) {
		this.imgPathTwo = imgPathTwo == null ? null : imgPathTwo.trim();
	}

	public String getImgPathThree() {
		return imgPathThree;
	}

	public void setImgPathThree(String imgPathThree) {
		this.imgPathThree = imgPathThree == null ? null : imgPathThree.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getNavId() {
		return navId;
	}

	public void setNavId(Integer navId) {
		this.navId = navId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getComboId() {
		return comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

	public List<Market> getMarketList() {
		return list;
	}

	public void setMarketList(List<Market> list) {
		this.list = list;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Navigation> getNavigationList() {
		return navigationList;
	}

	public void setNavigationList(List<Navigation> navigationList) {
		this.navigationList = navigationList;
	}

	public List<Combo> getComboList() {
		return comboList;
	}

	public void setComboList(List<Combo> comboList) {
		this.comboList = comboList;
	}

}
