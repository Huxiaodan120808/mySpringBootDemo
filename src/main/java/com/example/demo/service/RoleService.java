package com.example.demo.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.entity.Role;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.StatusCode;
import com.example.demo.mapper.RoleMapper;
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
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 角色列表
     */
    public List<Role> roleList() {
        List<Role> roleList = roleMapper.getList();
        return roleList;
    }

    /**
     * 添加
     *
     * @param role
     */
    public void add(Role role) {
        Role roleResult = roleMapper.select(role.getName());
        if (roleResult == null) {
            roleMapper.insert(role);
        } else {
            throw  new BusinessException((StatusCode.ROLE_EXIST));
        }
    }

    /***
     * 修改
     *
     * @param updateRole
     */
    public void  update(String roleId, Role role){
        Role roleResult = roleMapper.selectById(roleId);
        if(roleResult == null){
            throw new BusinessException(StatusCode.ROLE_NOT_FOUND);
        }else {
            roleMapper.updateById(role);
        }
    }


    /**
     * 删除
     *
     * @param roleId
     */
    public void delete(String roleId) {
        Role roleResult = roleMapper.selectById(roleId);
        if (roleResult == null) {
            throw new BusinessException(StatusCode.ROLE_NOT_FOUND);
        } else {
            roleMapper.delete(roleId);
        }
    }

}
