package com.chenlw.spring.example.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml","classpath*:spring-mvc.xml","classpath*:spring-mybatis.xml"})
@WebAppConfiguration
public class SysUserServiceTest {

    @Autowired
    private SysUserService sysUserService;



}