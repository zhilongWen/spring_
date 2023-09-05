package com.at.yuntai.admin.controller;

import com.at.yuntai.admin.bean.User;
import com.at.yuntai.admin.bean.UserLoginInfo;
import com.at.yuntai.admin.service.IndexService;
import com.at.yuntai.admin.service.UserService;
import com.at.yuntai.admin.util.JwtHelper;
import com.at.yuntai.admin.util.MD5;
import com.at.yuntai.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @create 2023-09-09
 */
@RestController
@RequestMapping("/admin/index")
public class IndexController {

    @PostMapping("login")
    public Result<String> login(@RequestBody User userInfo) {

        System.out.println("登录的用户：" + userInfo);

        var user = UserService.getUserByName(userInfo.getUsername());

        if (user != null) {

            if (!MD5.encrypt(userInfo.getPassword()).equals(user.getPassword())) {
                return Result.of(200, "fail", "密码错误");
            } else {
                var token = JwtHelper.createToken(user.getId(), user.getUsername());
                return Result.of(200, "success", token);
            }

        } else {
            return Result.of(200, "fail", "用户不存在");
        }

    }

    /**
     * 根据token获取用户信息
     */
    @GetMapping("userInfo")
    public Result<UserLoginInfo> userInfo(HttpServletRequest request) {
        var token = request.getHeader("token");
        var username = JwtHelper.getUserName(token);
        var userLoginInfo = IndexService.getUserInfo(username);
        return Result.of(200, "success", userLoginInfo);
    }

    @PostMapping("logout")
    public Result<Void> logout() {
        return Result.of(200, "success", null);
    }

}
