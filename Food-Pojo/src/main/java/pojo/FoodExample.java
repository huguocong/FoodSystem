package pojo;

import java.util.ArrayList;
import java.util.List;

public class FoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodExample() {
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

        public Criteria andFoodnameIsNull() {
            addCriterion("foodName is null");
            return (Criteria) this;
        }

        public Criteria andFoodnameIsNotNull() {
            addCriterion("foodName is not null");
            return (Criteria) this;
        }

        public Criteria andFoodnameEqualTo(String value) {
            addCriterion("foodName =", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotEqualTo(String value) {
            addCriterion("foodName <>", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameGreaterThan(String value) {
            addCriterion("foodName >", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameGreaterThanOrEqualTo(String value) {
            addCriterion("foodName >=", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLessThan(String value) {
            addCriterion("foodName <", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLessThanOrEqualTo(String value) {
            addCriterion("foodName <=", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameLike(String value) {
            addCriterion("foodName like", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotLike(String value) {
            addCriterion("foodName not like", value, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameIn(List<String> values) {
            addCriterion("foodName in", values, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotIn(List<String> values) {
            addCriterion("foodName not in", values, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameBetween(String value1, String value2) {
            addCriterion("foodName between", value1, value2, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodnameNotBetween(String value1, String value2) {
            addCriterion("foodName not between", value1, value2, "foodname");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1IsNull() {
            addCriterion("foodType_id1 is null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1IsNotNull() {
            addCriterion("foodType_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1EqualTo(Integer value) {
            addCriterion("foodType_id1 =", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1NotEqualTo(Integer value) {
            addCriterion("foodType_id1 <>", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1GreaterThan(Integer value) {
            addCriterion("foodType_id1 >", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("foodType_id1 >=", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1LessThan(Integer value) {
            addCriterion("foodType_id1 <", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1LessThanOrEqualTo(Integer value) {
            addCriterion("foodType_id1 <=", value, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1In(List<Integer> values) {
            addCriterion("foodType_id1 in", values, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1NotIn(List<Integer> values) {
            addCriterion("foodType_id1 not in", values, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1Between(Integer value1, Integer value2) {
            addCriterion("foodType_id1 between", value1, value2, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId1NotBetween(Integer value1, Integer value2) {
            addCriterion("foodType_id1 not between", value1, value2, "foodtypeId1");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2IsNull() {
            addCriterion("foodType_id2 is null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2IsNotNull() {
            addCriterion("foodType_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2EqualTo(Integer value) {
            addCriterion("foodType_id2 =", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2NotEqualTo(Integer value) {
            addCriterion("foodType_id2 <>", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2GreaterThan(Integer value) {
            addCriterion("foodType_id2 >", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("foodType_id2 >=", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2LessThan(Integer value) {
            addCriterion("foodType_id2 <", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2LessThanOrEqualTo(Integer value) {
            addCriterion("foodType_id2 <=", value, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2In(List<Integer> values) {
            addCriterion("foodType_id2 in", values, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2NotIn(List<Integer> values) {
            addCriterion("foodType_id2 not in", values, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2Between(Integer value1, Integer value2) {
            addCriterion("foodType_id2 between", value1, value2, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andFoodtypeId2NotBetween(Integer value1, Integer value2) {
            addCriterion("foodType_id2 not between", value1, value2, "foodtypeId2");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMpriceIsNull() {
            addCriterion("mprice is null");
            return (Criteria) this;
        }

        public Criteria andMpriceIsNotNull() {
            addCriterion("mprice is not null");
            return (Criteria) this;
        }

        public Criteria andMpriceEqualTo(Double value) {
            addCriterion("mprice =", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotEqualTo(Double value) {
            addCriterion("mprice <>", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceGreaterThan(Double value) {
            addCriterion("mprice >", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("mprice >=", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceLessThan(Double value) {
            addCriterion("mprice <", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceLessThanOrEqualTo(Double value) {
            addCriterion("mprice <=", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceIn(List<Double> values) {
            addCriterion("mprice in", values, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotIn(List<Double> values) {
            addCriterion("mprice not in", values, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceBetween(Double value1, Double value2) {
            addCriterion("mprice between", value1, value2, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotBetween(Double value1, Double value2) {
            addCriterion("mprice not between", value1, value2, "mprice");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andIstuijianIsNull() {
            addCriterion("istuijian is null");
            return (Criteria) this;
        }

        public Criteria andIstuijianIsNotNull() {
            addCriterion("istuijian is not null");
            return (Criteria) this;
        }

        public Criteria andIstuijianEqualTo(Integer value) {
            addCriterion("istuijian =", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianNotEqualTo(Integer value) {
            addCriterion("istuijian <>", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianGreaterThan(Integer value) {
            addCriterion("istuijian >", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianGreaterThanOrEqualTo(Integer value) {
            addCriterion("istuijian >=", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianLessThan(Integer value) {
            addCriterion("istuijian <", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianLessThanOrEqualTo(Integer value) {
            addCriterion("istuijian <=", value, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianIn(List<Integer> values) {
            addCriterion("istuijian in", values, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianNotIn(List<Integer> values) {
            addCriterion("istuijian not in", values, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianBetween(Integer value1, Integer value2) {
            addCriterion("istuijian between", value1, value2, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIstuijianNotBetween(Integer value1, Integer value2) {
            addCriterion("istuijian not between", value1, value2, "istuijian");
            return (Criteria) this;
        }

        public Criteria andIsnewIsNull() {
            addCriterion("isnew is null");
            return (Criteria) this;
        }

        public Criteria andIsnewIsNotNull() {
            addCriterion("isnew is not null");
            return (Criteria) this;
        }

        public Criteria andIsnewEqualTo(Integer value) {
            addCriterion("isnew =", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotEqualTo(Integer value) {
            addCriterion("isnew <>", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewGreaterThan(Integer value) {
            addCriterion("isnew >", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewGreaterThanOrEqualTo(Integer value) {
            addCriterion("isnew >=", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewLessThan(Integer value) {
            addCriterion("isnew <", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewLessThanOrEqualTo(Integer value) {
            addCriterion("isnew <=", value, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewIn(List<Integer> values) {
            addCriterion("isnew in", values, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotIn(List<Integer> values) {
            addCriterion("isnew not in", values, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewBetween(Integer value1, Integer value2) {
            addCriterion("isnew between", value1, value2, "isnew");
            return (Criteria) this;
        }

        public Criteria andIsnewNotBetween(Integer value1, Integer value2) {
            addCriterion("isnew not between", value1, value2, "isnew");
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