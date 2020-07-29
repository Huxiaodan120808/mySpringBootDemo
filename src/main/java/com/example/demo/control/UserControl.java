package com.example.demo.control;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
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
 * */

@RestController
@RequestMapping("/user")
@Slf4j
//@CrossOrigin("http://192.168.8.23:8081") // 局部配置跨域
public class UserControl {
    @Autowired
    private UserMapper userMapper;

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg register(@RequestBody User user){
        try {
            User userResult = userMapper.select(user.getUsername());
            if(userResult == null) {
                userMapper.insert(user); // 整个User对象插入数据库
//            userMapper.insert1(user.getUsername(), user.getPassword());
            } else {
                return  ResultUtil.error(400, "该用户名已经被注册");
            }
        } catch (DuplicateKeyException e) {
            return ResultUtil.error(400, "该用户名已经被注册");
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.error(400, "请求异常");
        }
        return ResultUtil.success();
    }

    // 登录
    @RequestMapping(value = "/login",  method = RequestMethod.POST)
    public Msg login(@RequestBody User user){
        try {
            User userResult = userMapper.select(user.getUsername());
            if(userResult == null) {
                return  ResultUtil.error(400, "该用户名没有注册");
            } else {
                if (userResult.getPassword().equals(user.getPassword())) {
                    return ResultUtil.success(userResult);
                } else {
                    return ResultUtil.error(400, "密码错误");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(400, "请求异常");
        }
    }
    // 测试
    @RequestMapping("/test")
    public String hello(){
        return "你好";
    }

    // 获取用户列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Msg getUserList() {
        try {
            List<User> userList = userMapper.getList();
            return ResultUtil.success(userList);
        } catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(400, "请求异常");
        }
    }

    // 修改用户
    @PutMapping(value = "/{userId}")
    public Msg updateUser(@PathVariable String userId, @RequestBody User user){
        try {
            User userResult = userMapper.selectById(userId);
            if (userResult == null) {
                return  ResultUtil.error(400,"找不到当前用户");
            } else {
                userMapper.updateById(user);
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace(); // 输出错误栈
            return ResultUtil.error(400, "请求异常");
        }
    }

    // 删除用户
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Msg deleteUserById(@PathVariable String userId) {
        try {
            User userResult = userMapper.selectById(userId);
            if (userResult == null) {
                return ResultUtil.error(400, "找不到当前用户");
            } else  {
                userMapper.delete(userId);
                return ResultUtil.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(400, "请求异常");
        }
    }

}
