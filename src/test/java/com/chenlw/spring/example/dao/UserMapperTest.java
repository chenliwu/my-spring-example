package com.chenlw.spring.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenlw.spring.example.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml", "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class UserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void listAll() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        List<SysUser> list = sysUserMapper.selectList(queryWrapper);
        System.out.println("总记录数目：" + list.size());
        for (SysUser sysUser : list) {
            System.out.println(sysUser.toString());
        }
    }

    @Test
    public void queryOne(){
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("loginName600000");
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>(sysUser);
        long millis = System.currentTimeMillis();
        System.out.println("===========开始查询数据==============");
        // System.out.println("查询结果："+sysUserMapper.selectOne(sysUser));
        List<SysUser> list = sysUserMapper.selectList(wrapper);
        Assert.assertNotNull(list);
        System.out.println("耗时：" + (System.currentTimeMillis() - millis)+"ms");
        System.out.println("===========查询数据结束==============");
    }

    @Test
    public void saveOne() {
        SysUser sysUser = new SysUser();
        sysUser.setId(UUID.randomUUID().toString().replace("-", ""));
        sysUser.setLoginName("loginName");
        sysUser.setPassword("password");
        sysUser.setName("name");
        sysUser.setSex("M");
        sysUser.setStatus("0");
        int result = sysUserMapper.insert(sysUser);
        Assert.assertEquals(1, result);
    }

    @Test
    public void saveBatch() {
        int totalRecordCount = 10000 * 60;
        long millis = System.currentTimeMillis();
        SysUser sysUser;
        System.out.println();
        System.out.println("===========开始插入数据==============");
        for (int i = 1; i <= totalRecordCount; i++) {
            sysUser = new SysUser();
            sysUser.setId(UUID.randomUUID().toString().replace("-", ""));
            sysUser.setLoginName("loginName" + i);
            sysUser.setPassword("password" + i);
            sysUser.setName("name" + i);
            sysUser.setSex("M");
            sysUser.setStatus("0");
            sysUserMapper.insert(sysUser);
        }
        // 113636 ms
        System.out.println("插入数据耗时：" + (System.currentTimeMillis() - millis)+"ms");
        System.out.println("==========插入数据结束===========");
    }


}