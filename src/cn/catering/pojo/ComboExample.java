package cn.catering.pojo;

import java.util.ArrayList;
import java.util.List;

public class ComboExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComboExample() {
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

        public Criteria andComboNameIsNull() {
            addCriterion("comboName is null");
            return (Criteria) this;
        }

        public Criteria andComboNameIsNotNull() {
            addCriterion("comboName is not null");
            return (Criteria) this;
        }

        public Criteria andComboNameEqualTo(String value) {
            addCriterion("comboName =", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameNotEqualTo(String value) {
            addCriterion("comboName <>", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameGreaterThan(String value) {
            addCriterion("comboName >", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameGreaterThanOrEqualTo(String value) {
            addCriterion("comboName >=", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameLessThan(String value) {
            addCriterion("comboName <", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameLessThanOrEqualTo(String value) {
            addCriterion("comboName <=", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameLike(String value) {
            addCriterion("comboName like", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameNotLike(String value) {
            addCriterion("comboName not like", value, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameIn(List<String> values) {
            addCriterion("comboName in", values, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameNotIn(List<String> values) {
            addCriterion("comboName not in", values, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameBetween(String value1, String value2) {
            addCriterion("comboName between", value1, value2, "comboName");
            return (Criteria) this;
        }

        public Criteria andComboNameNotBetween(String value1, String value2) {
            addCriterion("comboName not between", value1, value2, "comboName");
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