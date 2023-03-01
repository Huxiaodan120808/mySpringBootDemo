package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.UserVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库操作语句
 *
 * @author hxd
 * @date 2020/7/29
 */

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    // select 查询单个用户User数据
    @Select("SELECT * FROM tb_user WHERE username=#{username}")
    User select(@Param("username") String username);

    // select 查询用户列表List数据
    @Select("SELECT " +
            "u.id AS \"userId\", " +
            "u.username, " +
            "u.password, " +
            "u.role_id AS \"roleId\", " +
            "r.name AS \"roleName\" " +
            "FROM tb_user u JOIN tb_role r ON u.role_id = r.id") // 链表查询
    List<UserVo> getList();

    // delete
    @Delete("DELETE FROM tb_user WHERE id=#{userId}")
    int delete(String userId);
}
