package com.tensquare.base.bean;

/**
 * @author Irving Lu
 * @create 2018-12-15 20:25
 */
public class LabelSearchBean {

    private String labelname;//标签名称
    private String state;//状态
    private String recommend;//是否推荐
    private Integer pageNumber;//页码
    private Integer pageSize;//每页条数

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
