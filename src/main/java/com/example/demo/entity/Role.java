package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

/**
 * 实体 对象声明定义
 *
 * @author hxd
 * @date 2020/7/29
 */
@TableName(value = "tb_role") // 指定连接的数据库表
@Data // 实现自动生成get/set 方法， 不需要每个字段都写getter/setter方法
public class Role {

    @TableId // 紧跟着的字段是自增的主键
    private String id;

   @NotBlank
    private String name;
}
