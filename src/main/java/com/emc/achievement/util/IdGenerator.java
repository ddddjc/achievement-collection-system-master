package com.emc.achievement.util;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
*@author: hxq
*@date: 2020/10/7 下午4:34
*@description: 唯一id生成类
*/
@Slf4j
@Component
public class IdGenerator {
    private long workerId = 0;
    private long dataCenterId = 1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId, dataCenterId);

    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            log.error("获取机器id失败");
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long nextId() {
        return snowflake.nextId();
    }

}

