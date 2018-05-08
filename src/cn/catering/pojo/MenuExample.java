package cn.catering.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMenuIdIsNull() {
            addCriterion("menuId is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menuId is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menuId =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menuId <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menuId >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuId >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menuId <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menuId <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menuId in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menuId not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menuId between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menuId not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menuName is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menuName is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menuName =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menuName <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menuName >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menuName >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menuName <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menuName <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menuName like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menuName not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menuName in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menuName not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menuName between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menuName not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNull() {
            addCriterion("unitPrice is null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIsNotNull() {
            addCriterion("unitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unitPrice =", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unitPrice <>", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unitPrice >", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unitPrice >=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unitPrice <", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unitPrice <=", value, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unitPrice in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unitPrice not in", values, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitPrice between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unitPrice not between", value1, value2, "unitPrice");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNull() {
            addCriterion("describe is null");
            return (Criteria) this;
        }

        public Criteria andDescribeIsNotNull() {
            addCriterion("describe is not null");
            return (Criteria) this;
        }

        public Criteria andDescribeEqualTo(String value) {
            addCriterion("describe =", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotEqualTo(String value) {
            addCriterion("describe <>", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThan(String value) {
            addCriterion("describe >", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("describe >=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThan(String value) {
            addCriterion("describe <", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLessThanOrEqualTo(String value) {
            addCriterion("describe <=", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeLike(String value) {
            addCriterion("describe like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotLike(String value) {
            addCriterion("describe not like", value, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeIn(List<String> values) {
            addCriterion("describe in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotIn(List<String> values) {
            addCriterion("describe not in", values, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeBetween(String value1, String value2) {
            addCriterion("describe between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andDescribeNotBetween(String value1, String value2) {
            addCriterion("describe not between", value1, value2, "describe");
            return (Criteria) this;
        }

        public Criteria andImgPathOneIsNull() {
            addCriterion("imgPathOne is null");
            return (Criteria) this;
        }

        public Criteria andImgPathOneIsNotNull() {
            addCriterion("imgPathOne is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathOneEqualTo(String value) {
            addCriterion("imgPathOne =", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneNotEqualTo(String value) {
            addCriterion("imgPathOne <>", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneGreaterThan(String value) {
            addCriterion("imgPathOne >", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneGreaterThanOrEqualTo(String value) {
            addCriterion("imgPathOne >=", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneLessThan(String value) {
            addCriterion("imgPathOne <", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneLessThanOrEqualTo(String value) {
            addCriterion("imgPathOne <=", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneLike(String value) {
            addCriterion("imgPathOne like", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneNotLike(String value) {
            addCriterion("imgPathOne not like", value, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneIn(List<String> values) {
            addCriterion("imgPathOne in", values, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneNotIn(List<String> values) {
            addCriterion("imgPathOne not in", values, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneBetween(String value1, String value2) {
            addCriterion("imgPathOne between", value1, value2, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathOneNotBetween(String value1, String value2) {
            addCriterion("imgPathOne not between", value1, value2, "imgPathOne");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoIsNull() {
            addCriterion("imgPathTwo is null");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoIsNotNull() {
            addCriterion("imgPathTwo is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoEqualTo(String value) {
            addCriterion("imgPathTwo =", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoNotEqualTo(String value) {
            addCriterion("imgPathTwo <>", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoGreaterThan(String value) {
            addCriterion("imgPathTwo >", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoGreaterThanOrEqualTo(String value) {
            addCriterion("imgPathTwo >=", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoLessThan(String value) {
            addCriterion("imgPathTwo <", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoLessThanOrEqualTo(String value) {
            addCriterion("imgPathTwo <=", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoLike(String value) {
            addCriterion("imgPathTwo like", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoNotLike(String value) {
            addCriterion("imgPathTwo not like", value, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoIn(List<String> values) {
            addCriterion("imgPathTwo in", values, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoNotIn(List<String> values) {
            addCriterion("imgPathTwo not in", values, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoBetween(String value1, String value2) {
            addCriterion("imgPathTwo between", value1, value2, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathTwoNotBetween(String value1, String value2) {
            addCriterion("imgPathTwo not between", value1, value2, "imgPathTwo");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeIsNull() {
            addCriterion("imgPathThree is null");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeIsNotNull() {
            addCriterion("imgPathThree is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeEqualTo(String value) {
            addCriterion("imgPathThree =", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeNotEqualTo(String value) {
            addCriterion("imgPathThree <>", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeGreaterThan(String value) {
            addCriterion("imgPathThree >", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeGreaterThanOrEqualTo(String value) {
            addCriterion("imgPathThree >=", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeLessThan(String value) {
            addCriterion("imgPathThree <", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeLessThanOrEqualTo(String value) {
            addCriterion("imgPathThree <=", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeLike(String value) {
            addCriterion("imgPathThree like", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeNotLike(String value) {
            addCriterion("imgPathThree not like", value, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeIn(List<String> values) {
            addCriterion("imgPathThree in", values, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeNotIn(List<String> values) {
            addCriterion("imgPathThree not in", values, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeBetween(String value1, String value2) {
            addCriterion("imgPathThree between", value1, value2, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andImgPathThreeNotBetween(String value1, String value2) {
            addCriterion("imgPathThree not between", value1, value2, "imgPathThree");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("dateTime is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("dateTime is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(Date value) {
            addCriterion("dateTime =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(Date value) {
            addCriterion("dateTime <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(Date value) {
            addCriterion("dateTime >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("dateTime >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(Date value) {
            addCriterion("dateTime <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(Date value) {
            addCriterion("dateTime <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<Date> values) {
            addCriterion("dateTime in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<Date> values) {
            addCriterion("dateTime not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(Date value1, Date value2) {
            addCriterion("dateTime between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(Date value1, Date value2) {
            addCriterion("dateTime not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andNavIdIsNull() {
            addCriterion("navId is null");
            return (Criteria) this;
        }

        public Criteria andNavIdIsNotNull() {
            addCriterion("navId is not null");
            return (Criteria) this;
        }

        public Criteria andNavIdEqualTo(Integer value) {
            addCriterion("navId =", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotEqualTo(Integer value) {
            addCriterion("navId <>", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThan(Integer value) {
            addCriterion("navId >", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("navId >=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThan(Integer value) {
            addCriterion("navId <", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThanOrEqualTo(Integer value) {
            addCriterion("navId <=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdIn(List<Integer> values) {
            addCriterion("navId in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotIn(List<Integer> values) {
            addCriterion("navId not in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdBetween(Integer value1, Integer value2) {
            addCriterion("navId between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotBetween(Integer value1, Integer value2) {
            addCriterion("navId not between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andComboIdIsNull() {
            addCriterion("comboId is null");
            return (Criteria) this;
        }

        public Criteria andComboIdIsNotNull() {
            addCriterion("comboId is not null");
            return (Criteria) this;
        }

        public Criteria andComboIdEqualTo(Integer value) {
            addCriterion("comboId =", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdNotEqualTo(Integer value) {
            addCriterion("comboId <>", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdGreaterThan(Integer value) {
            addCriterion("comboId >", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comboId >=", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdLessThan(Integer value) {
            addCriterion("comboId <", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdLessThanOrEqualTo(Integer value) {
            addCriterion("comboId <=", value, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdIn(List<Integer> values) {
            addCriterion("comboId in", values, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdNotIn(List<Integer> values) {
            addCriterion("comboId not in", values, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdBetween(Integer value1, Integer value2) {
            addCriterion("comboId between", value1, value2, "comboId");
            return (Criteria) this;
        }

        public Criteria andComboIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comboId not between", value1, value2, "comboId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}