package cn.catering.pojo;

import java.util.ArrayList;
import java.util.List;

public class NavigationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NavigationExample() {
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

        public Criteria andNavNameIsNull() {
            addCriterion("navName is null");
            return (Criteria) this;
        }

        public Criteria andNavNameIsNotNull() {
            addCriterion("navName is not null");
            return (Criteria) this;
        }

        public Criteria andNavNameEqualTo(String value) {
            addCriterion("navName =", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotEqualTo(String value) {
            addCriterion("navName <>", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameGreaterThan(String value) {
            addCriterion("navName >", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameGreaterThanOrEqualTo(String value) {
            addCriterion("navName >=", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLessThan(String value) {
            addCriterion("navName <", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLessThanOrEqualTo(String value) {
            addCriterion("navName <=", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameLike(String value) {
            addCriterion("navName like", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotLike(String value) {
            addCriterion("navName not like", value, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameIn(List<String> values) {
            addCriterion("navName in", values, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotIn(List<String> values) {
            addCriterion("navName not in", values, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameBetween(String value1, String value2) {
            addCriterion("navName between", value1, value2, "navName");
            return (Criteria) this;
        }

        public Criteria andNavNameNotBetween(String value1, String value2) {
            addCriterion("navName not between", value1, value2, "navName");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(Integer value) {
            addCriterion("parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(Integer value) {
            addCriterion("parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(Integer value) {
            addCriterion("parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(Integer value) {
            addCriterion("parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(Integer value) {
            addCriterion("parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<Integer> values) {
            addCriterion("parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<Integer> values) {
            addCriterion("parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(Integer value1, Integer value2) {
            addCriterion("parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(Integer value1, Integer value2) {
            addCriterion("parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andWebPagePathIsNull() {
            addCriterion("webPagePath is null");
            return (Criteria) this;
        }

        public Criteria andWebPagePathIsNotNull() {
            addCriterion("webPagePath is not null");
            return (Criteria) this;
        }

        public Criteria andWebPagePathEqualTo(String value) {
            addCriterion("webPagePath =", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathNotEqualTo(String value) {
            addCriterion("webPagePath <>", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathGreaterThan(String value) {
            addCriterion("webPagePath >", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathGreaterThanOrEqualTo(String value) {
            addCriterion("webPagePath >=", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathLessThan(String value) {
            addCriterion("webPagePath <", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathLessThanOrEqualTo(String value) {
            addCriterion("webPagePath <=", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathLike(String value) {
            addCriterion("webPagePath like", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathNotLike(String value) {
            addCriterion("webPagePath not like", value, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathIn(List<String> values) {
            addCriterion("webPagePath in", values, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathNotIn(List<String> values) {
            addCriterion("webPagePath not in", values, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathBetween(String value1, String value2) {
            addCriterion("webPagePath between", value1, value2, "webPagePath");
            return (Criteria) this;
        }

        public Criteria andWebPagePathNotBetween(String value1, String value2) {
            addCriterion("webPagePath not between", value1, value2, "webPagePath");
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