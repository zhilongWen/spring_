package com.at.yuntai.statistic.bean;

/**
 * @create 2023-09-09
 */
public class PagePath {
    private String source;
    private String target;
    private Integer value;

    public PagePath() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
