package My;

import java.util.List;

public class PageResult {
    private Long total;//总记录数
    private Long size; //每页显示数量
    private Long cunrt; //当前页数
    private Long totalpaeg; //总页数
    private List row;  //每页记录


    public PageResult(Long total, Long size, Long cunrt, Long totalpaeg, List row) {
        this.total = total;
        this.size = size;
        this.cunrt = cunrt;
        this.totalpaeg = totalpaeg;
        this.row = row;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRow() {
        return row;
    }

    public void setRow(List row) {
        this.row = row;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCunrt() {
        return cunrt;
    }

    public void setCunrt(Long cunrt) {
        this.cunrt = cunrt;
    }

    public Long getTotalpaeg() {
        return totalpaeg;
    }

    public void setTotalpaeg(Long totalpaeg) {
        this.totalpaeg = totalpaeg;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", size=" + size +
                ", cunrt=" + cunrt +
                ", totalpaeg=" + totalpaeg +
                ", row=" + row +
                '}';
    }
}
