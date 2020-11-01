package com.chenlw.spring.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenlw.spring.example.entity.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

    List<SysLog> selectUserLogList();

}