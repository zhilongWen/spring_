package com.at.yuntai.statistic.service;

import ru.yandex.clickhouse.ClickHouseConnection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @create 2023-09-09
 */
public class MM {


    private static final String CLICKHOUSE_DRIVER_NAME = "ru.yandex.clickhouse.ClickHouseDriver";
    public static final int CONNECTION_CHECK_TIMEOUT_SECONDS = 60;
    public static final String URL = "jdbc:clickhouse://hadoop102:8123/yuntai";

    static ClickHouseConnection connection;

    static {

        try {
            Class.forName(CLICKHOUSE_DRIVER_NAME);

            connection = (ClickHouseConnection) DriverManager.getConnection(URL);

            connection.isValid(CONNECTION_CHECK_TIMEOUT_SECONDS);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws Exception{

        System.out.println("lll");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT SUM(order_amount) AS order_amount FROM product_statistics WHERE toYYYYMMDD(start_time) = 20221219 "
        );


        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println(resultSet.getBigDecimal("order_amount"));


        }

    }
}
