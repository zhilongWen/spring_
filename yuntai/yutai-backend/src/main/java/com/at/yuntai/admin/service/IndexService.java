package com.at.yuntai.admin.service;


import com.at.yuntai.admin.bean.UserLoginInfo;

import java.util.List;

public class IndexService {
    public static UserLoginInfo getUserInfo(String username) {
        var user = UserService.getUserByName(username);

        // 根据用户id获取权限列表

        if (user != null) {

            var permissionByUserId = PermissionService.getPermissionByUserId(user.getId());
            var userLoginInfo = new UserLoginInfo();

            userLoginInfo.setUsername(user.getUsername());
            userLoginInfo.getRoutes().addAll(permissionByUserId);

            return userLoginInfo;

        }

        return null;
    }
}
