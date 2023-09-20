package com.at.yuntai.admin.service;

import com.at.yuntai.admin.bean.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @create 2023-09-07
 */
public class RoleService {

    /**
     * 获取所有角色
     *
     * @return
     */
    public static List<Role> getAllRoles() {

        try {

            Class.forName(DATABASE.DRIVER);
            var connection = DriverManager.getConnection(
                    DATABASE.URL,
                    DATABASE.USERNAME,
                    DATABASE.PASSWORD
            );

            var preparedStatement = connection.prepareStatement("select id,role_name from role");
            var resultSet = preparedStatement.executeQuery();

            List<Role> roles = new ArrayList<>();

            while (resultSet.next()) {

                var role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setRoleName(resultSet.getString("role_name"));

                roles.add(role);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return roles;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 根据用户ID获取对应的角色名称
     *
     * @param userId
     * @return
     */
    public static String getUserRoleName(long userId) {
        try {
            Class.forName(DATABASE.DRIVER);
            var connection = DriverManager.getConnection(DATABASE.URL, DATABASE.USERNAME, DATABASE.PASSWORD);
            var selectStatement = connection.prepareStatement(
                    "SELECT role.role_name as roleName\n"
                            + "FROM user_role\n"
                            + "INNER JOIN role\n"
                            + "ON user_role.role_id = role.id\n"
                            + "WHERE user_role.user_id = ?"
            );
            selectStatement.setLong(1, userId);
            var resultSet = selectStatement.executeQuery();
            var roleName = "";
            if (resultSet.next()) {
                roleName = resultSet.getString("roleName");
            }

            selectStatement.close();
            connection.close();
            return roleName;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 删除角色
     */
    public static void deleteRole(Long roleId) {
        try {
            Class.forName(DATABASE.DRIVER);
            var connection = DriverManager.getConnection(DATABASE.URL, DATABASE.USERNAME, DATABASE.PASSWORD);

            var deleteRoleStatement = connection.prepareStatement(
                    "DELETE FROM role WHERE id = ?"
            );
            deleteRoleStatement.setLong(1, roleId);
            deleteRoleStatement.execute();

            var deleteRolePermissionStatement = connection.prepareStatement(
                    "DELETE FROM role_permission WHERE role_id = ?"
            );
            deleteRolePermissionStatement.setLong(1, roleId);
            deleteRolePermissionStatement.execute();

            var deleteUserRoleStatement = connection.prepareStatement(
                    "DELETE FROM user_role WHERE role_id = ?"
            );
            deleteUserRoleStatement.setLong(1, roleId);
            deleteUserRoleStatement.execute();

            deleteRoleStatement.close();
            deleteRolePermissionStatement.close();
            deleteUserRoleStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加新角色
     */
    public static void addRole(String roleName) {
        try {
            Class.forName(DATABASE.DRIVER);
            var connection = DriverManager.getConnection(DATABASE.URL, DATABASE.USERNAME, DATABASE.PASSWORD);
            var insertStatement = connection.prepareStatement(
                    "INSERT INTO role (role_name) VALUES (?)"
            );
            insertStatement.setString(1, roleName);
            insertStatement.execute();

            insertStatement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
