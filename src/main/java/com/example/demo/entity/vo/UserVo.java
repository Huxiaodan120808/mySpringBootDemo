package com.example.demo.entity.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 控制输出的字段
 * 可以实现链表查询后输出的字段
 * */
@Data
public class UserVo implements Serializable {
    private static final long serialVersionUID = 3358524043384206855L;

    private String userId;

    private String username;

    private String password;

    private String roleName; // 链表输出的字段
}
