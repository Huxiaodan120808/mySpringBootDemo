package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
public interface RoleMapper extends BaseMapper<Role> {

     @Select("SELECT * FROM tb_role WHERE name=#{name}")
     Role select(@Param("name") String name);

     @Select("SELECT * FROM tb_role")
     List<Role> getList();

     @Delete("DELETE FROM tb_role WHERE id=#{roleId}")
     int delete(String roleId);

}
