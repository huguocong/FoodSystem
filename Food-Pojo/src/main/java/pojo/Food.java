package pojo;

public class Food {
    private Integer id;

    private String foodname;

    private Integer foodtypeId1;

    private Integer foodtypeId2;

    private Double price;

    private Double mprice;

    private String remark;

    private String img;

    private Integer istuijian;

    private Integer isnew;

    private String cat1;

    private String cat2;


    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public Integer getFoodtypeId1() {
        return foodtypeId1;
    }

    public void setFoodtypeId1(Integer foodtypeId1) {
        this.foodtypeId1 = foodtypeId1;
    }

    public Integer getFoodtypeId2() {
        return foodtypeId2;
    }

    public void setFoodtypeId2(Integer foodtypeId2) {
        this.foodtypeId2 = foodtypeId2;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMprice() {
        return mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getIstuijian() {
        return istuijian;
    }

    public void setIstuijian(Integer istuijian) {
        this.istuijian = istuijian;
    }

    public Integer getIsnew() {
        return isnew;
    }

    public void setIsnew(Integer isnew) {
        this.isnew = isnew;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodname='" + foodname + '\'' +
                ", foodtypeId1=" + foodtypeId1 +
                ", foodtypeId2=" + foodtypeId2 +
                ", price=" + price +
                ", mprice=" + mprice +
                ", remark='" + remark + '\'' +
                ", img='" + img + '\'' +
                ", istuijian=" + istuijian +
                ", isnew=" + isnew +
                ", cat1='" + cat1 + '\'' +
                ", cat2='" + cat2 + '\'' +
                '}';
    }
}