package com.at.yuntai.statistic.bean;

import java.util.List;

/**
 * @create 2023-09-09
 */
public class Page<T> {

    public Integer total;
    public Integer size;
    public Integer current;
    public List<T> records;

    public Page() {
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", size=" + size +
                ", current=" + current +
                ", records=" + records +
                '}';
    }
}
