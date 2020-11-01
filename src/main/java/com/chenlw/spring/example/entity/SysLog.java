package com.chenlw.spring.example.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author chenlw
 * @since 2020-11-01
 */
@TableName("sys_log")
public class SysLog {

    @TableField("id")
    private String id;

    @TableField("user_id")
    private String userId;

    @TableField("oper_type")
    private String operType;

    @TableField("created_time")
    private String createdTime;

    @TableField("ip")
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", operType='" + operType + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
