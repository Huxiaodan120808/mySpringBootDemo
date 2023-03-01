package com.example.demo.control;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * api层对前端接口
 *
 * @author hxd
 * @date 2020/7/29
 */

@RestController
@RequestMapping("/role")
@Slf4j
//@CrossOrigin("http://192.168.8.23:8081") // 局部配置跨域
public class RoleControl {
    @Autowired
    private RoleService roleService;

    // 添加
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Role role) {
        roleService.add(role);
    }

    // update
    @PutMapping(value = "/{roleId}")
    public void updateRole(@PathVariable String roleId, @RequestBody Role role){
        roleService.update(roleId, role);
    }

    // 获取列表
    @GetMapping(value = "/list")
    public List<Role> getRoleList() {
        return roleService.roleList();
    }

    // 删除用户
    @DeleteMapping(value = "/{roleId}")
    public void deleteUserById(@PathVariable String roleId) {
        roleService.delete(roleId);
    }

}
