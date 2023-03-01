package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 实体 对象声明定义
 *
 * @author hxd
 * @date 2020/7/29
 */
@TableName(value = "tb_user") // 指定连接的数据库表
@Data // 实现自动生成get/set 方法， 不需要每个字段都写getter/setter方法
public class User {

    @TableId // 紧跟着的字段是自增的主键
    private String id;

    @NotBlank
    // 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0 案例：
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String roleId; // 对应角色标的role_id 在创建用户时，传参是roleId,到数据库会自动转换成role_id。

    // 自定义输出的字段
    public String getUserId() {
        return id;
    }

    public void setUserId(String userId) {
        this.id = userId;
    }
}
