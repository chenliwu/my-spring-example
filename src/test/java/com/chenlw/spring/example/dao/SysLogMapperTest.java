package com.chenlw.spring.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenlw.spring.example.entity.SysLog;
import com.chenlw.spring.example.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml", "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class SysLogMapperTest {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testInnerJoinQuery() {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("loginName600000");
        // 查询登录名为loginName600000用户的访问日志
        System.out.println("===========开始查询数据==============");
        long millis = System.currentTimeMillis();
        List<SysLog> sysLogList = sysLogMapper.selectUserLogList(sysUser);
        System.out.println("耗时：" + (System.currentTimeMillis() - millis) + "ms");
        System.out.println("数据数量：" + sysLogList.size());
        System.out.println("===========查询数据结束==============");

    }

    @Test
    public void insertOne() {
        SysLog sysLog = new SysLog();
        sysLog.setCreatedTime(new Date());
        sysLog.setUserId("userId");
        sysLog.setIp("192.1680.1.1");
        sysLog.setOperType("operType");
        int result = sysLogMapper.insert(sysLog);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertBatch() {
        // 准备部分用户数据
        List<SysUser> userList = getTestUserList();
        int userSize = userList.size();
        SysUser sysUser;

        int totalRecordCount = 10000 * 40;
        long millis = System.currentTimeMillis();
        SysLog sysLog;
        System.out.println();
        System.out.println("===========开始插入数据==============");
        for (int i = 1; i <= totalRecordCount; i++) {
            sysUser = userList.get((i - 1) % userSize);
            sysLog = new SysLog();
            sysLog.setCreatedTime(new Date());
            sysLog.setUserId(sysUser.getId());
            sysLog.setIp("192.1680.1.1");
            sysLog.setOperType("operType" + i);
            sysLogMapper.insert(sysLog);
        }
        // 113636 ms
        System.out.println("插入数据耗时：" + (System.currentTimeMillis() - millis) + "ms");
        System.out.println("==========插入数据结束===========");
    }


    public List<SysUser> getTestUserList() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        List<String> loginNameList = new ArrayList<>();
//        loginNameList.add("loginName600000");
//        loginNameList.add("loginName500000");
//        loginNameList.add("loginName400000");
//        loginNameList.add("loginName300000");
//        loginNameList.add("loginName200000");
//        loginNameList.add("loginName100000");
        loginNameList.add("loginName60000");
        loginNameList.add("loginName50000");
        loginNameList.add("loginName40000");
        loginNameList.add("loginName30000");
        loginNameList.add("loginName20000");
        loginNameList.add("loginName10000");
        queryWrapper.in("login_name", loginNameList);
        return sysUserMapper.selectList(queryWrapper);
    }

}