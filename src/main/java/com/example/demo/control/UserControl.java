package com.example.demo.control;

import com.example.demo.entity.User;
import com.example.demo.entity.vo.UserVo;
import com.example.demo.service.UserService;
import com.example.demo.util.Msg;
import com.example.demo.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * api层对前端接口
 *
 * @author hxd
 * @date 2020/7/29
 */

@RestController
@RequestMapping("/user")
@Slf4j
//@CrossOrigin("http://192.168.8.23:8081") // 局部配置跨域
public class UserControl {
    @Autowired
    private UserService userService;

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    // 测试
    @RequestMapping("/test")
    public String hello() {
        return "你好";
    }

    // 获取用户列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserVo> getUserList() {
        return userService.userList();
    }

    // 修改用户
    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody User user) {
        userService.update(userId, user);
    }

    // 删除用户
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable String userId) {
        userService.delete(userId);
    }

}
