package com.at.yuntai.admin.controller;

import com.at.yuntai.admin.bean.User;
import com.at.yuntai.admin.bean.UserRole;
import com.at.yuntai.admin.service.UserRoleService;
import com.at.yuntai.admin.service.UserService;
import com.at.yuntai.admin.util.MD5;
import com.at.yuntai.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @create 2023-09-09
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    /**
     * 获取所有用户
     */
    @GetMapping("getAllUsers")
    public Result<List<User>> getAllUsers() {
        return Result.of(200, "success", UserService.getAllUsers());
    }

    /**
     * 根据用户ID获取用户信息
     */
    @GetMapping("getUser/{userId}")
    public Result<User> getUserById(@PathVariable Long userId) {
        return Result.of(200, "success", UserService.getUserById(userId));
    }

    /**
     * 新增用户
     */
    @PostMapping("addUser")
    public Result<String> addUser(@RequestBody User userInfo) {
        UserService.addUser(
                userInfo.getUsername(),
                MD5.encrypt(userInfo.getPassword())
        );
        return Result.of(200, "success", "新添加了一个用户");
    }

    /**
     * 删除用户
     */
    @DeleteMapping("deleteUser/{userId}")
    public Result<String> deleteUser(@PathVariable Long userId) {
        UserService.deleteUserById(userId);
        return Result.of(200, "success", "删除用户完毕");
    }

    /**
     * 根据用户ID获取角色ID
     */
    @GetMapping("getRoleIdByUserId/{userId}")
    public Result<Long> getRoleIdByUserId(@PathVariable Long userId) {
        return Result.of(200, "success", UserRoleService.getRoleIdByUserId(userId));
    }

    /**
     * 为用户分配角色
     */
    @PostMapping("assignRoleToUser")
    public Result<String> assignRoleToUser(@RequestBody UserRole userRole) {
        UserRoleService.addUserIdRoleIdRelationship(userRole.getUserId(), userRole.getRoleId());
        return Result.of(200, "success", "分配角色成功");
    }
}
