package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Irving.Lu
 * @create 2018-12-02 20:23
 */
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {
    @Id
    private String id;//标签id
    private String labelname;//标签名称
    private String state;//状态
    private Integer count;//使用数
    private String recommend;//是否推荐
    private Integer fans;//粉丝数
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getlabelname() {
        return labelname;
    }

    public void setlabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }
}
