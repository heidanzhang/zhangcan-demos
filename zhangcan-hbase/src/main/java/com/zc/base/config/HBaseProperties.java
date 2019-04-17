package com.zc.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/27 12:53
 * @Description:
 */
@ConfigurationProperties(prefix = "hbase")
public class HBaseProperties {

    private Map<String, String> config;

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

}


