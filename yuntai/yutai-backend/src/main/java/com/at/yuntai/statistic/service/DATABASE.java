package com.at.yuntai.statistic.service;

public class DATABASE {
    public static String MYSQL_URL = "jdbc:mysql://hadoop102:3306/yuntai?useSSL=false";
    public static String MYSQL_USERNAME = "root";
    public static String MYSQL_PASSWORD = "root";
    public static String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String CLICKHOUSE_URL = "jdbc:clickhouse://hadoop102:8123/yuntai";
    public static String CLICKHOUSE_DRIVER =  "ru.yandex.clickhouse.ClickHouseDriver";
}
