package com.chenlw.spring.example.dao;

import com.chenlw.spring.example.entity.SysLog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml", "classpath*:spring-mvc.xml", "classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class SysLogMapperTest {

    @Autowired
    private SysLogMapper sysLogMapper;

    public void testQuery(){

    }

    @Test
    public void insertOne(){
        SysLog sysLog = new SysLog();
        sysLog.setCreatedTime(new Date());
        sysLog.setUserId("userId");
        sysLog.setIp("192.1680.1.1");
        sysLog.setOperType("operType");
        int result = sysLogMapper.insert(sysLog);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertBatch(){
        int totalRecordCount = 10000 * 60;
        long millis = System.currentTimeMillis();
        SysLog sysLog;
        System.out.println();
        System.out.println("===========开始插入数据==============");
        for (int i = 1; i <= totalRecordCount; i++) {

        }
        // 113636 ms
        System.out.println("插入数据耗时：" + (System.currentTimeMillis() - millis)+"ms");
        System.out.println("==========插入数据结束===========");
    }

}