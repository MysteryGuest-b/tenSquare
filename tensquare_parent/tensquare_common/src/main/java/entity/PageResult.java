package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Irving Lu
 * @create 2018-12-02 18:56
 */
public class PageResult<T> implements Serializable {
    private Long total;//总条数
    private List<T> rows;//分页结果集

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
