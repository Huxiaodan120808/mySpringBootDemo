package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.vo.UserVo;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.StatusCode;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 *
 * @author hxd
 * @date 2020/7/29
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户列表
     */
    public List<UserVo> userList() {
        List<UserVo> userList = userMapper.getList();
        return userList;
    }

    /**
     * 用户注册
     *
     * @param user
     */
    public void register(User user) {
        User userResult = userMapper.select(user.getUsername());
        if (userResult == null) {
            userMapper.insert(user);
        } else {
            // 该用户已经注册
            throw new BusinessException(StatusCode.USER_HAD_REGISTER);
        }

    }

    /**
     * 用户登录
     *
     * @param user
     */
    public User login(User user) {
        User userResult = userMapper.select(user.getUsername());
        if (userResult == null) {
            // 找不到该用户
            throw new BusinessException(StatusCode.USER_NOT_FOUND);
        } else {
            if (userResult.getPassword().equals(user.getPassword())) {
                return userResult;
            } else {
                // 密码错误
                throw new BusinessException(StatusCode.PASSWORD_ERROR);
            }
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     */
    public void delete(String userId) {
        User userResult = userMapper.selectById(userId);
        if (userResult == null) {
            //找不到该用户
            throw new BusinessException(StatusCode.USER_NOT_FOUND);
        } else {
            userMapper.delete(userId);
        }
    }

    /**
     * 更新用户
     *
     * @param userId String
     * @param user   Map
     */
    public void update(String userId, User user) {
        User userResult = userMapper.selectById(userId);
        if (userResult == null) {
            throw new BusinessException(StatusCode.USER_NOT_FOUND);
        } else {
            userMapper.updateById(user);
        }
    }

}
