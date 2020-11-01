package com.chenlw.spring.example.configs;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import java.util.UUID;

/**
 * @author chenlw
 * @since 2020-11-01
 */
public class MyBatisIdGenerator implements IdentifierGenerator {

    @Override
    public String nextUUID(Object entity) {
        return UUID.randomUUID().toString().replace("-","");
    }

    @Override
    public Number nextId(Object entity) {
        return null;
    }
}
