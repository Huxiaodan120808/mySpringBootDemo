package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User>{
    // insert 插入数据 （没有用到，因为id没有设置默认值）
//    @Insert("INSERT INTO tb_user(username, password) VALUES(#{username}, #{password})")
//    int insert1(@Param("username") String username, @Param("password") String password);

    // select 查询单个用户User数据
    @Select("SELECT * FROM tb_user WHERE username=#{username}")
    User select(@Param("username") String username);

    // select 查询用户列表List数据
    @Select("SELECT * FROM tb_user")
    List<User> getList();

    // delete
    @Delete("DELETE FROM tb_user WHERE id=#{userId}")
    int delete(String userId);
}
