package com.chenlw.spring.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenlw.spring.example.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据参数动态查询记录
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectRecordsByParameter(SysUser sysUser);


    /**
     * Select注解可在里面书写SQL语句，参数可用#{param},${param}方式写入
     *
     * @param sysUser
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE username = #{login_name} AND password = #{password}")
    List<SysUser> selectListByParameter(SysUser sysUser);

}