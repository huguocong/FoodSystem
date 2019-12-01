package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNull() {
            addCriterion("table_id is null");
            return (Criteria) this;
        }

        public Criteria andTableIdIsNotNull() {
            addCriterion("table_id is not null");
            return (Criteria) this;
        }

        public Criteria andTableIdEqualTo(Integer value) {
            addCriterion("table_id =", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotEqualTo(Integer value) {
            addCriterion("table_id <>", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThan(Integer value) {
            addCriterion("table_id >", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("table_id >=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThan(Integer value) {
            addCriterion("table_id <", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("table_id <=", value, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdIn(List<Integer> values) {
            addCriterion("table_id in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotIn(List<Integer> values) {
            addCriterion("table_id not in", values, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdBetween(Integer value1, Integer value2) {
            addCriterion("table_id between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("table_id not between", value1, value2, "tableId");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("orderDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("orderDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterion("orderDate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterion("orderDate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterion("orderDate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterion("orderDate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterion("orderDate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterion("orderDate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterion("orderDate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterion("orderDate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterion("orderDate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterion("orderDate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("totalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("totalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(Double value) {
            addCriterion("totalPrice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(Double value) {
            addCriterion("totalPrice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(Double value) {
            addCriterion("totalPrice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPrice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(Double value) {
            addCriterion("totalPrice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(Double value) {
            addCriterion("totalPrice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<Double> values) {
            addCriterion("totalPrice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<Double> values) {
            addCriterion("totalPrice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(Double value1, Double value2) {
            addCriterion("totalPrice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(Double value1, Double value2) {
            addCriterion("totalPrice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Integer value) {
            addCriterion("orderStatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Integer value) {
            addCriterion("orderStatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Integer value) {
            addCriterion("orderStatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderStatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Integer value) {
            addCriterion("orderStatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Integer value) {
            addCriterion("orderStatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Integer> values) {
            addCriterion("orderStatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Integer> values) {
            addCriterion("orderStatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderStatus not between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andPeopleIsNull() {
            addCriterion("people is null");
            return (Criteria) this;
        }

        public Criteria andPeopleIsNotNull() {
            addCriterion("people is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleEqualTo(String value) {
            addCriterion("people =", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotEqualTo(String value) {
            addCriterion("people <>", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThan(String value) {
            addCriterion("people >", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("people >=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThan(String value) {
            addCriterion("people <", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThanOrEqualTo(String value) {
            addCriterion("people <=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLike(String value) {
            addCriterion("people like", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotLike(String value) {
            addCriterion("people not like", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleIn(List<String> values) {
            addCriterion("people in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotIn(List<String> values) {
            addCriterion("people not in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleBetween(String value1, String value2) {
            addCriterion("people between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotBetween(String value1, String value2) {
            addCriterion("people not between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andTeleIsNull() {
            addCriterion("tele is null");
            return (Criteria) this;
        }

        public Criteria andTeleIsNotNull() {
            addCriterion("tele is not null");
            return (Criteria) this;
        }

        public Criteria andTeleEqualTo(String value) {
            addCriterion("tele =", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotEqualTo(String value) {
            addCriterion("tele <>", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleGreaterThan(String value) {
            addCriterion("tele >", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleGreaterThanOrEqualTo(String value) {
            addCriterion("tele >=", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLessThan(String value) {
            addCriterion("tele <", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLessThanOrEqualTo(String value) {
            addCriterion("tele <=", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleLike(String value) {
            addCriterion("tele like", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotLike(String value) {
            addCriterion("tele not like", value, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleIn(List<String> values) {
            addCriterion("tele in", values, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotIn(List<String> values) {
            addCriterion("tele not in", values, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleBetween(String value1, String value2) {
            addCriterion("tele between", value1, value2, "tele");
            return (Criteria) this;
        }

        public Criteria andTeleNotBetween(String value1, String value2) {
            addCriterion("tele not between", value1, value2, "tele");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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