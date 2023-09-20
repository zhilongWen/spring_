package com.at.yuntai.admin.service;

import com.at.yuntai.admin.bean.User;
import io.netty.channel.ChannelOption;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @create 2023-09-07
 */
public class UserService {

    /**
     * 获取所有用户信息
     *
     * @return
     */
    public static List<User> getAllUsers() {

        try {

            Class.forName(DATABASE.DRIVER);

            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );

            var preparedStatement = connection.prepareStatement(
                    "SELECT id,username,password FROM user"
            );
            var resultSet = preparedStatement.executeQuery();
            var users = new ArrayList<User>();

            while (resultSet.next()) {

                var user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleName(RoleService.getUserRoleName(resultSet.getLong("id")));

                users.add(user);
            }


            resultSet.close();
            preparedStatement.close();
            connection.close();

            return users;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    public static User getUserByName(String username) {

        try {

            Class.forName(DATABASE.DRIVER);
            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );

            var preparedStatement = connection.prepareStatement(
                    "SELECT id,username,password FROM user WHERE username = ?"
            );

            preparedStatement.setString(1, username);
            var resultSet = preparedStatement.executeQuery();

            var user = new User();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleName(RoleService.getUserRoleName(resultSet.getLong("id")));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return user;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return
     */
    public static User getUserById(Long id) {

        try {

            Class.forName(DATABASE.DRIVER);

            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );

            var preparedStatement = connection.prepareStatement(
                    "select id,username,password from user where id = ?"
            );
            preparedStatement.setLong(1, id);

            var resultSet = preparedStatement.executeQuery();

            var user = new User();
            if (resultSet.next()) {
                user.setId(id);
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setRoleName(RoleService.getUserRoleName(id));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return user;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户ID删除用户及用户对应的角色信息
     *
     * @param args
     */
    public static void deleteUserById(Long userId) {

        try {

            Class.forName(DATABASE.DRIVER);

            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );


            // 删除用户信息
            var delUser = connection.prepareStatement("DELETE FROM user where id = ?");
            delUser.setLong(1, userId);
            delUser.execute();
            delUser.close();

            // 删除用户对应的角色信息
            var delUserRole = connection.prepareStatement(
                    "DELETE FROM user_role WHERE user_id = ? "
            );
            delUserRole.setLong(1, userId);
            delUserRole.execute();
            delUserRole.close();

            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加新用户
     */
    public static void addUser(String username, String password) {

        try {

            Class.forName(DATABASE.DRIVER);

            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );

            var preparedStatement = connection.prepareStatement("insert into user(username,password) values(?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.execute();

            preparedStatement.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
